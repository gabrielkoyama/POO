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

	public String toString() {
		return (	"Nome: " + nome + "\n" + 
				"Telefone: " + telefone + "\n" +  
				"Data de Nascimento: " + endereco + "\n" +  
				"Sexo: " + cpf + "\n" );
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
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
