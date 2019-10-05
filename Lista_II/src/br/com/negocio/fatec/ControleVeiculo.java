package br.com.negocio.fatec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import br.com.modelo.fatec.Veiculo;

public class ControleVeiculo {
public static ArrayList<Veiculo> veiculosCadastrados;
	
	public ControleVeiculo() throws IOException {
		veiculosCadastrados = new ArrayList<Veiculo>();
		this.getAllVeiculosCadastradas();
	}
		
	public Veiculo getVeiculo() {
		
		ControleUtils getInputText = new ControleUtils();
		Veiculo v = new Veiculo();
		
		System.out.println("Placa: ");
		v.setNumero_placa(getInputText.texto());
		
		System.out.println("Modelo: ");
		v.setModelo(getInputText.texto());
		
		System.out.println("Ano de Fabricação: ");
		v.setAno_fabricacao(getInputText.texto());
		
		System.out.println("Valor: ");
		v.setValor(getInputText.texto());
		
		return v;
	}
	
	public ArrayList<Veiculo> getAllVeiculosCadastradas() throws IOException {
		
		File arq = new File("C:\\Users\\User\\Desktop\\listaII.txt");
		FileReader rd = new FileReader(arq);
		BufferedReader brd = new BufferedReader(rd);

		String texto = brd.readLine();
		Veiculo veiculo = new Veiculo();
		
		while(texto != null) {
			if(texto.split(":")[0].toLowerCase().contains("Placa".toLowerCase())) veiculo.setNumero_placa(texto.split(": ")[1]);
			if(texto.split(":")[0].toLowerCase().contains("Fabricação".toLowerCase())) veiculo.setAno_fabricacao(texto.split(": ")[1]);
			if(texto.split(":")[0].toLowerCase().contains("Modelo".toLowerCase())) veiculo.setModelo(texto.split(": ")[1]);
			if(texto.split(":")[0].toLowerCase().contains("Valor".toLowerCase())) {
				veiculo.setValor(texto.split(": ")[1]); 
				veiculosCadastrados.add(veiculo ); 
				veiculo = new Veiculo();
			}
			texto = brd.readLine();
		}
		brd.close();
		return veiculosCadastrados;
	}
	
	public void save(Veiculo veiculo) throws IOException {
		File arq = new File("C:\\Users\\User\\Desktop\\listaII.txt");
		FileWriter wr = new FileWriter(arq, true);
		BufferedWriter bwr = new BufferedWriter(wr);
	
		bwr.write("Placa: " + veiculo.getNumero_placa());
		bwr.newLine();
		bwr.write("Modelo: " + veiculo.getModelo());
		bwr.newLine();
		bwr.write("Ano de Fabricação: " + veiculo.getAno_fabricacao());
		bwr.newLine();
		bwr.write("Valor: " + veiculo.getValor());
		bwr.newLine();
		bwr.write("======================================");
		bwr.newLine();	
		
		bwr.close();
		
		System.out.println("Cadastrado com sucesso!");
	}	

}
