package sistema.view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DescontoView extends JFrame{
	public JLabel criterioLabel, codBarrasLabel, descontoLabel, prazoLabel;
	public JTextField codBarrasTextField, descontoTextField;
	public JButton aplicarButton;
	public JRadioButton codBarrasRadioButton, validadeRadioButton;
	public ButtonGroup bg;
	public JComboBox<String> prazoBox;
	
	
	public DescontoView() {
		super("Gerenciar");
		setSize(220, 280);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		
		criterioLabel = new JLabel(" Critério:  ");
		criterioLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		codBarrasLabel = new JLabel("Código Barras: ");
		descontoLabel = new JLabel("Desconto (%): ");
		prazoLabel = new JLabel("Prazo (dias): ");
		prazoLabel.setVisible(false);		
		
		codBarrasTextField = new JTextField(6);
		descontoTextField = new JTextField(4);
		
		aplicarButton = new JButton("Aplicar");
		aplicarButton.setEnabled(false);
		
		codBarrasRadioButton = new JRadioButton("Código Barras", true);
		validadeRadioButton = new JRadioButton("Validade", false);
		bg = new ButtonGroup();
		bg.add(codBarrasRadioButton);
		bg.add(validadeRadioButton);
		
		String opcoes [] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
							"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
							"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		
		prazoBox = new JComboBox<String>(opcoes);
		prazoBox.setVisible(false);
		
		add(criterioLabel);
		add(codBarrasRadioButton);
		add(validadeRadioButton);
		add(codBarrasLabel);
		add(codBarrasTextField);
		add(prazoLabel);
		add(prazoBox);
		add(descontoLabel);
		add(descontoTextField);
		add(aplicarButton);
		
		setVisible(true);
	}
}