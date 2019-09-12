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
}
