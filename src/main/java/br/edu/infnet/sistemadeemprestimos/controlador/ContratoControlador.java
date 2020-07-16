package br.edu.infnet.sistemadeemprestimos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.sistemadeemprestimos.modelo.Emprestimo;
import br.edu.infnet.sistemadeemprestimos.service.EmprestimoService;

@Controller
public class ContratoControlador {
	
	@Autowired //injeçao de dependencia - no atributo
	private EmprestimoService emprestimoService;
	
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public String listarContratos(Model model) {
		
		List<Emprestimo> emprestimo = emprestimoService.listarTodosEmprestimos();		
		model.addAttribute("emprestimo", emprestimo);
		return "/home";
	}	

}
