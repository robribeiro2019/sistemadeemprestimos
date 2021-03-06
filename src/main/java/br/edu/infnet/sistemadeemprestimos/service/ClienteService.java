package br.edu.infnet.sistemadeemprestimos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sistemadeemprestimos.model.Cliente;
import br.edu.infnet.sistemadeemprestimos.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepositorio;
	
	public List<Cliente> listarTodosClientes() {
		return clienteRepositorio.findAll();
	}
	
	public Cliente getCliente(Integer id) {
		return clienteRepositorio.findById((id)).orElse(new Cliente());
	}
}
