package com.vw.restaurante.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.vw.restaurante.Entity.Categoria;
import com.vw.restaurante.Entity.Productos;
import com.vw.restaurante.Interfaces.Interface_Categoria;
import com.vw.restaurante.Interfaces.Interface_Productos;

@Controller
@RequestMapping
public class CategoriaController {
	
	@Autowired
	private Interface_Categoria service;
	@Autowired
	private Interface_Productos produc;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("ListarCategoria",service.findAll());
		return "Categorias/ListarCat";
	}
	
	@GetMapping("/NuevoRegistro")
	public String agregar(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "Categorias/FormReg";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute @Validated Categoria c,Model model, @RequestParam("file") MultipartFile file) {
		if(!file.isEmpty()) {
   		 Path directorioImagen = Paths.get("src//main//resources//static/images");
   		 String rutaAbsoluta = directorioImagen.toFile().getAbsolutePath();
   		 try {
				byte[] bytesImg = file.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + file.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
   		 
   	 }
		c.setImagen(file.getOriginalFilename());
		service.save(c);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{IdCategoria}")
	public String editar(@PathVariable int IdCategoria, Model model) {
		model.addAttribute("categoria", service.findById(IdCategoria).get());
		return "Categorias/FormReg";
	}
	
	@GetMapping("/eliminar/{IdCategoria}")
	public String delete(Model model, @PathVariable int IdCategoria) {
		service.deleteById(IdCategoria);
		return "redirect:/listar";
	}
	@GetMapping("/filtrar/{IdCategoria}")
	public String filtrar(@PathVariable("IdCategoria") int IdCategoria, Model model) {
		 model.addAttribute("ListarProd",produc.findByCategoria(IdCategoria));
		 
		 List<Categoria> listadoCategorias = service.findAll();
			model.addAttribute("ListarCategoria",listadoCategorias);
			
				return "home/Home";
	}
}
