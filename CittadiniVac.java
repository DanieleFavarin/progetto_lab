package progetto_lab_B;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CittadiniVac implements ActionListener{
	public ServerInterface stub;
	JFrame frame = new JFrame();
	JLabel titolo = new JLabel("Registra nuovo vaccinato");
	JLabel cv = new JLabel("Centro vaccinale");
	JLabel name = new JLabel("Nome e Cognome");
	JLabel cf = new JLabel("Codice fiscale");
	JLabel date = new JLabel("Data somministrazione");
	JLabel vaccino = new JLabel("Vaccino");
	JTextField cvTxt = new JTextField();
	JTextField nameTxt = new JTextField();
	JTextField cfTxt = new JTextField();
	String[] vaccini = {"...", "Moderna", "Pfizer", "J&J"};
	JComboBox boxVaccini = new JComboBox(vaccini);
	String[] giorni = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	JComboBox gg = new JComboBox(giorni);
	String[] mesi = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	JComboBox mm = new JComboBox(mesi);
	String[] anni = {"2020", "2021", "2022", "2023", "2024", "2025"};
	JComboBox aaaa = new JComboBox(anni);
	JButton registra = new JButton("Registra vaccinato");
	String data;
	String doseVaccino;

	public CittadiniVac(ServerInterface s) {
		stub = s;
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		titolo.setBounds(156, 11, 190, 40);
		frame.add(titolo);
		
		cv.setBounds(10, 52, 104, 14);
		frame.add(cv);
		
		name.setBounds(10, 77, 104, 14);
		frame.add(name);
		
		cf.setBounds(10, 102, 89, 14);
		frame.add(cf);
		
		date.setBounds(10, 127, 129, 14);
		frame.add(date);
		
		vaccino.setBounds(10, 152, 46, 14);
		frame.add(vaccino);
		
		cvTxt.setBounds(156, 49, 218, 20);
		frame.add(cvTxt);
		cvTxt.setColumns(10);
		
		nameTxt.setBounds(156, 74, 218, 20);
		frame.add(nameTxt);
		nameTxt.setColumns(10);
		
		cfTxt.setBounds(156, 99, 218, 20);
		frame.add(cfTxt);
		cfTxt.setColumns(10);
		
		boxVaccini.setBounds(156, 148, 190, 22);
		frame.add(boxVaccini);
		boxVaccini.addActionListener(this);
		
		gg.setBounds(155, 123, 39, 22);
		frame.add(gg);
		gg.addActionListener(this);
		
		mm.setBounds(204, 123, 52, 22);
		frame.add(mm);
		mm.addActionListener(this);
		
		aaaa.setBounds(277, 123, 69, 22);
		frame.add(aaaa);
		aaaa.addActionListener(this);
		
		registra.setBounds(167, 201, 183, 33);
		frame.add(registra);
		registra.addActionListener(this);
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent h) {
		if (h.getSource()==gg) {
			JComboBox cb = (JComboBox)h.getSource();
			data = (String)cb.getSelectedItem();
		}
		if (h.getSource()==mm) {
			JComboBox cb = (JComboBox)h.getSource();
			data = data + "/" + (String)cb.getSelectedItem();
		}
		if (h.getSource()==aaaa) {
			JComboBox cb = (JComboBox)h.getSource();
			data = data + "/" + (String)cb.getSelectedItem();
		}
		if (h.getSource()==boxVaccini) {
			JComboBox cb = (JComboBox)h.getSource();
			doseVaccino = (String)cb.getSelectedItem();
		}
		
		if (h.getSource()==registra) {
			String centro = cvTxt.getText();
			String nomeCognome = nameTxt.getText();
			String codiceFiscale = cfTxt.getText();
			
			CittadinoVaccinato nuovoCittadino = new CittadinoVaccinato(nomeCognome, codiceFiscale, data, doseVaccino);
			try {
				int ID = stub.registraVaccinato(nuovoCittadino, centro);
				FinestraID conferma = new FinestraID(ID);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
