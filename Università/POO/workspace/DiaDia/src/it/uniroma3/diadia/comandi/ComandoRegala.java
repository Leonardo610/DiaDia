package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando {

	public String esegui(Partita partita) {
		Borsa borsaGiocatore = partita.getGiocatore().getBorsa();
		Attrezzo attrezzoDaRegalare = borsaGiocatore.getAttrezzo(this.getParametro());
		AbstractPersonaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (this.getParametro()==null)
			return "Cosa vuoi regalare?";
		if (personaggio!=null) 
			if (borsaGiocatore.hasAttrezzo(this.getParametro())) {
				borsaGiocatore.removeAttrezzo(this.getParametro());
				return personaggio.riceviRegalo(attrezzoDaRegalare, partita);
			}
			else
				return "Attrezzo non presente nella borsa del giocatore!";
		else
			return "Nessun personaggio nella stanza.";
	}
}
