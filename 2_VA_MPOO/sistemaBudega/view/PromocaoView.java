package sistema.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PromocaoView extends JFrame{
	JLabel codBarrasLabel;
	JTextField codBarrasField;
	JButton buscarButton, aplicarButton; //pode colocar public se não tiver restrição
	JCheckBox checkBox;
	
	public PromocaoView() {
		super("Promocao");
		setSize(220, 200);
		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //não tem
		setResizable(false);
		setLayout(new FlowLayout());
		
		codBarrasLabel = new JLabel("Código Barras: ");
		codBarrasField = new JTextField(7);
		buscarButton = new JButton("Buscar");
		aplicarButton = new JButton("Aplicar");
		checkBox = new JCheckBox("Aplicar Promocao    ", true);
		
		add(codBarrasLabel);
		add(codBarrasField);
		add(buscarButton);
		add(checkBox);
		checkBox.setSelected(false);
		checkBox.setVisible(false);
		add(aplicarButton);
		aplicarButton.setVisible(false);
		
		setVisible(true);
	}

	public JLabel getCodBarrasLabel() {
		return codBarrasLabel;
	}

	public JTextField getCodBarrasField() {
		return codBarrasField;
	}

	public JButton getBuscarButton() {
		return buscarButton;
	}

	public JButton getAplicarButton() {
		return aplicarButton;
	}

	public JCheckBox getCheckBox() {
		return checkBox;
	}
}
