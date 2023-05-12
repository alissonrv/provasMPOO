package sistema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import sistema.view.AVencerView;
import sistema.view.DescontoView;
import sistema.view.EstoqueView;

public class EstoqueController {
	EstoqueView estoqueView;
	ButtonHandler buttonHandler;
	KeyHandler keyHandler;
	
	public EstoqueController(EstoqueView estoqueView) {
		this.estoqueView = estoqueView;
		buttonHandler = new ButtonHandler();
		keyHandler = new KeyHandler();
		control();
	}
	
	private void control() {
		estoqueView.verProdutosButton.addActionListener(buttonHandler);
		estoqueView.definirPromocaoButton.addActionListener(buttonHandler);
		estoqueView.sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==estoqueView.sairButton) {
					if(JOptionPane.showInternalConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION)==0)
						System.exit(0);
				}
			}
		});
		
		estoqueView.verProdutosButton.addKeyListener(keyHandler);
		estoqueView.definirPromocaoButton.addKeyListener(keyHandler);
		estoqueView.sairButton.addKeyListener(keyHandler);
	}
	
	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==estoqueView.verProdutosButton) {
				new AVencerController(new AVencerView());
			}
			if(e.getSource()==estoqueView.definirPromocaoButton) {
				new DescontoController(new DescontoView());
			}
		}
	}
	
	private class KeyHandler extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
				if(JOptionPane.showInternalConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION)==0)
					System.exit(0);
		}
	}
}