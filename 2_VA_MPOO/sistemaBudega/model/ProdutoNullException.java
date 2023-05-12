package sistema.model;

//import sistema.view.MensagemView;

public class ProdutoNullException extends Exception{
	
	public ProdutoNullException() {
		super("Produto é null!");
//		new MensagemView("Produto é null!");
	}
}
