package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.Partita;

/**
 * Classe che modella il comando che termina la partita.
 * @author Leonardo
 * @version 1.0
 */

public class ComandoFine extends AbstractComando {
	
	public void esegui(Partita partita) {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}
}
