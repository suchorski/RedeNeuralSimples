package com.suchorski.redeneuralsimples.interfaces;

/**
 * Interface para verificar se o neurônio está ativo
 * @author Thiago Suchorski
 * @version 1.0
 *
 */
public interface Ativador {
	
	/**
	 * Verifica se o neurônio está ativo
	 * @param valor valor do neurônio
	 * @return verdadeiro/falso se está ativo ou não
	 */
	public boolean isAtivo(double valor);

}
