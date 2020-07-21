package br.edu.infnet.sistemadeemprestimos.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.sistemadeemprestimos.model.Cliente;
import br.edu.infnet.sistemadeemprestimos.model.Coletor;
import br.edu.infnet.sistemadeemprestimos.model.Emprestimo;
import br.edu.infnet.sistemadeemprestimos.model.Pagamento;
import br.edu.infnet.sistemadeemprestimos.model.TipoPagamento;
import br.edu.infnet.sistemadeemprestimos.service.ClienteService;
import br.edu.infnet.sistemadeemprestimos.service.ColetorService;
import br.edu.infnet.sistemadeemprestimos.service.EmprestimoService;
import br.edu.infnet.sistemadeemprestimos.service.PagamentoService;
import br.edu.infnet.sistemadeemprestimos.service.TipoPagamentoService;
import br.edu.infnet.sistemadeemprestimos.util.Util;

@Controller
public class ContratoController {
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	@Autowired
	private ColetorService coletorService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@Autowired
	private TipoPagamentoService tipoPagamentoService;
	
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
		model.addAttribute("coletor",  coletor);
		model.addAttribute("cliente",  cliente);
		
		return "/formEmprestimo";
	}
	
	@Transactional
	@RequestMapping(value="/salvar", method = RequestMethod.POST )
	public String form(Model model, Emprestimo emprestimo) {
		
		if(emprestimo.getNumeroDoContrato() != null) {
			
			Emprestimo emprestimoVelho = emprestimoService.getEmprestimo(emprestimo.getNumeroDoContrato().toString());
			emprestimoVelho.setObservacoes(emprestimo.getObservacoes());
			emprestimoService.salvar(emprestimoVelho);
			return "redirect:/";
			
		}
		
		emprestimo.setCliente                   (clienteService.getCliente(emprestimo.getCliente().getNumeroDoCliente()));
		emprestimo.setColetor                   (coletorService.getColetor(emprestimo.getColetor().getNumeroDoColetor()));
		emprestimo.setMontanteDoEmprestimoDevido(emprestimo.getMontanteDoEmprestimo().doubleValue());
		emprestimo.setDataProximoVencimento     (Util.adicionarMes(emprestimo.getDataInicioContrato(), 1));
		emprestimo.setDataFimContrato           (Util.adicionarMes(emprestimo.getDataInicioContrato(), emprestimo.getQuantidadeDeParcelas()));
	
		emprestimoService.salvar(emprestimo);
		
		BigDecimal bgParcela = Util.calcularValorParcela(emprestimo);
		
		IntStream.range(0, emprestimo.getQuantidadeDeParcelas()).forEach(n -> {
			pagamentoService.salvar(
					new Pagamento(bgParcela, 
							Util.adicionarMes(emprestimo.getDataInicioContrato(), ++n),
							Util.calcularTaxaDeJuros(bgParcela, emprestimo.getColetor().getTaxaDeJuros()), 
							"", 
							emprestimo));

	    });
			
		return "redirect:/";
	}

	
	@RequestMapping(value="/formedit/{numeroDoContrato}", method = RequestMethod.GET )
	public String formEdit(@PathVariable("numeroDoContrato") String id,  Model model) {
		
		Emprestimo emprestimo = emprestimoService.getEmprestimo(id);
		
		model.addAttribute("emprestimo", emprestimo);
		model.addAttribute("tipoForm",   "Editar");
		
		return "/formEmprestimo";
	}
	
	
	@RequestMapping(value="/formpag/{numeroDoContrato}", method = RequestMethod.GET )
	public String formpag(@PathVariable("numeroDoContrato") String id,  Model model) {
		
		Emprestimo          emprestimo    = emprestimoService.getEmprestimo(id);
		List<TipoPagamento> tipoPagamento = tipoPagamentoService.listarTodosTipoPagamento();
		
		model.addAttribute("emprestimo",    emprestimo);
		model.addAttribute("tipoPagamento", tipoPagamento);
		model.addAttribute("tipoForm",      "Pagamentos");
		
		return "/formListaPagamento";
	}
	
	@RequestMapping( value = "/delete/{numeroDoContrato}", method = RequestMethod.GET )
	public String delete(@PathVariable("numeroDoContrato") String id) {	
		emprestimoService.deletar(id);
		return "redirect:/";
	}	
}
