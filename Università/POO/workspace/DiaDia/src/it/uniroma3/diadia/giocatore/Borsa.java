package it.uniroma3.diadia.giocatore;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNome;

/**
 * Classe che modella la borsa dell'equipaggiamento del giocatore.
 * @author Leonardo
 * @see Giocatore
 * @version 1.01
 */
public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo==null)
			return false;
		if (attrezzo.getPeso() + this.getPeso()>this.getPesoMax())
			return false;
		else 
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return true;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	public int getPeso() {
		int pesoTotale = 0;
		for (Attrezzo a : this.getAttrezzi())
			pesoTotale += a.getPeso();
		return pesoTotale;
	}
	
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(nomeAttrezzo);
	}
	
	public List<Attrezzo> getAttrezzi() {
		return new LinkedList<>(this.attrezzi.values());
	}
	
	/**
	 * Ordina gli attrezzi presenti nella borsa per peso, e in caso di parità, per nome.
	 * @return una lista ordinata di attrezzi per peso e per nome
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> attrezziOrdinati = this.getAttrezzi();
		Collections.sort(attrezziOrdinati);
		return attrezziOrdinati;
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerNome() {
		List<Attrezzo> attrezziOrdinati = this.getAttrezzi();
		ComparatorePerNome comparatore = new ComparatorePerNome();
		Collections.sort(attrezziOrdinati, comparatore);
		return attrezziOrdinati;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer, Set<Attrezzo>> attrezziRaggruppati = new HashMap<>();
		Set<Attrezzo> tmp;
		for (Attrezzo a : this.attrezzi.values()) {
			if (attrezziRaggruppati.containsKey(a.getPeso())) {
				tmp = attrezziRaggruppati.get(a.getPeso());
				tmp.add(a);
			}
			else {
				tmp = new HashSet<>();
				tmp.add(a);
				attrezziRaggruppati.put(a.getPeso(), tmp);
			}
		}
		return attrezziRaggruppati;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Set<Attrezzo> a : this.getContenutoRaggruppatoPerPeso().values()) 
				s.append(a.toString() + " ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
