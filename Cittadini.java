package progetto_lab_B;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Cittadini implements ActionListener{
	public ServerInterface stub;
	JFrame frame = new JFrame();
	JLabel titolo = new JLabel("Sezione Cittadini");
	JButton bottoneInfo = new JButton("Visualizza informazioni di un centro");
	JButton bottoneRegistra = new JButton("Registrare la propria vaccinazione");
	JButton bottoneEventi = new JButton("Notificare eventi avversi");

	public Cittadini(ServerInterface s) {
		stub = s;
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		
		titolo.setHorizontalAlignment(SwingConstants.CENTER);
		titolo.setBounds(84, 11, 250, 34);
		frame.add(titolo);
		
		bottoneInfo.setBounds(84, 56, 250, 48);
		bottoneInfo.addActionListener(this);
		frame.add(bottoneInfo);
		
		bottoneRegistra.setBounds(84, 115, 250, 48);
		bottoneRegistra.addActionListener(this);
		frame.add(bottoneRegistra);
		
		bottoneEventi.setBounds(84, 174, 250, 48);
		bottoneEventi.addActionListener(this);
		frame.add(bottoneEventi);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent i) {
		if(i.getSource()==bottoneInfo) {
			RicercaCentro finestraRicerca = new RicercaCentro(stub, 0);
		}
		if(i.getSource()==bottoneRegistra) {
			RegistraVaccinato finestraRvacc = new RegistraVaccinato(stub);
		}
		if(i.getSource()==bottoneEventi) {
			Login finestraLogin = new Login(stub);
		}
	}

}
