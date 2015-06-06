package it.uniroma3.diadia.comando;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.AbstractComando;

public class AbstractComandoFittizio extends AbstractComando {
	
	@Override
	public String esegui(Partita partita) {
		return "done";
	}

}
