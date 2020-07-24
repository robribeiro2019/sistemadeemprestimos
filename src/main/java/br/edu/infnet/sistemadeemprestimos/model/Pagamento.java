package br.edu.infnet.sistemadeemprestimos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

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
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="DueDate")
	private Date dataVencimento;	
	
	@Column(name="AmountOfPayment")
	private BigDecimal pagamentoDoMontante;	
	
	@Column(name="InterestRatePayment")
	private BigDecimal pagamentoTaxaDeJuros;		
	
	@Column(name="Remarks")
	private String observacoes;
	
    public Pagamento() {
		super();
	}
    
    
	public Pagamento(BigDecimal pagamentoDoMontante, Date dataVencimento, BigDecimal pagamentoTaxaDeJuros, String observacoes,
			Emprestimo emprestimo) {
		
		this.pagamentoDoMontante  = pagamentoDoMontante;
		this.dataVencimento       = dataVencimento;
		this.pagamentoTaxaDeJuros = pagamentoTaxaDeJuros;
		this.observacoes          = observacoes;
		this.emprestimo			  = emprestimo;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ContractID")
	private Emprestimo emprestimo;
    
   
    @OneToOne
    @JoinColumn(name="payTypeCode")
    private TipoPagamento tipoPagamento;
    
    @Transient
    private String status;
    
    
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}


	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}


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


	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getStatus() {
		
		Date dateNow = new Date();
		
		if(dataVencimento.compareTo(dateNow) > 0 && dataDoPagamento==null) {	
			return "Regular";
		}else if (dataVencimento.compareTo(dateNow) < 0 && dataDoPagamento==null) {
			return "Vencido";
		}else if (dataDoPagamento!=null && pagamentoTaxaDeJuros.doubleValue() > 0 ){
			return "Quitado";
		}else if (dataDoPagamento!=null && pagamentoTaxaDeJuros.doubleValue() == 0 ){
			return "Parcial";
		}
		
		return "Sem Status";
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
