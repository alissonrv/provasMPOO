package sistema.view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class CadastroView extends JFrame{
	JLabel nomeLabel, codBarrasLabel, quantidadeLabel, validadeLabel, perecivelLabel, avisoLabel;
	JTextField nomeField, codBarrasField, quantidadeField, validadeField;
	JRadioButton simRadioButton, naoRadioButton;
	ButtonGroup bg;
	JButton adicionarButton;
	
	public CadastroView() {
		super("Cadastro");
		setSize(250, 250);
		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(new FlowLayout());
		
		nomeLabel = new JLabel("Nome: ");
		codBarrasLabel = new JLabel("Código Barras: ");
		quantidadeLabel = new JLabel("Quantidade: ");
		validadeLabel = new JLabel("Validade: ");
		perecivelLabel = new JLabel("           Perecível: ");
		avisoLabel = new JLabel("Todos os campos são obrigatórios");
		avisoLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 9));
		
		nomeField = new JTextField(10);
		codBarrasField = new JTextField(10);
		quantidadeField = new JTextField(10);
		validadeField = new JTextField();
		try {
			validadeField = new JFormattedTextField(new MaskFormatter("##/##/####"));
			validadeField.setColumns(6);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		simRadioButton = new JRadioButton("Sim", true);
		naoRadioButton = new JRadioButton("Não", false);
		
		bg = new ButtonGroup();
		bg.add(simRadioButton);
		bg.add(naoRadioButton);
		
		adicionarButton = new JButton("Adicionar");
		add(nomeLabel);
		add(nomeField);		
		
		add(codBarrasLabel);
		add(codBarrasField);
		
		add(quantidadeLabel);
		add(quantidadeField);
		
		add(validadeLabel);
		add(validadeField);
		
		add(perecivelLabel);
		add(simRadioButton);
		add(naoRadioButton);
		add(avisoLabel);
		add(adicionarButton);
		adicionarButton.setEnabled(false);
		
		setVisible(true);
	}
	
	
	public JTextField getNomeField() {
		return nomeField;
	}


	public JTextField getCodBarrasField() {
		return codBarrasField;
	}


	public JTextField getQuantidadeField() {
		return quantidadeField;
	}


	public JTextField getValidadeField() {
		return validadeField;
	}


	public JRadioButton getSimRadioButton() {
		return simRadioButton;
	}


	public JRadioButton getNaoRadioButton() {
		return naoRadioButton;
	}


	public JButton getAdicionarButton() {
		return adicionarButton;
	}
}
