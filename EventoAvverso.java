package progetto_lab_B;

import java.io.Serializable;
import java.util.Random;

public class EventoAvverso implements Serializable{
	private static final long serialVersionUID = 1L;
	String nome;
	int severit�;
	String commento;
	int idEvento;
	int idCentro;

	public EventoAvverso(String s, int sev, int idC) {
		nome = s;
		severit� = sev;
        Random random = new Random();
        idEvento = random.nextInt(1000);
        idCentro = idC;

	}
	public EventoAvverso(String s, int sev, int idC, String c) {
		nome = s;
		severit� = sev;
        Random random = new Random();
        idEvento = random.nextInt(1000);
        idCentro = idC;
        commento = c;
	}
	

	
	public static String scriviEvento(EventoAvverso e) {
		String s = e.idEvento+" "+e.nome+" "+e.severit�;
		String c = e.commento;
		if(c != null) {
			s = s+" "+e.commento;
		}
		return s;
	}


}
