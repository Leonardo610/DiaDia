package it.uniroma3.diadia.ambienti;

/**
 * Classe che modella una stanza buia. A meno che all'interno non vi sia un oggetto in grado di emettere luce
 * allora non sarà possibile visualizzarne la descrizione.
 * @author Leonardo
 * @version 1.0
 */

public class StanzaBuia extends Stanza {
	private String fonteDiLuce;
	
	public StanzaBuia(String nome, String fonteDiLuce) {
		super(nome);
		this.fonteDiLuce = fonteDiLuce;
	}
	
	@Override
	public String getDescrizione() {
		if (super.hasAttrezzo(fonteDiLuce))
					return super.getDescrizione();
		else
			return "Non si vede niente, è buio pesto.";
	}
	

}
