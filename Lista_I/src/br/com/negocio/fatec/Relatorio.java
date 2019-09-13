package br.com.negocio.fatec;

import java.util.ArrayList;
import java.util.Map;

import br.com.modelo.fatec.Contato;

public class Relatorio {
	
	public void getServicoMaisProcurado(Map<String, Integer> map) {
		int maior=0;
		String x = null;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if(maior < entry.getValue()) {
				maior = entry.getValue();
				x = entry.getKey();
			}
		}
		System.out.println(x + "\n");
	}
	
	
	public String getServicoMaisProcuradoGenero(Map<String, Integer> map) {
		int maior=0;
		String x = null;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if(maior < entry.getValue()) {
				maior = entry.getValue();
				x = entry.getKey();
			}
		}
		return x;
	}
	
	public Integer idadeMedia(ArrayList<Contato> contatos) {
		int num = 0;
		int soma = 0;
		int total = 0;
		for (Contato contato : contatos) {
			total++;
			soma += 2018 - Integer.parseInt(contato.getData_nasc().split("/")[2]);
		}
		num = soma/total;
		return num;
	}
	
	public Integer idadeMediaGeneroM(ArrayList<Contato> contatosM) {
		int num = 0;
		int soma = 0;
		int total = 0;
		for (Contato contato : contatosM) {
			total++;
			soma += 2018 - Integer.parseInt(contato.getData_nasc().split("/")[2]);
		}
		num = soma/total;
		return num;
	}
	
	public Integer idadeMediaGeneroF(ArrayList<Contato> contatosF) {
		int num = 0;
		int soma = 0;
		int total = 0;
		for (Contato contato : contatosF) {
			total++;
			soma += 2018 - Integer.parseInt(contato.getData_nasc().split("/")[2]);
		}
		num = soma/total;
		return num;
	}
}
