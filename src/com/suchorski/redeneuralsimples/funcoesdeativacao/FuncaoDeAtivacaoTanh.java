package com.suchorski.redeneuralsimples.funcoesdeativacao;

import com.suchorski.redeneuralsimples.interfaces.FuncaoDeAtivacao;

/**
 * Interface implementada de função de ativação de tangente hiperbólica
 * 
 * Retorna a função de tangente hiperbólica
 * @author Thiago Suchorski
 * @version 1.0
 *
 */
public class FuncaoDeAtivacaoTanh implements FuncaoDeAtivacao {

	@Override
	public double ativa(double valor) {
		return 2.0 / (1.0 + Math.exp(-2 * valor)) - 1.0;
	}

}
