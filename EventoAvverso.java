package progetto_lab_B;

import java.io.Serializable;
import java.util.Random;

public class EventoAvverso implements Serializable{
	private static final long serialVersionUID = 1L;
	String nome;
	int severità;
	String commento;
	int idEvento;
	int idCentro;

	public EventoAvverso(String s, int sev, int idC) {
		nome = s;
		severità = sev;
        Random random = new Random();
        idEvento = random.nextInt(1000);
        idCentro = idC;

	}
	public EventoAvverso(String s, int sev, int idC, String c) {
		nome = s;
		severità = sev;
        Random random = new Random();
        idEvento = random.nextInt(1000);
        idCentro = idC;
        commento = c;
	}
	

	
	public static String scriviEvento(EventoAvverso e) {
		String s = e.idEvento+" "+e.nome+" "+e.severità;
		String c = e.commento;
		if(c != null) {
			s = s+" "+e.commento;
		}
		return s;
	}


}
