package progetto_lab_B;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ServerInterface extends Remote{
	void salvaCentro (Centro c) throws RemoteException;
	int registraVaccinato(CittadinoVaccinato x, String c) throws RemoteException;
	void registraCittadino (CittadinoRegistrato c) throws RemoteException;
	Centro[] ricercaPerNome (String n) throws RemoteException;
	Centro[] ricercaPerComune (String c, String t) throws RemoteException;
	boolean login(String userID, String password) throws RemoteException;
	void InserisciEventiAvversi(EventoAvverso e, Centro c) throws RemoteException;
}
