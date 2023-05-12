package sistema.model;

import java.util.Calendar;
import java.util.Date;

public class Produto implements VencidoInterface{
	public int id;
	private static int ultimo;
	private String nome;
	private String codBarras;
	private double preco;
	private int quantidade;
	private Date validade;
	private Estoque estoque;
	private Fornecedor fornecedor;
	
	public Produto(String nome, String codBarras, double preco, int quantidade, Date validade, Fornecedor fornecedor) {
		ultimo++;
		this.id = ultimo;
		this.nome = nome;
		this.codBarras = codBarras;
		this.preco = preco;
		this.quantidade = quantidade;
		this.validade = validade;
		this.fornecedor = fornecedor;
		this.estoque = new Estoque(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getUltimo() {
		return ultimo;
	}

	public static void setUltimo(int ultimo) {
		Produto.ultimo = ultimo;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
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

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public boolean aplicarDesconto(double desconto) {
		if(desconto>0) {
			setPreco(getPreco()-(getPreco()*desconto));
			return true;
		
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "ID:" + id + ", Nome:" + nome + ", CodigoBarras:" + codBarras
				+ ", Preco:" + preco + ", Quantidade:"+ quantidade +
				", Validade:" + validade.getDate() + "/" +
								validade.getMonth() + "/" +
								validade.getYear()
				+", Fornecedor:" + fornecedor.getNomeFantasia()
				+", Estoque:" + estoque.getQuantidade() + "]";
	}

	@Override
	public boolean isVencido() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, this.validade.getDate());
		c.set(Calendar.MONTH, this.validade.getMonth());
		c.set(Calendar.YEAR, this.validade.getYear());
		
		Date validadeProduto = c.getTime();
		if(validadeProduto.before(new Date()))
			return true;
		
		return false;
	}
}