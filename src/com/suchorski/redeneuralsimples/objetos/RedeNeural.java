package com.suchorski.redeneuralsimples.objetos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
public class RedeNeural {
	
	public static final double PADRAO_MINIMO = -1000d;
	public static final double PADRAO_MAXIMO = 1000d;
	public static final double PADRAO_CORRECAO = 0.01d;
	public static final int PADRAO_BIAS = 1;
	
	private List<Camada> camadas;
	private int quantidadeNeuroniosEntrada;
	private int quantidadeNeuroniosSaida;
	private List<Integer> quantidadeNeuroniosEscondidas;
	private double pesoMinimo;
	private double pesoMaximo;
	private double correcao;
	private int quantidadeDeBias;
	private FuncaoDeAtivacao funcaoDeAtivacao;
	
	/**
	 * Construtor da classe RedeNeural
	 * @param quantidadeNeuroniosEntrada quantidade de neurônios na camada de entrada
	 * @param quantidadeNeuroniosSaida quantidade de neurônios na camada de saída
	 * @param quantidadeNeuroniosEscondidas quantidade de neurônios nas camadas escondidas
	 * @param pesoMinimo peso mínimo para geração do valor aleatório
	 * @param pesoMaximo peso máximo para geração do valor aleatório
	 * @param correcao porcentagem de correção dos pesos
	 * @param quantidadeDeBias quantidade de bias nas camadas
	 * @param funcaoDeAtivacao função de ativação
	 * @param ativador função de checagem de ativação
	 */
	public RedeNeural(int quantidadeNeuroniosEntrada, int quantidadeNeuroniosSaida, List<Integer> quantidadeNeuroniosEscondidas, double pesoMinimo, double pesoMaximo, double correcao, int quantidadeDeBias, FuncaoDeAtivacao funcaoDeAtivacao, Ativador ativador) {
		this.quantidadeNeuroniosEntrada = quantidadeNeuroniosEntrada;
		this.quantidadeNeuroniosSaida = quantidadeNeuroniosSaida;
		this.quantidadeNeuroniosEscondidas = quantidadeNeuroniosEscondidas;
		this.pesoMinimo = pesoMinimo;
		this.pesoMaximo = pesoMaximo;
		this.correcao = correcao;
		this.quantidadeDeBias = quantidadeDeBias;
		this.funcaoDeAtivacao = funcaoDeAtivacao;
		camadas = new ArrayList<Camada>(quantidadeNeuroniosEscondidas.size() + 2);
		camadas.add(new Camada(quantidadeNeuroniosEntrada, quantidadeDeBias, pesoMinimo, pesoMaximo, funcaoDeAtivacao, ativador, Optional.empty()));
		for (Integer i : quantidadeNeuroniosEscondidas) {
			camadas.add(new Camada(i, quantidadeDeBias, pesoMinimo, pesoMaximo, funcaoDeAtivacao, ativador, Optional.of(camadas.get(camadas.size() - 1))));
		}
		camadas.add(new Camada(quantidadeNeuroniosSaida, 0, pesoMinimo, pesoMaximo, funcaoDeAtivacao, ativador, Optional.of(camadas.get(camadas.size() - 1))));
	}
	
	/**
	 * Construtor da classe RedeNeural
	 * @param quantidadeNeuroniosEntrada quantidade de neurônios na camada de entrada
	 * @param quantidadeNeuroniosSaida quantidade de neurônios na camada de saída
	 * @param quantidadeNeuroniosEscondidas quantidade de neurônios nas camadas escondidas
	 * @param funcaoDeAtivacao função de ativação
	 * @param ativador função de checagem de ativação
	 */
	public RedeNeural(int quantidadeNeuroniosEntrada, int quantidadeNeuroniosSaida, List<Integer> quantidadeNeuroniosEscondidas, FuncaoDeAtivacao funcaoDeAtivacao, Ativador ativador) {
		this(quantidadeNeuroniosEntrada, quantidadeNeuroniosSaida, quantidadeNeuroniosEscondidas, PADRAO_MINIMO, PADRAO_MAXIMO, PADRAO_CORRECAO, PADRAO_BIAS, funcaoDeAtivacao, ativador);
	}

	/**
	 * Construtor da classe RedeNeural
	 * @param quantidadeNeuroniosEntrada quantidade de neurônios na camada de entrada
	 * @param quantidadeNeuroniosSaida quantidade de neurônios na camada de saída
	 * @param quantidadeNeuroniosEscondida quantidade de neurônios na camada de escondida
	 * @param funcaoDeAtivacao função de ativação
	 * @param ativador função de checagem de ativação
	 */
	public RedeNeural(int quantidadeNeuroniosEntrada, int quantidadeNeuroniosSaida, int quantidadeNeuroniosEscondida, FuncaoDeAtivacao funcaoDeAtivacao, Ativador ativador) {
		this(quantidadeNeuroniosEntrada, quantidadeNeuroniosSaida, Arrays.asList(quantidadeNeuroniosEscondida), PADRAO_MINIMO, PADRAO_MAXIMO, PADRAO_CORRECAO, PADRAO_BIAS, funcaoDeAtivacao, ativador);
	}
	
	/**
	 * Retorna todas as camadas
	 * @return retorna todas as camadas
	 */
	public List<Camada> getCamadas() {
		return camadas;
	}
	
	/**
	 * Retorna somente a camada de entrada
	 * @return retorna somente a camada de entrada
	 */
	public Camada getCamadaEntrada() {
		return camadas.get(0);
	}
	
	/**
	 * Retorna somente a camada de saída
	 * @return retorna somente a camada de saída
	 */
	public Camada getCamadaSaida() {
		return camadas.get(camadas.size() - 1);
	}
	
	/**
	 * Retorna a quantidade de neurônios na camada de entrada
	 * @return retorna a quantidade de neurônios na camada de entrada
	 */
	public int getQuantidadeNeuroniosEntrada() {
		return quantidadeNeuroniosEntrada;
	}
	
	/**
	 * Retorna a quantidade de neurônios na camada de saída
	 * @return retorna a quantidade de neurônios na camada de saída
	 */
	public int getQuantidadeNeuroniosSaida() {
		return quantidadeNeuroniosSaida;
	}
	
	/**
	 * Retorna a quantidade de neurônios nas camadas de escondidas
	 * @return retorna a quantidade de neurônios nas camadas de escondidas
	 */
	public List<Integer> getQuantidadeNeuroniosEscondidas() {
		return quantidadeNeuroniosEscondidas;
	}
	
	/**
	 * Retorna o peso mínimo para o cálculo aleatório
	 * @return retorna o peso mínimo para o cálculo aleatório
	 */
	public double getPesoMinimo() {
		return pesoMinimo;
	}
	
	/**
	 * Retorna o peso máximo para o cálculo aleatório
	 * @return retorna o peso máximo para o cálculo aleatório
	 */
	public double getPesoMaximo() {
		return pesoMaximo;
	}
	
	/**
	 * Retorna a porcentagem de correção para o cálculo aleatório
	 * @return retorna a porcentagem de correção para o cálculo aleatório
	 */
	public double getCorrecao() {
		return correcao;
	}
	
	/**
	 * Define a porcentagem de correção para o cálculo aleatório
	 * @param correcao porcentagem de correção para o cálculo aleatório
	 */
	public void setCorrecao(double correcao) {
		this.correcao = correcao;
	}
	
	/**
	 * Retorna a quantidade de bias
	 * @return retorna a quantidade de bias
	 */
	public int getQuantidadeDeBias() {
		return quantidadeDeBias;
	}
	
	/**
	 * Retorna a função de ativação
	 * @return retorna a função de ativação
	 */
	public FuncaoDeAtivacao getFuncaoDeAtivacao() {
		return funcaoDeAtivacao;
	}
	
	/**
	 * Retorna a quantidade de pesos da rede
	 * @return retorna a quantidade de pesos da rede
	 */
	public int getQuantidadeDePesos() {
		int pesos = 0;
		for (Camada c : camadas) {
			for (Neuronio n : c.getNeuronios()) {
				pesos += n.getLigacoes().size();
			}
		}
		return pesos;
	}
	
	/**
	 * Calcula os valores dos neurônios da rede
	 * @param entrada lista dos valores da camada de entrada
	 * @return lista de neurônios da camada de saída
	 */
	public List<Neuronio> calcular(List<Double> entrada) {
		Iterator<Double> it = entrada.iterator();
		for (Neuronio n : getCamadaEntrada().getNeuronios()) {
			if (!n.isBias()) {
				n.setValor(it.next());
			}
		}
		for (Camada c : camadas) {
			c.atualizarNeuronios();
		}
		return getCamadaSaida().getNeuronios();
	}
	
	/**
	 * Recalcula os pesos das ligações dos neurônios aleatoriamente
	 */
	public void recalcularPesos() {
		for (Camada c : camadas) {
			c.recalcularPesos(pesoMinimo, pesoMaximo, correcao);
		}
	}
	
	/**
	 * Retorna o DNA da rede
	 * @return retorna o DNA da rede
	 */
	public List<Double> getDna() {
		List<Double> dna = new ArrayList<Double>(getQuantidadeDePesos());
		for (Camada c : camadas) {
			for (Neuronio n : c.getNeuronios()) {
				for (Ligacao l : n.getLigacoes()) {
					dna.add(l.getPeso());
				}
			}
		}
		return dna;
	}
	
	/**
	 * Define o DNA da rede
	 * @param dna DNA da rede
	 */
	public void setDna(List<Double> dna) {
		Iterator<Double> it = dna.iterator();
		for (Camada c : camadas) {
			for (Neuronio n : c.getNeuronios()) {
				for (Ligacao l : n.getLigacoes()) {
					l.setPeso(it.next());
				}
			}
		}
	}
	
}
