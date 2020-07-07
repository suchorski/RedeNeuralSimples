package com.suchorski.redeneuralsimples.funcoesdeativacao;

import com.suchorski.redeneuralsimples.interfaces.FuncaoDeAtivacao;

/**
 * Interface implementada de função de ativação sigmoidal
 * 
 * Retorna a função sigmodal
 * @author Thiago Suchorski
 * @version 1.0
 *
 */
public class FuncaoDeAtivacaoSigmoide implements FuncaoDeAtivacao {

	@Override
	public double ativa(double valor) {
		return 1.0 / (1.0 + Math.exp(-valor));
	}

}
