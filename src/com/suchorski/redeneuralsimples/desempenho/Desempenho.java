package com.suchorski.redeneuralsimples.desempenho;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.suchorski.redeneuralsimples.objetos.RedeNeural;

/**
 * Classe auxiliar somente para calcular a quantidade de popução ideal
 * @author Thiago Suchorski
 *
 * @param <T> classe que estende RedeNeural
 */
public class Desempenho <T extends RedeNeural> {
	
	/**
	 * Calcula a quantidade de redes a serem usadas em determinado tempo em milisegundos
	 * @param <T> classe que estende RedeNeural
	 * @param redeNeural rede a ser calculada
	 * @param tempoEmMs tempo em milisegundos
	 * @return quantidade de redes calculadas no tempo solicitado
	 */
	public static <T> int quantidade(T redeNeural, int tempoEmMs) {
		int quantidadeDePesos = ((RedeNeural) redeNeural).getQuantidadeDePesos();
		List<Double> entrada = new ArrayList<Double>(quantidadeDePesos);
		IntStream.range(0, quantidadeDePesos).forEach(i -> entrada.add(Math.random()));
		long ticks = System.nanoTime();
		((RedeNeural) redeNeural).calcular(entrada);
		return (int) (tempoEmMs * 1_000_000 / (System.nanoTime() - ticks));
	}
	
	/**
	 * Calcula a quantidade de redes a serem usadas em um segundo
	 * @param <T> classe que estende RedeNeural
	 * @param redeNeural rede a ser calculada
	 * @return quantidade de redes calculadas no tempo solicitado
	 */
	public static <T> int quantidadePorSegundo(T redeNeural) {
		return quantidade(redeNeural, 1000);
	}

}
