package sistemaSupermercado;

import java.util.ArrayList;

public class Compra {
	
	public static int id;
	private double valor;
	private static ArrayList<Produto> produtos;
	
	
	public Compra(double valor, ArrayList<Produto> produtos) {
		id++;
		this.valor = valor;
	}

	public static int getId() {
		return id;
	}
	
	public static void setId(int id) {
		Compra.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
//	public boolean setProdutos(ArrayList<Produto> produtos, Produto produto) {
//		return produtos.add(produto);
//	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", valor=" + valor + ", produtos=" + produtos + "]";
	}
}
