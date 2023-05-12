 package sistema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sistema.model.BaseDados;
import sistema.model.Produto;
import sistema.model.ProdutoNaoExisteException;
import sistema.model.ProdutoNullException;
import sistema.view.EstoqueView;
import sistema.view.MensagemErroView;
import sistema.view.MensagemView;

public class EstoqueController implements ActionListener {
	EstoqueView estoqueView;

	public EstoqueController(EstoqueView estoqueView) {
		this.estoqueView = estoqueView;
		control();
	}
	
	private void control() {
		estoqueView.getBuscarButton().addActionListener(this);
		estoqueView.getEditarButton().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Produto produtoTemp;
		String codBarras;
		int quantidade;
		
		if(e.getSource()==estoqueView.getBuscarButton()){
			codBarras = estoqueView.getCodBarrasField().getText();
			
			if(codBarras.equalsIgnoreCase("")) {
				new MensagemErroView("Preencha o código de barras!");
			}else {
				try {
					produtoTemp = BaseDados.buscarProduto(codBarras);
					
					if(produtoTemp!=null) {
						estoqueView.getBuscarButton().setVisible(false);
						estoqueView.getQuantidadeLabel().setVisible(true);
						estoqueView.getQuantidadeField().setVisible(true);
						estoqueView.getEditarButton().setVisible(true);
					}else {
						throw new ProdutoNaoExisteException();
					}
				} catch (ProdutoNullException | ProdutoNaoExisteException e1) {
					new MensagemErroView(e1.getMessage());
					e1.printStackTrace();
				}
			}
		}
		
		if(e.getSource()==estoqueView.getEditarButton()){
			if(estoqueView.getQuantidadeField().getText().equalsIgnoreCase("")) {
				new MensagemErroView("Digite a quantidade!");
			}else {
				try {
					codBarras = estoqueView.getCodBarrasField().getText();
					produtoTemp = BaseDados.buscarProduto(codBarras);
					quantidade = Integer.parseInt(estoqueView.getQuantidadeField().getText());
					BaseDados.atualizarEstoque(produtoTemp, quantidade);
					new MensagemView("Estoque atualizado!");
				
				} catch (ProdutoNullException e1) {
					new MensagemErroView(e1.getMessage());
					e1.printStackTrace();
				}
			}
		}
	}
}