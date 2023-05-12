package sistema.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EstoqueView extends JFrame{
	JLabel codBarrasLabel, quantidadeLabel;
	JTextField codBarrasField, quantidadeField;
	JButton buscarButton, editarButton; //pode colocar public se não tiver restrição
	
	public EstoqueView() {
		super("Estoque");
		setSize(250, 200);
		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //não tem
		setResizable(false);
		setLayout(new FlowLayout());
		
		codBarrasLabel = new JLabel("Código Barras: ");
		quantidadeLabel = new JLabel("Quantidade: ");
		
		codBarrasField = new JTextField(10);
		quantidadeField = new JTextField(8);
		
		buscarButton = new JButton("Buscar");
		editarButton = new JButton("Editar");
		
		add(codBarrasLabel);
		add(codBarrasField);
		add(quantidadeLabel);
		quantidadeLabel.setVisible(false);
		add(quantidadeField);
		quantidadeField.setVisible(false);
		add(editarButton);
		editarButton.setVisible(false);
		add(buscarButton);
		
		setVisible(true);
	}

	public JTextField getCodBarrasField() {
		return codBarrasField;
	}

	public JTextField getQuantidadeField() {
		return quantidadeField;
	}
	
	public JButton getBuscarButton() {
		return buscarButton;
	}
	
	public JLabel getQuantidadeLabel() {
		return quantidadeLabel;
	}

	public JButton getEditarButton() {
		return editarButton;
	}
}
