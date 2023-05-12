package sistema.model;

public interface PrecoInterface {
	public static final double DESCONTO = 0.1;
	
	public abstract boolean definirPreco(double valor, String codBarras);
}
