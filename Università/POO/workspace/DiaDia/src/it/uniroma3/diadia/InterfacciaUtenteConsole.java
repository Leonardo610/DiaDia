package it.uniroma3.diadia;


import java.util.Scanner;

public class InterfacciaUtenteConsole implements InterfacciaUtente {
	Scanner scannerDiLinee;
	
	public InterfacciaUtenteConsole() {
		scannerDiLinee = new Scanner(System.in);
	}
	
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);
	}
	
	public String prendiIstruzione() {
		String linea = scannerDiLinee.nextLine();
		return linea;
	}

}
