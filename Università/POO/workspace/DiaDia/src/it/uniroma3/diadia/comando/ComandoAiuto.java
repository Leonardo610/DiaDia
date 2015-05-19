package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.Partita;

/**
 * Comando che stampa l'elenco dei comandi disponibili al giocatore.
 * @author Leonardo
 * @version 1.0
 */

public class ComandoAiuto extends AbstractComando {
	private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "saluta", "interagisci"};

	
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}
}