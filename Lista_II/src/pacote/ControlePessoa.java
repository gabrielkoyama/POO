package pacote;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Pessoa;

public class ControlePessoa {
	public Pessoa getPessoa() throws Exception {
		
		Controle ctrl 	= new Controle();
		Pessoa c 		= new Pessoa();
		
		System.out.println("Por favor, digite um nome para o contato");
		c.setNome(ctrl.texto());
		
		System.out.println("Digite um telefone para o contato:");
		c.setTelefone(ctrl.texto());
		
		System.out.println("Digite seu Endereco:");
		c.setEndereco(ctrl.texto());
		
		System.out.println("CPf");
		c.setCpf(ctrl.texto());
		
		return c;
	}

	public void salvar(Pessoa p) throws IOException {
		File arq 			= new File("C:\\Users\\User\\Desktop\\agenda2.txt");
		FileWriter wr 		= new FileWriter(arq, true);
		BufferedWriter bwr 	= new BufferedWriter(wr);
	
		bwr.write("Nome: " + p.getNome());
		bwr.newLine();
		bwr.write("Telefone: " + p.getTelefone());
		bwr.newLine();
		bwr.write("Endereco: " + p.getEndereco());
		bwr.newLine();
		bwr.write("Cpf: " + p.getCpf());
		bwr.newLine();
		bwr.write("======================================");
		bwr.newLine();
		bwr.close();
		
		System.out.println("Inseriu " + p.getNome() +
				" " + p.getEndereco() + 
				" " + p.getCpf() + 
				" " + p.getTelefone());
	}
}
