package progetto_lab_B;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login implements ActionListener{
	public ServerInterface stub;
	JFrame frame = new JFrame();
	JLabel titolo = new JLabel("Per poter inserire un evento avverso");
	JLabel titolo2 = new JLabel("\u00E8 necessario effettuare il login");
	JLabel userID = new JLabel("User ID");
	JLabel pwd = new JLabel("Password");
	JTextField userIDTxt = new JTextField();
	JTextField pwdTxt = new JTextField();
	JButton bottoneContinua = new JButton("Continua");
	
	public Login(ServerInterface s) {
		stub = s;
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		titolo.setHorizontalAlignment(SwingConstants.CENTER);
		titolo.setBounds(10, 11, 414, 14);
		frame.add(titolo);
		
		titolo2.setHorizontalAlignment(SwingConstants.CENTER);
		titolo2.setBounds(10, 24, 414, 14);
		frame.add(titolo2);
		
		userID.setBounds(23, 80, 63, 14);
		frame.add(userID);
		
		pwd.setBounds(23, 126, 63, 14);
		frame.add(pwd);
		
		userIDTxt.setBounds(127, 77, 228, 20);
		frame.add(userIDTxt);
		userIDTxt.setColumns(10);
		
		pwdTxt.setBounds(127, 123, 228, 20);
		frame.add(pwdTxt);
		pwdTxt.setColumns(10);
		
		bottoneContinua.setBounds(171, 188, 89, 23);
		frame.add(bottoneContinua);
		bottoneContinua.addActionListener(this);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent m) {
		if(m.getSource()==bottoneContinua) {
			boolean ok = false;
			String id = userIDTxt.getText();
			String pw = pwdTxt.getText();
			try {
				ok = stub.login(id, pw);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if(!ok) {
				JFrame frameAlert = new JFrame();
				JOptionPane.showMessageDialog(frameAlert, "User ID o password non trovati, riprova oppure procedi alla registrazione");
			} else {
				RicercaCentro finestraRicerca = new RicercaCentro(stub, 1);
			}

		}
		
	}



}
