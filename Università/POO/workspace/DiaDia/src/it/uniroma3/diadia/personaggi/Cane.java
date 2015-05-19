package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

public class Cane extends AbstractPersonaggio {
	private static final String ABBAIA = "WOF";
	private static final String RINGHIO = "GRRR";
	
	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}
	
	@Override
	public String saluta() {
		return ABBAIA;
	}
	
	@Override
	public String agisci(Partita partita) {
		System.out.println(RINGHIO);
		partita.getGiocatore().consumaCfu();
		return "Hai perso un cfu...";
		
	}
}
