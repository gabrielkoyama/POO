package br.com.negocio.fatec;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import br.com.modelo.fatec.Pessoa;

public class ControlePessoa {
	public static ArrayList<Pessoa> pessoasCadastradas;
	
	public ControlePessoa() throws IOException {
		pessoasCadastradas = new ArrayList<Pessoa>();
		this.getAllPessoasCadastradas();
	}
	
	public boolean checkNomeExists(String nome) {
		boolean response=false;
		for (Pessoa pessoa : pessoasCadastradas) {
			if(pessoa.getNome().toLowerCase().contains(nome.toLowerCase())) response=true;
		}
		return response;
	}
		
	public Pessoa getPessoa() {
		ControleUtils getInputText = new ControleUtils();
		Pessoa p = new Pessoa();
		String nomeAux;
		boolean flagAux=false;

		System.out.println("Nome: ");
		nomeAux = getInputText.texto();
		flagAux = checkNomeExists(nomeAux);
				
		if(flagAux) {
			System.out.println("Nome ja existe, escolha outro \n");
			nomeAux = getInputText.texto();
			flagAux = checkNomeExists(nomeAux);
			while(flagAux) {
				System.out.println("Nome ja existe, escolha outro \n");
				nomeAux = getInputText.texto();
				flagAux = checkNomeExists(nomeAux);
			}
		}
		p.setNome(nomeAux);
		
		System.out.println("Telefone: ");
		p.setTelefone(getInputText.texto());
		
		System.out.println("Endereco: ");
		p.setEndereco(getInputText.texto());
		
		System.out.println("CPF: ");
		p.setCpf(getInputText.texto());
		
		return p;
	}
	
	public ArrayList<Pessoa> getAllPessoasCadastradas() throws IOException {
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaII.txt");
		FileReader rd = new FileReader(arq);
		BufferedReader brd = new BufferedReader(rd);

		String texto = brd.readLine();
		Pessoa pessoa = new Pessoa();
		
		while(texto != null) {
			if(texto.split(":")[0].toLowerCase().contains("Nome".toLowerCase())) pessoa.setNome(texto.split(": ")[1]);
			if(texto.split(":")[0].toLowerCase().contains("Telefone".toLowerCase())) pessoa.setTelefone(texto.split(": ")[1]);
			if(texto.split(":")[0].toLowerCase().contains("Endereco".toLowerCase())) pessoa.setEndereco(texto.split(": ")[1]);
			if(texto.split(":")[0].toLowerCase().contains("Cpf".toLowerCase())) {
				pessoa.setCpf(texto.split(": ")[1]); 
				pessoasCadastradas.add(pessoa); 
				pessoa = new Pessoa();
			}
			texto = brd.readLine();
		}
		brd.close();
		return pessoasCadastradas;
	}
	
	public void save(Pessoa pessoa) throws IOException {
		File arq = new File("C:\\Users\\User\\Desktop\\listaII.txt");
		FileWriter wr = new FileWriter(arq, true);
		BufferedWriter bwr = new BufferedWriter(wr);
	
		bwr.write("Nome: " + pessoa.getNome());
		bwr.newLine();
		bwr.write("Telefone: " + pessoa.getTelefone());
		bwr.newLine();
		bwr.write("Endereco: " + pessoa.getEndereco());
		bwr.newLine();
		bwr.write("CPF: " + pessoa.getCpf());
		bwr.newLine();
		bwr.write("======================================");
		bwr.newLine();	
		
		bwr.close();
		
		System.out.println("Cadastrado com sucesso!");
	}	
}