package it.uniroma3.diadia.attrezzi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Test;

public class AttrezzoTest {
	private Attrezzo attrezzo1 = new Attrezzo("Piccone", 3);
	private Attrezzo attrezzo2 = new Attrezzo("", 0);
	
	//testo il metodo toString():
	@Test
	public void testAttrezzoVuoto() {
		assertEquals(" (0 kg)", attrezzo2.toString());
	}

	@Test
	public void testAttrezzoStandard() {
		assertEquals("Piccone (3 kg)", attrezzo1.toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAttrezzoPesoNegativo() {
		@SuppressWarnings("unused")
		Attrezzo attrezzo3 = new Attrezzo("Matita", -2);
	}
	


}
