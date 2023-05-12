package sistema.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class BaseDados implements AVencerInterface{
	private static ArrayList<Produto> produtos;
	
	public static void createBase() {
		produtos = new ArrayList<Produto>();
		inicializarBase();
	}
	
	private static void inicializarBase() {
		Produto produto1 = new Produto("Pinga Sertão",
									   "prod001",
									   1000.00, 800,
									   new Date("2025/10/25"),
									   new Fornecedor("Zé Santos",
											   		  "111.111.111-11",
											   		  "01.000.000/0001-11",
											   		  "Sertão Bebidas"));
		new Estoque(produto1, 100);
		
		Produto produto2 = new Produto("Feijão",
									   "prod002",
									   5.00, 1,
									   new Date(2022,10,15),
									   new Fornecedor("Zé Santos",
											   		  "111.111.111-11",
											   		  "01.000.000/0001-11",
											   		  "Sertão Bebidas"));
		produto2.setEstoque(new Estoque(produto2, 100));
		
		Produto produto3 = new Produto("Picanha",
									   "prod003",
									   60.00, 1,
									   new Date(2022,12,10),
									   new Fornecedor("Zé Santos",
											   		  "111.111.111-11",
											   		  "01.000.000/0001-11",
											   		  "Sertão Bebidas"));
		new Estoque(produto3, 50);
		
		Produto produto4 = new Produto("Danone",
									   "prod004",
									   12.00, 1,
									   new Date(2022,9,01),
									   new Fornecedor("Zé Santos",
											   		  "111.111.111-11",
											   		  "01.000.000/0001-11",
											   		  "Sertão Bebidas"));
		new Estoque(produto4, 10);
		
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);
	}
	
	public static Produto buscarProduto(String codBarras) throws ProdutoNaoExisteException {
		for(Produto produtoCurrent:produtos) {
			if(produtoCurrent.getCodBarras().equalsIgnoreCase(codBarras)) {
				return produtoCurrent;
			}
		}
		throw new ProdutoNaoExisteException();
	}
	
	public static ArrayList<Produto> buscarProdutosAVencer(int diasAVencer){
		ArrayList<Produto> produtosAVencer = new ArrayList<Produto>();
		for(Produto produtoCurrent:produtos) {
			if(diasAVencer(produtoCurrent)-produtoCurrent.getValidade().getDate()<=diasAVencer) {
				produtosAVencer.add(produtoCurrent);
				return produtosAVencer;
			}
		}
		return null;
	}
	
	public static ArrayList<Produto> buscarProdutosVencidos(){
		ArrayList<Produto> produtosVencidos = new ArrayList<Produto>();
		for(Produto produtoCurrent:produtos) {
			if(produtoCurrent.getValidade().getDate()>=diasAVencer(produtoCurrent)) {
				produtoCurrent.isVencido();
				produtosVencidos.add(produtoCurrent);
				return produtosVencidos;
			}
		}
		return null;
	}

	public static ArrayList<Produto> getProdutos() {
		return produtos;
	}
	
	public static long diasAVencer(Produto produto) {
		LocalDateTime atual = LocalDateTime.now();
		LocalDateTime produtoDate = LocalDateTime.of(produto.getValidade().getYear(),
													 produto.getValidade().getMonth(),
													 produto.getValidade().getDate(), 0,0);
		
		long diasaVencer = ChronoUnit.DAYS.between(atual.toLocalDate(), produtoDate.toLocalDate());
		return diasaVencer;
	}
}