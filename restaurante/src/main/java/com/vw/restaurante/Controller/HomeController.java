package com.vw.restaurante.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vw.restaurante.Entity.Categoria;
import com.vw.restaurante.Entity.Detalle_Orden;
import com.vw.restaurante.Entity.Productos;
import com.vw.restaurante.Entity.Tipo_Bebida;
import com.vw.restaurante.Entity.Tipo_Platillo;
import com.vw.restaurante.Interfaces.Interface_Categoria;
import com.vw.restaurante.Interfaces.Interface_Detalle;
import com.vw.restaurante.Interfaces.Interface_Productos;

@Controller
public class HomeController {
	@Autowired
	private Interface_Categoria service;
	@Autowired
	private Interface_Productos produc;
	@Autowired 
	private Interface_Detalle deta;
	@GetMapping("/")
	public String home(Model model) {
		List<Categoria> listadoCategorias = service.findAll();
		model.addAttribute("ListarCategoria",listadoCategorias);
		
		  List<Productos> listadoProductos = produc.findAll();
		  model.addAttribute("ListarProd",listadoProductos);
		 
		
		return "home/Home";
	}
	
	@GetMapping("/guardarOrden/{IdProd}")
	public String saveOrden(@PathVariable("IdProd") int IdProd,
			Model model) {
		Detalle_Orden dot = new Detalle_Orden();
		dot.setIdProducto_FK(produc.findById(IdProd).get());
		dot.setTotal(00);
		dot.setCantidad(1);
          deta.save(dot);
  		List<Categoria> listadoCategorias = service.findAll();
  		model.addAttribute("ListarCategoria",listadoCategorias);
  		
  		  List<Productos> listadoProductos = produc.findAll();
  		  model.addAttribute("ListarProd",listadoProductos);
		    
		return"home/Home";
	}
	
	
	
	@GetMapping("/New")
	public String home1() {
		return "home/NewFile";
	}
	
	@GetMapping("/user")
	public String Usuario() {
		return "Usuario/RegUsuario";
	}
	
	@GetMapping("/tipoBebida")
	public String tipoPlaBebida(Model model) {
		model.addAttribute("TipoBebida", new Tipo_Bebida());
		return "TipoBebida/ListarBebida";
	}
	
	@GetMapping("/tipoPlatillo")
	public String agregar(Model model) {
		model.addAttribute("TipoPlatillo", new Tipo_Platillo());
		return "TipoPlatillo/ListarPlatillo";
	}
	
	@GetMapping("/Categoria")
	public String categoria(Model model) {
		model.addAttribute("Categoria", new Categoria());
		return "Categorias/ListarCat";
	}
	
	
	@GetMapping("/Productos")
	public String aggProductos(Model model) {
		model.addAttribute("Productos", new Productos());
		return "Productos/ListarProductos";
	}

	
	
}
