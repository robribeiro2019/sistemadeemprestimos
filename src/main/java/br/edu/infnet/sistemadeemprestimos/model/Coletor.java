package br.edu.infnet.sistemadeemprestimos.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.lang.NonNull;


@Entity
@Table(name="Collector")
public class Coletor implements Serializable {
	
	private static final long serialVersionUID = 6703371814159881926L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CollectorID")
	private Integer numeroDoColetor;
	
	@NonNull
	@Column(name="CollectorName")
	private String nomeDoColetor;
	
	@NotNull(message = "Valor da taxa de juros é obrigatório")
	@Column(name="InterestRate")
	private BigDecimal taxaDeJuros;

	public BigDecimal getTaxaDeJuros() {
		return taxaDeJuros;
	}

	public void setTaxaDeJuros(BigDecimal taxaDeJuros) {
		this.taxaDeJuros = taxaDeJuros;
	}

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
