package br.edu.infnet.sistemadeemprestimos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sistemadeemprestimos.model.TipoPagamento;
import br.edu.infnet.sistemadeemprestimos.repository.TipoPagamentoRepository;

@Service
public class TipoPagamentoService {
	
	@Autowired
	private TipoPagamentoRepository tipoPagamentoRepositorio;
	
	public List<TipoPagamento> listarTodosTipoPagamento(){
		return tipoPagamentoRepositorio.findAll();
	}
	
	public TipoPagamento getTipoPagamento(Integer id) {
		return tipoPagamentoRepositorio.findById((id)).orElse(new TipoPagamento());
	}
}
