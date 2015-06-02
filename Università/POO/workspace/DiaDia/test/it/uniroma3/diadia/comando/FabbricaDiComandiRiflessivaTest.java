package it.uniroma3.diadia.comando;

import static org.junit.Assert.*;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiRiflessivaTest {
	private FabbricaDiComandi fabbrica;
	
	@Before
	public void setUp() throws Exception {
		fabbrica = new FabbricaDiComandiRiflessiva();
	}

	@Test
	public void testCostruisciComando_ComandoValido_Vai() {
		assertSame(it.uniroma3.diadia.comandi.ComandoVai.class, this.fabbrica.costruisciComando("vai sud").getClass());
	}
	
	@Test
	public void testGetMapIstruzioneToClasse() {
		assertEquals("it.uniroma3.diadia.comandi.ComandoVai", this.fabbrica.costruisciComando("vai sud").getClass().getName());
	}
	
	@Test
	public void testCostruisciComando_ComandoNonValido() {
		assertSame(it.uniroma3.diadia.comandi.ComandoNonValido.class, this.fabbrica.costruisciComando("corri sud").getClass());
	}

}
