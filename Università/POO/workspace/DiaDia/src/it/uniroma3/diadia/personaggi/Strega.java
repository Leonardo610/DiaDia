package it.uniroma3.diadia.personaggi;

import java.util.Collections;

import it.uniroma3.diadia.Partita;

public class Strega extends AbstractPersonaggio {
	private static final String MESSAGGIO_RISENTITO = "Ma come ti permetti? Sparisci da qui!" + 
													  "\nLa strega ti ha teletrasportato nella stanza adiacente con meno attrezzi.";
	private static final String MESSAGGIO_BUONO = "Sei molto educato, e percio' ti ricompenserò!" + 
												  "\nLa strega ti ha teletrasportato nella stanza adiacente con piu' attrezzi.";
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	public String agisci(Partita partita) {
		String msg = null;
		if (!super.haSalutato()) {
			/*I metodi min e max di Collections richiedono che la Collection 
			 * su cui operano non sia nulla, altrimenti restituiscono errore
			 * a tempo dinamico, perciò è buona norma mettere un if (collection!=null) 
			 * prima di utilizzare quei metodi.
			 */
			if (partita.getStanzaCorrente().getStanzeAdiacenti()!=null) {
				partita.setStanzaCorrente(Collections.min(partita.getStanzaCorrente().getStanzeAdiacenti()));
				msg = MESSAGGIO_RISENTITO;
			}
		}
		else {
			if (partita.getStanzaCorrente().getStanzeAdiacenti()!=null) {
				partita.setStanzaCorrente(Collections.max(partita.getStanzaCorrente().getStanzeAdiacenti()));
				msg = MESSAGGIO_BUONO;
			}
		}
		return msg;
	}
}
