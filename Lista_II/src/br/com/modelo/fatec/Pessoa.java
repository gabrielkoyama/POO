package br.com.modelo.fatec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Pessoa {
	protected String nome;
	protected String telefone;
	protected String endereco;
	protected String cpf;
	protected String servico;

	public String All() {
		return (	"Nome: " + nome + "\n" + 
				"Telefone: " + telefone + "\n" +  
				"Data de Nascimento: " + endereco + "\n" +  
				"Sexo: " + cpf );
	}
	
	public void listar() throws Exception {
		File arq 			= new File("C:\\Users\\User\\Desktop\\agenda.txt");
		FileReader rd 		= new FileReader(arq);
		BufferedReader brd 	= new BufferedReader(rd);
		String texto 		= brd.readLine();
		String aux;
		
		Map<String, Pessoa> contatos = new HashMap<String, Pessoa>();
		Pessoa c = new Pessoa();
		
		while(texto != null) {
			System.out.println(texto);
			texto = brd.readLine();
		}
	
		brd.close();
	}

	
	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
