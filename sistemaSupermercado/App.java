package sistemaSupermercado;

import java.util.ArrayList;
import java.util.Date;

public class App {
	public static void main(String[] args) {
		
		Supermercado supermercado = new Supermercado("MPOO Supermarket",
													new Gerente("José Santos",
																	"111.111.111-11"),
													new ArrayList<Compra>());
		
		BaseDados.inicializarBase();
		
		BaseDados.addProduto(new Produto("PROD002",
										"Biscoito treloso",
										1.50,
										new Date(2023, 2, 1),
										false));
		
		ArrayList<Produto> compras = new ArrayList<Produto>();
		
		compras.add(new Produto("PROD001",
								"Feijão da Serra",
								9.00,
								new Date(2022, 10, 12),
								false));
		
		Compra compra1 = new Compra(9.00, compras);		
	}
}
