package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * Una classe che modella un comando che rimuove un Attrezzo dalla borsa del giocatore e lo ripone nella stanza.
 * @author Leonardo
 * @version 1.0
 */

public class ComandoPosa extends AbstractComando {
	
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Borsa borsaGiocatore = partita.getGiocatore().getBorsa();
		Attrezzo attrezzoDaPosare = null;
		if (super.getParametro()==null)
			System.out.println("Cosa vuoi posare?");
		else {
			attrezzoDaPosare = borsaGiocatore.getAttrezzo(super.getParametro());
			if (attrezzoDaPosare == null)
				System.out.println("Attrezzo non presente nella borsa del giocatore!");
			else {
				borsaGiocatore.removeAttrezzo(super.getParametro());
				stanzaCorrente.addAttrezzo(attrezzoDaPosare);
				System.out.println("Attrezzo posato!");
			}
		}
	}
}
