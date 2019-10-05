package br.com.negocio.fatec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import br.com.modelo.fatec.Pessoa;
import br.com.modelo.fatec.Revisao;
import br.com.modelo.fatec.Manutencao;
import br.com.modelo.fatec.Veiculo;

public class ControleServicoManutencao {
	
	public static ArrayList<Manutencao> manutencoesCadastradas;

	public ControleServicoManutencao () throws IOException {
		new ControlePessoa();
		new ControleVeiculo();
		manutencoesCadastradas = new ArrayList<Manutencao>();
		this.getAllManutencoesCadastradas();
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
	
	public ArrayList<Manutencao> getAllManutencoesCadastradas() throws IOException {
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaII.txt");
		FileReader rd = new FileReader(arq);
		BufferedReader brd = new BufferedReader(rd);

		String texto = brd.readLine();
		Manutencao manutencao = new Manutencao();
		
		while(texto != null) {
			
			if(texto.split(":")[0].toLowerCase().contains("Nome_manutencao".toLowerCase())) 
				manutencao.setPessoa(findPessoaByName(texto.split(": ")[1]));
			
			if(texto.split(":")[0].toLowerCase().contains("Veiculo_manutencao".toLowerCase())) 
				manutencao.setVeiculo(findVeiculoByPlaca(texto.split(": ")[1]));
			
			if(texto.split(":")[0].toLowerCase().contains("Data_manutencao".toLowerCase())) 	
				manutencao.setData(texto.split(": ")[1]); // status: 1 - ok, 0 - cancelado
			
			if(texto.split(":")[0].toLowerCase().contains("Status_manutencao".toLowerCase())) { 
				manutencao.setStatus(texto.split(": ")[1]);
				manutencoesCadastradas.add(manutencao); 
				manutencao = new Manutencao();
			}
			texto = brd.readLine();
		}
		brd.close();
		return manutencoesCadastradas;
	}
	
	public Manutencao getManutencaoInput() throws IOException {
		
		ControleUtils getInput = new ControleUtils();
		ControleUtils getInputText = new ControleUtils();
		Manutencao manutencao = new Manutencao();
		
		System.out.println("Selecionar pessoa: \n");
		for (int i = 0; i < ControlePessoa.pessoasCadastradas.size(); i++) 
			System.out.println(i + " - " + ControlePessoa.pessoasCadastradas.get(i).toString());
		manutencao.setPessoa(ControlePessoa.pessoasCadastradas.get(getInput.opcao()));
		
		System.out.println("Selecionar veiculo: \n");
		for (int i = 0; i < ControleVeiculo.veiculosCadastrados.size(); i++) 
			System.out.println(i + " - " + ControleVeiculo.veiculosCadastrados.get(i).toString());
		manutencao.setVeiculo(ControleVeiculo.veiculosCadastrados.get(getInput.opcao()));
		
		manutencao.setStatus("1"); //1 - ok, 0 - cancelado
		
		System.out.println("Selecione a data: ");
		manutencao.setData(getInputText.texto());
		
		return manutencao;
	}
	
	public void agendarManutencao(Manutencao manutencao) throws IOException{
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaII.txt");
		FileWriter wr = new FileWriter(arq, true);
		BufferedWriter bwr = new BufferedWriter(wr);
	
		bwr.write("Nome_manutencao: " + manutencao.getPessoa().getNome());
		bwr.newLine();
		bwr.write("Veiculo_manutencao: " + manutencao.getVeiculo().getNumero_placa());
		bwr.newLine();
		bwr.write("Data_manutencao: " + manutencao.getData());
		bwr.newLine();
		bwr.write("Status_manutencao: " + manutencao.getStatus());
		bwr.newLine();
		bwr.write("======================================");
		bwr.newLine();	
		
		bwr.close();
		
		System.out.println("Cadastrado com sucesso!");
		
	}

	public void editDataManutencao() throws IOException {
		
		//		
		//		
			ControlePessoa controlePessoa= new ControlePessoa(); 
			ControleVeiculo controleVeiculo = new ControleVeiculo();
			ControleServicoRevisao controleServicoRevisao= new ControleServicoRevisao();
			ControleUtils getInput = new ControleUtils();
			ControleUtils getInputText = new ControleUtils();
			Manutencao manutencaoEdit = new Manutencao();
			int index;
			
			System.out.println("Escolha uma revisão para alterar a sua data: \n");
			for (int i = 0; i < manutencoesCadastradas.size(); i++) 
				System.out.println(i + " - " + manutencoesCadastradas.get(i).toString());
	
			index = getInput.opcao();
			manutencaoEdit = manutencoesCadastradas.get(index);
			
			System.out.println("Selecione uma nova data de agendamento: \n");
			manutencaoEdit.setData(getInputText.texto());

			manutencoesCadastradas.set(index, manutencaoEdit);
		
		//		WORKAROUND TEMP
		//		
		
			File arq = new File("C:\\Users\\User\\Desktop\\listaII.txt");
			FileWriter wr = new FileWriter(arq, false);
			BufferedWriter bwr = new BufferedWriter(wr);
			
			for (Manutencao manutencao : manutencoesCadastradas) {				
				bwr.write("Nome_manutencao: " + manutencao.getPessoa().getNome());
				bwr.newLine();
				bwr.write("Veiculo_manutencao: " + manutencao.getVeiculo().getNumero_placa());
				bwr.newLine();
				bwr.write("Data_manutencao: " + manutencao.getData());
				bwr.newLine();
				bwr.write("Status_manutencao: " + manutencao.getStatus());
				bwr.newLine();
				bwr.write("======================================");
				bwr.newLine();	
			}
			bwr.close();
			
			for (Pessoa pessoa : ControlePessoa.pessoasCadastradas) 
				controlePessoa.save(pessoa);
			
			for (Veiculo veiculo : ControleVeiculo.veiculosCadastrados) 
				controleVeiculo.save(veiculo);
			
			for (Revisao revisao : ControleServicoRevisao.revisoesCadastradas) {
				controleServicoRevisao.agendarRevisao(revisao);
			}
			
			
			System.out.println("Editado com sucesso!");
		
	}

	public void cancelarManutencao() throws IOException {
		//			
		//		
			ControlePessoa controlePessoa= new ControlePessoa(); 
			ControleVeiculo controleVeiculo = new ControleVeiculo();
			ControleServicoRevisao controleServicoRevisao = new ControleServicoRevisao();
			ControleUtils getInput = new ControleUtils();
			ControleUtils getInputText = new ControleUtils();
			Manutencao manutencaoCancel= new Manutencao();
			int index;
			
			System.out.println("Escolha a revisão que deseja cancelar: \n");
			for (int i = 0; i < manutencoesCadastradas.size(); i++) 
				System.out.println(i + " - " + manutencoesCadastradas.get(i).toString());
	
			index = getInput.opcao();
			manutencaoCancel = manutencoesCadastradas.get(index);
			manutencaoCancel.setStatus("0");

			manutencoesCadastradas.set(index, manutencaoCancel);
		
		//		WORKAROUND TEMP
		//		
		
			File arq = new File("C:\\Users\\User\\Desktop\\listaII.txt");
			FileWriter wr = new FileWriter(arq, false);
			BufferedWriter bwr = new BufferedWriter(wr);
			
			for (Manutencao manutencao : manutencoesCadastradas) {				
				bwr.write("Nome_manutencao: " + manutencao.getPessoa().getNome());
				bwr.newLine();
				bwr.write("Veiculo_manutencao: " + manutencao.getVeiculo().getNumero_placa());
				bwr.newLine();
				bwr.write("Data_manutencao: " + manutencao.getData());
				bwr.newLine();
				bwr.write("Status_manutencao: " + manutencao.getStatus());
				bwr.newLine();
				bwr.write("======================================");
				bwr.newLine();	
			}
			bwr.close();
			
			for (Pessoa pessoa : ControlePessoa.pessoasCadastradas) 
				controlePessoa.save(pessoa);
			
			for (Veiculo veiculo : ControleVeiculo.veiculosCadastrados) 
				controleVeiculo.save(veiculo);
			
			for (Revisao revisao : ControleServicoRevisao.revisoesCadastradas) {
				controleServicoRevisao.agendarRevisao(revisao);
			}
			
			System.out.println("Cancelado com sucesso!");
	}
	
}
