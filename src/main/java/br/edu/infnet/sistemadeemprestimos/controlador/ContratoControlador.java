package br.edu.infnet.sistemadeemprestimos.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContratoControlador {
	
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public String listarContratos(Model model) {
		return "/home";
	}	

}
