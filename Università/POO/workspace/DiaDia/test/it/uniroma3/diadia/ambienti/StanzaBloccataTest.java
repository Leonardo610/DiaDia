package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaBloccataTest {
	private Stanza stanzaBloccataTest, stanzaVicina;
	private Attrezzo chiave;

	@Before
	public void setUp() throws Exception {
		stanzaBloccataTest = new StanzaBloccata("Camera", "est", "chiave");
		chiave = new Attrezzo("chiave", 1);
	}

	@Test
	public void testVaiInDirezioneBloccata() {
		stanzaVicina = stanzaBloccataTest.getStanzaAdiacente("est");
		assertSame(stanzaBloccataTest, stanzaVicina);
	}
	
	@Test
	public void testVaiInDirezioneLecita() {
		stanzaVicina = stanzaBloccataTest.getStanzaAdiacente("nord");
		assertNull(stanzaVicina);
	}
	
	@Test
	public void testSbloccaDirezione() {
		stanzaBloccataTest.addAttrezzo(chiave);
		assertNull(stanzaBloccataTest.getStanzaAdiacente("est"));
	}

}
