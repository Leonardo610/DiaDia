package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	private static final String MESSAGGIO_NOSALUTO = "Che maleducato, chi ti ha insegnato le buone maniere?";
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo bel borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private static final String MESSAGGIO_RINGRAZIAMENTO = "Ohohoh grazie del regalo. Ma non dovevi...";
	private Attrezzo attrezzo;
	
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		if (super.haSalutato()) {
			if (attrezzo!=null) {
				partita.getStanzaCorrente().addAttrezzo(attrezzo);
				this.attrezzo = null;
				msg = MESSAGGIO_DONO;
			}
			else 
				msg = MESSAGGIO_SCUSE;
		}
		else
			msg = MESSAGGIO_NOSALUTO;
		return msg;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
			attrezzo.setPeso(attrezzo.getPeso()/2);
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			return MESSAGGIO_RINGRAZIAMENTO + "\nIl mago ha rilasciato l'oggetto nella stanza con il peso dimezzato";
	}
}
