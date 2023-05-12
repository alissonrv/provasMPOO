package sistema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import sistema.model.BaseDados;
import sistema.model.Produto;
import sistema.model.ProdutoNaoExisteException;
import sistema.view.DescontoView;
import sistema.view.MensagemErroView;
import sistema.view.MensagemView;

public class DescontoController implements ActionListener{
	DescontoView descontoView;
	FieldHander fieldHander;
	
	public DescontoController(DescontoView descontoView) {
		this.descontoView = descontoView;
		fieldHander = new FieldHander();
		control();
	}
	
	private void control() {
		descontoView.aplicarButton.addActionListener(this);
		descontoView.codBarrasRadioButton.addActionListener(this);
		descontoView.validadeRadioButton.addActionListener(this);
		
		descontoView.codBarrasTextField.addCaretListener(fieldHander);
		descontoView.descontoTextField.addCaretListener(fieldHander);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		double desconto;
		Produto produtoTemp;
		
		if(e.getSource()==descontoView.aplicarButton) {
			
			if(descontoView.descontoTextField.getText().replaceAll("[^0-9]", "").equalsIgnoreCase("")) {
				new MensagemErroView("Preencha o campo desconto com valor válido!");
			
			}else if(descontoView.codBarrasTextField.getText().equalsIgnoreCase("")) {
				new MensagemErroView("Preencha o campo desconto com valor válido!");
			
			}else {
				try {
					desconto = Double.parseDouble(descontoView.descontoTextField.getText());
					if(desconto<=0) {
						new MensagemView("Preencha um valor maior que zero");
					}
					
					produtoTemp = BaseDados.buscarProduto(descontoView.codBarrasTextField.getText());
					
					if(produtoTemp.aplicarDesconto(desconto)==true) {
						produtoTemp.aplicarDesconto(desconto);
						new MensagemView("Desconto aplicado com sucesso!");	
					}
					
				} catch (ProdutoNaoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					new MensagemView(e1.getMessage());
				}
			}
		}
		if(descontoView.codBarrasRadioButton.isSelected()) {
			descontoView.codBarrasLabel.setVisible(true);
			descontoView.codBarrasTextField.setVisible(true);
			descontoView.prazoLabel.setVisible(false);
			descontoView.prazoBox.setVisible(false);
		}
		
		if(descontoView.validadeRadioButton.isSelected()) {
			descontoView.codBarrasLabel.setVisible(false);
			descontoView.codBarrasTextField.setVisible(false);
			descontoView.prazoLabel.setVisible(true);
			descontoView.prazoBox.setVisible(true);
		}
	}
	
	private class FieldHander implements CaretListener{
		@Override
		public void caretUpdate(CaretEvent e) {
			if(descontoView.codBarrasTextField.getText().equalsIgnoreCase("")
			 | descontoView.descontoTextField.getText().equalsIgnoreCase("")) {
				descontoView.aplicarButton.setEnabled(false);
			
			}else {
				descontoView.aplicarButton.setEnabled(true);
			}	
		}
	}
}