package AplicacaoPSO;

import java.text.DecimalFormat;

public class Objeto {

	private float peso;

	private float valor;
	
	private float ratio;
	
	

	public Objeto(int peso, int valor) {
		this.peso = peso;
		this.valor = valor;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (((((Objeto) obj).getPeso()) == this.getPeso())
				&& ((((Objeto) obj).getPeso()) == this.getPeso())) {
			return true;
		}
		return false;
	}

	public float getRatio() {
		return ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat();  
		df.applyPattern("0.00");  
		return "(" + this.peso + "; " + this.valor +  " )";
	}

}
