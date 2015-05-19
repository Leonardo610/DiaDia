package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Restituisce la descrizione della stanza in cui si trova il giocatore e delle sue statistiche.
 * @author Leonardo
 * @version 1.0
 */

public class ComandoGuarda extends AbstractComando {
	
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Giocatore giocatore = partita.getGiocatore();
		System.out.println(stanzaCorrente.getDescrizione() + "\n" + giocatore.toString());
	}

}
