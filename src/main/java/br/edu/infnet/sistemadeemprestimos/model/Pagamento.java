package br.edu.infnet.sistemadeemprestimos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.lang.NonNull;

@Entity
@Table(name="Payment")
public class Pagamento implements Serializable {
	
	private static final long serialVersionUID = -409252652793914658L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PaymentID")
	private Integer numeroDoPagamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DateOfPayment")
	private Date dataDoPagamento;
	
	@NonNull
	@Column(name="AmountOfPayment")
	private BigDecimal pagamentoDoMontante;	
	
	@NonNull
	@Column(name="InterestRatePayment")
	private BigDecimal pagamentoTaxaDeJuros;		
	
	@NonNull
	@Column(name="Remarks")
	private String observacoes;
	
    public Pagamento() {
		super();
	}

	public Pagamento(BigDecimal pagamentoDoMontante, BigDecimal pagamentoTaxaDeJuros, String observacoes,
			Emprestimo emprestimoConcedido) {
		
		this.pagamentoDoMontante = pagamentoDoMontante;
		this.pagamentoTaxaDeJuros = pagamentoTaxaDeJuros;
		this.observacoes = observacoes;
		this.emprestimoConcedido = emprestimoConcedido;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ContractID")
	private Emprestimo emprestimoConcedido;
    
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name="PaymentID")
    private List<TipoPagamento> tipoPagamento;
    
    

	public Integer getNumeroDoPagamento() {
		return numeroDoPagamento;
	}

	public void setNumeroDoPagamento(Integer numeroDoPagamento) {
		this.numeroDoPagamento = numeroDoPagamento;
	}

	public Date getDataDoPagamento() {
		return dataDoPagamento;
	}

	public void setDataDoPagamento(Date dataDoPagamento) {
		this.dataDoPagamento = dataDoPagamento;
	}

	public BigDecimal getPagamentoDoMontante() {
		return pagamentoDoMontante;
	}

	public void setPagamentoDoMontante(BigDecimal pagamentoDoMontante) {
		this.pagamentoDoMontante = pagamentoDoMontante;
	}

	public BigDecimal getPagamentoTaxaDeJuros() {
		return pagamentoTaxaDeJuros;
	}

	public void setPagamentoTaxaDeJuros(BigDecimal pagamentoTaxaDeJuros) {
		this.pagamentoTaxaDeJuros = pagamentoTaxaDeJuros;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Emprestimo getEmprestimoConcedido() {
		return emprestimoConcedido;
	}

	public void setEmprestimoConcedido(Emprestimo emprestimoConcedido) {
		this.emprestimoConcedido = emprestimoConcedido;
	}

	public List<TipoPagamento> getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(List<TipoPagamento> tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
