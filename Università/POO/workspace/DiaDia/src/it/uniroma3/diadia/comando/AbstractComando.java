package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {
	private String nome;
	private String parametro;
	
	public abstract void esegui(Partita partita);
	
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getParametro() {
		return this.parametro;
	}
}