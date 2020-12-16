package com.vw.restaurante.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vw.restaurante.Entity.Tipo_Platillo;
import com.vw.restaurante.Interfaces.Interface_TipoPlatillo;

@Controller
@RequestMapping
public class Tipo_PlatilloController {
	
	@Autowired
	private Interface_TipoPlatillo servicePlatillo;
	
	@GetMapping("/listarPlatillo")
	public String listarB(Model model) {
		model.addAttribute("ListarPlatillos",servicePlatillo.findAll());
		return "TipoPlatillo/ListarPlatillo";
	}
	
	@GetMapping("/NuevoRegistroPlatillo")
	public String agregar(Model model) {
		model.addAttribute("TipoPlatillo", new Tipo_Platillo());
		return "TipoPlatillo/FormReg_Platillo";
	}
	
	@PostMapping("/savePlatillo")
	public String save(@ModelAttribute Tipo_Platillo TP) {
		servicePlatillo.save(TP);
		return "redirect:/listarPlatillo";
	}
	
	@GetMapping("/editarPlatillo/{IdTipoPlatillo}")
	public String editar(@PathVariable int IdTipoPlatillo, Model model) {
		model.addAttribute("TipoPlatillo", servicePlatillo.findById(IdTipoPlatillo).get());
		return "TipoPlatillo/FormReg_Platillo";
	}
	
	@GetMapping("/eliminarPlatillo/{IdTipoPlatillo}")
	public String delete(Model model, @PathVariable int IdTipoPlatillo) {
		servicePlatillo.deleteById(IdTipoPlatillo);
		return "redirect:/listarPlatillo";
	}

}
