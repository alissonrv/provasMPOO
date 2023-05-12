package sistema.model;

public class Fornecedor extends Pessoa{
	private String cnpj;
	private String nomeFantasia;
	
	public Fornecedor(String nome, String cpf, String cnpj, String nomeFantasia) {
		super(nome, cpf);
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Override
	public boolean validarCPF(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}
}
