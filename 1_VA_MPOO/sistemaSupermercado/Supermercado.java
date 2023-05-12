package sistemaSupermercado;

import java.util.ArrayList;

public class Supermercado {
	
	public String nome;
	private Funcionario gerente;
	private ArrayList<Compra> compras;
	
	public Supermercado(String nome, Funcionario gerente, ArrayList<Compra> compras) {

		this.nome = nome;
		this.gerente = gerente;
		this.compras = compras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Funcionario getGerente() {
		return gerente;
	}

	public void setGerente(Funcionario gerente) {
		this.gerente = gerente;
	}

	public ArrayList<Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		return "Supermercado [nome=" + nome + ", gerente=" + gerente + ", compras=" + compras + "]";
	}
}
