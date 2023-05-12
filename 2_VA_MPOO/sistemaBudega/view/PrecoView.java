package sistema.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PrecoView extends JFrame{
	JLabel codBarrasLabel, precoLabel;
	JTextField codBarrasField, precoField;
	JButton buscarButton, editarButton; //pode colocar public se não tiver restrição
	
	public PrecoView() {
		super("Preço");
		setSize(250, 200);
		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //não tem
		setResizable(false);
		setLayout(new FlowLayout());
		
		codBarrasLabel = new JLabel("Código Barras: ");
		precoLabel = new JLabel("Preço (R$): ");
		
		codBarrasField = new JTextField(10);
		precoField = new JTextField(8);
		
		buscarButton = new JButton("Buscar");
		editarButton = new JButton("Editar");
		
		
		
		add(codBarrasLabel);
		add(codBarrasField);
		add(precoLabel);
		precoLabel.setVisible(false);
		add(precoField);
		precoField.setVisible(false);
		add(editarButton);
		editarButton.setVisible(false);
		add(buscarButton);
		
		setVisible(true);
	}

	public JLabel getCodBarrasLabel() {
		return codBarrasLabel;
	}

	public JLabel getPrecoLabel() {
		return precoLabel;
	}

	public JTextField getCodBarrasField() {
		return codBarrasField;
	}

	public JTextField getPrecoField() {
		return precoField;
	}

	public JButton getBuscarButton() {
		return buscarButton;
	}

	public JButton getEditarButton() {
		return editarButton;
	}
}