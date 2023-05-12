package sistema.model;

//import sistema.view.MensagemView;

public class ProdutoNaoExisteException extends Exception{
	
	public ProdutoNaoExisteException() {
		super("Produto não localizado");
//		new MensagemView("Produto não localizado");
	}
}
