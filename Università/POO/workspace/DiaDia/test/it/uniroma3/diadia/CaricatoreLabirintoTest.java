package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

public class CaricatoreLabirintoTest {
	private CaricatoreLabirinto caricatore;
	private StringReader lettore;
	private File fileprova;

	@Before
	public void setUp() throws Exception {
		lettore = new StringReader("Stanze: biblioteca, N10, N11 Inizio: N10 Vincente: N11 Attrezzi: martello 10 biblioteca, pinza 2 N10 Uscite: biblioteca nord N10, biblioteca sud N11");	
	}

	@Test(expected = FileNotFoundException.class)
	public void testFileNonTrovato() {
		caricatore = new CaricatoreLabirinto(lettore);
		
}
