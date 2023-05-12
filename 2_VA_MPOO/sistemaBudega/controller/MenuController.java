package sistema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import sistema.model.Promocao;
import sistema.view.CadastroView;
import sistema.view.EstoqueView;
import sistema.view.MenuView;
import sistema.view.PrecoView;
import sistema.view.PromocaoView;

public class MenuController {
	MenuView menuView;
	ButtonHandler buttonHandler;
	KeyHandler keyHandler;
	
	public MenuController(MenuView menuView) {
		this.menuView = menuView;
		buttonHandler = new ButtonHandler();
		keyHandler = new KeyHandler();
		control();
	}
	
	private void control() {
		menuView.getCadastrarProdutoButton().addActionListener(buttonHandler); 
		menuView.getDefinirEstoqueButton().addActionListener(buttonHandler);
		menuView.getDefinirPrecoButton().addActionListener(buttonHandler);
		menuView.getDefinirPromocaoButton().addActionListener(buttonHandler); 
		menuView.getRodarPromocaoButton().addActionListener(buttonHandler);
		menuView.getSairButton().addActionListener(buttonHandler);
		
		menuView.getCadastrarProdutoButton().addKeyListener(keyHandler);
		menuView.getDefinirEstoqueButton().addKeyListener(keyHandler);
		menuView.getDefinirPrecoButton().addKeyListener(keyHandler);
		menuView.getDefinirPromocaoButton().addKeyListener(keyHandler);
		menuView.getRodarPromocaoButton().addKeyListener(keyHandler);
		menuView.getSairButton().addKeyListener(keyHandler);
//		menuView.addKeyListener(keyHandler); //sempre tem um botão ativo que tira o focus do JFrame
	}
	
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==menuView.getCadastrarProdutoButton()) {
				new CadastroController(new CadastroView());
			
			}if(e.getSource()==menuView.getDefinirEstoqueButton()) {
				new EstoqueController(new EstoqueView());
			
			}if(e.getSource()==menuView.getDefinirPrecoButton()) {
				new PrecoController(new PrecoView());
			
			}if(e.getSource()==menuView.getDefinirPromocaoButton()) {
				new PromocaoController(new PromocaoView());
			
			}if(e.getSource()==menuView.getRodarPromocaoButton()) {
				new Promocao().start();
			
			}if(e.getSource()==menuView.getSairButton()) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja encerrar a aplicação?", "", JOptionPane.YES_NO_OPTION);
				if(resposta==0)
					System.exit(0);
			}	
		}
	}
	private class KeyHandler extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
				int op = JOptionPane.showConfirmDialog(null, "Deseja encerrar a aplicação?", "Sair", JOptionPane.YES_NO_OPTION);
				if(op==0) {
					System.exit(0);
				}
			}
		}		 
	}
}