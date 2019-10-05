package br.com.negocio.fatec;

import java.io.IOException;

import br.com.modelo.fatec.Manutencao;
import br.com.modelo.fatec.Revisao;

public class ControleRelatorio {

	public ControleRelatorio() throws IOException {
		new ControleServicoRevisao();
		new ControleServicoManutencao();
	}
	
	
	
	public void relatorioServicos() {
		for (Revisao revisao : ControleServicoRevisao.revisoesCadastradas) 
			System.out.println(revisao.toString());
		
		for (Manutencao manuntencao: ControleServicoManutencao.manutencoesCadastradas) 
			System.out.println(manuntencao.toString());
	}

}
