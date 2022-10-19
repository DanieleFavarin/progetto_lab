package progetto_lab_B;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FinestraID {
	int ID;
	JFrame frame = new JFrame();
	JLabel lblNewLabel = new JLabel("registrazione effettuata con successo");
	JLabel lblNewLabel_1;
	JButton btnNewButton = new JButton("OK");
	
	FinestraID(int i){
		ID = i;
		frame.setBounds(100, 100, 449, 151);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //per ora la finestra si chiude solo con la x, vorrei chiuderla anche premendo su "OK
		frame.setLayout(null);
		
		lblNewLabel.setBounds(117, 11, 243, 26);
		frame.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("ID vacinazione: "+i);
		lblNewLabel_1.setBounds(114, 48, 246, 20);
		frame.add(lblNewLabel_1);
		
		btnNewButton.setBounds(177, 79, 89, 23);
		frame.add(btnNewButton);

		
		frame.setVisible(true);
	}


}
