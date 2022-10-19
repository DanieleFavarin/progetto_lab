package progetto_lab_B;

import java.io.Serializable;

public class CittadinoVaccinato implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nomeCognome;
	String codiceFiscale;
	String dataVaccino;
	String vaccino;
	
	public CittadinoVaccinato(String n, String cf, String d, String v) {
		nomeCognome = n;
		codiceFiscale = cf;
		dataVaccino = d;
		vaccino = v;
	}
	public static String scriviCittadino(CittadinoVaccinato c) {
		String s = c.nomeCognome+" "+c.codiceFiscale+" "+c.dataVaccino+" "+c.vaccino;
		return s;
	}

}
