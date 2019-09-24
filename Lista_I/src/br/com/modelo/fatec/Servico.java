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
	
	public String list() {
		return (	"Servico: " + nome + "\n" + 
				"Nome: " + pessoa.getNome() + "\n" + 
				"Telefone: " + pessoa.getTelefone() + "\n" +  
				"Data de Nascimento: " + pessoa.getData_nasc() + "\n" +  
				"Sexo: " + pessoa.getGenero() + "\n");
	}
}
