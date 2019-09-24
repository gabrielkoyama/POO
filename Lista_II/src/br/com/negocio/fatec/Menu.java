package br.com.negocio.fatec;

public class Menu {
	public void boasVindas() {
		System.out.println("Bem vindo a melhor agenda do mundo!");
	}
	public void menu() {
		System.out.println("### Menu ###");
		System.out.println("1 - Pessoa");
		System.out.println("2 - Veiculo");
		System.out.println("3 - Servicos");
		System.out.println("4 - Relatorio");
		System.out.println("0 - Sair");
	}
	
	public void common() {
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
	}
	
	public void servico() {
		System.out.println("1 - Agendar revisão");
		System.out.println("2 - Agendar manutenção");
	}
}