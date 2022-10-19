package progetto_lab_B;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Centro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List listaEventi;
	int id;
	String nome;
	String indirizzo;
	String tipologia;
	String info;
	
	public Centro(String n, String i, String t) {
		listaEventi = new ArrayList();
		nome = n;
		indirizzo = i;
		tipologia = t;
        Random random = new Random();
        id = random.nextInt(1000);
	}
	
	public static String scrivi(Centro c) {
		String s = c.nome+" "+c.indirizzo+" "+c.tipologia;
		return s;
	}
	public String getVia() {
		String via = this.indirizzo;
		return via;
	}
	public String getNome() {
		String nome = this.nome;
		return nome;
	}
	public String getTipo() {
		String tipo = this.tipologia;
		return tipo;
	}
	public static void setInfo(Centro d, String s) {
		d.info = s;
	}
	public static String getInfo(Centro c) {
		String s = c.info;
		return s;
	}

	public int getID() {
		return this.id;
	}



}
