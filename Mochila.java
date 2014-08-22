package AplicacaoPSO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mochila {

	private List<Objeto> listaItensMochila;

	private float pesoMochila = 0;

	private float valorTotal = 0;
	
	private Posicao localidade;
	 
	private Velocidade velocidade;
	 
	private double fitness;

	// gera uma mochila aleatoria
	public Mochila() {
		listaItensMochila = new ArrayList<Objeto>();

		Random r = new Random();
		List<Objeto> itens = new ArrayList<Objeto>();
		itens.addAll(Algoritimo.getListaItensSetados());
		Random generator = new Random();

		Objeto aux = new Objeto(0, 0);
		aux = itens.get(r.nextInt(itens.size()));

		// adiciona itens a mochila ate atingir o peso maximo
		for (int i = 0; i < 100; i++) {
			if ((this.getPesoMochila() + aux.getPeso()) <= (Algoritimo
					.getPesoMaximo())) {
				listaItensMochila.add(aux);
				itens.remove(aux);
				if ((this.getPesoMochila() + aux.getPeso()) == (Algoritimo
						.getPesoMaximo())) {
					i = 100;
				}
			}
			aux = itens.get(r.nextInt(itens.size()));
		}
//		
//
//		
//		 System.out.println("Peso mochila:" + this.getPesoMochila()); 
//		 System.out.println("Valor mochila:"+ this.getValorTotal()); 
//		
		 Integer posX = (int) (generator.nextInt(5)+1 *this.getPesoMochila());
		 Integer posY = (int)  (generator.nextInt(5)+1 *this.getValorTotal() );
		 this.setLocalidade(new Posicao(posX, posY));
		 
		 Integer velX =  (int) (generator.nextInt(10)+1);
		 Integer velY =  (int) (generator.nextInt(10)+1);
		 this.setVelocidade(new Velocidade(velX, velY));

		this.getPesoMochila();
		this.getValorTotal();
	}

	// cria um indivíduo com os listaItensMochila definidos
	public Mochila(List<Objeto> listaItensMochila) {

		this.listaItensMochila = listaItensMochila;

		//testa se o mochila criada extrapolou o peso da mochila
		if (!naoEstorou()) {
			this.listaItensMochila = listaItensMochila;
			//testa novamente com os listaItensMochila iniciais, pois pode ter havido mutacao
			if (!naoEstorou()) {
				//se o peso for maior que o max permitido, cria uma nova mochila aleatoria
				novaMochila();
			}
		}

		//carrega o peso e o valor
		this.getPesoMochila();
		this.getValorTotal();

	}

	
	// cria uma nova mochila aleatoria
	private void novaMochila() {
		listaItensMochila = new ArrayList<Objeto>();

		Random r = new Random();
		List<Objeto> itens = new ArrayList<Objeto>();
		itens.addAll(Algoritimo.getListaItensSetados());

		Objeto aux = new Objeto(0, 0);
		aux = itens.get(r.nextInt(itens.size()));

		
		//adiciona os itens na mochila conciderando a regra:
		//ou o item esta na mochila ou nao esta, ou seja,
		// tenta adicionar se nao der joga fora...
		while((!itens.isEmpty())){
			if ((this.getPesoMochila() + aux.getPeso()) <= (Algoritimo
					.getPesoMaximo())) {
				listaItensMochila.add(aux);
			}
			aux = itens.get(r.nextInt(itens.size()));
			itens.remove(aux);
		}

		//carrega o peso e o valor
		this.getPesoMochila();
		this.getValorTotal();

	}

	// Verifica se o mochila criada extrapolou o peso da mochila
	public boolean naoEstorou() {
		if  (this.getPesoMochila() > Algoritimo.getPesoMaximo())
//				||(this.getValorTotal() > 35)) 
		{
			return false;
		}
		return true;
	}

	public List<Objeto> getListaItensMochila() {
		return listaItensMochila;
	}

	public void setListaItensMochila(List<Objeto> listaItensMochila) {
		this.listaItensMochila = listaItensMochila;
	}

	public float getPesoMochila() {
		pesoMochila = 0;
		for (int i = 0; i < listaItensMochila.size(); i++) {
			pesoMochila = pesoMochila + listaItensMochila.get(i).getPeso();
		}
		return pesoMochila;
	}

	public void setPesoMochila(float pesoMochila) {
		this.pesoMochila = pesoMochila;
	}

	public float getValorTotal() {
		valorTotal = 0;
		for (int i = 0; i < listaItensMochila.size(); i++) {
			valorTotal = valorTotal + listaItensMochila.get(i).getValor();
		}
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	

	public double getFitness() {
		 calculateFitness();
		 return fitness;
		 }
		 
	public void calculateFitness() {
		 double x = this.localidade.getX();
		 double y = this.localidade.getY();
		 
		 fitness = Math.pow((2.8125 - x + x * Math.pow(y, 4)), 2) +
		 Math.pow((2.25 - x + x * Math.pow(y, 2)), 2) +
		 Math.pow((1.5 - x + x * y), 2);
		 }
	 
	public Posicao getLocalidade() {
		 return localidade;
		 }

	 public void setLocalidade(Posicao localidade) {
		 this.localidade = localidade;
		 }
		 
	 public Velocidade getVelocidade() {
		 return velocidade;
		 }
		 
	 public void setVelocidade(Velocidade velocidade) {
		 this.velocidade = velocidade;
		 }
	
}
