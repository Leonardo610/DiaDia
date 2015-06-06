package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class CaneTest {
	private Cane cane;
	private Partita partita;
	private Stanza stanza;

	@Before
	public void setUp() throws Exception {
		cane = new Cane("a", "b");
		partita = new Partita();
		stanza = new Stanza("nome");
	}

	@Test
	public void testAgisci() {
		cane.agisci(partita);
		assertEquals(19, partita.getGiocatore().getCfu());
	}
	
	@Test
	public void testRiceviRegalo() {
		partita.setStanzaCorrente(stanza);
		cane.riceviRegalo(new Attrezzo("prova", 1), partita);
		assertTrue(stanza.hasAttrezzo("prova"));
	}
}
