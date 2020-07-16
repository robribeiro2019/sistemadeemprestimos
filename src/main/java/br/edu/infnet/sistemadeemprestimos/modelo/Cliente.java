package br.edu.infnet.sistemadeemprestimos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;



@Entity
@Table(name="Customer")
public class Cliente {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="CustomerNumber")
	private Integer numeroDoCliente;
	
	@NonNull
	@Column(name="CustomerName")
	private String nomeDoCliente;
	
	@Column(name="Address")
	private String enderecoDoCliente;

	public Integer getNumeroDoCliente() {
		return numeroDoCliente;
	}

	public void setNumeroDoCliente(Integer numeroDoCliente) {
		this.numeroDoCliente = numeroDoCliente;
	}

	public String getNomeDoCliente() {
		return nomeDoCliente;
	}

	public void setNomeDoCliente(String nomeDoCliente) {
		this.nomeDoCliente = nomeDoCliente;
	}

	public String getEnderecoDoCliente() {
		return enderecoDoCliente;
	}

	public void setEnderecoDoCliente(String enderecoDoCliente) {
		this.enderecoDoCliente = enderecoDoCliente;
	}
	
	
}
