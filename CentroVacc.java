package progetto_lab_B;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CentroVacc implements ActionListener{
	public ServerInterface stub;
	JFrame frame = new JFrame();
	JLabel nome = new JLabel("Nome");
	JLabel indirizzo = new JLabel("Indirizzo");
	JLabel tipologia = new JLabel("Tipologia");
	JTextField nomeTxt = new JTextField();
	JTextField indirizzoTxt = new JTextField();
	String[] tipi = {"...", "HUB", "Ospedaliero", "Aziendale"};
	JComboBox tipologie = new JComboBox(tipi);
	JButton save = new JButton("Salva");
	String tipo;
	
	public CentroVacc(ServerInterface s) {
		stub = s;
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		nome.setBounds(23, 51, 61, 14);
		frame.add(nome);
		nomeTxt.setBounds(173, 48, 86, 20);
		frame.add(nomeTxt);
		nomeTxt.setColumns(10);
		
		indirizzo.setBounds(23, 80, 46, 14);
		frame.add(indirizzo);
		indirizzoTxt.setBounds(173, 77, 86, 20);
		frame.add(indirizzoTxt);
		indirizzoTxt.setColumns(10);
		
		tipologia.setBounds(23, 105, 46, 14);
		frame.add(tipologia);
		tipologie.setBounds(173, 101, 86, 22);
		tipologie.setSelectedIndex(0);
		tipologie.addActionListener(this);
		frame.add(tipologie);
		
		save.setBounds(170, 172, 89, 23);
		frame.add(save);
		save.addActionListener(this);
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent g) {
		if (g.getSource()==tipologie) {
			JComboBox cb = (JComboBox)g.getSource();
			tipo = (String)cb.getSelectedItem();
		}
		if (g.getSource()==save) {
			String via = indirizzoTxt.getText();
			String name = nomeTxt.getText();
			String t = tipo;
			
			Centro c = new Centro(name, via, t);
			try {
				stub.salvaCentro(c);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
	}

}
