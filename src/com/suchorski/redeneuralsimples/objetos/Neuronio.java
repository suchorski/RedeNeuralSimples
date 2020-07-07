package com.suchorski.redeneuralsimples.objetos;

import java.util.ArrayList;
import java.util.List;

import com.suchorski.redeneuralsimples.interfaces.Ativador;
import com.suchorski.redeneuralsimples.interfaces.FuncaoDeAtivacao;

/**
 * 
 * @author Thiago Suchorski
 * @version 1.0
 *
 */
public class Neuronio {
	
	private double valor;
	private boolean isBias;
	private FuncaoDeAtivacao funcaoDeAtivacao;
	private Ativador ativador;
	private List<Ligacao> ligacoes;
	
	/**
	 * Construtor da classe neurônio
	 */
	public Neuronio() {
		this.valor = 1;
		this.isBias = true;
		this.funcaoDeAtivacao = new FuncaoDeAtivacao() {
			@Override
			public double ativa(double valor) {
				return 1;
			}
		};
		this.ativador = new Ativador() {
			@Override
			public boolean isAtivo(double valor) {
				return true;
			}
		};
		this.ligacoes = new ArrayList<Ligacao>();
	}
	
	/**
	 * Construtor da classe neurônio
	 * @param funcaoDeAtivacao função de ativação
	 * @param ativador função de checagem de ativação
	 */
	public Neuronio(FuncaoDeAtivacao funcaoDeAtivacao, Ativador ativador) {
		this.valor = 0;
		this.isBias = false;
		this.funcaoDeAtivacao = funcaoDeAtivacao;
		this.ativador = ativador;
		this.ligacoes = new ArrayList<Ligacao>();
	}
	
	/**
	 * Retorna o valor do neurônio
	 * @return retorna o valor do neurônio
	 */
	public double getValor() {
		return valor;
	}
	
	/**
	 * Define o valor do neurônio
	 * @param valor define o valor do neurônio
	 */
	public void setValor(double valor) {
		this.valor = isBias ? 1 : valor;
	}
	
	/**
	 * Retorna verdadeiro/false se é bias
	 * @return retorna verdadeiro/false se é bias
	 */
	public boolean isBias() {
		return isBias;
	}
	
	/**
	 * Retorna se o neurônio está ativo
	 * @return retorna se o neurônio está ativo
	 */
	public boolean isAtivo() {
		return ativador.isAtivo(valor);
	}
	
	/**
	 * Retorna as ligações do neurônio
	 * @return retorna as ligações do neurônio
	 */
	public List<Ligacao> getLigacoes() {
		return ligacoes;
	}
	
	/**
	 * Calcula o valor do neurônio
	 */
	public void calcularValor() {
		if (!isBias && ligacoes.size() > 0) {
			double soma = 0;
			for (Ligacao l : ligacoes) {
				soma += l.getPeso() * l.getNeuronio().getValor();
			}
			valor = funcaoDeAtivacao.ativa(soma);
		}
	}

	/**
	 * Recalcula os pesos do neurônio aleatoriamente
	 * @param pesoMinimo peso mínimo para geração do valor aleatório
	 * @param pesoMaximo peso máximo para geração do valor aleatório
	 * @param correcao porcentagem de correção dos pesos
	 */
	public void recalcularPesos(double pesoMinimo, double pesoMaximo, double correcao) {
		for (Ligacao l : ligacoes) {
			l.recalcularPeso(pesoMinimo, pesoMaximo, correcao);
		}
	}
	
}
