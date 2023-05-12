package sistema.model;

//import sistema.view.MensagemView;

public class ProdutoExisteException extends Exception{

	public ProdutoExisteException() {
		super("Erro: Instance of product is duplicated!");
//		new MensagemView("Erro: Instance of product is duplicated!");
	}
}
