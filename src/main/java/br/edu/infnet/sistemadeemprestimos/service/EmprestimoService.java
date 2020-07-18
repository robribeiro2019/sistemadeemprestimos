package br.edu.infnet.sistemadeemprestimos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.sistemadeemprestimos.modelo.Emprestimo;
import br.edu.infnet.sistemadeemprestimos.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository emprestimoRepositorio;

	@Transactional
	public void salvar(Emprestimo emprestimo) {
		emprestimoRepositorio.save(emprestimo);
	}

	public List<Emprestimo> listarTodosEmprestimos() {
		return emprestimoRepositorio.findAll();
	}
	
	public Emprestimo getEmprestimo(String id) {
		return emprestimoRepositorio.findById((Integer.valueOf(id))).orElse(new Emprestimo());
	}
	
	@Transactional
	public void deletar(String id) {
		emprestimoRepositorio.delete(getEmprestimo(id ));
	}	

}
