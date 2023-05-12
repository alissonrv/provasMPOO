package sistema.model;

public class Estoque {
	private int quantidade;

	public Estoque(int quantidade, Produto produto) {
		produto.getEstoque().quantidade = quantidade; //atualização da parte do todo
	}
	
	public Estoque(Produto produto) {} //viabilizar o todo
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}