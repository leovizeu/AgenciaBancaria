package br.com.cruzvita;

public class Cliente {

	private static int contador = 1;
	
	private String nome;
	private String idade;
	private String nomeBanco;
		
	public Cliente(String nome, String idade, String nomeBanco) {
		this.nome = nome;
		this.idade = idade;
		this.nomeBanco = nomeBanco;
		contador += 1;
	}

	public String getNome () {
		return nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public String getIdade () {
		return idade;
	}
	
	public void setIdade (String idade) {
		this.idade = idade;
	}
	
	public String getNomeBanco () {
		return nomeBanco;
	}
	
	public void setNomeBanco (String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	
	public String toString() {
		return "\nNome: " + this.getNome() +
			   "\nIdade: " + this.getIdade() + 
			   "\nNomeBanco: " + this.getNomeBanco();
			   //String.format("%.2f", saldo) ;
	}
	
}