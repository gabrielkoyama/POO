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
import br.com.modelo.fatec.Pessoa;

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
	
	public ArrayList init() throws IOException {
			File arq 					= new File("C:\\Users\\User\\Desktop\\agenda.txt");
			FileReader rd 				= new FileReader(arq);
			BufferedReader brd 			= new BufferedReader(rd);
			Pessoa c 					= new Pessoa();
			String texto 				= brd.readLine();
			ArrayList<Pessoa> pessoas 	= new ArrayList<Pessoa>();
			
			while(texto != null) {
				if(texto.split(": ")[0].contains("Nome")) {
					c.setNome(texto.split(": ")[1]);
				}
				
				if(texto.split(": ")[0].contains("Telefone")) {
					c.setTelefone(texto.split(": ")[1]);
				}
				
				if(texto.split(": ")[0].contains("Endereco")) {
					c.setEndereco(texto.split(": ")[1]);
				}
				
				if(texto.split(": ")[0].contains("Sexo")) {
					c.setCpf(texto.split(": ")[1]); 
					pessoas.add(c); 
					c = new Pessoa();
				}
				texto = brd.readLine();
			}
			
			brd.close();
			return pessoas;
	}
	
	
	
	
	public void salvarLista(ArrayList<Pessoa> contatos) throws IOException {
		
		File arq 			= new File("C:\\Users\\User\\Desktop\\agenda.txt");
		FileWriter wr 		= new FileWriter(arq);
		BufferedWriter bwr 	= new BufferedWriter(wr);
		
		for (Pessoa c : contatos) {
			
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


















