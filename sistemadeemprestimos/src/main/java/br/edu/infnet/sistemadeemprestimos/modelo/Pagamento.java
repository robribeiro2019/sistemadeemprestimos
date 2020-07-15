package br.edu.infnet.sistemadeemprestimos.modelo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.NonNull;

@Entity
@Table(name="Payment")
public class Pagamento {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="PaymentID")
	private Integer numeroDoPagamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DateOfPayment")
	private Date DataDoPagamento;
	
	@NonNull
	@Column(name="AmountOfPayment")
	private BigDecimal PagamentoDoMontante;	
	
	@NonNull
	@Column(name="InterestRatePayment")
	private BigDecimal PagamentoTaxaDeJuros;		
	
	@NonNull
	@Column(name="Remarks")
	private String observacoes;	
	
    @ManyToOne
	@JoinColumn(name="ContractID")
	private EmprestimoConcedido emprestimoConcedido;

	public Integer getNumeroDoPagamento() {
		return numeroDoPagamento;
	}

	public void setNumeroDoPagamento(Integer numeroDoPagamento) {
		this.numeroDoPagamento = numeroDoPagamento;
	}

	public Date getDataDoPagamento() {
		return DataDoPagamento;
	}

	public void setDataDoPagamento(Date dataDoPagamento) {
		DataDoPagamento = dataDoPagamento;
	}

	public BigDecimal getPagamentoDoMontante() {
		return PagamentoDoMontante;
	}

	public void setPagamentoDoMontante(BigDecimal pagamentoDoMontante) {
		PagamentoDoMontante = pagamentoDoMontante;
	}

	public BigDecimal getPagamentoTaxaDeJuros() {
		return PagamentoTaxaDeJuros;
	}

	public void setPagamentoTaxaDeJuros(BigDecimal pagamentoTaxaDeJuros) {
		PagamentoTaxaDeJuros = pagamentoTaxaDeJuros;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public EmprestimoConcedido getEmprestimoConcedido() {
		return emprestimoConcedido;
	}

	public void setEmprestimoConcedido(EmprestimoConcedido emprestimoConcedido) {
		this.emprestimoConcedido = emprestimoConcedido;
	}	

    
    
}
