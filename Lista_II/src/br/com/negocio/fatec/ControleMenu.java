package br.com.negocio.fatec;

import java.io.IOException;

import br.com.modelo.fatec.Manutencao;
import br.com.modelo.fatec.Pessoa;
import br.com.modelo.fatec.Revisao;
import br.com.modelo.fatec.Veiculo;

public class ControleMenu {
	
	ControleUtils optionSubMenu;
	
	public void menu() {
		System.out.println("### Menu ###");
		System.out.println("1 - Clientes");
		System.out.println("2 - Veiculos");
		System.out.println("3 - Revisão");
		System.out.println("4 - Manutenção");
		System.out.println("5 - Relatorio de Servicos");
		System.out.println("0 - Sair");
	}
	
	public void subMenuClientes() throws IOException {
		this.commonActions();
		optionSubMenu = new ControleUtils();
		ControlePessoa controlePessoa = new ControlePessoa();
		switch (optionSubMenu.opcao()) {
			case 1:
				controlePessoa.save(controlePessoa.getPessoa());
				break;
			case 2:
				for (Pessoa pessoa: ControlePessoa.pessoasCadastradas) System.out.println(pessoa.toString());
				break;
		}
	}
	
	public void subMenuVeiculos() throws IOException {
		this.commonActions();
		optionSubMenu = new ControleUtils();
		ControleVeiculo controleVeiculo = new ControleVeiculo();
		switch (optionSubMenu.opcao()) {
			case 1:
				controleVeiculo.save(controleVeiculo.getVeiculo());
				break;
			case 2:
				for (Veiculo veiculo: ControleVeiculo.veiculosCadastrados) System.out.println(veiculo.toString());
				break;
		}
	}
	
	public void subMenuRevisao() throws IOException {
		this.commonServiceAction();
		optionSubMenu = new ControleUtils();
		ControleServicoRevisao controleVeiculoServicos = new ControleServicoRevisao(); 
		switch (optionSubMenu.opcao()) {
			case 1:
				controleVeiculoServicos.agendarRevisao(controleVeiculoServicos.getRevisaoInput());
				break;
			case 2:
					for (Revisao revisao : ControleServicoRevisao.revisoesCadastradas) 
						if(!revisao.getStatus().contains("0")) System.out.println(revisao.toString());
				break;
			case 3: 
				controleVeiculoServicos.editDataAgendamento();
				break;
			case 4:
				controleVeiculoServicos.cancelarAgendamento();
				break;
		}
	}
	
	public void subMenuManutencao() throws IOException {
		this.commonServiceAction();
		optionSubMenu = new ControleUtils();
		ControleServicoManutencao controleServicoManutencao = new ControleServicoManutencao();
		switch (optionSubMenu.opcao()) {
			case 1:
				controleServicoManutencao.agendarManutencao(controleServicoManutencao.getManutencaoInput());
				break;
			case 2:
				for (Manutencao manutencao: ControleServicoManutencao.manutencoesCadastradas)
					if(!manutencao.getStatus().contains("0")) System.out.println(manutencao.toString());
				break;
			case 3: 
				controleServicoManutencao.editDataManutencao();
				break;
			case 4:
				controleServicoManutencao.cancelarManutencao();
				break;
		}
	}
	
	public void commonActions() {
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
	}

	public void commonServiceAction() {
		System.out.println("1 - Agendamento");
		System.out.println("2 - Listar");
		System.out.println("3 - Alterar data de Agendamento");
		System.out.println("4 - Cancelamento");
	}
	
}