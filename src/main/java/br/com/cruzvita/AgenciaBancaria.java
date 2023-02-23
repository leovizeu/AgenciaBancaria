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
		//System.out.println("");
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
		
		switch(operacao) {
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
		System.out.println("Nome: ");
		String nome = input.next();
		
		System.out.println("Idade: ");
		String idade = input.next();
		
		System.out.println("Banco: ");
		String nomeBanco = input.next();
		
		Cliente cliente = new Cliente(nome, idade, nomeBanco);
		
		Banco banco = new Banco(cliente);
		
		contasBancarias.add(banco);
		System.out.println("Sua conta foi criada com Sucesso! ;D");
		
		operacoes();
	}
	
	private static Banco encontrarConta(int numeroConta){
		Banco banco = null;
		if(contasBancarias.size()>0) {
			for(Banco c: contasBancarias) {
				if (c.getNumeroConta() == numeroConta);
				banco = c;
			}
		}
		return banco;
	}
	
	public static void depositar () {
		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();
		
		Banco banco = encontrarConta(numeroConta);
		
		if (banco != null) {
			System.out.println("Qual valor deseja depositar? ");
			double valorDeposito = input.nextDouble();
			banco.depositar(valorDeposito);
			//System.out.println("O valor foi depositado com sucesso!");
		}else {
			System.out.println("A conta não foi encontrada! :(");
		}
		operacoes();
	}
	
	public static void sacar() {
		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();
		
		Banco banco = encontrarConta(numeroConta);
		
		if (banco != null) {
			System.out.println("Qual valor deseja sacar? ");
			double valorSaque = input.nextDouble();
			banco.sacar(valorSaque);
			//System.out.println("O valor foi sacado com sucesso!");
		}else {
			System.out.println("A conta não foi encontrada! :(");
		}
		operacoes();
	}
	
	public static void transferir() {
		System.out.println("Número da conta remetente: ");
		int numeroContaRemetente = input.nextInt();
		
		Banco contaRemetente = encontrarConta (numeroContaRemetente);
		
		if(contaRemetente != null){
			System.out.println("Número da conta destinatário: ");
			int numeroContaDestinatario = input.nextInt();
			
			Banco contaDestinatario = encontrarConta (numeroContaDestinatario);
			
			if(contaDestinatario != null) {
				System.out.println("Qual o valor da transferência?");
				double valor = input.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor);
			}else {
				System.out.println("A conta não foi encontrada! :(");
			}
		}else {
			System.out.println("A conta não foi encontrada! :(");
		}
		operacoes();
	}
	
	public static void listarContas() {
		if(contasBancarias.size() >0) {
			for (Banco banco: contasBancarias) {
				System.out.println(banco);
			}
		}else {
			System.out.println("Não há contas cadastradas! :'(");
		}
		operacoes();
	}
}
