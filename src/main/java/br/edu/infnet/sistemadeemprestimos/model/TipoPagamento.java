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
@Table(name="PaymentType")
public class TipoPagamento implements Serializable {
	
	private static final long serialVersionUID = 77440966411498897L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="payTypeCode")
	private Integer idTipoPagamento;
	
	@Column(name="paymentTypeDescription")
	private String descPagamento;

	public Integer getIdTipoPagamento() {
		return idTipoPagamento;
	}

	public void setIdTipoPagamento(Integer idTipoPagamento) {
		this.idTipoPagamento = idTipoPagamento;
	}

	public String getDescPagamento() {
		return descPagamento;
	}

	public void setDescPagamento(String descPagamento) {
		this.descPagamento = descPagamento;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
