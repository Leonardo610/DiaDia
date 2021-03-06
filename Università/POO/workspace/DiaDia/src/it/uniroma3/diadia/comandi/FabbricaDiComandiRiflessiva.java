package it.uniroma3.diadia.comandi;

import java.util.Scanner;

/**
 * Istanzia un comando.
 * @author Leonardo
 *
 */
public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	
	public AbstractComando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		AbstractComando comando = null;
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();
		scannerDiParole.close();
		try {
			String nomeClasse = "it.uniroma3.diadia.comandi.Comando";
			nomeClasse += Character.toUpperCase(nomeComando.charAt(0));
			nomeClasse += nomeComando.substring(1);
			comando = (AbstractComando) Class.forName(nomeClasse).newInstance();
			comando.setParametro(parametro);
		}
		catch (Exception e) {
			comando = new ComandoNonValido();
			comando.setParametro("Comando inesistente!");
		}
		return comando;
	}
}
