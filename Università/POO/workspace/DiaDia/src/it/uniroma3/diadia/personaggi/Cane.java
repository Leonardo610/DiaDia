package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

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
	
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if (attrezzo.getNome().equals("osso")) {
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("letame", 2));
			return "BAU" + "\nIl cane ha gradito ed ha lasciato un attrezzo nella stanza.";
		}
		else {
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			return "SNORT" + "\nIl cane non ha gradito e ha lasciato cadere il regalo nella stanza.";
		}
	}
}
