package org.exemplo;

public class Pessoa {
	int idade;
	String nome;
	
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	

	public static void main(String[] args) {
		if (args.length < 2) {
			return;
		}
		Pessoa pessoa = new Pessoa(args[0], Integer.parseInt(args[1]));
		System.out.println(pessoa.getNome() + " " + pessoa.getIdade());
	}

}
