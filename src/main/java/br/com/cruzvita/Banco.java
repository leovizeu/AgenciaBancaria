package br.com.cruzvita;

import java.util.Scanner;

import utilitarios.Utils;

public class Banco {

	private static int contadorContas = 1;

	private int numeroConta;
	private double saldo = 0.0;
	private double contaDeposito;
	Cliente cliente;
	// Conta conta;

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

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String toString() {
		return "\nNúmero da Conta: " + this.getNumeroConta() +
			   "\nNome: " + this.cliente.getNome() +
			   "\nIdade: " + this.cliente.getIdade() +
			   "\nNomeBanco: " + this.cliente.getnomeBanco() +
			   "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
			   "\n";
	}
	
	public void depositar (double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu depósito foi realizado com Sucesso!");
		}else {
			System.out.println("Não foi possível realizar o depósito!");
		}
	}
	
	public void sacar (double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com Sucesso!");
		}else {
			System.out.println("Não foi possível realizar o saque!");
		}
	}
	
	public void transferir (Conta contaParaDeposito, double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			contaParaDeposito.saldo = contaParaDeposito.getSaldo();
		}else {
			System.out.println("Não foi possível realizar a transferência!");
		}
	}
}
