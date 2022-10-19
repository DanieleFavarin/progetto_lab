package progetto_lab_B;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Random;

public class Server extends UnicastRemoteObject implements ServerInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Server() throws RemoteException {
		super();
	}

	@Override
	public synchronized void salvaCentro(Centro c) throws RemoteException {
		File elencoCentri = new File("CentriVaccinali.dati.txt");
		String nomeCentro = c.getNome();
		File centro = new File("Vaccinati_"+nomeCentro+".txt");
		try {
			centro.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		FileWriter w; BufferedWriter wr; PrintWriter pw;
        try {
			w = new FileWriter("CentriVaccinali.dati.txt");
			wr = new BufferedWriter(w);
			pw = new PrintWriter(wr);
			pw.println(Centro.scrivi(c));
	        pw.flush();
	        pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static synchronized void main(String[] args) {
		try {
			Server obj = new Server();
			Registry registro = LocateRegistry.createRegistry(1099);
			registro.rebind("server", obj);
			System.err.println("server ready");
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	@Override
	public synchronized int registraVaccinato(CittadinoVaccinato x, String c) throws RemoteException {
		FileWriter w; BufferedWriter wr; PrintWriter pw;
        try {
			w = new FileWriter("Vaccinati_"+c+".txt");
			wr = new BufferedWriter(w);
			pw = new PrintWriter(wr);
			pw.println(CittadinoVaccinato.scriviCittadino(x));
	        pw.flush();
	        pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Random random = new Random();
        int idVaccino = random.nextInt(200);
        System.out.println(idVaccino);
        
		return idVaccino;
	}

	@Override
	public synchronized void registraCittadino(CittadinoRegistrato c) throws RemoteException {
		FileWriter w; BufferedWriter wr; PrintWriter pw;
		File elencoCittadiniR = new File("Cittadini_Registrati.txt");
        try {
			w = new FileWriter(elencoCittadiniR);
			wr = new BufferedWriter(w);
			pw = new PrintWriter(wr);
			pw.println(CittadinoRegistrato.scriviCittadinoRegistrato(c));
	        pw.flush();
	        pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public synchronized Centro[] ricercaPerNome(String n) throws RemoteException {  //metodo creato apposta per fare le prove
		Centro c = new Centro("multisala", "via dei paperi", "HUB");  //andrà poi definito il metodo corretto per la ricerca su DB
		Centro d = new Centro("sala", "piazza gigi", "HUB");
		Centro.setInfo(d, "questo centro fa cagare");
		Centro[] centri = {c, d}; //prova per array vuoto, altimenti ci inserisco c, d che sono i centri creati nel metodo
		return centri;
	}

	@Override
	public synchronized Centro[] ricercaPerComune(String c, String t) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized boolean login(String userID, String password) throws RemoteException {
		//questo metodo fa un check nel DB per vedere se l'utente è già registrato, controllando se sono presenti il suo ID e la password
		//ovviamente se li trova, il metodo ritornerà true, in caso contrario ritornerà false
		return true;
	}

	@Override
	public synchronized void InserisciEventiAvversi(EventoAvverso ev, Centro c) throws RemoteException {
		FileWriter w; BufferedWriter wr; PrintWriter pw;
		File elencoEventi = new File("Eventi_Avversi.txt");
        try {
			w = new FileWriter(elencoEventi);
			wr = new BufferedWriter(w);
			pw = new PrintWriter(wr);
			pw.println(EventoAvverso.scriviEvento(ev));
	        pw.flush();
	        pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
       add(c, ev);
	}
	
	public static synchronized void add(Centro c, EventoAvverso ev) {
		(c.listaEventi).add(ev);
		
	}
	
	}

