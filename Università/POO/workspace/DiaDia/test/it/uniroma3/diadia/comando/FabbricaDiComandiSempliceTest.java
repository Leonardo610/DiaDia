package it.uniroma3.diadia.comando;

import static org.junit.Assert.*;
import it.uniroma3.diadia.comando.AbstractComando;
import it.uniroma3.diadia.comando.FabbricaDiComandi;
import it.uniroma3.diadia.comando.FabbricaDiComandiSemplice;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiSempliceTest {
	private  FabbricaDiComandi fabbricaTest;
	private AbstractComando comando;

	@Before
	public void setUp() throws Exception {
		fabbricaTest = new FabbricaDiComandiSemplice();
	}

	@Test
	public void verificaComandoVaiNome() {
		comando = fabbricaTest.costruisciComando("vai nord");
		assertEquals("vai", comando.getNome());
	}
	
	@Test
	public void verificaComandoVaiParametro() {
		comando = fabbricaTest.costruisciComando("vai nord");
		assertEquals("nord", comando.getParametro());
	}
	
	@Test
	public void verificaComandoVuoto() {
		comando = fabbricaTest.costruisciComando("");
		assertEquals("non valido", comando.getNome());
	}
	
	@Test
	public void verificaComandoSbagliato() {
		comando = fabbricaTest.costruisciComando("estrai");
		assertEquals("non valido", comando.getNome());
	}	
}
