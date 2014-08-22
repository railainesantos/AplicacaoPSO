package AplicacaoPSO;

public class Populacao {

	private Mochila[] listaMochilas;
	private int tamPopulacao;
	private int geracao;
	private Mochila pBest;
	


	// cria uma popula��o com indiv�duos sem valor, ser� composto posteriormente
	public Populacao(int tamPop) {
		tamPopulacao = tamPop;
		listaMochilas = new Mochila[tamPop];
		for (int i = 0; i < listaMochilas.length; i++) {
			listaMochilas[i] = new Mochila();
		}
	}
	
	public Populacao(int tamPop,boolean bAux) {
		tamPopulacao = tamPop;
		listaMochilas = new Mochila[tamPop];
		for (int i = 0; i < listaMochilas.length; i++) {
			listaMochilas[i] = null;
		}
	}
	// coloca uma mochila em uma certa posi��o da popula��o
	public void setMochila(Mochila mochila, int posicao) {
		listaMochilas[posicao] = mochila;
	}

	// coloca uma mochila na pr�xima posi��o dispon�vel da popula��o
	public void setMochila(Mochila mochila) {
		for (int i = 0; i < listaMochilas.length; i++) {
			if (listaMochilas[i] == null) {
				listaMochilas[i] = mochila;
				return;
			}
		}
	}
	

	public Mochila getMochila(int pos) {
		return listaMochilas[pos];
	}

	// n�mero de indiv�duos existentes na popula��o
	public int getNumMochilas() {
		int num = 0;
		for (int i = 0; i < this.listaMochilas.length; i++) {
			if (this.listaMochilas[i] != null) {
				num++;
			}
		}
		return num;
	}

	public int getTamPopulacao() {
		return tamPopulacao;
	}
	
	// ordena a popula��o pelo Peso e Valor de cada indiv�duo, do maior valor para o menor, assim se eu quiser obter o melhor indiv�duo desta popula��o, acesso a posi��o 0 do array de indiv�duos
	public void ordenaPopulacao() {
		boolean trocouPeso = true;
		while (trocouPeso) {
			trocouPeso = false;
			for (int i = 0; i < listaMochilas.length - 1; i++) {
				if (listaMochilas[i].getPesoMochila() < listaMochilas[i + 1]
						.getPesoMochila()) {
					Mochila temp = listaMochilas[i];
					listaMochilas[i] = listaMochilas[i + 1];
					listaMochilas[i + 1] = temp;
					trocouPeso = true;
				}
			}
		}


		boolean trocouValor = true;
		while (trocouValor) {
			trocouValor = false;
			for (int i = 0; i < listaMochilas.length - 1; i++) {
				if (listaMochilas[i].getPesoMochila() == listaMochilas[i + 1]
						.getPesoMochila()) {
					float valor1 = listaMochilas[i].getValorTotal();
					float valor2 = listaMochilas[i + 1].getValorTotal();
					if (valor1 < valor2) {
						Mochila temp = listaMochilas[i];
						listaMochilas[i] = listaMochilas[i + 1];
						listaMochilas[i + 1] = temp;
						trocouValor = true;
					}
				}
			}
		}

	}

	public int getGeracao() {
		return getNumMochilas();
	}

	public void setGeracao(int geracao) {
		this.geracao = geracao;
	}
	
	
	

	
}
