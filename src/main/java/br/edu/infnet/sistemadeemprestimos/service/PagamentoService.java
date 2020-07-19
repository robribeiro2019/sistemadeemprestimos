package br.edu.infnet.sistemadeemprestimos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.sistemadeemprestimos.model.Pagamento;
import br.edu.infnet.sistemadeemprestimos.repository.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository pagamentoRepositorio;
  
	public List<Pagamento> listarTodosPagamentos(){
		return pagamentoRepositorio.findAll();
	}
	
	@Transactional
	public void salvar(Pagamento pagamento) {
		pagamentoRepositorio.save(pagamento);
	}
}
