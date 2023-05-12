package sistema.view;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuView extends JFrame{
	JButton cadastrarProdutoButton, definirEstoqueButton, definirPrecoButton, //pode colocar public se não tiver restrição
			definirPromocaoButton, rodarPromocaoButton, sairButton;
	JLabel imagemLabel;
	
	public MenuView() {
		setSize(800, 125);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //apenas essa tela implementa esse comando
//		setResizable(false);	//não faz sentido pq a tela já está sem borda
		setLayout(new FlowLayout());
		
		ImageIcon imageIcon = new ImageIcon("img/logoBudega.png");
		imagemLabel = new JLabel(imageIcon);
		
		cadastrarProdutoButton = new JButton("Cadastrar Produto");
		definirEstoqueButton = new JButton("Definir Estoque");
		definirPrecoButton = new JButton("Definir Preço");
		definirPromocaoButton = new JButton("Definir Promoção");
		rodarPromocaoButton = new JButton("Rodar Promoção");
		sairButton = new JButton("Sair");
		
		add(imagemLabel);
		//add(new JLabel(new ImageIcon("img/logoBudega.png")));
		add(cadastrarProdutoButton);
		add(definirEstoqueButton);
		add(definirPrecoButton);
		add(definirPromocaoButton);
		add(rodarPromocaoButton);
		add(sairButton);

		setVisible(true);
	}

	public JButton getCadastrarProdutoButton() {
		return cadastrarProdutoButton;
	}

	public JButton getDefinirEstoqueButton() {
		return definirEstoqueButton;
	}

	public JButton getDefinirPrecoButton() {
		return definirPrecoButton;
	}

	public JButton getDefinirPromocaoButton() {
		return definirPromocaoButton;
	}

	public JButton getRodarPromocaoButton() {
		return rodarPromocaoButton;
	}

	public JButton getSairButton() {
		return sairButton;
	}
}