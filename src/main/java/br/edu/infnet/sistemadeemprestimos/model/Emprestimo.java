package br.edu.infnet.sistemadeemprestimos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name="LoanContract")
public class Emprestimo implements Serializable {
	
	private static final long serialVersionUID = 507293577398905243L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ContractID")
	private Integer numeroDoContrato;
	
	@NotNull(message = "Date de início de contrato é obrigatória")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="DateContractStarts")
	private Date dataInicioContrato;	

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="DateContractEnds")
	private Date dataFimContrato;	

	@NotNull(message = "Valor do emprestimo é obrigatório")
	@NumberFormat(pattern = "#,##0.00")  
	@Column(name="LoanAmount")
	private BigDecimal montanteDoEmprestimo;	
	
	@NumberFormat(pattern = "#,##0.00") 
	@Column(name="LoanPaymentAmountDue")
	private Double montanteDoEmprestimoDevido;
	
	@NotNull(message = "Quantidade de Parcelas é obrigatório")
	@Column(name="LoanPaymentFrequency")
	private Integer quantidadeDeParcelas;	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="LoanPaymentDueDate")
	private Date dataProximoVencimento;		
	
	@OneToOne
	@JoinColumn(name="CustomerNumber")
	private Cliente cliente;	
    
    @OneToOne
	@JoinColumn(name="CollectorID")
	private Coletor coletor;
    
    @OneToMany(mappedBy = "emprestimoId", fetch = FetchType.EAGER)
	private List<Pagamento> pagamentos;
    
	@Column(name="Remarks")
	private String observacoes;
    
    @Transient
    private String status;
    
    @Transient
    private String tipoForm;
    
	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

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
	
	public String getTipoForm() {
		return tipoForm;
	}

	public void setTipoForm(String tipoForm) {
		this.tipoForm = tipoForm;
	}

	public String getStatus() {
		
		Date dateNow = new Date();
		
		if(dataProximoVencimento.compareTo(dateNow) > 0 && montanteDoEmprestimoDevido > 0) {	
			return "Regular";
		}else if (dataProximoVencimento.compareTo(dateNow) < 0 && montanteDoEmprestimoDevido > 0) {
			return "Vencido";
		}else if (montanteDoEmprestimoDevido == 0 ){
			return "Quitado";
		}
		
		return "Sem Status";
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
