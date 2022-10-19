package progetto_lab_B;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class EsitoRicerca implements ActionListener {
	JFrame frame = new JFrame();
	JLabel titolo = new JLabel("Esito ricerca");
	JLabel lblNewLabel = new JLabel("Seleziona il centro che cercavi");
	
	JComboBox esiti;
	JButton show = new JButton("vedi info");
	JTextPane textArea = new JTextPane();
	
	JScrollBar scrollBar = new JScrollBar();
	Centro[] trovati;
	Centro c;


	public EsitoRicerca(ServerInterface stub, int cardinality, Centro[] t) {
		trovati = t;
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		
		titolo.setHorizontalAlignment(SwingConstants.CENTER);
		titolo.setBounds(151, 11, 160, 22);
		frame.add(titolo);
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(151, 44, 160, 14);
		frame.add(lblNewLabel);
		
		String[] find = new String[cardinality];  //questa sezione è sicuramente da contollare!!!!!
		for (int i = 0; i < cardinality; i++) {
			find[i] = Centro.scrivi(trovati[i]);
		}
		esiti = new JComboBox(find);
		esiti.setBounds(37, 69, 387, 22);
		esiti.addActionListener(this);
		frame.add(esiti);
		
		show.setBounds(185, 102, 89, 23);
		show.addActionListener(this);
		frame.add(show);
		
		textArea.setBounds(10, 147, 414, 103);
		textArea.setEditable(false);
		frame.add(textArea);
		
		scrollBar.setBounds(407, 147, 17, 103);
		frame.getContentPane().add(scrollBar);
		
		frame.setVisible(true);
		

	    }


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==esiti) {
			JComboBox cb = (JComboBox)e.getSource();
			int index = (int)cb.getSelectedIndex();
			c = trovati[index];
		}
		if(e.getSource()==show) {
			String txt = Centro.getInfo(c);
			System.out.println(txt);
			textArea.setText(txt);
	}


		}




	}
