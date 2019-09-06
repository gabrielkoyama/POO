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
	
	
	public Map init() throws IOException {
		
			File arq 			= new File("C:\\Users\\Aluno\\Desktop\\agenda.txt");
			FileReader rd 		= new FileReader(arq);
			BufferedReader brd 	= new BufferedReader(rd);
			String aux;
			String texto 		= brd.readLine();
			Map<String, Contato> contatosMapinha = new HashMap<String, Contato>();
			Contato c = new Contato();
			
			while(texto != null) {
				aux = texto.split(":")[0];
				if(aux.contains("Nome")) 		c.setNome(texto.split(": ")[1]);
				if(aux.contains("Telefone")) 	c.setTelefone(texto.split(": ")[1]);
				if(aux.contains("Data")) 		c.setData_nasc(texto.split(": ")[1]);
				if(aux.contains("Sexo")) {
					c.setGenero(texto);
//					System.out.println("Adicionou no mapinha " + c.All());
					contatosMapinha.put(c.getNome(), c);
				}
				texto = brd.readLine();
			}
			
			brd.close();
			System.out.println(contatosMapinha);
			return contatosMapinha;
	}
	
	public void listar() throws Exception {
		File arq 			= new File("C:\\Users\\Aluno\\Desktop\\agenda.txt");
		FileReader rd 		= new FileReader(arq);
		BufferedReader brd 	= new BufferedReader(rd);
		String aux;
		String texto 		= brd.readLine();
		
		Map<String, Contato> contatos = new HashMap<String, Contato>();
//		ArrayList<Contato> contatos = new ArrayList<Contato>();
		
		Contato c = new Contato();
		
		while(texto != null) {
			aux = texto.split(":")[0];
			if(aux.contains("Nome")) 		c.setNome(texto);
			if(aux.contains("Telefone")) 	c.setTelefone(texto);
			if(aux.contains("Data")) 		c.setData_nasc(texto);
			if(aux.contains("Sexo")) {
				c.setGenero(texto);
				System.out.println(c.All());
				contatos.put(c.getNome(), c);
			}
			
//			certo
//			System.out.println(texto);
			texto = brd.readLine();
			aux = texto;
		}
	
		brd.close();
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

	@Override
	protected void finalize() throws Throwable {
		scanner.close();
	}
}


















