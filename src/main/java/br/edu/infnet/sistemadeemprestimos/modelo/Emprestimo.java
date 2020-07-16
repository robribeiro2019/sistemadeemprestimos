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

import org.springframework.data.annotation.Transient;
import org.springframework.lang.NonNull;


@Entity
@Table(name="LoanContract")
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ContractID")
	private Integer numeroDoContrato;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DateContractStarts")
	private Date dataInicioContrato;	

	@Temporal(TemporalType.DATE)
	@Column(name="DateContractEnds")
	private Date dataFimContrato;	
	
	@NonNull
	@Column(name="InterestRate")
	private BigDecimal taxaDeJuros;
	
	@NonNull
	@Column(name="LoanAmount")
	private BigDecimal montanteDoEmprestimo;	
	
	@NonNull
	@Column(name="LoanPaymentAmountDue")
	private Double montanteDoEmprestimoDevido;
	
	@Column(name="LoanPaymentFrequency")
	private Integer quantidadeDeParcelas;	
	
	@Temporal(TemporalType.DATE)
	@Column(name="LoanPaymentDueDate")
	private Date dataProximoVencimento;		
	
    @ManyToOne
	@JoinColumn(name="CustomerNumber")
	private Cliente cliente;	
    
    @ManyToOne
	@JoinColumn(name="CollectorID")
	private Coletor coletor;
    
    @Transient
    private String status;

	public Integer getNumeroDoContrato() {
		return numeroDoContrato;
	}

	public void setNumeroDoContrato(Integer numeroDoContrato) {
		this.numeroDoContrato = numeroDoContrato;
	}

	public Date getDataInicioContrato() {
		return dataInicioContrato;
	}

	public void setDataInicioContrato(Date dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
	}

	public Date getDataFimContrato() {
		return dataFimContrato;
	}

	public void setDataFimContrato(Date dataFimContrato) {
		this.dataFimContrato = dataFimContrato;
	}

	public BigDecimal getTaxaDeJuros() {
		return taxaDeJuros;
	}

	public void setTaxaDeJuros(BigDecimal taxaDeJuros) {
		this.taxaDeJuros = taxaDeJuros;
	}

	public BigDecimal getMontanteDoEmprestimo() {
		return montanteDoEmprestimo;
	}

	public void setMontanteDoEmprestimo(BigDecimal montanteDoEmprestimo) {
		this.montanteDoEmprestimo = montanteDoEmprestimo;
	}

	public Double getMontanteDoEmprestimoDevido() {
		return montanteDoEmprestimoDevido;
	}

	public void setMontanteDoEmprestimoDevido(Double montanteDoEmprestimoDevido) {
		this.montanteDoEmprestimoDevido = montanteDoEmprestimoDevido;
	}

	public Integer getQuantidadeDeParcelas() {
		return quantidadeDeParcelas;
	}

	public void setQuantidadeDeParcelas(Integer quantidadeDeParcelas) {
		this.quantidadeDeParcelas = quantidadeDeParcelas;
	}

	public Date getDataProximoVencimento() {
		return dataProximoVencimento;
	}

	public void setDataProximoVencimento(Date dataProximoVencimento) {
		this.dataProximoVencimento = dataProximoVencimento;
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

	public String getStatus() {
		
		Date hoje = new Date();
		
		if(dataProximoVencimento.compareTo(hoje) > 0) {	
			return "Regular";
		}else if (dataProximoVencimento.compareTo(hoje) < 0 && montanteDoEmprestimoDevido > 0) {
			return "Vencido";
		}else if (montanteDoEmprestimoDevido == 0 ){
			return "Quitado";
		}
		
		return "Sem Status";
		
	}	  
	
	
	
}
