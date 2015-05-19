package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaBuiaTest {
	private Stanza stanzaBuiaTest;
	private Attrezzo lanterna;

	@Before
	public void setUp() throws Exception {
		stanzaBuiaTest = new StanzaBuia("Camera", "lanterna");
		lanterna = new Attrezzo("lanterna", 2);
	}

	@Test
	public void stanzaBuiaSenzaLuce() {
		assertEquals("Non si vede niente, è buio pesto.", stanzaBuiaTest.getDescrizione());
	}

	@Test
	public void stanzaBuiaIlluminata() {
		stanzaBuiaTest.addAttrezzo(lanterna);
		assertFalse("Non si vede niente, è buio pesto.".equals(stanzaBuiaTest.getDescrizione()));
	}
	
	
}
