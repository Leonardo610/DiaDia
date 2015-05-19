package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import org.junit.Before;
import org.junit.Test;

public class BorsaTest {
	private Borsa borsa;
	private Attrezzo attrezzoPesoZero;
	private Attrezzo attrezzoPesoEccessivo;
	private Attrezzo a1, a2, a3, b1, b2, b4;
	private List<Attrezzo> list;
	private Map<Integer, Set<Attrezzo>> mappa;
	private Set<Attrezzo> insieme1, insieme2, insieme3, insieme4;

	@Before
	public void setUp() throws Exception {
		borsa = new Borsa(100);
		attrezzoPesoZero = new Attrezzo("Zero", 0);
		attrezzoPesoEccessivo = new Attrezzo("Troppo", 101);
		a1 = new Attrezzo("a1", 3);
		a2 = new Attrezzo("a2", 2);
		a3 = new Attrezzo("a3", 8);
		b1 = new Attrezzo("b1", 3);
		b2 = new Attrezzo("b2", 2);
		b4 = new Attrezzo("b4", 9);
		list = new LinkedList<>();
		mappa = new HashMap<>();
		insieme1 = new HashSet<>();
		insieme2 = new HashSet<>();
		insieme3 = new HashSet<>();
		insieme4 = new HashSet<>();
	}

	@Test
	public void testAddAttrezzo_AttrezzoNull() {
		assertFalse(borsa.addAttrezzo(null));
	}
	
	@Test
	public void testAddAttrezzo_AttrezzoPesoZero() {
		assertTrue(borsa.addAttrezzo(attrezzoPesoZero));
	}
	
	@Test
	public void testAddAttrezzo_AttrezzoPesoEccessivo() {
		assertFalse(borsa.addAttrezzo(attrezzoPesoEccessivo));
	}

	@Test
	public void testIsEmpty_BorsaVuota() {
		assertTrue(borsa.isEmpty());
	}
	
	@Test
	public void testIsEmpty_BorsaNonVuota() {
		borsa.addAttrezzo(attrezzoPesoZero);
		assertFalse(borsa.isEmpty());
	}

	@Test
	public void testHasAttrezzo_BorsaConAttrezzo() {
		borsa.addAttrezzo(attrezzoPesoZero);
		assertTrue(borsa.hasAttrezzo("Zero"));
	}
	
	@Test
	public void testHasAttrezzo_BorsaSenzaAttrezzo() {
		assertFalse(borsa.hasAttrezzo("Zero"));
	}

	@Test
	public void testRemoveAttrezzo_BorsaSenzaAttrezzi() {
		assertNull(borsa.removeAttrezzo("Zero"));
	}
	
	@Test
	public void testRemoveAttrezzo_BorsaConUnAttrezzo() {
		borsa.addAttrezzo(attrezzoPesoZero);
		assertEquals(attrezzoPesoZero, borsa.removeAttrezzo("Zero"));
	}
	
	@Test
	public void testRemoveAttrezzo_BorsaConUnAttrezzoNull() {
		borsa.addAttrezzo(attrezzoPesoZero);
		borsa.addAttrezzo(null);
		assertNull(borsa.removeAttrezzo(null));
	}
	
	@Test
	public void testOrdinamentoNaturale() {
		borsa.addAttrezzo(a1);
		borsa.addAttrezzo(a2);
		borsa.addAttrezzo(a3);
		list.add(a2);
		list.add(a1);
		list.add(a3);
		assertEquals(list, borsa.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testOrdinamentoNaturaleTuttiAttrezziPesoZero() {
		borsa.addAttrezzo(new Attrezzo("Gamma", 0));
		borsa.addAttrezzo(new Attrezzo("Alfa", 0));
		borsa.addAttrezzo(new Attrezzo("Abaco", 0));
		list.add(new Attrezzo("Abaco", 0));
		list.add(new Attrezzo("Alfa", 0));
		list.add(new Attrezzo("Gamma", 0));
		assertEquals(list, borsa.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testOrdinamentoNaturaleBorsaVuota() {
		assertEquals(list, borsa.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testOrdinamentoNaturaleSingleton() {
		borsa.addAttrezzo(a1);
		list.add(a1);
		assertEquals(list, borsa.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testOrdinamentoEsterno() {
		borsa.addAttrezzo(a2);
		borsa.addAttrezzo(a3);
		borsa.addAttrezzo(a1);
		list.add(a1);
		list.add(a2);
		list.add(a3);
		assertEquals(list, borsa.getContenutoOrdinatoPerNome());
	}
	
	@Test
	public void testOrdinamentoEsternoSingleton() {
		borsa.addAttrezzo(a3);
		list.add(a3);
		assertEquals(list, borsa.getContenutoOrdinatoPerNome());
	}
	
	@Test
	public void testOrdinamentoEsternoBorsaVuota() {
		assertEquals(list, borsa.getContenutoOrdinatoPerNome());
	}
	
	@Test
	public void testOrdinamentoConMappa() {
		borsa.addAttrezzo(a1);
		borsa.addAttrezzo(a2);
		borsa.addAttrezzo(a3);
		borsa.addAttrezzo(b1);
		borsa.addAttrezzo(b2);
		borsa.addAttrezzo(b4);
		insieme1.add(a1);
		insieme1.add(b1);
		mappa.put(3, insieme1);
		insieme2.add(a2);
		insieme2.add(b2);
		mappa.put(2, insieme2);
		insieme3.add(a3);
		mappa.put(8, insieme3);
		insieme4.add(b4);
		mappa.put(9, insieme4);
		assertEquals(mappa, borsa.getContenutoRaggruppatoPerPeso());
	}
	
	@Test
	public void testOrdinamentoConMappaBorsaVuota() {
		assertEquals(mappa, borsa.getContenutoRaggruppatoPerPeso());
	}
	
	@Test
	public void testOrdinamentoConMappaBorsaSingleton() {
		borsa.addAttrezzo(a1);
		insieme1.add(a1);
		mappa.put(3, insieme1);
		assertEquals(mappa, borsa.getContenutoRaggruppatoPerPeso());
	}

}
