package sistema.model;

import java.util.ArrayList;
import java.util.Date;

public class BaseDados implements PrecoInterface{
	private static ArrayList<Produto> produtos;
	
	public static void createBase() {
		produtos = new ArrayList<Produto>();
		inicializarBase();
	}
	
	private static void inicializarBase() {	
		produtos.add(new Produto("Pinga Sertão",			
								 "prod001",				
								 800,					
								 new Date(2025, 10, 26), // new Date(26/10/2025)
								 false,
								 1000.00,
								 false));
		
		produtos.add(new Produto("Feijão",				
								 "prod002",				
								 1,						
								 new Date(2023, 5, 4),	// new Date(04/05/2023)
								 false,					
								 5.00,					
								 false));
		
		produtos.add(new Produto("Picanha",				
								 "prod003",				
								 1,						
								 new Date(2022, 12, 8),	// new Date(08/12/2022)
								 true,					
								 6.00,					
								 false));
	}
	
	public static Produto buscarProduto(String codBarras) throws ProdutoNullException{ 
		if(codBarras==null)
			throw new ProdutoNullException();
		
		for(Produto produtoCurrent:produtos) {
			if(produtoCurrent.getCodBarras().equalsIgnoreCase(codBarras))
				return produtoCurrent;
		}
		
		return null;
	}
	
	public static boolean isProduto(Produto produto) throws ProdutoNullException{
		return produtos.contains(buscarProduto(produto.getCodBarras()));
	}

	public static ArrayList<Produto> getProdutos() {
		return produtos;
	}
	
	public static boolean adicionarProduto(Produto produto) throws ProdutoNullException, ProdutoExisteException, ProdutoNaoExisteException{
		if(produto==null) {
			throw new ProdutoNullException();
		}

		if(isProduto(produto)) {
			throw new ProdutoExisteException();
		
		}else {
			return produtos.add(produto);	
		}
	}
	
	public static boolean atualizarEstoque(Produto produto, int quantidade) throws ProdutoNullException{
		if(produto==null) {
			throw new ProdutoNullException();
		}
		
		if(buscarProduto(produto.getCodBarras())!=null) {
			produto.getEstoque().setQuantidade(quantidade);
			return true;
		}
		return false;
	}

	@Override
	public boolean definirPreco(double valor, String codBarras){
		Produto produtoTemp;
		
		if(codBarras!=null) {
			try {
				produtoTemp = buscarProduto(codBarras);
				produtoTemp.setPreco(valor);
				return true;
				
			} catch (ProdutoNullException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}