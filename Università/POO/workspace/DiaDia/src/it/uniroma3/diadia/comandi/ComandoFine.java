package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Classe che modella il comando che termina la partita.
 * @author Leonardo
 * @version 1.0
 */

public class ComandoFine extends AbstractComando {
	
	public String esegui(Partita partita) {
		return "Grazie di aver giocato!";  // si desidera smettere
	}
}
