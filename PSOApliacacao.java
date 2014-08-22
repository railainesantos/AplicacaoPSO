package AplicacaoPSO;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PSOApliacacao {

	public static int mochilaMGeracao = 1;
	public static Mochila mochilaGBest = null;
	
	public static void main(String[] args) {
		
		List<Objeto> listaObjetos = new ArrayList<Objeto>();

		listaObjetos.add(new Objeto(3, 5));

		listaObjetos.add(new Objeto(5, 2));

		listaObjetos.add(new Objeto(7, 3));

		listaObjetos.add(new Objeto(2, 8));

		listaObjetos.add(new Objeto(8, 9));

		listaObjetos.add(new Objeto(4, 3));

		listaObjetos.add(new Objeto(4, 2));

		listaObjetos.add(new Objeto(3, 4));

		listaObjetos.add(new Objeto(7, 5));

		listaObjetos.add(new Objeto(2, 1));

		listaObjetos.add(new Objeto(3, 2));

		listaObjetos.add(new Objeto(5, 6));

		listaObjetos.add(new Objeto(4, 3));

		listaObjetos.add(new Objeto(3, 2));
		
		// Define os itens existentes no problema
		Algoritimo.setListaItensSetados(listaObjetos);
		
		// Define o peso maximo da mochila
		Algoritimo.setPesoMaximo(25);

		// tamanho da população
		int tamPop = 10;

		// numero máximo de gerações
		int numMaxGeracoes = 100;

		// cria a primeira população aleatérioa
		Populacao populacao = new Populacao(tamPop);
	
			
		int geracao = 0;
		
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*Problema Mochila*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*" 
		+"\n Lista de Itens Setados:" + listaObjetos.toString());
//		
		
		System.out.println("Iniciando... ");
		 
		// loop até o critério de parada
		while (geracao < numMaxGeracoes) {
			geracao++;

			// cria nova populacao
			populacao = Algoritimo.novaGeracao(populacao,mochilaGBest);

			System.out.println("Geração  " + geracao +  
					" .. Peso: " 	+ populacao.getMochila(0).getPesoMochila() +
					" .. Valor: " + populacao.getMochila(0).getValorTotal()	+
					" .. Melhor: " + populacao.getMochila(0).getListaItensMochila()
					) ;

			// armazena a gBest solucao
			gravaGBest(populacao, geracao);

			
		}

		if (geracao == numMaxGeracoes) {
			System.out.println("Melhor Resultado :");
			System.out.println("Geração " + mochilaMGeracao
					+ " .. Peso: " + mochilaGBest.getPesoMochila()
					+ " .. Valor: " + mochilaGBest.getValorTotal()
					+ " .. Localidade : "	+ mochilaGBest.getLocalidade().getX() 
					+ " .. Localidade : "	+ mochilaGBest.getLocalidade().getY() 
					+ " .. Velocidade : "	+ mochilaGBest.getVelocidade().getX()
					+ " .. Velocidade : "	+ mochilaGBest.getVelocidade().getY()
					+ " .. Melhor : "	+ mochilaGBest.getListaItensMochila() 
					);
		}

	}

	
	// Armazena o mochilaGBest mochila ate agora
	private static void gravaGBest(Populacao populacao, int geracao) {
		if (mochilaGBest == null) {
			mochilaGBest = populacao.getMochila(0);
		} else {
			if (mochilaGBest.getPesoMochila() < populacao.getMochila(0).getPesoMochila()) {
				mochilaGBest = populacao.getMochila(0);
			}
			if (mochilaGBest.getPesoMochila() == populacao.getMochila(0)
					.getPesoMochila()) {
				if (mochilaGBest.getValorTotal() < populacao.getMochila(0)
						.getValorTotal()) {
					mochilaGBest = populacao.getMochila(0);
					mochilaMGeracao = geracao;
				}
			}
		}

	}
	

}
