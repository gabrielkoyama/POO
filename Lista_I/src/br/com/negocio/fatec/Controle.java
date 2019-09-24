package br.com.negocio.fatec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.modelo.fatec.Contato;

public class Controle {
	public Scanner scanner;
	public Map <String, Integer> contServicos;
	public Map <String, Integer> contServicosM;
	public Map <String, Integer> contServicosF;

	public Map<String, Integer> getContServicosM() {
		return contServicosM;
	}

	public void setContServicosM(Map<String, Integer> contServicosM) {
		this.contServicosM = contServicosM;
	}

	public Map<String, Integer> getContServicosF() {
		return contServicosF;
	}

	public void setContServicosF(Map<String, Integer> contServicosF) {
		this.contServicosF = contServicosF;
	}

	public Controle() {
		scanner = new Scanner(System.in);
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
		
		contServicosM = new  HashMap<String, Integer>();
		contServicosM.put("Manicure", 0);
		contServicosM.put("Pedicure", 0);
		contServicosM.put("Design de sobrancelhas", 0);
		contServicosM.put("Corte", 0);
		contServicosM.put("Pintura de cabelos", 0);
		contServicosM.put("Remoção de rugas", 0);
		contServicosM.put("Remoção de manchas na pele", 0);
		contServicosM.put("Aplicação de botox", 0);
		contServicosM.put("Tratamento para emagrecimento", 0);
		contServicosM.put("Redução de medidas", 0);
		
		
		contServicosF = new  HashMap<String, Integer>();
		contServicosF.put("Manicure", 0);
		contServicosF.put("Pedicure", 0);
		contServicosF.put("Design de sobrancelhas", 0);
		contServicosF.put("Corte", 0);
		contServicosF.put("Pintura de cabelos", 0);
		contServicosF.put("Remoção de rugas", 0);
		contServicosF.put("Remoção de manchas na pele", 0);
		contServicosF.put("Aplicação de botox", 0);
		contServicosF.put("Tratamento para emagrecimento", 0);
		contServicosF.put("Redução de medidas", 0);
		
	}
	
	public Map<String, Integer> getContServicos() {
		return contServicos;
	}

	public void setContServicos(Map<String, Integer> contServicos) {
		this.contServicos = contServicos;
	}

	public int opcao() {
		int op = scanner.nextInt();
		return op;
	}

	public String texto() {
		String t = scanner.nextLine();
		return t;
	}
	
	public Map getContatosMap() throws IOException {
		File arq 			= new File("C:\\Users\\Aluno\\Desktop\\agenda.txt");
		FileReader rd 		= new FileReader(arq);
		BufferedReader brd 	= new BufferedReader(rd);
		String texto 		= brd.readLine();
		Map<String, Contato> contatos = new HashMap<String, Contato>();
		String aux;
		Contato c = new Contato();
		
		while(texto != null) {
			aux = texto.split(":")[0];
			if(aux.contains("Nome")) {
				c.setNome(texto.split(": ")[1]);
			}
			
			if(aux.contains("Telefone")) {
				c.setTelefone(texto.split(": ")[1]);
			}
			
			if(aux.contains("Data")) {
				c.setData_nasc(texto.split(": ")[1]);
			}
			
			if(aux.contains("Sexo")) {
				c.setGenero(texto.split(": ")[1]); 
				contatos.put(c.getNome(), c);
				c = new Contato();
			}
			texto = brd.readLine();
		}
		
		brd.close();
		return contatos;
	}
	
	public ArrayList init() throws IOException {
		
			ArrayList<Contato> contatos = new ArrayList<Contato>();
			File arq 					= new File("C:\\Users\\Aluno\\Desktop\\agenda.txt");
			FileReader rd 				= new FileReader(arq);
			BufferedReader brd 			= new BufferedReader(rd);
			String texto 				= brd.readLine();
			Contato c 					= new Contato();
			
			while(texto != null) {
				if(texto.split(":")[0].contains("Nome")) {
					c.setNome(texto.split(": ")[1]);
				}
				
				if(texto.split(":")[0].contains("Telefone")) {
					c.setTelefone(texto.split(": ")[1]);
				}
				
				if(texto.split(":")[0].contains("Data")) {
					c.setData_nasc(texto.split(": ")[1]);
				}
				
				if(texto.split(":")[0].contains("Sexo")) {
					c.setGenero(texto.split(": ")[1]);

					contatos.add(c);
					c = new Contato();
				}
				
				texto = brd.readLine();
			}

			brd.close();
			return contatos;
	}
	

	public void salvar(Contato c) throws IOException {
		
		File arq 			= new File("C:\\Users\\Aluno\\Desktop\\agenda.txt");
		FileWriter wr 		= new FileWriter(arq, true);
		BufferedWriter bwr 	= new BufferedWriter(wr);
		
		bwr.write("Nome: " + c.getNome());
		bwr.newLine();
		bwr.write("Telefone: " + c.getTelefone());
		bwr.newLine();
		bwr.write("Data de nascimento: " + c.getData_nasc());
		bwr.newLine();
		bwr.write("Sexo: " + c.getGenero());
		bwr.newLine();
		bwr.write("======================================");
		bwr.newLine();
		bwr.close();
		
		System.out.println("Inseriu " + c.getNome() +
				" " + c.getData_nasc() + 
				" " + c.getGenero() + 
				" " + c.getTelefone());
	}
	
	public void salvarLista(ArrayList<Contato> contatos) throws IOException {
		
		File arq 			= new File("C:\\Users\\Aluno\\Desktop\\agenda.txt");
		FileWriter wr 		= new FileWriter(arq);
		BufferedWriter bwr 	= new BufferedWriter(wr);
		
		for (Contato c : contatos) {
			
			bwr.write("Nome: " + c.getNome());
			bwr.newLine();
			bwr.write("Telefone: " + c.getTelefone());
			bwr.newLine();
			bwr.write("Data de nascimento: " + c.getData_nasc());
			bwr.newLine();
			bwr.write("Sexo: " + c.getGenero());
			bwr.newLine();
			bwr.write("======================================");
			bwr.newLine();			
		}
		bwr.close();
	}

	@Override
	protected void finalize() throws Throwable {
		scanner.close();
	}
	
	
//	ordenados
	public ArrayList<Contato> ordena(ArrayList<Contato> contatos,  String x){
		
		ArrayList<Contato> res = new ArrayList<Contato>();
		ArrayList<String> listaNomes = new ArrayList<String>();
		
		if(x.toUpperCase().contains("M")) {			
			for (Contato contato : contatos) 
				if(contato.getGenero().toUpperCase().contains("M")) 
					listaNomes.add(contato.getNome());
		}
		else if(x.toUpperCase().contains("F")) {
			for (Contato contato : contatos) 
				if(contato.getGenero().toUpperCase().contains("F")) 
					listaNomes.add(contato.getNome());
		}else {
			for (Contato contato : contatos) 
				listaNomes.add(contato.getNome());
		}
		
		Collections.sort(listaNomes);
		
		for (String nome : listaNomes) 
			for (Contato z : contatos) 
				if(z.getNome() == nome) 
					res.add(z);

		
		return res; 
	}
	
	
	
}