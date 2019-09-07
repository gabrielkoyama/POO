package br.com.modelo.fatec;

public class Familiares extends Contato{
	
	public Familiares(String nome) {
		super(nome); // execucao ao construtor superior
	}
	
	
	public void alterarNome() {
		nome = "Novo Nome";
	}

}
