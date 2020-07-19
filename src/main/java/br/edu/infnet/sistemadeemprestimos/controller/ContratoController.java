package br.edu.infnet.sistemadeemprestimos.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.sistemadeemprestimos.model.Cliente;
import br.edu.infnet.sistemadeemprestimos.model.Coletor;
import br.edu.infnet.sistemadeemprestimos.model.Emprestimo;
import br.edu.infnet.sistemadeemprestimos.model.Pagamento;
import br.edu.infnet.sistemadeemprestimos.service.ClienteService;
import br.edu.infnet.sistemadeemprestimos.service.ColetorService;
import br.edu.infnet.sistemadeemprestimos.service.EmprestimoService;
import br.edu.infnet.sistemadeemprestimos.service.PagamentoService;

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
		
		emprestimo.setCliente                   (clienteService.getCliente(emprestimo.getCliente().getNumeroDoCliente()));
		emprestimo.setColetor                   (coletorService.getColetor(emprestimo.getColetor().getNumeroDoColetor()));
		emprestimo.setMontanteDoEmprestimoDevido(emprestimo.getMontanteDoEmprestimo().doubleValue());
		
		emprestimoService.salvar(emprestimo);
			
		if(emprestimo.getTipoForm().equals("Novo")) {
			
			//Calcula o valor das parcelas
			BigDecimal bgParcela = emprestimo.getMontanteDoEmprestimo().divide(new BigDecimal(emprestimo.getQuantidadeDeParcelas()), 2);
			
			IntStream.range(0, emprestimo.getQuantidadeDeParcelas()).forEach(n -> {
				Pagamento pagamento = new Pagamento();
				
				//Soma um mes a cada pagamento
				LocalDate dateAdd = emprestimo.getDataInicioContrato().toInstant()
					      .atZone(ZoneId.systemDefault())
					      .toLocalDate().plusMonths(++n);

				pagamento.setDataDoPagamento     (Date.from(dateAdd.atStartOfDay(ZoneId.systemDefault()).toInstant()));
				pagamento.setPagamentoDoMontante (bgParcela);
				pagamento.setPagamentoTaxaDeJuros(bgParcela.multiply(emprestimo.getColetor().getTaxaDeJuros()).divide(new BigDecimal(100)));
				pagamento.setEmprestimoConcedido (emprestimo);
				
				pagamentoService.salvar(pagamento);
				
				pagamento = null;
		    });
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/formedit/{numeroDoContrato}", method = RequestMethod.GET )
	public String formEdit(@PathVariable("numeroDoContrato") String id,  Model model) {	
		Emprestimo emprestimo = emprestimoService.getEmprestimo(id);
		
		model.addAttribute("emprestimo", emprestimo);
		model.addAttribute("tipoForm", "Editar");
		
		return "/formEmprestimo";
	}
	
	
	@RequestMapping(value="/formpag/{numeroDoContrato}", method = RequestMethod.GET )
	public String formpag(@PathVariable("numeroDoContrato") String id,  Model model) {	
		Emprestimo emprestimo = emprestimoService.getEmprestimo(id);
		
		model.addAttribute("emprestimo", emprestimo);
		model.addAttribute("tipoForm",   "Pagamentos");
		
		return "/formListaPagamento";
	}
	
	@RequestMapping( value = "/delete/{numeroDoContrato}", method = RequestMethod.GET )
	public String delete(@PathVariable("numeroDoContrato") String id) {	
		emprestimoService.deletar(id);
		return "redirect:/";
	}	

}
