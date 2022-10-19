package progetto_lab_B;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RicercaCentro implements ActionListener {
	public ServerInterface stub;
	int scopoRicerca;
	JFrame frame = new JFrame();
	JLabel titolo = new JLabel("Ricerca Centro Vaccinale");
	JLabel perNome = new JLabel("Per nome");
	JLabel perComune = new JLabel("Per comune");
	JTextField nomeCentroTxt = new JTextField();
	JTextField comuneCentroTxt = new JTextField();
	JButton ricercaPerNome = new JButton("Cerca");
	JButton ricercaPerComune = new JButton("Cerca");
	String[] tipi = {"...", "HUB", "Ospedaliero", "Aziendale"};
	JComboBox opzTipologia = new JComboBox(tipi);
	String tipologia;

	public RicercaCentro(ServerInterface s, int scopo) { //lo scopo della ricerca indica se: 0 - vogliamo fare la ricerca delle info ; 1 - ricerca per inserire eventi avversi 
		stub = s;
		scopoRicerca = scopo;
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		
		titolo.setHorizontalAlignment(SwingConstants.CENTER);
		titolo.setBounds(76, 11, 257, 26);
		frame.add(titolo);
		
		perNome.setBounds(10, 71, 57, 14);
		frame.add(perNome);
		
		perComune.setBounds(10, 132, 74, 14);
		frame.add(perComune);
		
		nomeCentroTxt.setBounds(97, 68, 144, 20);
		frame.add(nomeCentroTxt);
		nomeCentroTxt.setColumns(10);
		
		comuneCentroTxt.setBounds(97, 129, 138, 20);
		frame.add(comuneCentroTxt);
		comuneCentroTxt.setColumns(10);
		
		opzTipologia.setBounds(245, 128, 80, 22);
		frame.add(opzTipologia);
		opzTipologia.addActionListener(this);
		
		
		ricercaPerNome.setBounds(335, 67, 89, 23);
		frame.add(ricercaPerNome);
		ricercaPerNome.addActionListener(this);
		
		ricercaPerComune.setBounds(335, 128, 89, 23);
		frame.add(ricercaPerComune);
		ricercaPerComune.addActionListener(this);
		

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent m) {
		if(m.getSource()==opzTipologia) {
			JComboBox cb = (JComboBox)m.getSource();
			tipologia = (String)cb.getSelectedItem();
		}
		if(m.getSource()==ricercaPerNome) {
			String nome = nomeCentroTxt.getText();
			try {
				Centro[] trovati = stub.ricercaPerNome(nome);
				int cardinality = trovati.length;
				if (cardinality==0) {
					JFrame frameAlert = new JFrame();
					JOptionPane.showMessageDialog(frameAlert, "nessun centro trovato, riprova!");
				} else if(scopoRicerca==0) {
					EsitoRicerca finestraEsito = new EsitoRicerca(stub, cardinality, trovati);
					} else {
						RegistraEvento finestraEventi = new RegistraEvento(stub, cardinality, trovati);
					}
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		if(m.getSource()==ricercaPerComune) {
			String comune = comuneCentroTxt.getText();
			try {
				Centro[] trovati = stub.ricercaPerComune(comune, tipologia);
				int cardinality = trovati.length;
				if (cardinality==0) {
					JFrame frameAlert = new JFrame();
					JOptionPane.showMessageDialog(frameAlert, "nessun centro trovato, riprova!");
				}  else if(scopoRicerca==0) {
					EsitoRicerca finestraEsito = new EsitoRicerca(stub, cardinality, trovati);
					} else {
						RegistraEvento finestraEventi = new RegistraEvento(stub, cardinality, trovati);
					}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
	}

}
