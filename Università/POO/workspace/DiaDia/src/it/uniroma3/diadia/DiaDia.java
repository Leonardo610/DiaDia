package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

/**
 *  Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 *  Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 *  Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes) *
 * @version 0.1
 */

public class DiaDia {
	private InterfacciaUtente console;
	private Partita partita;
	private static final String MESSAGGIO_BENVENUTO = 
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
    

    public DiaDia() throws FormatoFileNonValidoException {
    	this.console = new InterfacciaUtenteConsole();
    	this.partita = new Partita(new Labirinto("labirinto1.txt"));
    }
    
    
    /**
     * Il metodo gioca dà inizio al divertimento.
     */
	public void gioca() {
		String istruzione;
		this.console.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = this.console.prendiIstruzione();
		while (!processaIstruzione(istruzione));
	} 
       
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) { 
		AbstractComando comandoDaEseguire; 
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva(); 
		comandoDaEseguire = factory.costruisciComando(istruzione); 
		if (comandoDaEseguire!=null)
			this.console.mostraMessaggio(comandoDaEseguire.esegui(this.partita)); 
		if (this.partita.vinta()) 
				this.console.mostraMessaggio("Hai vinto!"); 
		if (!this.partita.giocatoreIsVivo()) 
				this.console.mostraMessaggio("GAME OVER! CFU esauriti!"); 
		return this.partita.isFinita(); 

	}
	
	public static void main(String[] argc) throws FormatoFileNonValidoException {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}