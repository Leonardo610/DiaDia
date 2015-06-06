package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class AbstractPersonaggioFittizio extends AbstractPersonaggio{

	@Override
	public String agisci(Partita partita) {
		return "done";
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "grazie";
	}
	
	@Override
	public String saluta() {
		return "ciao";
	}
}
