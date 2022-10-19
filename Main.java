package progetto_lab_B;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main implements ActionListener{
	JFrame finestraMain = new JFrame();
	JLabel lblNewLabel = new JLabel("benvenuti");
	JButton bottoneCentri = new JButton("centri");
	JButton bottoneCittadini = new JButton("Cittadini");
	public ServerInterface stub;

	
	public Main(ServerInterface s) {
		stub = s;
		
		finestraMain.setBounds(100, 100, 450, 300);
		finestraMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finestraMain.setLayout(null);
		finestraMain.setVisible(true);
		
		lblNewLabel.setBounds(0, 0, 434, 45);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		finestraMain.getContentPane().add(lblNewLabel);
		
		bottoneCentri.setBounds(138, 56, 159, 58);
		bottoneCentri.addActionListener(this);
		finestraMain.add(bottoneCentri);
		


		bottoneCittadini.setBounds(138, 125, 159, 63);
		bottoneCittadini.addActionListener(this);
		finestraMain.getContentPane().add(bottoneCittadini);
		

	}
	
	public static void main(String[] args) {
		Registry registro;
		ServerInterface stub = null;
		
		try {
			 registro = LocateRegistry.getRegistry(1099);
			 stub = (ServerInterface) registro.lookup("server");
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
		new Main(stub);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bottoneCentri) {
			CentriVaccinali finestraCentri = new CentriVaccinali(stub);
		} else 	if(e.getSource()==bottoneCittadini) {
			Cittadini finestraCittadini = new Cittadini(stub);
		}
		
	}

}
