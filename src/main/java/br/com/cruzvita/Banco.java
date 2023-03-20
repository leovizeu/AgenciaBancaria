package br.com.cruzvita;

import utilitarios.Utils;

public class Banco {

	private static int contadorContas = 1;

	private int numeroConta;
	Cliente cliente;
	private Double saldo = 0.0;

	public Banco() {
	}

	public Banco(Cliente cliente) {
		this.numeroConta = contadorContas;
		this.cliente = cliente;
		contadorContas += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String toString() {
		return "\nNome: " + this.cliente.getNome() +
				"\nIdade: " + this.cliente.getIdade() +
				"\nBanco: " + this.cliente.getNomeBanco() +
				"\nNúmero da Conta: " + this.getNumeroConta() +
				"\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
				"\n";
	}

	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Operação realizada com sucesso");
		} else {
			System.out.println("Não foi possível realizara operação!");
		}
	}

	public void sacar(double quantia) {
		if (this.saldo > 0) {
			saldo -= quantia;
		} else {
			System.out.println("Valor insulficiente para operação! ");
		}
	}

	public void transferir(Banco contaParaDeposito, Double valor) {
		if (this.saldo > 0) {
			contaParaDeposito.depositar(valor);
			this.sacar(valor);
		} else {
			System.out.println("Transferência não realizada Saldo insuficiente");
		}
	}
}