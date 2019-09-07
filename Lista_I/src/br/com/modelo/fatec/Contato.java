package br.com.modelo.fatec;

public class Contato {
	protected String nome;
	protected String telefone;
	protected String data_nasc;
	protected String genero;

	public String getNome() {
		return nome;
	}
	
	public String All() {
		return (	"Nome: " + nome + "\n" + 
					"Telefone: " + telefone + "\n" +  
					"Data de Nascimento: " + data_nasc + "\n" +  
					"Sexo: " + genero );
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
//	@Override
//	public String toString(){
//		return (nome + telefone + data_nasc + genero);
//	}
	
}
