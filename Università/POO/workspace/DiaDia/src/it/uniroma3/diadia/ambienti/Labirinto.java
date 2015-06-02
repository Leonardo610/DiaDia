package it.uniroma3.diadia.ambienti;


import java.io.IOException;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

/**
 * Questa classe modella il labirinto all'interno del quale il giocatore dovrà muoversi.
 * @author Leonardo
 * @see Stanza
 * @version 0.1
 */

public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	
	public Labirinto() {
		this.creaStanze();
	}
	
	public Labirinto(String nomeFile) throws FormatoFileNonValidoException {
		try {
			CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
			c.carica();
			this.stanzaIniziale = c.getStanzaIniziale();
			this.stanzaCorrente = c.getStanzaIniziale();
			this.stanzaVincente = c.getStanzaVincente();
		}
		catch (IOException e) {
			throw new FormatoFileNonValidoException("Formato del file errato.");
		}
	}
	
	private void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo pala = new Attrezzo("pala", 4);
		Attrezzo spadone = new Attrezzo("spadone", 6);
		Attrezzo ciarpame = new Attrezzo("ciarpame", 2);
		Attrezzo libro = new Attrezzo("libro", 1);
		Attrezzo chiave = new Attrezzo("chiave", 1);
		Attrezzo ascia = new Attrezzo("ascia", 4);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza ds2 = new StanzaMagica("DS2");
		Stanza aulaN12 = new StanzaBuia("Aula N12", "lanterna");
		Stanza segreteria = new StanzaBloccata("Segreteria", "nord", "chiave");
		Stanza bar = new Stanza("Bar");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN11.impostaStanzaAdiacente("sud", ds2);
		aulaN11.impostaStanzaAdiacente("est", bar);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", ds2);
		aulaN10.impostaStanzaAdiacente("ovest", aulaN12);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("sud", aulaN12);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		ds2.impostaStanzaAdiacente("nord", aulaN11);
		ds2.impostaStanzaAdiacente("est", segreteria);
		ds2.impostaStanzaAdiacente("ovest", aulaN10);
		aulaN12.impostaStanzaAdiacente("nord", laboratorio);
		aulaN12.impostaStanzaAdiacente("est", aulaN10);
		segreteria.impostaStanzaAdiacente("nord", bar);
		segreteria.impostaStanzaAdiacente("ovest", ds2);
		bar.impostaStanzaAdiacente("sud", segreteria);
		bar.impostaStanzaAdiacente("ovest", aulaN11);
		
		/*mette i personaggi nelle stanze*/
		atrio.setPersonaggio(new Mago("Merlino", "Sono il mago dell'università e ti aiuterò nella tua avventura!", new Attrezzo("pugnale", 1)));
		aulaN11.setPersonaggio(new Cane("Cerbero", null));
		aulaN12.setPersonaggio(new Strega("Beatrice", "Sono la strega dell'aula N12, se sarai buono con me ti ricompenserò adeguatamente, altrimenti te ne pentirai!"));

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		laboratorio.addAttrezzo(spadone);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(pala);
		atrio.addAttrezzo(ascia);
		ds2.addAttrezzo(ciarpame);
		aulaN12.addAttrezzo(libro);
		ds2.addAttrezzo(chiave);

		// il gioco comincia nell'atrio
        stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
    }

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

}
