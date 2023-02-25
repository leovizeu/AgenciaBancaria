package br.com.cruzvita;

import java.util.ArrayList;
import java.util.Scanner;



public class AgenciaBancaria {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Banco> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Banco>();
		operacoes();
	}

	public static void operacoes() {
		// System.out.println("");
		System.out.println("------------------------------------------------------");
		System.out.println("--------------Bem Vindos a nossa Agência--------------");
		System.out.println("------------------------------------------------------");
		System.out.println("------------------------------------------------------");
		System.out.println("****--Selecione uma operação que deseja realizar--****");
		System.out.println("------------------------------------------------------");
		System.out.println("|                Opção 1 - Criar Conta                |");
		System.out.println("|                Opção 2 - Depositar                  |");
		System.out.println("|                Opção 3 - Sacar                      |");
		System.out.println("|                Opção 4 - Transferir                 |");
		System.out.println("|                Opção 5 - Listar                     |");
		System.out.println("|                Opção 6 - Sair                       |");

		int operacao = input.nextInt();

		switch (operacao) {
			case 1:
				criarConta();
				break;
			case 2:
				depositar();
				break;
			case 3:
				sacar();
				break;
			case 4:
				transferir();
				break;
			case 5:
				listarContas();
				break;
			case 6:
				System.out.println("Obrigado por usar nossa agência! :)");
				System.exit(0);

			default:
				System.out.println("Opção inválida!");
				operacoes();
				break;
		}
	}

	public static void criarConta() {
		System.out.print("Nome: ");
		String nome = input.next();

		System.out.print("Idade: ");
		String idade = input.next();

		System.out.print("Banco: ");
		String nomeBanco = input.next();

		Cliente cliente = new Cliente(nome, idade, nomeBanco);

		Banco banco = new Banco(cliente);

		contasBancarias.add(banco);
		System.out.println("Sua conta foi criada com Sucesso! ;D");

		operacoes();
	}

	private static Banco encontrarConta(int numeroConta) {

		Banco banco = null;

		for (Banco c : contasBancarias) {
			if (c.getNumeroConta() == numeroConta & banco != null)
				;
			banco = c;

		}
		return banco;
	}

	public static void depositar() {
		System.out.print("Número da conta: ");
		int numeroConta = input.nextInt();

		// Banco banco = encontrarConta(numeroConta);

		for (Banco conta : contasBancarias) {
			if (conta.getNumeroConta() == numeroConta) {
				System.out.print("Qual valor deseja depositar? ");
				double valorDeposito = input.nextDouble();
				conta.depositar(valorDeposito);
				operacoes();

			}

		}
		System.out.println("A conta não foi encontrada! :(");
		operacoes();
	}

	public static void sacar() {
		System.out.print("Número da conta: ");
		int numeroConta = input.nextInt();

		//Banco banco = encontrarConta(numeroConta);

		for (Banco conta : contasBancarias) {
			if (conta.getNumeroConta() == numeroConta) {
				System.out.print("Qual valor deseja depositar? ");
				double valorSaque = input.nextDouble();
				conta.sacar(valorSaque);
				operacoes();

			}

		}
		operacoes();
	}

	// Banco contaRemetente = encontrarConta(numeroContaRemetente);

	public static void transferir( ) {

	

		System.out.print("Número da conta remetente: ");
		int ContaRemetente = input.nextInt();	

		for (Banco conta1 : contasBancarias) {
			if (conta1.getNumeroConta() == ContaRemetente) {

				System.out.print("Número da conta destinatário: ");
				int ContaDestinatario = input.nextInt();
				
				for (Banco conta2 : contasBancarias) {
					if (conta2.getNumeroConta() == ContaDestinatario) {

						System.out.print("Qual o valor da transferência?");
						double valor = input.nextDouble();

						conta1.sacar(valor);
						conta2.depositar(valor);
						operacoes();
					}
					System.out.println("conta Destinatária não encotrada.");
				}

				System.out.println("conta Remetente não encotrada.");

			}
		}
		operacoes();

	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Banco banco : contasBancarias) {
				System.out.println(banco);
			}
		} else {
			System.out.println("Não há contas cadastradas! :'(");
		}
		operacoes();
	}
}
