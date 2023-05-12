package sistema.model;

public class Estoque {
	private int quantidade;
	
	public Estoque(Produto produto, int quantidade) {
		produto.getEstoque().setQuantidade(quantidade);
	}
	
	public Estoque(Produto produto) {}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
