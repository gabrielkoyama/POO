package br.com.modelo.fatec;

public class Servico {

	protected String nome;
	protected Contato pessoa;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Contato getPessoa() {
		return pessoa;
	}
	public void setPessoa(Contato pessoa) {
		this.pessoa = pessoa;
	}
}
