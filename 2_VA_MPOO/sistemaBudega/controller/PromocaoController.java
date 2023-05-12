package sistema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sistema.model.BaseDados;
import sistema.model.Produto;
import sistema.model.ProdutoNaoExisteException;
import sistema.model.ProdutoNullException;
import sistema.view.MensagemErroView;
import sistema.view.MensagemView;
import sistema.view.PromocaoView;

public class PromocaoController implements ActionListener{
	PromocaoView promocaoView;
	
	public PromocaoController(PromocaoView promocaoView) {
		this.promocaoView = promocaoView;
		promocaoView.getBuscarButton().addActionListener(this);
		promocaoView.getAplicarButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Produto produtoTemp;
		
		if(e.getSource()==promocaoView.getBuscarButton()) {
			if(promocaoView.getCodBarrasField().getText().equalsIgnoreCase("")) {
				new MensagemErroView("Preencha o código de barras!");	
			
			}else {
				try {
					produtoTemp = BaseDados.buscarProduto(promocaoView.getCodBarrasField().getText());
					if(produtoTemp!=null) {
						promocaoView.getBuscarButton().setVisible(false);
						promocaoView.getAplicarButton().setVisible(true);
						promocaoView.getCheckBox().setVisible(true);
					
					}else {
						throw new ProdutoNaoExisteException();
					}
					
				} catch (ProdutoNullException | ProdutoNaoExisteException e1) { 
					new MensagemErroView(e1.getMessage());
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource()==promocaoView.getAplicarButton()) {
			if(promocaoView.getCheckBox().isSelected()) {
				try {
					produtoTemp = BaseDados.buscarProduto(promocaoView.getCodBarrasField().getText());
					if(produtoTemp!=null) {
						produtoTemp.setPromocao(true);
						new MensagemView("Promocao aplicada!");
					
					}else {
						throw new ProdutoNaoExisteException();
					}
				
				} catch (ProdutoNullException | ProdutoNaoExisteException e1) {
					new MensagemErroView(e1.getMessage());
					e1.printStackTrace();
				}
			
			}else {
				new MensagemView("Promoção não aplicada!");
			}
		}		
	}
}
