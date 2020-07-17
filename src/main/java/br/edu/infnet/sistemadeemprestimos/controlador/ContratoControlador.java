package br.edu.infnet.sistemadeemprestimos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.sistemadeemprestimos.modelo.Cliente;
import br.edu.infnet.sistemadeemprestimos.modelo.Coletor;
import br.edu.infnet.sistemadeemprestimos.modelo.Emprestimo;
import br.edu.infnet.sistemadeemprestimos.service.ClienteService;
import br.edu.infnet.sistemadeemprestimos.service.ColetorService;
import br.edu.infnet.sistemadeemprestimos.service.EmprestimoService;

@Controller
public class ContratoControlador {
	
	@Autowired //injeçao de dependencia - no atributo
	private EmprestimoService emprestimoService;
	
	@Autowired //injeçao de dependencia - no atributo
	private ColetorService coletorService;
	
	@Autowired //injeçao de dependencia - no atributo
	private ClienteService clienteService;
	
	
	@RequestMapping(value="/", method = RequestMethod.GET )
	public String listarContratos(Model model) {
		
		List<Emprestimo> emprestimo = emprestimoService.listarTodosEmprestimos();		
		model.addAttribute("emprestimo", emprestimo);
		return "/home";
	}	
	
	@RequestMapping(value="/novo", method = RequestMethod.GET )
	public String form(Model model) {
		List<Coletor> coletor = coletorService.listarTodosColetores();
		List<Cliente> cliente = clienteService.listarTodosClientes();
		model.addAttribute("tipoForm", "Novo");
		model.addAttribute("coletor", coletor);
		model.addAttribute("cliente", cliente);
		return "/formEmprestimo";
	}
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST )
	public String form(Model model, Emprestimo emprestimo) {	
		emprestimoService.salvar(emprestimo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/formedit/{numeroDoContrato}", method = RequestMethod.GET )
	public String formEdit( @PathVariable("numeroDoContrato") String id,  Model model) {	
		Emprestimo emprestimo = emprestimoService.getEmprestimo(id);
		model.addAttribute("emprestimo", emprestimo);
		model.addAttribute("tipoForm", "Editar");
		return "/formEmprestimo";
	}
	
	
	@RequestMapping( value = "/delete/{numeroDoContrato}", method = RequestMethod.GET )
	public String delete( @PathVariable("numeroDoContrato") String id) {	
		emprestimoService.delete(id);
		return "redirect:/";
	}	

}
