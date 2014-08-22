package AplicacaoPSO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Algoritimo {


	private static double pesoMaximo;

	private static List<Objeto> listaItensSetados;
	

	public static Populacao novaGeracao(Populacao populacao, Mochila gBest) {
		Random r = new Random();
		// nova população do mesmo tamanho da antiga
		Populacao novaPopulacao = new Populacao(populacao.getTamPopulacao());
		
		novaPopulacao.setMochila(gBest);

		// ordena a nova população
		novaPopulacao.ordenaPopulacao();
		return novaPopulacao;
	}


	public static List<Objeto> getListaItensSetados() {
		return listaItensSetados;
	}

	public static void setListaItensSetados(List<Objeto> listaItensSetados) {
		Algoritimo.listaItensSetados = listaItensSetados;
	}

	public static double getPesoMaximo() {
		return pesoMaximo;
	}

	public static void setPesoMaximo(double pesoMaximo) {
		Algoritimo.pesoMaximo = pesoMaximo;
	}
	
	public static void atualizaFitness(){
		
	}

}
