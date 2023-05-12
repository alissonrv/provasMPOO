package sistema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sistema.model.BaseDados;
import sistema.model.Produto;
import sistema.model.ProdutoNaoExisteException;
import sistema.model.ProdutoNullException;
import sistema.view.MensagemErroView;
import sistema.view.MensagemView;
import sistema.view.PrecoView;

public class PrecoController implements ActionListener{
	PrecoView precoView;

	public PrecoController(PrecoView precoView) {
		this.precoView = precoView;
		control();
	}
	
	private void control() {
		precoView.getBuscarButton().addActionListener(this);
		precoView.getEditarButton().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Produto produtoTemp;
		if(e.getSource()==precoView.getBuscarButton()) {
			if(precoView.getCodBarrasField().getText().equalsIgnoreCase("")) {
				new MensagemErroView("Preencha o código de barras!");	
			
			}else {
				try {
					produtoTemp = BaseDados.buscarProduto(precoView.getCodBarrasField().getText());
					
					if(produtoTemp!=null) {
						precoView.getBuscarButton().setVisible(false);
						precoView.getPrecoLabel().setVisible(true);
						precoView.getPrecoField().setVisible(true);
						precoView.getEditarButton().setVisible(true);
					
					}else {
						throw new ProdutoNaoExisteException();
					}
					
				} catch (ProdutoNullException | ProdutoNaoExisteException e1) {
					new MensagemErroView(e1.getMessage());
					e1.printStackTrace();
				}
			}
		}
		
		if(e.getSource()==precoView.getEditarButton()) {
			try {
				produtoTemp = BaseDados.buscarProduto(precoView.getCodBarrasField().getText());
				
				if(produtoTemp!=null) {
					double preco = Double.parseDouble(precoView.getPrecoField().getText());
					new BaseDados().definirPreco(preco, precoView.getCodBarrasField().getText());
					new MensagemView("Preco atualizado!");
				
				}
			
			} catch (ProdutoNullException e1) {
				new MensagemErroView(e1.getMessage());
				e1.printStackTrace();
			}
		}
	}
}
