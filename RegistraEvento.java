package progetto_lab_B;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class RegistraEvento implements ActionListener {
	public ServerInterface stub;
	JFrame frame = new JFrame();
	JLabel titolo = new JLabel("seleziona il centro dove \u00E8 avvenuta la vaccinazione");
	JComboBox elencoCentri;
	JCheckBox malDiTesta = new JCheckBox("Mal di testa");
	JCheckBox febbre = new JCheckBox("Febbre");
	JCheckBox dolori = new JCheckBox("dolori muscolari");
	JCheckBox linfo = new JCheckBox("Linfoadenopatia");
	JCheckBox tachi = new JCheckBox("Tachicardia");
	JCheckBox crisi = new JCheckBox("Crisi ipertensiva");
	JLabel titolo2 = new JLabel("seleziona l'evento (o gli eventi) che vuoi segnalare, con la loro severit\u00E0 (puoi anche inserire dei commenti)");
	JLabel lblEvento = new JLabel("evento");
	String[] sev = {"1", "2", "3", "4", "5"};
	JComboBox sevFebbre = new JComboBox(sev);
	JComboBox sevDolori = new JComboBox(sev);
	JComboBox sevLinfo = new JComboBox(sev);
	JComboBox sevTachi = new JComboBox(sev);
	JComboBox sevCrisi = new JComboBox(sev);
	JComboBox sevTesta = new JComboBox(sev);
	JLabel lblSeverità = new JLabel("severit\u00E0");
	JTextField febbreTxt = new JTextField();
	JTextField doloriTxt = new JTextField();
	JTextField linfoTxt = new JTextField();
	JTextField tachiTxt = new JTextField();
	JTextField crisiTxt = new JTextField();
	JTextField testaTxt = new JTextField();
	JLabel lblCommenti = new JLabel("commenti");
	JButton bottoneSubmit = new JButton("Registra");
	Centro[] trovati;
	Centro selected;
	int idCentro;
	

	public RegistraEvento(ServerInterface s, int cardinality, Centro[] t) {
		stub = s;
		trovati = t;
		frame.setBounds(100, 100, 676, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		titolo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		titolo.setHorizontalAlignment(SwingConstants.CENTER);
		titolo.setBounds(10, 11, 640, 30);
		frame.add(titolo);
		
		String[] find = new String[cardinality];  //questa sezione è sicuramente da contollare!!!!!
		for (int i = 0; i < cardinality; i++) {
			find[i] = Centro.scrivi(trovati[i]);
		}
		elencoCentri = new JComboBox(find);
		elencoCentri.setBounds(20, 52, 630, 22);
		elencoCentri.addActionListener(this);
		frame.add(elencoCentri);
		
		malDiTesta.setBounds(20, 274, 128, 23);
		malDiTesta.addActionListener(this);
		frame.add(malDiTesta);
		
		febbre.setBounds(20, 144, 128, 23);
		febbre.addActionListener(this);
		frame.add(febbre);
		
		dolori.setBounds(20, 170, 128, 23);
		dolori.addActionListener(this);
		frame.add(dolori);
		
		linfo.setBounds(20, 196, 128, 23);
		linfo.addActionListener(this);
		frame.add(linfo);
		
		tachi.setBounds(20, 222, 128, 23);
		tachi.addActionListener(this);
		frame.add(tachi);
		
		crisi.setBounds(20, 248, 128, 23);
		crisi.addActionListener(this);
		frame.add(crisi);
		
		titolo2.setHorizontalAlignment(SwingConstants.CENTER);
		titolo2.setBounds(30, 93, 620, 14);
		frame.add(titolo2);
		
		lblEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvento.setBounds(23, 123, 46, 14);
		frame.add(lblEvento);
		
		sevFebbre.setBounds(198, 144, 38, 22);
		sevFebbre.addActionListener(this);
		frame.add(sevFebbre);
		
		sevDolori.setBounds(198, 170, 38, 22);
		sevDolori.addActionListener(this);
		frame.add(sevDolori);
		
		sevLinfo.setBounds(198, 196, 38, 22);
		sevLinfo.addActionListener(this);
		frame.add(sevLinfo);
		
		sevTachi.setBounds(198, 222, 38, 22);
		sevTachi.addActionListener(this);
		frame.add(sevTachi);
		
		sevCrisi.setBounds(198, 248, 38, 22);
		sevCrisi.addActionListener(this);
		frame.add(sevCrisi);
		
		sevTesta.setBounds(198, 274, 38, 22);
		sevTesta.addActionListener(this);
		frame.add(sevTesta);
		
		lblSeverità.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeverità.setBounds(190, 118, 52, 14);
		frame.add(lblSeverità);
		
		febbreTxt.setBounds(257, 145, 393, 20);
		frame.add(febbreTxt);
		febbreTxt.setColumns(10);
		
		doloriTxt.setColumns(10);
		doloriTxt.setBounds(257, 171, 393, 20);
		frame.add(doloriTxt);
		
		linfoTxt.setColumns(10);
		linfoTxt.setBounds(257, 197, 393, 20);
		frame.add(linfoTxt);
		
		tachiTxt.setColumns(10);
		tachiTxt.setBounds(257, 223, 393, 20);
		frame.add(tachiTxt);
		
		crisiTxt.setColumns(10);
		crisiTxt.setBounds(257, 249, 393, 20);
		frame.add(crisiTxt);
		
		testaTxt.setColumns(10);
		testaTxt.setBounds(257, 275, 393, 20);
		frame.add(testaTxt);
		
		lblCommenti.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommenti.setBounds(415, 118, 89, 14);
		frame.add(lblCommenti);
		
		bottoneSubmit.setBounds(239, 328, 89, 23);
		bottoneSubmit.addActionListener(this);
		frame.add(bottoneSubmit);
		
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent n) {
		if(n.getSource()==elencoCentri) {
			JComboBox cb = (JComboBox)n.getSource();
			int index = (int)cb.getSelectedIndex();
			System.out.println(index);
			selected = trovati[index];
			idCentro = selected.getID();
		}
		if(n.getSource()==bottoneSubmit) {
			if(malDiTesta.isSelected()) {
				int sev1 = sevTesta.getSelectedIndex() +1;
				EventoAvverso eventoTesta;
				if(testaTxt.getText().length() !=0 ) {
					String commento = testaTxt.getText();
					eventoTesta = new EventoAvverso("Mal di testa", sev1, idCentro, commento);
				} else {eventoTesta = new EventoAvverso("Mal di testa", sev1, idCentro);}
				System.out.println(EventoAvverso.scriviEvento(eventoTesta));
				try {
					stub.InserisciEventiAvversi(eventoTesta, selected);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
			}
			if(febbre.isSelected()) {
				int sev2 = sevFebbre.getSelectedIndex() +1;
				EventoAvverso eventoFebbre;
				if(febbreTxt.getText().length() !=0 ) {
					String commento = febbreTxt.getText();
					 eventoFebbre = new EventoAvverso("Febbre", sev2, idCentro, commento);
				} else {eventoFebbre = new EventoAvverso("Febbre", sev2, idCentro);}
				System.out.println(EventoAvverso.scriviEvento(eventoFebbre));
				try {
					stub.InserisciEventiAvversi(eventoFebbre, selected);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
			
			if(dolori.isSelected()) {
				int sev3 = sevDolori.getSelectedIndex() +1;
				EventoAvverso eventoDolori;
				if(doloriTxt.getText().length() !=0 ) {
					String commento = doloriTxt.getText();
					 eventoDolori = new EventoAvverso("Dolori muscolari", sev3, idCentro, commento);
				} else {eventoDolori  = new EventoAvverso("Dolori muscolari", sev3, idCentro);}
				System.out.println(EventoAvverso.scriviEvento(eventoDolori));
				try {
					stub.InserisciEventiAvversi(eventoDolori, selected);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
			}
			
			if(linfo.isSelected()) {
				int sev4 = sevLinfo.getSelectedIndex() +1;
				EventoAvverso eventoLinfo;
				if(linfoTxt.getText().length() !=0 ) {
					String commento = linfoTxt.getText();
					eventoLinfo = new EventoAvverso("Linfoadenopatia", sev4, idCentro, commento);
				} else {eventoLinfo  = new EventoAvverso("Linfoadenopatia", sev4, idCentro);}
				System.out.println(EventoAvverso.scriviEvento(eventoLinfo));
				try {
					stub.InserisciEventiAvversi(eventoLinfo, selected);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
			}
			
			if(tachi.isSelected()) {
				int sev5 = sevTachi.getSelectedIndex() +1;
				EventoAvverso eventoTachi;
				if(tachiTxt.getText().length() !=0 ) {
					String commento = tachiTxt.getText();
					eventoTachi  = new EventoAvverso("Tachicardia", sev5, idCentro, commento);
				} else {eventoTachi  = new EventoAvverso("Tachicardia", sev5, idCentro);}
				System.out.println(EventoAvverso.scriviEvento(eventoTachi));
				try {
					stub.InserisciEventiAvversi(eventoTachi, selected);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
			}
			
			if(crisi.isSelected()) {
				int sev6 = sevCrisi.getSelectedIndex() +1;
				EventoAvverso eventoCrisi;
				if(crisiTxt.getText().length() !=0 ) {
					String commento = crisiTxt.getText();
					eventoCrisi  = new EventoAvverso("Crisi ipertensiva", sev6, idCentro, commento);
				} else {eventoCrisi  = new EventoAvverso("Crisi ipertensiva", sev6, idCentro);}
				System.out.println(EventoAvverso.scriviEvento(eventoCrisi));
				try {
					stub.InserisciEventiAvversi(eventoCrisi, selected);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

}
