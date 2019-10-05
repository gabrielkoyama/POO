package br.com.negocio.fatec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import br.com.modelo.fatec.Manutencao;
import br.com.modelo.fatec.Pessoa;
import br.com.modelo.fatec.Revisao;
import br.com.modelo.fatec.Veiculo;

public class ControleServicoRevisao {
	
	public static ArrayList<Revisao> revisoesCadastradas;

	public ControleServicoRevisao () throws IOException {
		new ControlePessoa();
		new ControleVeiculo();
		revisoesCadastradas = new ArrayList<Revisao>();
		this.getAllRevisoesCadastradas();
	}
	
	public Pessoa findPessoaByName(String nome) {
		Pessoa response = null;
		for (Pessoa pessoa : ControlePessoa.pessoasCadastradas) 
			if(pessoa.getNome().toLowerCase().contains(nome.toLowerCase())) response=pessoa;
		return response;
	}
	
	public Veiculo findVeiculoByPlaca(String placa) {
		Veiculo response = null;
		for (Veiculo veiculo : ControleVeiculo.veiculosCadastrados) 
			if(veiculo.getNumero_placa().toLowerCase().contains(placa.toLowerCase())) response=veiculo;
		return response;
	}
	
	public ArrayList<Revisao> getAllRevisoesCadastradas() throws IOException {
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaII.txt");
		FileReader rd = new FileReader(arq);
		BufferedReader brd = new BufferedReader(rd);

		String texto = brd.readLine();
		Revisao revisao = new Revisao();
		
		while(texto != null) {
			
			if(texto.split(":")[0].toLowerCase().contains("Nome_revisao".toLowerCase())) 
				revisao.setPessoa(findPessoaByName(texto.split(": ")[1]));
			
			if(texto.split(":")[0].toLowerCase().contains("Veiculo_revisao".toLowerCase())) 
				revisao.setVeiculo(findVeiculoByPlaca(texto.split(": ")[1]));
			
			if(texto.split(":")[0].toLowerCase().contains("Data_revisao".toLowerCase())) 	
				revisao.setData(texto.split(": ")[1]); // status: 1 - ok, 0 - cancelado
			
			if(texto.split(":")[0].toLowerCase().contains("Status_revisao".toLowerCase())) { 
				revisao.setStatus(texto.split(": ")[1]);
				revisoesCadastradas.add(revisao); 
				revisao = new Revisao();
			}
			texto = brd.readLine();
		}
		brd.close();
		return revisoesCadastradas;
	}
	
	public Revisao getRevisaoInput() throws IOException {
		
		ControleUtils getInput = new ControleUtils();
		ControleUtils getInputText = new ControleUtils();
		Revisao revisao = new Revisao();
		
		System.out.println("Selecionar pessoa: \n");
		for (int i = 0; i < ControlePessoa.pessoasCadastradas.size(); i++) 
			System.out.println(i + " - " + ControlePessoa.pessoasCadastradas.get(i).toString());
		revisao.setPessoa(ControlePessoa.pessoasCadastradas.get(getInput.opcao()));
		
		System.out.println("Selecionar veiculo: \n");
		for (int i = 0; i < ControleVeiculo.veiculosCadastrados.size(); i++) 
			System.out.println(i + " - " + ControleVeiculo.veiculosCadastrados.get(i).toString());
		revisao.setVeiculo(ControleVeiculo.veiculosCadastrados.get(getInput.opcao()));
		
		revisao.setStatus("1"); //1 - ok, 0 - cancelado
		
		System.out.println("Selecione a data: ");
		revisao.setData(getInputText.texto());
		
		return revisao;
	}
	
	public void agendarRevisao(Revisao revisao) throws IOException{
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaII.txt");
		FileWriter wr = new FileWriter(arq, true);
		BufferedWriter bwr = new BufferedWriter(wr);
	
		bwr.write("Nome_revisao: " + revisao.getPessoa().getNome());
		bwr.newLine();
		bwr.write("Veiculo_revisao: " + revisao.getVeiculo().getNumero_placa());
		bwr.newLine();
		bwr.write("Data_revisao: " + revisao.getData());
		bwr.newLine();
		bwr.write("Status_revisao: " + revisao.getStatus());
		bwr.newLine();
		bwr.write("======================================");
		bwr.newLine();	
		
		bwr.close();
		
		System.out.println("Cadastrado com sucesso!");
		
	}

	public void editDataAgendamento() throws IOException {
		
		//		
		//		
			ControlePessoa controlePessoa= new ControlePessoa(); 
			ControleVeiculo controleVeiculo = new ControleVeiculo();
			ControleServicoManutencao controleServicoManutencao= new ControleServicoManutencao();
			ControleUtils getInput = new ControleUtils();
			ControleUtils getInputText = new ControleUtils();
			Revisao revisaoEdit = new Revisao();
			int index;
			
			System.out.println("Escolha uma revisão para alterar a sua data: \n");
			for (int i = 0; i < revisoesCadastradas.size(); i++) 
				System.out.println(i + " - " + revisoesCadastradas.get(i).toString());
	
			index = getInput.opcao();
			revisaoEdit = revisoesCadastradas.get(index);
			
			System.out.println("Selecione uma nova data de agendamento: \n");
			revisaoEdit.setData(getInputText.texto());

			revisoesCadastradas.set(index, revisaoEdit);
		
		//		WORKAROUND TEMP
		//		
		
			File arq = new File("C:\\Users\\User\\Desktop\\listaII.txt");
			FileWriter wr = new FileWriter(arq, false);
			BufferedWriter bwr = new BufferedWriter(wr);
			
			for (Revisao revisao : revisoesCadastradas) {				
				bwr.write("Nome_revisao: " + revisao.getPessoa().getNome());
				bwr.newLine();
				bwr.write("Veiculo_revisao: " + revisao.getVeiculo().getNumero_placa());
				bwr.newLine();
				bwr.write("Data_revisao: " + revisao.getData());
				bwr.newLine();
				bwr.write("Status_revisao: " + revisao.getStatus());
				bwr.newLine();
				bwr.write("======================================");
				bwr.newLine();	
			}
			bwr.close();
			
			for (Pessoa pessoa : ControlePessoa.pessoasCadastradas) 
				controlePessoa.save(pessoa);
			
			for (Veiculo veiculo : ControleVeiculo.veiculosCadastrados) 
				controleVeiculo.save(veiculo);
			
			for (Manutencao manutencao: ControleServicoManutencao.manutencoesCadastradas) 
				controleServicoManutencao.agendarManutencao(manutencao);
			
			
			System.out.println("Editado com sucesso!");
		
	}

	public void cancelarAgendamento() throws IOException {
		//		
		//		
			ControlePessoa controlePessoa= new ControlePessoa(); 
			ControleVeiculo controleVeiculo = new ControleVeiculo();
			ControleServicoManutencao controleServicoManutencao= new ControleServicoManutencao();

			ControleUtils getInput = new ControleUtils();
			Revisao revisaoCancel= new Revisao();
			int index;
			
			System.out.println("Escolha a revisão que deseja cancelar: \n");
			for (int i = 0; i < revisoesCadastradas.size(); i++) 
				System.out.println(i + " - " + revisoesCadastradas.get(i).toString());
	
			index = getInput.opcao();
			revisaoCancel = revisoesCadastradas.get(index);
			revisaoCancel.setStatus("0");

			revisoesCadastradas.set(index, revisaoCancel);
		
		//		WORKAROUND TEMP
		//		
		
			File arq = new File("C:\\Users\\User\\Desktop\\listaII.txt");
			FileWriter wr = new FileWriter(arq, false);
			BufferedWriter bwr = new BufferedWriter(wr);
			
			for (Revisao revisao : revisoesCadastradas) {				
				bwr.write("Nome_revisao: " + revisao.getPessoa().getNome());
				bwr.newLine();
				bwr.write("Veiculo_revisao: " + revisao.getVeiculo().getNumero_placa());
				bwr.newLine();
				bwr.write("Data_revisao: " + revisao.getData());
				bwr.newLine();
				bwr.write("Status_revisao: " + revisao.getStatus());
				bwr.newLine();
				bwr.write("======================================");
				bwr.newLine();	
			}
			bwr.close();
			
			
			for (Pessoa pessoa : ControlePessoa.pessoasCadastradas) 
				controlePessoa.save(pessoa);
			
			for (Veiculo veiculo : ControleVeiculo.veiculosCadastrados) 
				controleVeiculo.save(veiculo);
		
			for (Manutencao manutencao: ControleServicoManutencao.manutencoesCadastradas) 
				controleServicoManutencao.agendarManutencao(manutencao);
			
			
			System.out.println("Cancelado com sucesso!");
	}
	
}
