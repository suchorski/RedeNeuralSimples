package com.suchorski.redeneuralsimples.funcoesdeativacao;

import com.suchorski.redeneuralsimples.interfaces.FuncaoDeAtivacao;

/**
 * Interface implementada de função de ativação Relu derivada em X
 * 
 * Retorna a função Relu derivada em X
 * @author Thiago Suchorski
 * @version 1.0
 *
 */
public class FuncaoDeAtivacaoReluDX implements FuncaoDeAtivacao {
	
	@Override
	public double ativa(double valor) {
		return valor >= 0 ? 1 : 0;
	}

}
