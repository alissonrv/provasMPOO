package sistema.view;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EstoqueView extends JFrame{
	public JLabel imgLabel;
	public JButton verProdutosButton, definirPromocaoButton, sairButton;
	
	public EstoqueView() {
		setSize(450, 110);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		
		imgLabel = new JLabel(new ImageIcon("img/logoBudega.png"));
		
		verProdutosButton = new JButton("Ver Produtos");
		definirPromocaoButton = new JButton("Definir Promoção");
		sairButton = new JButton("Sair");
		
		add(imgLabel);
		add(verProdutosButton);
		add(definirPromocaoButton);
		add(sairButton);
		
		setVisible(true);
	}
}