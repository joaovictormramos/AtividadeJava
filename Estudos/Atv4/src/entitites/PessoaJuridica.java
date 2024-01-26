package entitites;

public class PessoaJuridica extends Pessoa {
	
	private Integer funcionarios;

	public PessoaJuridica() {
	}

	public PessoaJuridica(String nome, Double renda, Integer funcionarios) {
		super(nome, renda);
		this.funcionarios = funcionarios;
	}

	public Integer getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Integer funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	@Override
	public double declaraImposto() {
		if(getFuncionarios() > 10) {
			double impostoPago = (getRenda() * 0.14);
			return impostoPago;
		}
		else {
			double impostoPago = (getRenda() * 0.14);
			return impostoPago;
		}
	}
}
