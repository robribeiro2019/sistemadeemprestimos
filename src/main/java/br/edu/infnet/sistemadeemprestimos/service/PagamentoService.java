package br.edu.infnet.sistemadeemprestimos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sistemadeemprestimos.repository.PagamentoRepository;
import br.edu.infnet.sistemadeemprestimos.modelo.Pagamento;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository pagamentorepositorio;
  
	public List<Pagamento> listarTodosPagamentos(){
		return pagamentorepositorio.findAll();
	  
  }

}
