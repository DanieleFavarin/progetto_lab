package progetto_lab_B;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegistraVaccinato implements ActionListener{
	public ServerInterface stub;
	JFrame frame = new JFrame();
	JLabel titolo = new JLabel("Registra la tua vaccinazione");
	JLabel nome = new JLabel("Nome e Cognome");
	JLabel cf = new JLabel("Codice fiscale");
	JLabel mail = new JLabel("E-mail");
	JLabel utente = new JLabel("User ID");
	JLabel pw = new JLabel("Password");
	JLabel vaccinoID = new JLabel("ID vaccinazione");
	JTextField nomeTxt = new JTextField();
	JTextField cfTxt = new JTextField();
	JTextField mailTxt = new JTextField();
	JTextField utenteTxt = new JTextField();
	JTextField pwTxt = new JTextField();
	JTextField vaccinoIDTxt = new JTextField();
	JButton bottoneRegistra = new JButton("Registra");


	public RegistraVaccinato(ServerInterface s) {
		stub = s;
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		
		titolo.setHorizontalAlignment(SwingConstants.CENTER);
		titolo.setBounds(35, 11, 373, 34);
		frame.add(titolo);
		
		nome.setBounds(10, 61, 98, 14);
		frame.add(nome);
		
		cf.setBounds(10, 86, 86, 14);
		frame.add(cf);
		
		mail.setBounds(10, 111, 46, 14);
		frame.add(mail);
		
		utente.setBounds(10, 136, 46, 14);
		frame.getContentPane().add(utente);
		
		pw.setBounds(10, 161, 46, 14);
		frame.add(pw);
		
		vaccinoID.setBounds(10, 186, 86, 14);
		frame.add(vaccinoID);
		
		nomeTxt.setBounds(157, 56, 229, 20);
		frame.add(nomeTxt);
		nomeTxt.setColumns(10);
		
		cfTxt.setBounds(157, 81, 229, 20);
		frame.add(cfTxt);
		cfTxt.setColumns(10);
		
		mailTxt.setBounds(157, 106, 229, 20);
		frame.add(mailTxt);
		mailTxt.setColumns(10);
		
		utenteTxt.setBounds(156, 131, 230, 20);
		frame.add(utenteTxt);
		utenteTxt.setColumns(10);
		
		pwTxt.setBounds(157, 156, 229, 20);
		frame.add(pwTxt);
		pwTxt.setColumns(10);
		
		vaccinoIDTxt.setBounds(157, 183, 229, 20);
		frame.add(vaccinoIDTxt);
		vaccinoIDTxt.setColumns(10);
		
		bottoneRegistra.setBounds(154, 214, 181, 36);
		bottoneRegistra.addActionListener(this);
		frame.add(bottoneRegistra);
		
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent l) {
		if(l.getSource()==bottoneRegistra) {
			String nome = nomeTxt.getText();
			String codFiscale = cfTxt.getText();
			String email = mailTxt.getText();
			String user = utenteTxt.getText();
			String password = pwTxt.getText();
			String vaccID = vaccinoIDTxt.getText();
			
			CittadinoRegistrato citt = new CittadinoRegistrato(nome, codFiscale, email, user, password, vaccID);
			try {
				stub.registraCittadino(citt);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
