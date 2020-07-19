package br.edu.infnet.sistemadeemprestimos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name="Customer")
public class Cliente implements Serializable {

	private static final long serialVersionUID = -6303035483179479166L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CustomerNumber")
	private Integer numeroDoCliente;
	
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
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
