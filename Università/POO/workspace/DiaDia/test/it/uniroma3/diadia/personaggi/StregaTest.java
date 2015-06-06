package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StregaTest {
	private Strega strega;
	private Partita partita;
	private Stanza stanza, smax, smin;

	@Before
	public void setUp() throws Exception {
		strega = new Strega("a", "b");
		partita = new Partita();
		stanza = new Stanza("nome");
		smax = new Stanza("max");
		smin = new Stanza("min");
		smax.addAttrezzo(new Attrezzo("test", 1));
		stanza.impostaStanzaAdiacente("nord", smax);
		stanza.impostaStanzaAdiacente("sud", smin);
		partita.setStanzaCorrente(stanza);
	}

	@Test
	public void testAgisci_noSaluto() {
		strega.agisci(partita);
		assertSame(smin, partita.getStanzaCorrente());
	}
	
	@Test
	public void testAgisci_saluto() {
		strega.saluta();
		strega.agisci(partita);
		assertSame(smax, partita.getStanzaCorrente());
	}
	
	@Test
	public void testRiceviRegalo() {
		strega.riceviRegalo(new Attrezzo("prova", 2), partita);
		assertTrue(stanza.isEmpty());
	}
}
