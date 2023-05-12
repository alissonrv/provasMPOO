package sistema.model;

import java.util.Date;

public class Produto {
	private String nome;
	private String codBarras;
	private int quantidade;
	private Date validade;
	private boolean perecivel;
	private double preco;
	private boolean isPromocao;
	private Estoque estoque;
	
	public Produto(String nome, String codBarras, int quantidade, Date validade,
					boolean perecivel, double preco, boolean isPromocao) {
		this.nome = nome;
		this.codBarras = codBarras;
		this.quantidade = quantidade;
		this.validade = validade;
		this.perecivel = perecivel;
		this.preco = preco;
		this.isPromocao = isPromocao;
		this.estoque = new Estoque(this);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public boolean isPerecivel() {
		return perecivel;
	}

	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isPromocao() {
		return isPromocao;
	}

	public void setPromocao(boolean isPromocao) {
		this.isPromocao = isPromocao;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
}
