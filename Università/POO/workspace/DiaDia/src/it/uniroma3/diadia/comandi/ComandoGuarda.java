package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Restituisce la descrizione della stanza in cui si trova il giocatore e delle sue statistiche.
 * @author Leonardo
 * @version 1.0
 */

public class ComandoGuarda extends AbstractComando {
	
	public String esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Giocatore giocatore = partita.getGiocatore();
		return stanzaCorrente.getDescrizione() + "\n" + giocatore.toString();
	}

}
