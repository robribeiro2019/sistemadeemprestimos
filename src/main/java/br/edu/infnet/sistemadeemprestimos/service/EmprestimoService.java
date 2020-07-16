package br.edu.infnet.sistemadeemprestimos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.sistemadeemprestimos.modelo.Emprestimo;
import br.edu.infnet.sistemadeemprestimos.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	private EmprestimoRepository emprestimoRepositorio;

	@Autowired // injetando a depencia - no construtor
	public EmprestimoService(EmprestimoRepository emprestimoRepositorio) {
		this.emprestimoRepositorio = emprestimoRepositorio;
	}

	@Transactional
	public void salvar(Emprestimo emprestimo) {
		emprestimoRepositorio.save(emprestimo);
	}

	public List<Emprestimo> listarTodosEmprestimos() {
		return emprestimoRepositorio.findAll();
	}
	
	public Emprestimo getEmprestimo(String id) {
		return emprestimoRepositorio.getOne(Integer.valueOf(id));
	}
	
	@Transactional
	public void delete(String id) {
		emprestimoRepositorio.delete(getEmprestimo(id));
	}	

}
