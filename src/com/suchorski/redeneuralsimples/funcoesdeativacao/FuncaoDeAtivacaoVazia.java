package com.suchorski.redeneuralsimples.funcoesdeativacao;

import com.suchorski.redeneuralsimples.interfaces.FuncaoDeAtivacao;

/**
 * Interface implementada de função de ativação vazia
 * 
 * Retorna sempre o mesmo valor
 * @author Thiago Suchorski
 * @version 1.0
 *
 */
public class FuncaoDeAtivacaoVazia implements FuncaoDeAtivacao {

	@Override
	public double ativa(double valor) {
		return valor;
	}

}
