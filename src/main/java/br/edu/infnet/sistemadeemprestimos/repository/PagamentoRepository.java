package br.edu.infnet.sistemadeemprestimos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.sistemadeemprestimos.modelo.Pagamento;


@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{
	

}
