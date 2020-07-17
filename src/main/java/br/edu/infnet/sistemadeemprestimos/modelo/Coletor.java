package br.edu.infnet.sistemadeemprestimos.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
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
	
	@NotNull(message = "Valor da taxa de juros é obrigatório")
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
	@DecimalMax(value = "9999999.99", message = "Valor não pode ser maior que 9.999.999,99")
	@NumberFormat(pattern = "#,##0.00") 
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

	
}
