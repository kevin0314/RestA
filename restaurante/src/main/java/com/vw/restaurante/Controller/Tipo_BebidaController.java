package com.vw.restaurante.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vw.restaurante.Entity.Tipo_Bebida;
import com.vw.restaurante.Interfaces.Interface_TipoBebida;

@Controller
@RequestMapping
public class Tipo_BebidaController {
	
	@Autowired
	private Interface_TipoBebida serviceBebida;
	
	@GetMapping("/listarBebida")
	public String listarB(Model model) {
		model.addAttribute("ListarBebidas",serviceBebida.findAll());
		return "TipoBebida/ListarBebida";
	}
	
	@GetMapping("/NuevoRegistroBebida")
	public String agregar(Model model) {
		model.addAttribute("TipoBebida", new Tipo_Bebida());
		return "TipoBebida/FormReg_Bebida";
	}
	
	@PostMapping("/saveBebida")
	public String save(@ModelAttribute Tipo_Bebida TB) {
		serviceBebida.save(TB);
		return "redirect:/listarBebida";
	}
	
	@GetMapping("/editarBebida/{IdTipoBebida}")
	public String editar(@PathVariable int IdTipoBebida, Model model) {
		model.addAttribute("TipoBebida", serviceBebida.findById(IdTipoBebida).get());
		return "TipoBebida/FormReg_Bebida";
	}
	

	@GetMapping("/eliminarBebida/{IdTipoBebida}")
	public String delete(Model model, @PathVariable int IdTipoBebida) {
		serviceBebida.deleteById(IdTipoBebida);
		return "redirect:/listarBebida";
	}

}
