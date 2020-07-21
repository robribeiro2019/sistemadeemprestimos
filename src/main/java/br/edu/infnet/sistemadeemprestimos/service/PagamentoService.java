package br.edu.infnet.sistemadeemprestimos.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.sistemadeemprestimos.controller.PagamentoController;
import br.edu.infnet.sistemadeemprestimos.model.Pagamento;
import br.edu.infnet.sistemadeemprestimos.repository.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository pagamentoRepositorio;
	
	@Autowired
	private PagamentoService pagamentoService;
  
	public List<Pagamento> listarTodosPagamentos(){
		return pagamentoRepositorio.findAll();
	}
	
	@Transactional
	public void salvar(Pagamento pagamento) {
		pagamentoRepositorio.save(pagamento);
	}
	
	public Pagamento getPagamento(Integer id) {
		return pagamentoRepositorio.findById((id)).orElse(new Pagamento());
	}

	public void receber(Integer idPagamento) {
		Pagamento pagamento = pagamentoService.getPagamento(Integer.valueOf(idPagamento));
		pagamento.setDataDoPagamento(new Date());
		pagamento.setObservacoes("Mudei");
		
		pagamentoRepositorio.save(pagamento);
		
	}
}
