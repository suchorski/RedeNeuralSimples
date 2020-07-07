package com.suchorski.redeneuralsimples.objetos;

/**
 * 
 * @author Thiago Suchorski
 * @version 1.0
 *
 */
public class Ligacao {
	
	private Neuronio neuronio;
	private double peso;
	
	/**
	 * Construtor da classe ligação
	 * @param neuronio neurônio de ligação
	 * @param pesoMinimo peso mínimo para geração do valor aleatório
	 * @param pesoMaximo peso máximo para geração do valor aleatório
	 */
	public Ligacao(Neuronio neuronio, double pesoMinimo, double pesoMaximo) {
		this.neuronio = neuronio;
		this.peso = Math.random() * (pesoMaximo - pesoMinimo + 1) + pesoMinimo;
	}
	
	/**
	 * Retorna o neurônio ligado
	 * @return retorna o neurônio ligado
	 */
	public Neuronio getNeuronio() {
		return neuronio;
	}
	
	/**
	 * Retorna o peso da ligação
	 * @return retorna o peso da ligação
	 */
	public double getPeso() {
		return peso;
	}
	
	/**
	 * Define o peso da ligação
	 * @param peso peso da ligação
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * Recalcula o peso do neurônio aleatóriamente
	 * @param pesoMinimo peso mínimo para geração do valor aleatório
	 * @param pesoMaximo peso máximo para geração do valor aleatório
	 * @param correcao porcentagem de correção dos pesos
	 */
	public void recalcularPeso(double pesoMinimo, double pesoMaximo, double correcao) {
		double max = pesoMaximo * correcao;
		double min = pesoMinimo * correcao;
		peso += Math.random() * (max - min + 1) + min;
	}
	
}
