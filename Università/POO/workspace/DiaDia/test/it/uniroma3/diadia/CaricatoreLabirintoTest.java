package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

public class CaricatoreLabirintoTest {
	private StringReader lettore, lettoreSbagliato;
	private File fileprova;

	@Before
	public void setUp() throws Exception {
		lettore = new StringReader("Stanze: Biblioteca\nInizio: Biblioteca\nVincente: Biblioteca\nAttrezzi: \nUscite:");
	}

	@Test(expected = FormatoFileNonValidoException.class)
	public void testLettoreSbagliato() {
		lettoreSbagliato = new StringReader("Sanze: Biblioteca\nInizio: Biblioteca\nVincente: Biblioteca\nAttrezzi: \nUscite:");
		CaricatoreLabirinto sbagliato = new CaricatoreLabirinto(lettore);
		CaricatoreLabirinto corretto = new CaricatoreLabirinto(lettoreSbagliato);
		assertEquals(sbagliato, corretto);
	}
		
}
