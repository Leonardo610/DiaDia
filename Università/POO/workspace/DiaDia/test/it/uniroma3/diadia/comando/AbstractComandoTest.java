package it.uniroma3.diadia.comando;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;

import org.junit.Before;
import org.junit.Test;

public class AbstractComandoTest {
	private AbstractComandoFittizio comando;
	
	@Before
	public void setUp() throws Exception {
		comando = new AbstractComandoFittizio();
	}

	@Test
	public void test() {
		Partita partita = new Partita();
		assertEquals("done", comando.esegui(partita));
	}

}
