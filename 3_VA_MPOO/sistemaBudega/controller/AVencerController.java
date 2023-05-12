package sistema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import sistema.model.BaseDados;
import sistema.model.Produto;
import sistema.model.ProdutoNaoExisteException;
import sistema.view.AVencerView;
import sistema.view.MensagemErroView;
import sistema.view.MensagemView;

public class AVencerController implements ActionListener{
	AVencerView aVencerView;

	public AVencerController(AVencerView aVencerView) {
		this.aVencerView = aVencerView;
		aVencerView.buscarButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(aVencerView.prazoTextField.getText().equalsIgnoreCase(""))
			new MensagemErroView("Preencha o prazo em dias!");
		
		if(e.getSource()==aVencerView.buscarButton) { 
			try {
				int diasAVencer = Integer.parseInt(aVencerView.prazoTextField.getText());
				
				for(Produto produtoTemp:BaseDados.buscarProdutosAVencer(diasAVencer)) {
					new MensagemView(produtoTemp.toString());
				}
				
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				new MensagemErroView(e1.getMessage());
			}
		}
	}
}