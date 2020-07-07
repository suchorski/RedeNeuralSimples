package com.suchorski.redeneuralsimples.ativadores;

import com.suchorski.redeneuralsimples.interfaces.Ativador;

/**
 * Interface implementada de ativador maior que zero
 * 
 * Retorna verdadeiro para maior que zero, senão retorna falso
 * @author Thiago Suchorski
 * @version 1.0
 *
 */
public class AtivadorMaiorQueZero implements Ativador {

	@Override
	public boolean isAtivo(double valor) {
		return valor > 0;
	}

}
