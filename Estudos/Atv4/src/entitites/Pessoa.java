package entitites;

public abstract class Pessoa {
	
	private String nome;
	private Double renda;
	protected Double impostoPago;
		
	public Pessoa() {
	}

	public Pessoa(String nome, Double renda) {
		this.nome = nome;
		this.renda = renda;
	}
	
	public String getNome() {
		return nome;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double declaraImposto() {
		return impostoPago;
	}
	
	public String impostoPago() {
		return getNome() + ": R$ " + String.format("%.2f\n", declaraImposto());
	}
}
