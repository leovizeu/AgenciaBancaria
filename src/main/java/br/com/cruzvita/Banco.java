package br.com.cruzvita;

import utilitarios.Utils;

public class Banco {

	private static int contadorContas = 1;

	private int numeroConta;
	Cliente cliente;
	private Double saldo = 0.0;

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
		return	"\nNome: " + this.cliente.getNome() +
			    "\nIdade: " + this.cliente.getIdade() +
			    "\nBanco: " + this.cliente.getNomeBanco() +
			    "\nNúmero da Conta: " + this.getNumeroConta() +
			    "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
			    "\n";
	}
	
	public void depositar (Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu depósito foi realizado com Sucesso!");
		}else {
			System.out.println("Não foi possível realizar o depósito!");
		}
	}
	
	public void sacar (Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com Sucesso!");
		}else {
			System.out.println("Não foi possível realizar o saque! ");
		}
	}
	
	public void transferir (Banco contaParaDeposito, Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			contaParaDeposito.saldo = contaParaDeposito.getSaldo();
			System.out.println("Transferência foi realizada com Sucesso!");
		}else {
			System.out.println("Não foi possível realizar a transferência!");
		}
	}
}
