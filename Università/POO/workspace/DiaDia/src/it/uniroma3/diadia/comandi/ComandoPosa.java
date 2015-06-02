package it.uniroma3.diadia.comandi;

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
	
	public String esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Borsa borsaGiocatore = partita.getGiocatore().getBorsa();
		Attrezzo attrezzoDaPosare = null;
		if (super.getParametro()==null)
			return "Cosa vuoi posare?";
		else {
			attrezzoDaPosare = borsaGiocatore.getAttrezzo(super.getParametro());
			if (attrezzoDaPosare == null)
				return "Attrezzo non presente nella borsa del giocatore!";
			else {
				borsaGiocatore.removeAttrezzo(super.getParametro());
				stanzaCorrente.addAttrezzo(attrezzoDaPosare);
				return "Attrezzo posato!";
			}
		}
	}
}
