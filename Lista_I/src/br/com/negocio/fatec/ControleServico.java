package br.com.negocio.fatec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import br.com.modelo.fatec.Agenda;
import br.com.modelo.fatec.Contato;
import br.com.modelo.fatec.Servico;

public class ControleServico {
	
	public ArrayList<Servico> init() throws IOException{
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		File arq 					= new File("C:\\Users\\Aluno\\Desktop\\agenda.txt");
		FileReader rd 				= new FileReader(arq);
		BufferedReader brd 			= new BufferedReader(rd);
		String texto 				= brd.readLine();
		Servico s 					= new Servico();
		Contato c 					= new Contato();
		
		while(texto != null) {
			
			switch (texto.split(":")[0]) {
			case "SVC":
				s.setNome(texto.split(":")[1]);
				break;
			case "SVC_NOME":
				c.setNome(texto.split(":")[1]);
				break;
			case "SVC_TELEFONE":
				c.setTelefone(texto.split(":")[1]);
				break;
			case "SVC_DATA_NASC":
				c.setData_nasc(texto.split(":")[1]);
				break;
			case "SVC_SEXO":
				c.setGenero(texto.split(":")[1]);
				s.setPessoa(c);
				servicos.add(s);
				
				c = new Contato();
				s = new Servico();
				
				break;
			}
			
			texto = brd.readLine();
		}

		brd.close();
		return servicos;
	}
	
	public void listar(ArrayList<Servico> servicos) {
		
		for (Servico servico : servicos) {
			System.out.println(servico.list());
		}
		
	}
	
	public Servico getServicoInput(ArrayList<Contato> contatos) throws Exception {
		Servico servico = new Servico();
		Controle ctrl 	= new Controle();
		Menu menu = new Menu();
		Agenda agenda = new Agenda();
		Contato c = new Contato();
		
		int cont=1;
		
		menu.servicos();
		servico.setNome(c.dictServicos.get(ctrl.texto()));
		
		System.out.println("Adicionar a um contato existente?[S/N]\n");
		
		if(ctrl.texto().toUpperCase().equals("S")) {
			for (Contato contato : contatos) {
				System.out.println(cont + " - " + contato.All());
				cont++;
			}
			int opt = ctrl.opcao();
			opt--;
			servico.setPessoa(contatos.get(opt));
		}else servico.setPessoa(agenda.getContato());

		return servico;
		
	}
	
	public void salvar(Servico servico) throws IOException {
		
		File arq 			= new File("C:\\Users\\Aluno\\Desktop\\agenda.txt");
		FileWriter wr 		= new FileWriter(arq, true);
		BufferedWriter bwr 	= new BufferedWriter(wr);
		
		bwr.write("SVC: " + servico.getNome());
		bwr.newLine();
		bwr.write("SVC_NOME: " + servico.getPessoa().getNome());
		bwr.newLine();
		bwr.write("SVC_TELEFONE: " + servico.getPessoa().getTelefone());
		bwr.newLine();
		bwr.write("SVC_DATA_NASC: " + servico.getPessoa().getData_nasc());
		bwr.newLine();
		bwr.write("SVC_SEXO: " + servico.getPessoa().getGenero());
		bwr.newLine();
		bwr.write("======================================");
		bwr.newLine();
		bwr.close();
		
		System.out.println("Cadastrado com sucesso!");
	}
}
