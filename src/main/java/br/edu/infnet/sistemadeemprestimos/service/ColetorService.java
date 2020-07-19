package br.edu.infnet.sistemadeemprestimos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sistemadeemprestimos.model.Coletor;
import br.edu.infnet.sistemadeemprestimos.repository.ColetorRepository;

@Service
public class ColetorService {
	
	@Autowired
	private ColetorRepository coletorRepositorio;

	public List<Coletor> listarTodosColetores() {
		return coletorRepositorio.findAll();
	}
	
	public Coletor getColetor(Integer id) {
		return coletorRepositorio.findById((id)).orElse(new Coletor());
	}
}
