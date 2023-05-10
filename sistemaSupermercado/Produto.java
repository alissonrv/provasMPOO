package sistemaSupermercado;

import java.util.Date;

public class Produto {
	
	public String codBarras;
	private String nome;
	protected double preco;
	private Date validade;
	private boolean perecivel;
	
	public Produto(String codBarras, String nome, double preco, Date validade, boolean perecivel) {
		
		this.codBarras = codBarras;
		this.nome = nome;
		this.preco = preco;
		this.validade = validade;
		this.perecivel = perecivel;
	}
	
	public String getCodBarras() {
		return codBarras;
	}
	
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
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

	@Override
	public String toString() {
		return "Produto [codBarras=" + codBarras + ", nome=" + nome + ", preco=" + preco +
				", validade=" + validade + ", perecivel=" + perecivel + "]";
	}
}
