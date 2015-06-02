package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

/**
 * Classe che modella un comando che fa muovere il giocatore in una stanza adiacente, se esiste la direzione, 
 * oppure restituisce un messaggio di errore.
 * @author Leonardo
 * @version 1.0
 */

public class ComandoVai extends AbstractComando {


	public String esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null; 
		if (super.getParametro()==null) 
			return ("Dove vuoi andare? Devi specificare una direzione");  
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(super.getParametro());
		if (prossimaStanza==null) {
			return "Direzione inesistente";
		}
		if (prossimaStanza==partita.getStanzaCorrente()) {
			return prossimaStanza.getNome();
		}
		partita.setStanzaCorrente(prossimaStanza);
		partita.getGiocatore().consumaCfu();
		return partita.getStanzaCorrente().getNome();
	}

}
