package br.edu.infnet.sistemadeemprestimos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;


@Entity
@Table(name="Collector")
public class Coletor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CollectorID")
	private Integer numeroDoColetor;
	
	@NonNull
	@Column(name="CollectorName")
	private String nomeDoColetor;

	public Integer getNumeroDoColetor() {
		return numeroDoColetor;
	}

	public void setNumeroDoColetor(Integer numeroDoColetor) {
		this.numeroDoColetor = numeroDoColetor;
	}

	public String getNomeDoColetor() {
		return nomeDoColetor;
	}

	public void setNomeDoColetor(String nomeDoColetor) {
		this.nomeDoColetor = nomeDoColetor;
	}

	
}
