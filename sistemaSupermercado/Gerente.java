package sistemaSupermercado;

public class Gerente extends Funcionario{
	
	private static final double SALARIO = 3200.5;
	
	public Gerente(String nome, String cpf) {
		super(nome, cpf, SALARIO);
	}
	
	@Override
	public void calcularSalario() {
		setSalario(SALARIO);
	}
	public double darDesconto(double valor, double desconto) {
		return valor-(valor*desconto/100);
	}
	
	@Override
	public String toString() {
		return "Gerente [toString()=" + super.toString() + "]";
	}
}
