package sistemaSupermercado;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class BaseDados {
	
	private static ArrayList<Produto> produtos;
	
	public static void createBase() {
		if(produtos!=null)
			produtos = new ArrayList<Produto>();
	}
	
	public static void inicializarBase() {
		createBase();
		addProduto(new Produto("PROD001",
							"Feijão da Serra",
							9.00,
							new Date(2022, 10, 12),
							false));
		
		addProduto(new Produto("PROD003",
							"Laranja formosa",
							0.50,
							new Date(2022, 8, 30),
							false));
	}	
	
//	private static Produto buscarProduto(Produto produto) {
//		for(Produto produtoCurrent:produtos) {
//			if(produtoCurrent.getCodBarras().equalsIgnoreCase(produto.getCodBarras())) {
//				return produtoCurrent;
//			}
//		}
//		return null;
//	}
	private static Produto buscarProduto(String codBarras) {
		for(Produto produtoCurrent:produtos) {
			if(produtoCurrent.getCodBarras().equalsIgnoreCase(codBarras)) {
				return produtoCurrent;
			}
		}
		return null;
	}
	
	public static boolean isProduto(Produto produto) {
		return produtos.contains(buscarProduto(produto.codBarras));
	}
	
	public static boolean addProduto(Produto produto) {
		if(produto!=null && !isProduto(produto)) {
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
			return produtos.add(produto);
		}
		
		JOptionPane.showMessageDialog(null, "Produto já cadastrado!");
		return false;
	}
	
	public static boolean removerProduto(Produto produto) {
		return produtos.remove(buscarProduto(produto.codBarras));
	}
	
	public static ArrayList<String> exibirProduto(){
		ArrayList<String> listaProdutos = new ArrayList<String>();
		
		for(Produto produtoCurrent:produtos) {
			listaProdutos.add(produtoCurrent.toString());
			return listaProdutos;
		}
		return null;
	}
}
