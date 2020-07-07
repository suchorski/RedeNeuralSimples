package com.suchorski.redeneuralsimples.objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.suchorski.redeneuralsimples.interfaces.Ativador;
import com.suchorski.redeneuralsimples.interfaces.FuncaoDeAtivacao;

/**
 * 
 * @author Thiago Suchorski
 * @version 1.0
 *
 */
public class Camada {
	
	private List<Neuronio> neuronios;
	
	/**
	 * Construtor da classe camada
	 * @param quantidadeDeNeuronios quantidade de neurônios
	 * @param quantidadeDeBias quantidade de bias
	 * @param pesoMinimo peso mínimo para geração do valor aleatório
	 * @param pesoMaximo peso máximo para geração do valor aleatório
	 * @param funcaoDeAtivacao função de ativação
	 * @param ativador função de checagem de ativação
	 * @param camadaAnterior camada anterior utilizando a classe Optional do Java
	 */
	public Camada(int quantidadeDeNeuronios, int quantidadeDeBias, double pesoMinimo, double pesoMaximo, FuncaoDeAtivacao funcaoDeAtivacao, Ativador ativador, Optional<Camada> camadaAnterior) {
		neuronios = new ArrayList<Neuronio>(quantidadeDeNeuronios + quantidadeDeBias);
		for (int i = 0; i < quantidadeDeNeuronios; ++i) {
			Neuronio neuronio = new Neuronio(funcaoDeAtivacao, ativador);
			camadaAnterior.ifPresent(c -> {
				for (Neuronio n : c.getNeuronios()) {
					neuronio.getLigacoes().add(new Ligacao(n, pesoMinimo, pesoMaximo));
				}
			});
			neuronios.add(neuronio);
		}
		for (int i = 0; i < quantidadeDeBias; ++i) {
			neuronios.add(new Neuronio());
		}
	}

	/**
	 * Retorna os neurônios
	 * @return retorna os neurônios
	 */
	public List<Neuronio> getNeuronios() {
		return neuronios;
	}
	
	/**
	 * Atualiza os valores dos neurônios
	 */
	public void atualizarNeuronios() {
		for (Neuronio n : neuronios) {
			n.calcularValor();
		}
	}
	
	/**
	 * Recalcula os pesos dos neurônios
	 * @param pesoMinimo peso mínimo para geração do valor aleatório
	 * @param pesoMaximo peso máximo para geração do valor aleatório
	 * @param correcao porcentagem de correção dos pesos
	 */
	public void recalcularPesos(double pesoMinimo, double pesoMaximo, double correcao) {
		for (Neuronio n : neuronios) {
			n.recalcularPesos(pesoMinimo, pesoMaximo, correcao);
		}
	}
	
}
