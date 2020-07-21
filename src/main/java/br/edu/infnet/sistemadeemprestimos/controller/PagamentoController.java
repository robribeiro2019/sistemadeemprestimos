package br.edu.infnet.sistemadeemprestimos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.sistemadeemprestimos.model.Pagamento;
import br.edu.infnet.sistemadeemprestimos.service.PagamentoService;

@Controller
public class PagamentoController {
	
	@Autowired
	private PagamentoService pagamentoService;


	@RequestMapping(value="/receberPagamento/{numeroDoPagamento}", method = RequestMethod.GET)
	public String receberPagamento(@PathVariable("numeroDoPagamento") Integer idPagamento,  Model model){
		
		Pagamento pagamento = pagamentoService.getPagamento(idPagamento);
		
		model.addAttribute("pagamento", pagamento);
		model.addAttribute("tipoForm",   "Pagamento");
		pagamentoService.receber(pagamento.getNumeroDoPagamento());
		
		return "redirect:/";
	}

}
