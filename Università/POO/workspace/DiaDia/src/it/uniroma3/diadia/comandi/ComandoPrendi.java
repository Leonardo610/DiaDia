package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * Una classe che modella un comando che prende un oggetto dalla stanza e lo ripone nella borsa.
 * @author Leonardo
 * @version 1.0
 *
 */

public class ComandoPrendi extends AbstractComando {

	public String esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Borsa borsaGiocatore = partita.getGiocatore().getBorsa();
		Attrezzo attrezzoDaPrendere = null;
		if (super.getParametro() == null)
			return "Cosa vuoi prendere?";
		else {
			attrezzoDaPrendere = stanzaCorrente.getAttrezzo(super.getParametro());
			if (attrezzoDaPrendere == null)
				return "Attrezzo non presente nella stanza!";
			else {
				boolean preso = borsaGiocatore.addAttrezzo(attrezzoDaPrendere);
				if (preso) {
					stanzaCorrente.removeAttrezzo(super.getParametro());
					return "Attrezzo preso!";
				}
				else
					return "Attrezzo non preso, capienza massima borsa raggiunta!";
			}
		}
	}
}