package sistema.model;

import java.util.ArrayList;

import sistema.view.MensagemErroView;
import sistema.view.MensagemView;

public class Robot extends Thread{
	public static boolean isProdutoAVencer;
	public static boolean isProdutoVencido;
	public static final long VERIFICACAO_DIAS = 86400000;
	public static final int PRAZO_DIAS = 2;
	
	@Override
	public void run() {
		try {
			sleep(VERIFICACAO_DIAS);
			executarVerificarAVencer();
			executarVerificarVencido();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void executarVerificarAVencer() {
		ArrayList<Produto> produtosAVencer = BaseDados.buscarProdutosAVencer(30);
		for(Produto produtoTemp:produtosAVencer) {
			isProdutoVencido = produtoTemp.isVencido();
			if(BaseDados.diasAVencer(produtoTemp)>0)
				new MensagemView("Existe(m) produto(s) a vencer em 2 dias");
		}
	}
	
	public static void executarVerificarVencido() {
		for(Produto produtoTemp:BaseDados.buscarProdutosVencidos()) {
			if(produtoTemp.isVencido()==true)
				new MensagemView("Existe(m) produto(s) vencido(s)!");
		}
	}
}