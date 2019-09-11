package br.com.modelo.fatec;

import java.util.HashMap;
import java.util.Map;

public class Contato {
	protected String nome;
	protected String telefone;
	protected String data_nasc;
	protected String genero;
	protected String servico;
	public Map <String, String> dictServicos;
	public Map <String, Integer> contServicos;
	
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
		
		contServicos = new HashMap<String, Integer>();
		contServicos.put("Manicure", 0);
		contServicos.put("Pedicure", 0);
		contServicos.put("Design de sobrancelhas", 0);
		contServicos.put("Corte", 0);
		contServicos.put("Pintura de cabelos", 0);
		contServicos.put("Remoção de rugas", 0);
		contServicos.put("Remoção de manchas na pele", 0);
		contServicos.put("Aplicação de botox", 0);
		contServicos.put("Tratamento para emagrecimento", 0);
		contServicos.put("Redução de medidas", 0);
		
	}

	public Map<String, Integer> getContServicos() {
		return contServicos;
	}

	public void setContServicos(Map<String, Integer> contServicos) {
		this.contServicos = contServicos;
	}

	public String getNome() {
		return nome;
	}
	
	public String All() {
		return (	"Nome: " + nome + "\n" + 
					"Telefone: " + telefone + "\n" +  
					"Data de Nascimento: " + data_nasc + "\n" +  
					"Sexo: " + genero + "\n" +
					"Servico: " + servico );
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
