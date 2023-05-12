package sistema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import sistema.model.BaseDados;
import sistema.model.Produto;
import sistema.model.ProdutoExisteException;
import sistema.model.ProdutoNaoExisteException;
import sistema.model.ProdutoNullException;
import sistema.view.CadastroView;
import sistema.view.MensagemErroView;
import sistema.view.MensagemView;

public class CadastroController implements ActionListener{
	CadastroView cadastroView;
	FieldHandler fieldHandler;
	
	public CadastroController(CadastroView cadastroView) {
		this.cadastroView = cadastroView;
		fieldHandler = new FieldHandler();
		control();	
	}
	
	private void control() {
		cadastroView.getNomeField().addCaretListener(fieldHandler);
		cadastroView.getCodBarrasField().addCaretListener(fieldHandler);
		cadastroView.getQuantidadeField().addCaretListener(fieldHandler);
		cadastroView.getValidadeField().addCaretListener(fieldHandler);
		
		
		cadastroView.getAdicionarButton().addActionListener(this);
		cadastroView.getSimRadioButton().addActionListener(this);
		cadastroView.getNaoRadioButton().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cadastroView.getAdicionarButton()) {
			if(cadastroView.getNomeField().getText().equalsIgnoreCase("")
					|| cadastroView.getCodBarrasField().getText().equalsIgnoreCase("")
					|| cadastroView.getQuantidadeField().getText().equalsIgnoreCase("")
					|| cadastroView.getValidadeField().getText().replace("/", "").trim().equalsIgnoreCase("")) {
				
				new MensagemErroView("Preencha os campos");					
			
			}else if(cadastroView.getNomeField().getText().replaceAll("[^A-Z | ^a-z]", "").equalsIgnoreCase("")
					|| cadastroView.getCodBarrasField().getText().equalsIgnoreCase("")
					|| cadastroView.getQuantidadeField().getText().equalsIgnoreCase("")
					|| cadastroView.getValidadeField().getText().equalsIgnoreCase("")) {
				
				new MensagemErroView("Digite apenas letras no campo <Nome>!");
			
			}else if(cadastroView.getSimRadioButton().isSelected()) {
				try {
					int quantidade = Integer.parseInt(cadastroView.getQuantidadeField().getText());
					String nome = cadastroView.getNomeField().getText();
					String codBarras = cadastroView.getCodBarrasField().getText();
					
					String data = cadastroView.getValidadeField().getText().replace("/", "");
					SimpleDateFormat format =  new SimpleDateFormat("ddMMyyyy");
					Date validade = format.parse(data);
					
					Produto produtoTemp = new Produto(nome, codBarras, quantidade, validade, true, 0.0, false);
					BaseDados.adicionarProduto(produtoTemp);
					new MensagemView("Produto adicionado com sucesso!");
					
					
				}catch(ParseException | ProdutoNullException | ProdutoExisteException
						| ProdutoNaoExisteException | NumberFormatException e1) {
					e1.printStackTrace();
					new MensagemErroView(e1.getMessage());
				}
			
			}else if(cadastroView.getNaoRadioButton().isSelected()) {
				try {
					int quantidade = Integer.parseInt(cadastroView.getQuantidadeField().getText());
					String nome = cadastroView.getNomeField().getText();
					String codBarras = cadastroView.getCodBarrasField().getText();
					
					String data = cadastroView.getValidadeField().getText().replace("/", "");
					SimpleDateFormat dateFormat =  new SimpleDateFormat("ddMMyyyy");
					Date validade = dateFormat.parse(data);
					
					Produto produtoTemp = new Produto(nome, codBarras, quantidade, validade, false, 0.0, false);
					BaseDados.adicionarProduto(produtoTemp);
					new MensagemView("Produto adicionado com sucesso!");
										
				}catch(ParseException | ProdutoNullException | ProdutoExisteException
						| ProdutoNaoExisteException | NumberFormatException e1) {
					e1.printStackTrace();
					new MensagemErroView(e1.getMessage());
				}
			}
		}
		
		if(e.getSource() == cadastroView.getSimRadioButton()) {
			cadastroView.getNaoRadioButton().setSelected(false);
		}
		if(e.getSource() ==  cadastroView.getNaoRadioButton()) {
			cadastroView.getSimRadioButton().setSelected(false);
		}
	}
	
	private class FieldHandler implements CaretListener{
		@Override
		public void caretUpdate(CaretEvent e) {
			if(cadastroView.getNomeField().getText().equalsIgnoreCase("")
			|cadastroView.getCodBarrasField().getText().equalsIgnoreCase("")
			|cadastroView.getQuantidadeField().getText().equalsIgnoreCase("")
			|cadastroView.getValidadeField().getText().replace("/", "").trim().equalsIgnoreCase("")) {
				
				cadastroView.getAdicionarButton().setEnabled(false);
			
			}else {
				cadastroView.getAdicionarButton().setEnabled(true);		
			}
		}
	}	
}