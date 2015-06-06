package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class MagoTest {
	private Mago mago;
	private Partita partita;
	private Stanza stanza;

	@Before
	public void setUp() throws Exception {
		mago = new Mago("a", "b", new Attrezzo("regalo", 1));
		partita = new Partita();
		stanza = new Stanza("nome");
		partita.setStanzaCorrente(stanza);
	}

	@Test
	public void testAgisci() {
		mago.saluta();
		mago.agisci(partita);
		assertTrue(stanza.hasAttrezzo("regalo"));
	}
	
	@Test
	public void testRiceviRegalo() {
		mago.riceviRegalo(new Attrezzo("prova", 2), partita);
		assertTrue(stanza.hasAttrezzo("prova"));
	}
}
