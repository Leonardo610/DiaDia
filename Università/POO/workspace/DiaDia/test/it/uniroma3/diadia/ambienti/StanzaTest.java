package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
	private Stanza stanza1;
	private Stanza stanza2;
	private Stanza stanza3;
	private Attrezzo attrezzo1;
	
	
	@Before
	public void setUp() {
		stanza1 = new Stanza("Biblioteca");
		stanza2 = new Stanza("Mensa");
		stanza3 = new Stanza("Bar");
		attrezzo1 = new Attrezzo("Pala", 1);
	}

	//test su impostaStanzaAdiacente(String, Stanza):
	@Test
	public void testStanzaStandard() {
		stanza1.impostaStanzaAdiacente("est", stanza2);
		assertSame(stanza2, stanza1.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testStanzaNull() {
		stanza1.impostaStanzaAdiacente("nord", null);
		assertNull(stanza1.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testDirezioneErrata() {
		stanza1.impostaStanzaAdiacente("sud", stanza2);
		assertNull(stanza1.getStanzaAdiacente("ovest"));
	}
	
	//test su addAttrezzo(Attrezzo):
	@Test
	public void testAttrezzoStandard() {
		assertTrue(stanza1.addAttrezzo(attrezzo1));
	}
	
	@Test
	public void testAttrezzoNull() {
		assertFalse(stanza1.addAttrezzo(null));
	}
	
	//test su hasAttrezzo(String):
	@Test
	public void testStanzaVuota() {
		assertFalse(stanza3.hasAttrezzo("Pala"));
	}
	
	@Test
	public void testStanzaConOggetto() {
		stanza1.addAttrezzo(new Attrezzo("Coltello", 1));
		assertTrue(stanza1.hasAttrezzo("Coltello"));
	}
	
	@Test
	public void testStanzaConOggettoMaNonQuelloCercato() {
		stanza1.addAttrezzo(new Attrezzo("Martello", 3));
		assertFalse(stanza1.hasAttrezzo("Coltello"));
	}
	
	//test su removeAttrezzo(String):
	@Test
	public void testStanzaSenzaAttrezzi() {
		assertFalse(stanza3.removeAttrezzo("Pala"));
	}
	
	@Test
	public void testStanzaConUnAttrezzo() {
		stanza2.addAttrezzo(new Attrezzo("Spada", 2));
		assertTrue(stanza2.removeAttrezzo("Spada"));
	}
	
	@Test
	public void testStanzaConUnAttrezzoMaNonQuelloDaRimuovere() {
		assertFalse(stanza2.removeAttrezzo("Martello"));
	}

}
