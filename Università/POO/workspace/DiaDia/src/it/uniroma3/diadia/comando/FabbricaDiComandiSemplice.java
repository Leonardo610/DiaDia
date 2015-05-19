package it.uniroma3.diadia.comando;

import java.util.Scanner;

public class FabbricaDiComandiSemplice implements FabbricaDiComandi {
	
	public AbstractComando costruisciComando(String istruzione) { 
		Scanner scannerDiParole = new Scanner(istruzione); 
		String nomeComando = null; 
		String parametro = null; 
		AbstractComando comando = null; 
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando 
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();// seconda parola: eventuale parametro 
		scannerDiParole.close();
		if (nomeComando == null)
			System.out.println("Nessun comando inserito!");
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai(); 
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi();
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa();
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else if (nomeComando.equals("interagisci"))
			comando = new ComandoInteragisci();
		else if (nomeComando.equals("saluta"))
			comando = new ComandoSaluta();
		else comando = new ComandoNonValido();
		if (comando!=null)
			comando.setParametro(parametro);
		return comando;
	}
}
