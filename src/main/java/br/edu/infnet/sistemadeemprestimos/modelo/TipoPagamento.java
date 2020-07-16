package br.edu.infnet.sistemadeemprestimos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PaymentType")
public class TipoPagamento {
	
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

}
