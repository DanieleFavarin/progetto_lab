package progetto_lab_B;

import java.io.Serializable;

public class CittadinoRegistrato implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nomeCognome;
	String codFiscale;
	String email;
	String user;
	String password;
	String vaccID;
	
	public CittadinoRegistrato(String nome, String cf, String mail, String uid, String pwd, String vid) {
		nomeCognome = nome;
		codFiscale = cf;
		email = mail;
		user = uid;
		password = pwd;
		vaccID = vid;
	}
	
	public static String scriviCittadinoRegistrato (CittadinoRegistrato c) {
		String s = c.nomeCognome+" "+c.codFiscale+" "+c.email+" "+c.user+" "+c.password+" "+c.vaccID;
		return s;
	}

}
