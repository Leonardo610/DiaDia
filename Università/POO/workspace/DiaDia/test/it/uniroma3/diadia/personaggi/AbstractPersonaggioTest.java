package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.assertEquals;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class AbstractPersonaggioTest {
	private AbstractPersonaggioFittizio personaggio;
	private Partita partita;
	
	@Before
	public void setUp() throws Exception {
	personaggio = new AbstractPersonaggioFittizio();
	partita = new Partita();
	}

	@Test
	public void testSaluta() {
		assertEquals("ciao", personaggio.saluta());
	}

	@Test
	public void testAgisci() {
		assertEquals("done", personaggio.agisci(partita));
	}

	@Test
	public void testRiceviRegalo() {
		assertEquals("grazie", personaggio.riceviRegalo(new Attrezzo("a", 1), partita));
	}

}
