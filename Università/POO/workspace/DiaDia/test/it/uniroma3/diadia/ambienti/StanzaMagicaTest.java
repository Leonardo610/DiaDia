package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaMagicaTest {
	private Stanza stanzaMagicaTest;
	private Attrezzo ciarpame;

	@Before
	public void setUp() throws Exception {
		stanzaMagicaTest = new StanzaMagica("Camera");
		ciarpame = new Attrezzo("ciarpame", 2);
	}

	@Test
	public void testStanzaMagicaFunziona() {
		stanzaMagicaTest.addAttrezzo(ciarpame);
		stanzaMagicaTest.addAttrezzo(ciarpame);
		stanzaMagicaTest.addAttrezzo(ciarpame);
		stanzaMagicaTest.addAttrezzo(ciarpame);
		assertTrue(stanzaMagicaTest.hasAttrezzo("emapraic"));
	}
	
	@Test
	public void testStanzaNonContieneDoppioni() {
		stanzaMagicaTest.addAttrezzo(ciarpame);
		stanzaMagicaTest.addAttrezzo(ciarpame);
		assertEquals(1, stanzaMagicaTest.getNumeroAttrezzi());
	}
}
