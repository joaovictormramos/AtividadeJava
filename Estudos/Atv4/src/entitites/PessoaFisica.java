package entitites;

public class PessoaFisica extends Pessoa {
	
	private Double gastoComSaude;
	
	public PessoaFisica() {
	}

	public PessoaFisica(String nome, Double renda, Double gastoComSaude) {
		super(nome, renda);
		this.gastoComSaude = gastoComSaude;
	}

	public Double getGastoComSaude() {
		return gastoComSaude;
	}

	public void setGastoComSaude(Double gastoComSaude) {
		this.gastoComSaude = gastoComSaude;
	}

	@Override
	public double declaraImposto() {
		if(getRenda() > 20000.00 && getGastoComSaude() > 0) {
			double impostoPago = getRenda() * 0.25 - getGastoComSaude() * 0.50;
			return impostoPago;
		}
		else if(getRenda() > 20000) {
			double impostoPago = (getRenda() * 0.25);
			return impostoPago;
		}
		else {
			double impostoPago = getRenda() * 0.15;
			return impostoPago;
		}
	}
}