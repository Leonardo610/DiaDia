package it.uniroma3.diadia.giocatore;

/**
 * Questa classe modella il giocatore che dovrà muoversi all'interno del labirinto.
 * @author Leonardo
 * @see Borsa
 * @version 0.1
 */

public class Giocatore {
	private int cfu;
	private static int CFU_INIZIALI = 20;
	private Borsa borsa;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public void consumaCfu() {
		this.cfu--;
	}
	
	public String toString() {
		return "CFU: " + this.cfu + "\n" + borsa.toString();
	}
}
