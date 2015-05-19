package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Labirinto;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	private Labirinto labirinto;

	@Before
	public void setUp() throws Exception {
		labirinto = new Labirinto();
	}

	@Test
	public void testGetStanzaVincente() {
		assertNotNull(labirinto.getStanzaVincente());
	}

}
