package models.entities;

import models.exceptions.SaqueException;

public class ContaBancaria {
	private Integer numeroConta;
	private String titularConta;
	private Double saldo;
	private Double limiteDeSaque;

	public ContaBancaria() {

	}

	public ContaBancaria(Integer numeroConta, String titularConta, Double saldo, Double limiteDeSaque) {
		this.numeroConta = numeroConta;
		this.titularConta = titularConta;
		this.saldo = saldo;
		this.limiteDeSaque = limiteDeSaque;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTitularConta() {
		return titularConta;
	}

	public void setTitularConta(String titularConta) {
		this.titularConta = titularConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteDeSaque() {
		return limiteDeSaque;
	}

	public void deposito(Double valor) {

	}

	public void deposita(Double valor) {
		saldo += valor;
	}

	public void saque(Double valor) throws SaqueException {
		if (valor > getSaldo()) {
			throw new SaqueException("Saldo insuficiente.");
		} else if (valor > getLimiteDeSaque()) {
			throw new SaqueException("Limite de saque excedido.");
		} else {
			saldo -= valor;
			toString();
		}
	}

	@Override
	public String toString() {
		return "\nNúmero da conta: " + getNumeroConta() + "\nTitular: " + getTitularConta() + "\nSaldo: "
				+ String.format("$%.2f", getSaldo()) + "\nLimite de saque: "
				+ String.format("$%.2f", getLimiteDeSaque());
	}
}
