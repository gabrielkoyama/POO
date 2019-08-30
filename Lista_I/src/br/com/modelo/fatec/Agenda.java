package br.com.modelo.fatec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.com.negocio.fatec.Controle;

public class Agenda {
	
	public void inserirContato() throws Exception {
		
		Controle ctrl 	= new Controle();
		Contato c 		= new Contato();
		
		System.out.println("Por favor, digite um nome para o contato");
		c.setNome(ctrl.texto());
		
		System.out.println("Digite um telefone para o contato:");
		c.setTelefone(ctrl.texto());
		
		System.out.println("Digite sua data de nascimento:");
		c.setData_nasc(ctrl.texto());
		
		System.out.println("Sexo: [M/F/O]:");
		c.setGenero(ctrl.texto());
		
		ctrl.salvar(c);	
	}
	
	public void remover() throws IOException {
		File arq 			= new File("C:\\Users\\User\\Desktop\\agenda.txt");
		FileWriter wr 		= new FileWriter(arq, true);
		FileReader rd 		= new FileReader(arq);
		BufferedReader brd 	= new BufferedReader(rd);
		BufferedWriter bwr 	= new BufferedWriter(wr);
		String texto 		= brd.readLine();
		Controle ctrl 		= new Controle();
		String linha;
		
		System.out.println("Digite a linha que deseja remover");
		linha = ctrl.texto();
		
//		debuggar isso aqui
		while ((texto = brd.readLine()) != null) {
	        if (!texto.trim().equals(linha)) {
//	        	System.out.println(texto);
	        	continue;
	        }else {
	        	bwr.write(texto);	        	
	        }
	      }
		brd.close();
		bwr.close();
	}
}