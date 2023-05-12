package sistema.model;

import sistema.view.MensagemErroView;
import sistema.view.MensagemView;

public class Promocao extends Thread{
	
	@Override
	public void run() {			
		while(true) {
			try {
				sleep(5000);
				executarPromo();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void executarPromo() {
		for(Produto produtoCurrent : BaseDados.getProdutos()) {
			if(produtoCurrent instanceof Produto) {
				if(produtoCurrent.isPromocao()==true) {
					produtoCurrent.setPreco(produtoCurrent.getPreco()-(produtoCurrent.getPreco()*PrecoInterface.DESCONTO));
					produtoCurrent.setPromocao(false);
					new MensagemView("Promoção aplicada!");
				}
				else {
					new MensagemErroView("Nenhum produto é apto para receber promoção!");
				}
			}
		}
	}
}