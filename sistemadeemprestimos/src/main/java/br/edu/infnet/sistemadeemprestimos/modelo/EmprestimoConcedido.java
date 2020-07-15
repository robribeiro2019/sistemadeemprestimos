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
@Table(name="LoanContract")
public class EmprestimoConcedido {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="ContractID")
	private Integer numeroDoContrato;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DateContractStarts")
	private Date DataInicioContrato;	

	@Temporal(TemporalType.DATE)
	@Column(name="DateContractEnds")
	private Date DataFimContrato;	
	
	@NonNull
	@Column(name="InterestRate")
	private BigDecimal TaxaDeJuros;
	
	@NonNull
	@Column(name="LoanAmount")
	private BigDecimal MontanteDoEmprestimo;	
	
	@NonNull
	@Column(name="LoanPaymentAmountDue")
	private BigDecimal MontanteDoEmprestimoDevido;
	
	@Column(name="LoanPaymentFrequency")
	private Integer QuantidadeDeParcelas;	
	
	@Temporal(TemporalType.DATE)
	@Column(name="LoanPaymentDueDate")
	private Date DataProximoVencimento;		
	
    @ManyToOne
	@JoinColumn(name="CustomerNumber")
	private Cliente cliente;	
    
    @ManyToOne
	@JoinColumn(name="CollectorID")
	private Coletor coletor;

    
	public Integer getNumeroDoContrato() {
		return numeroDoContrato;
	}

	public void setNumeroDoContrato(Integer numeroDoContrato) {
		this.numeroDoContrato = numeroDoContrato;
	}

	public Date getDataInicioContrato() {
		return DataInicioContrato;
	}

	public void setDataInicioContrato(Date dataInicioContrato) {
		DataInicioContrato = dataInicioContrato;
	}

	public Date getDataFimContrato() {
		return DataFimContrato;
	}

	public void setDataFimContrato(Date dataFimContrato) {
		DataFimContrato = dataFimContrato;
	}

	public BigDecimal getTaxaDeJuros() {
		return TaxaDeJuros;
	}

	public void setTaxaDeJuros(BigDecimal taxaDeJuros) {
		TaxaDeJuros = taxaDeJuros;
	}

	public BigDecimal getMontanteDoEmprestimo() {
		return MontanteDoEmprestimo;
	}

	public void setMontanteDoEmprestimo(BigDecimal montanteDoEmprestimo) {
		MontanteDoEmprestimo = montanteDoEmprestimo;
	}

	public BigDecimal getMontanteDoEmprestimoDevido() {
		return MontanteDoEmprestimoDevido;
	}

	public void setMontanteDoEmprestimoDevido(BigDecimal montanteDoEmprestimoDevido) {
		MontanteDoEmprestimoDevido = montanteDoEmprestimoDevido;
	}

	public Integer getQuantidadeDeParcelas() {
		return QuantidadeDeParcelas;
	}

	public void setQuantidadeDeParcelas(Integer quantidadeDeParcelas) {
		QuantidadeDeParcelas = quantidadeDeParcelas;
	}

	public Date getDataProximoVencimento() {
		return DataProximoVencimento;
	}

	public void setDataProximoVencimento(Date dataProximoVencimento) {
		DataProximoVencimento = dataProximoVencimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Coletor getColetor() {
		return coletor;
	}

	public void setColetor(Coletor coletor) {
		this.coletor = coletor;
	}	    
	
}
