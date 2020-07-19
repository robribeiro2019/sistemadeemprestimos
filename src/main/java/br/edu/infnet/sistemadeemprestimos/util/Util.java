package br.edu.infnet.sistemadeemprestimos.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import br.edu.infnet.sistemadeemprestimos.model.Emprestimo;

/**
 * Classe de Utilitários
 * 
 * @author rafael.fernandes
 */
public class Util {
	
	/**
	 * Calcula valor da parcela
	 * @param emprestimo {@link Emprestimo}
	 * @return Valor da Parcela
	 */
	public static BigDecimal calcularValorParcela(Emprestimo emprestimo) {
		
		BigDecimal bgParcela = new BigDecimal(0);
		
		try {
			bgParcela = emprestimo.getMontanteDoEmprestimo().divide(new BigDecimal(emprestimo.getQuantidadeDeParcelas()), 2);
		} catch (ArithmeticException e) {
			bgParcela = new BigDecimal(0);
		}
		return bgParcela;
	}
	
	/**
	 * Adiciona Qtd ao mes na data de inicio do emprestimo
	 * @param data Data de inicio do emprestimo
	 * @param qtd  Quantidade
	 * @return Data somada
	 */
	public static Date adicionarMes(Date data, int qtd) {
		
		LocalDate dateAdd = data.toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate().plusMonths(qtd);
		
		return Date.from(dateAdd.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	/**
	 * Calcula Taxa de Juros
	 * @param bgParcela Parcela
	 * @param txJuros Taxa de Juros do Coletor
	 * @return Taxa de Juros calculada
	 */
	public static BigDecimal calcularTaxaDeJuros(BigDecimal bgParcela, BigDecimal txJuros) {
		
		BigDecimal bgTxJuros = new BigDecimal(0);
		
		try {
			bgTxJuros = bgParcela.multiply(txJuros).divide(new BigDecimal(100));
		} catch (ArithmeticException e) {
			bgTxJuros = new BigDecimal(0);
		}
		return bgTxJuros;
	}
}
