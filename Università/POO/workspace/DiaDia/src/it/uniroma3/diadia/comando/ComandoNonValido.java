package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.Partita;

/**
 * Stampa un messaggio di errore se il comando non è presente tra l'elenco dei comandi.
 * @author Leonardo
 * @version 1.0
 */

public class ComandoNonValido extends AbstractComando {
	
	public void esegui(Partita partita) {
		System.out.println("Comando non valido!");
	}

}
