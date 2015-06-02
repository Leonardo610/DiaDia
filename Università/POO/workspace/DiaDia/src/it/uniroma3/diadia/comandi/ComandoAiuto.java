package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Comando che stampa l'elenco dei comandi disponibili al giocatore.
 * @author Leonardo
 * @version 1.0
 */

public class ComandoAiuto extends AbstractComando {
	private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "saluta", "interagisci", "regala"};

	
	public String esegui(Partita partita) {
		String elenco = new String("");
		for(int i=0; i< elencoComandi.length; i++) 
			elenco = elenco + elencoComandi[i] + " ";
		return elenco;
	}
}