package br.com.modelo.fatec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Contato {
	protected String nome;
	protected String telefone;
	protected String data_nasc;
	protected String genero;
	protected String servico;
	public Map <String, String> dictServicos;
	
	
	public Contato() {
		dictServicos = new HashMap<String, String>();
		dictServicos.put("1", "Manicure");
		dictServicos.put("2","Pedicure");
		dictServicos.put("3","Design de sobrancelhas");
		dictServicos.put("4","Corte");
		dictServicos.put("5","Pintura de cabelos");
		dictServicos.put("6","Remoção de rugas");
		dictServicos.put("7","Remoção de manchas na pele");
		dictServicos.put("8","Aplicação de botox");
		dictServicos.put("9","Tratamento para emagrecimento");
		dictServicos.put("10","Redução de medidas");
	}
	
	public String getNome() {
		return nome;
	}
	
	public String All() {
		return (	"Nome: " + nome + "\n" + 
					"Telefone: " + telefone + "\n" +  
					"Data de Nascimento: " + data_nasc + "\n" +  
					"Sexo: " + genero + "\n" +
					"Servico: " + servico + "\n");
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

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
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
	
}
