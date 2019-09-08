package br.com.negocio.fatec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.com.modelo.fatec.Agenda;
import br.com.modelo.fatec.Contato;

public class Controle {
	public Scanner scanner;

	public Controle() {
		scanner = new Scanner(System.in);
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
		File arq 			= new File("C:\\Users\\User\\Desktop\\agenda.txt");
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
		
			File arq 			= new File("C:\\Users\\User\\Desktop\\agenda.txt");
			FileReader rd 		= new FileReader(arq);
			BufferedReader brd 	= new BufferedReader(rd);
			String texto 		= brd.readLine();
			Map<String, Contato> contatosMapinha = new HashMap<String, Contato>();
			String aux;
			Contato c = new Contato();
			ArrayList<Contato> contatos = new ArrayList<Contato>();
			while(texto != null) {
				aux = texto.split(":")[0];
				if(aux.contains("Nome")) {
					c.setNome(texto.split(": ")[1]);
//					System.out.println("Adicionou: " + c.getNome());
				}
				
				if(aux.contains("Telefone")) {
					c.setTelefone(texto.split(": ")[1]);
//					System.out.println("Adicionou: " + c.getTelefone());
				}
				
				if(aux.contains("Data")) {
					c.setData_nasc(texto.split(": ")[1]);
//					System.out.println("Adicionou: " + c.getData_nasc());
				}
				
				if(aux.contains("Sexo")) {
					c.setGenero(texto.split(": ")[1]); 
//					System.out.println("Adicionou: " + c.getGenero());
//					System.out.println("Listar tudo " + c.All());
					contatos.add(c); 
					c = new Contato();
				}
				
				texto = brd.readLine();
			}
			
			brd.close();
			return contatos;
	}
	
	public void listar() throws Exception {
		File arq 			= new File("C:\\Users\\User\\Desktop\\agenda.txt");
		FileReader rd 		= new FileReader(arq);
		BufferedReader brd 	= new BufferedReader(rd);
		String texto 		= brd.readLine();
		String aux;
		
		Map<String, Contato> contatos = new HashMap<String, Contato>();
		Contato c = new Contato();
		
		while(texto != null) {
			System.out.println(texto);
			texto = brd.readLine();
		}
	
		brd.close();
	}
	
	public void salvar(Contato c) throws IOException {
		
		File arq 			= new File("C:\\Users\\User\\Desktop\\agenda.txt");
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
		
		File arq 			= new File("C:\\Users\\User\\Desktop\\agenda.txt");
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
}


















