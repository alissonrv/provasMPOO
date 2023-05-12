package sistema.model;

public class ProdutoNaoExisteException extends Exception{
	public ProdutoNaoExisteException() {
		super("Produto não localizado");
	}
}
