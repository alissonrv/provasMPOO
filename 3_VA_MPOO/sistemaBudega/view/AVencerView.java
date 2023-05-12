package sistema.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AVencerView extends JFrame{
	public JLabel prazoLabel;
	public JTextField prazoTextField;
	public JButton buscarButton;
	
	public AVencerView() {
		super("A Vencer");
		setSize(230, 120);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		
		prazoLabel = new JLabel("Prazo (dias): ");
		prazoTextField = new JTextField(5);
		buscarButton = new JButton("Buscar");
		
		add(prazoLabel);
		add(prazoTextField);
		add(buscarButton);
		
		setVisible(true);
	}
}