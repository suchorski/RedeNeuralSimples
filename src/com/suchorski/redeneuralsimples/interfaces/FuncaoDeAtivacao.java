package com.suchorski.redeneuralsimples.interfaces;

/**
 * Interface para ativar o neurônio
 * @author Thiago Suchorski
 * @version 1.0
 *
 */
public interface FuncaoDeAtivacao {
	
	/**
	 * Função para calcular o valor de ativação
	 * @param valor valor a ser ativado
	 * @return valor ativado
	 */
	public double ativa(double valor);

}
