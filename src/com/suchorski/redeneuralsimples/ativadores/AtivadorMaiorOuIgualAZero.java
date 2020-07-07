package com.suchorski.redeneuralsimples.ativadores;

import com.suchorski.redeneuralsimples.interfaces.Ativador;

/**
 * Interface implementada de ativador maior ou igual a zero
 * 
 * Retorna verdadeiro para maior ou igual a zero, senão retorna falso
 * @author Thiago Suchorski
 * @version 1.0
 *
 */
public class AtivadorMaiorOuIgualAZero implements Ativador {

	@Override
	public boolean isAtivo(double valor) {
		return valor >= 0;
	}

}
