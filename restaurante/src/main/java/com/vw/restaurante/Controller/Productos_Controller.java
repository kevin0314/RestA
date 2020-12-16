package com.vw.restaurante.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.el.parser.ParseException;
import com.vw.restaurante.Entity.Categoria;
import com.vw.restaurante.Entity.Productos;
import com.vw.restaurante.Interfaces.Interface_Categoria;
import com.vw.restaurante.Interfaces.Interface_Productos;
import com.vw.restaurante.Interfaces.Interface_TipoBebida;
import com.vw.restaurante.Interfaces.Interface_TipoPlatillo;


@Controller
public class Productos_Controller {
	
	@Autowired
	Interface_Productos interfaceProser;
	
	@Autowired
	Interface_Categoria interfaceCat;
	
	@Autowired
	Interface_TipoBebida interfaceBebida;
	
	@Autowired
	Interface_TipoPlatillo interfacePlatillo;
	
	@GetMapping("/listarPro")
	public String listar(Model model) {
		model.addAttribute("ListarProducto", interfaceProser.findAll());
		model.addAttribute("Listarcateg", interfaceCat.findAll());
		model.addAttribute("Listarplati", interfacePlatillo.findAll());
		model.addAttribute("Listarbebi", interfaceBebida.findAll());
		return "Productos/ListarProductos";
	}
	
	@GetMapping("/NuevoProducto")
	public String agregar(Model model) {
		model.addAttribute("Productos", new Productos());
		model.addAttribute("Listarcateg", interfaceCat.findAll());
		model.addAttribute("Listarplati", interfacePlatillo.findAll());
		model.addAttribute("Listarbebi", interfaceBebida.findAll());
		return "Productos/FormReg_Productos.html";
	}
	
	@PostMapping ("/saveProducto")
	public String saveProductos (@RequestParam(value = "IdCatFK") int IdCatFK,
								 @RequestParam(value = "IdPlaFK") int IdPlaFK,
								 @RequestParam(value = "IdBebFK") int IdBebFK,
								 @RequestParam(value = "Descrip") String Descrip,
								 @RequestParam(value = "prec") double prec,
								 @RequestParam(value = "nom") String nom,
								 @RequestParam(value = "tama") String tama,
								 @RequestParam("file") MultipartFile file)
										 throws ParseException{
		
		Productos proEn = new Productos();
		proEn.setIdCategoria_FK(interfaceCat.findById(IdCatFK).get());
		proEn.setIdTipoPlatillo_FK(interfacePlatillo.findById(IdPlaFK).get());
		proEn.setIdTipoBebida_FK(interfaceBebida.findById(IdBebFK).get());
		
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
		proEn.setDescripcion(Descrip);
		proEn.setPrecio(prec);
		proEn.setNombre(nom);
		proEn.setTamanio(tama);
		proEn.setImagen(file.getOriginalFilename());
		
		interfaceProser.save(proEn);
		
		return "redirect:/listarPro";
		
	}
	
	@RequestMapping(value = "/updateProducto", method = RequestMethod.POST)
	public String nuevo(@RequestParam(value = "IdCatFK") int IdCatFK,
			 @RequestParam(value = "IdPlaFK") int IdPlaFK,
			 @RequestParam(value = "IdBebFK") int IdBebFK,
			 @ModelAttribute("Producto") Productos pr) {
		
		pr.setIdCategoria_FK(interfaceCat.findById(IdCatFK).get());
		pr.setIdTipoPlatillo_FK(interfacePlatillo.findById(IdPlaFK).get());
		pr.setIdTipoBebida_FK(interfaceBebida.findById(IdBebFK).get());
		
		interfaceProser.save(pr);
		return "redirect:/listarPro";
	} 
	
	@GetMapping("/editarPro/{id}")
	public String editar(@PathVariable int id, Model model) {
		model.addAttribute("Producto", interfaceProser.findById(id).get());
		model.addAttribute("Listarcateg", interfaceCat.findAll());
		model.addAttribute("Listarplati", interfacePlatillo.findAll());
		model.addAttribute("Listarbebi", interfaceBebida.findAll());
		return "Productos/FormAct_Pro.html";
	}
	
	@GetMapping("/listarProd/{IdProducto}")
	public String listarprod(@PathVariable("IdProducto") int IdProducto, Model model) {

		
		model.addAttribute("Listarpro", interfaceProser.findByIdP(IdProducto));
		
		List<Categoria> listadoCategorias = interfaceCat.findAll();
		model.addAttribute("ListarCategoria",listadoCategorias);
		  List<Productos> listadoProductos = interfaceProser.findAll();
		  model.addAttribute("ListarProd",listadoProductos);
		return "home/Home";
	}
	
	@RequestMapping(value="/eliminarPro/{id}")
	public String delete(Model model, @PathVariable int id) {
		interfaceProser.deleteById(id);
		return "redirect:/listarPro";
	}
	

}
