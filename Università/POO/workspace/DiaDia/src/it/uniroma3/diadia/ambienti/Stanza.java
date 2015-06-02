package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * @author Paolo Merialdo (a partire da un'idea di Michael Kolling e David J. Barnes)
 * @see Attrezzo
 * @version 1.0
*/

public class Stanza implements Comparable<Stanza> {
	private String nome;
    protected Map<String, Attrezzo> attrezzi;
    private Map<String, Stanza> stanzeAdiacenti;
    private AbstractPersonaggio personaggio;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new HashMap<>();
        this.personaggio = null;
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
    	this.stanzeAdiacenti.put(direzione, stanza);
    }  

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public List<Attrezzo> getAttrezzi() {
        return new LinkedList<>(this.attrezzi.values());
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	if (attrezzo == null)
    		return false;
    	else {
    		this.attrezzi.put(attrezzo.getNome(), attrezzo);
    		return true;
    	}
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    
    @Override
    public String toString() {
    	String s = new String();
    	s += this.nome;
    	s += "\nUscite: ";
    	for (String direzione : this.stanzeAdiacenti.keySet())
    		if (direzione!=null)
    			s += " " + direzione;
    	s += "\nAttrezzi nella stanza: ";
    	for (Attrezzo attrezzo : this.getAttrezzi()) {
    		if (attrezzo!=null)
    		s += attrezzo.toString()+" ";
    	}
    	s += "\nPersonaggi nella stanza: ";
    	if (this.getPersonaggio()!=null)
    		s += this.getPersonaggio();
    	else 
    		s += "nella stanza non c'è nessuno";
    	return s;
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		if (this.attrezzi.containsKey(nomeAttrezzo))
			return true;
		else
			return false;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
	
	/*Cambia l'attrezzo nella stanza*/
	public void setAttrezzo(Attrezzo attrezzo) {
				
			
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(String nomeAttrezzo) {
		if (this.hasAttrezzo(nomeAttrezzo)) {
			this.attrezzi.remove(nomeAttrezzo);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Verifica se nella stanza non vi siano oggetti
	 * @return true se la stanza e' vuota, false altrimenti
	 */
	public boolean isEmpty() {
		return this.getAttrezzi().isEmpty();
	}

	/**
	 * Ritorna la collezione delle direzioni collegate ad una determinata stanza.
	 * @return la collezione delle direzioni
	 */
	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
    }
	
	public int getNumeroAttrezzi() {
		return this.getAttrezzi().size();
	}
	
	/**
	 * Ritorna il numero di stanze adiacenti.
	 * @return un int che rappresenta il numero delle stanze adiacenti.
	 */
	public int getNumeroStanzeAdiacenti() {
		return this.stanzeAdiacenti.size();
	}
	
	/**
	 * Ritorna la lista delle stanze adiacenti.
	 * @return list con le stanze adiacenti.
	 */
	public List<Stanza> getStanzeAdiacenti() {
		return new LinkedList<>(this.stanzeAdiacenti.values());
	}
	
	/**
	 * Ritorna il personaggio presente nella stanza.
	 * @return il personaggio presente nella stanza.
	 */
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}
	
	/**
	 * Cambia il personaggio nella stanza con quello passato come parametro.
	 * @param personaggioNuovo
	 */
	public void setPersonaggio(AbstractPersonaggio personaggioNuovo) {
		this.personaggio = personaggioNuovo;
	}
	
	/**
	 * Ordina per il numero di attrezzi presenti nella stanza.
	 * @param that
	 * @return maggiore di 0 se this ha più attrezzi di that, 0 se uguale e -1 se ne ha di meno
	 */

	@Override
	public int compareTo(Stanza that) {
		if (this.getNumeroAttrezzi()==that.getNumeroAttrezzi())
			return this.getNome().compareTo(that.getNome());
		else
			return this.getNumeroAttrezzi()-that.getNumeroAttrezzi();
	}
	
	@Override
	public boolean equals(Object o) {
		Stanza s = (Stanza) o;
		return this.getNome()==s.getNome() && this.getAttrezzi().equals(s.getAttrezzi()) 
			   && this.getStanzeAdiacenti().equals(s.getStanzeAdiacenti());
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode() + this.attrezzi.hashCode() + this.getStanzeAdiacenti().hashCode();
	}
}