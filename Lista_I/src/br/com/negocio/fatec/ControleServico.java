package br.com.negocio.fatec;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import br.com.modelo.fatec.Agenda;
import br.com.modelo.fatec.Contato;
import br.com.modelo.fatec.Servico;

public class ControleServico {
	
	public void listar() {
		
	}
	
	public Servico getServicoInput() throws Exception {
		Servico servico = new Servico();
		Controle ctrl 	= new Controle();
		Menu menu = new Menu();
		Agenda agenda = new Agenda();
		Contato c = new Contato();
		
		menu.servicos();
		
		servico.setNome(c.dictServicos.get(ctrl.texto()));
		servico.setPessoa(agenda.getContato());

		return servico;
		
	}
	
//	public void salvar() {
//		File arq 			= new File("C:\\Users\\Aluno\\Desktop\\agenda.txt");
//		FileWriter wr 		= new FileWriter(arq, true);
//		BufferedWriter bwr 	= new BufferedWriter(wr);
//		
//		bwr.write("Nome: " + c.getNome());
//		bwr.newLine();
//		bwr.write("Telefone: " + c.getTelefone());
//		bwr.newLine();
//		bwr.write("Data de nascimento: " + c.getData_nasc());
//		bwr.newLine();
//		bwr.write("Sexo: " + c.getGenero());
//		bwr.newLine();
//		bwr.write("======================================");
//		bwr.newLine();
//		bwr.close();
//		
//		System.out.println("Inseriu " + c.getNome() +
//				" " + c.getData_nasc() + 
//				" " + c.getGenero() + 
//				" " + c.getTelefone());
//	}
}
