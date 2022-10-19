package progetto_lab_B;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CentriVaccinali implements ActionListener {
	public ServerInterface stub;
	JFrame finestraCentri = new JFrame();
	JLabel lblNewLabel = new JLabel("sezione centi vaccinali");
	JButton bottoneCentro = new JButton("aggiungi centro");
	JButton bottoneCittadino = new JButton("registra cittadino");
	
	public CentriVaccinali(ServerInterface s) {
		stub = s;

		finestraCentri.setBounds(100, 100, 450, 300);
		finestraCentri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finestraCentri.setLayout(null);
		
		
		lblNewLabel.setBounds(163, 35, 134, 29);
		finestraCentri.add(lblNewLabel);
		
	
		bottoneCentro.setBounds(163, 75, 145, 45);
		finestraCentri.add(bottoneCentro);
		bottoneCentro.addActionListener(this);
		
	
		bottoneCittadino.setBounds(165, 131, 132, 38);
		finestraCentri.add(bottoneCittadino);
		bottoneCittadino.addActionListener(this);
		
		finestraCentri.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent f) {
		if(f.getSource()==bottoneCentro) {
			CentroVacc finestraCentro = new CentroVacc(stub);
		} else if(f.getSource()==bottoneCittadino) {
			CittadiniVac finestraCittadini = new CittadiniVac(stub);
		}
		
	}

}
