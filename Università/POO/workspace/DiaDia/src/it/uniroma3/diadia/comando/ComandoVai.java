package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

/**
 * Classe che modella un comando che fa muovere il giocatore in una stanza adiacente, se esiste la direzione, 
 * oppure restituisce un messaggio di errore.
 * @author Leonardo
 * @version 1.0
 */

public class ComandoVai extends AbstractComando {


	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null; 
		if (super.getParametro()==null) {
			System.out.println("Dove vuoi andare? Devi specificare una direzione"); 
			return; 
		} 
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(super.getParametro());
		if (prossimaStanza==null) {
			System.out.println("Direzione inesistente"); 
			return; 
		}
		if (prossimaStanza==partita.getStanzaCorrente()) {
			System.out.println(prossimaStanza.getNome());
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		System.out.println(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().consumaCfu();
	}

}
