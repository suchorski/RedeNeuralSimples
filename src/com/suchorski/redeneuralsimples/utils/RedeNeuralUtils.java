package com.suchorski.redeneuralsimples.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Classe de utilitários para carregar e salvar o DNA da rede neural
 * @author Thiago Suchorski
 * @version 1.0
 *
 */
public class RedeNeuralUtils {
	
	/**
	 * Método para salvar um DNA
	 * @param nomeDoArquivo nome do arquivo para salvar
	 * @param dna DNA a ser salvo
	 * @param id identificador do DNA
	 * @throws FileNotFoundException Se o arquivo não for encontrado
	 */
	public synchronized static void salvarDna(String nomeDoArquivo, List<Double> dna, long id) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(new File(nomeDoArquivo))) {
			pw.println(id);
			for (double d : dna) {
				pw.println(d);
			}
		}
	}
	
	/**
	 * Método para carregar um DNA
	 * @param nomeDoArquivo nome do arquivo para salvar
	 * @param dna lista para carregar o DNA
	 * @return identificador do DNA
	 * @throws FileNotFoundException Se o arquivo não for encontrado
	 */
	public synchronized static long carregarDna(String nomeDoArquivo, List<Double> dna) throws FileNotFoundException {
		try (Scanner s = new Scanner(new File(nomeDoArquivo))) {
			s.useLocale(Locale.ENGLISH);
			long pontuacao = 0;
			while (s.hasNextInt()) {
				pontuacao = s.nextInt();
			}
			while (s.hasNextDouble()) {
				dna.add(s.nextDouble());
			}
			return pontuacao;
		}
	}

}
