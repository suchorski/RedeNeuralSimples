package com.suchorski.redeneuralsimples.funcoesdeativacao;

import com.suchorski.redeneuralsimples.interfaces.FuncaoDeAtivacao;

/**
 * Interface implementada de função de ativação Relu
 * 
 * Retorna a função Relu
 * @author Thiago Suchorski
 * @version 1.0
 *
 */
public class FuncaoDeAtivacaoRelu implements FuncaoDeAtivacao {
	
	@Override
	public double ativa(double valor) {
		return valor > 0 ? valor : 0;
	}

}
