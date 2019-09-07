package br.com.negocio.fatec;

public class Menu {
	public void boasVindas() {
		System.out.println("Bem vindo a melhor agenda do mundo!");
	}
	public void menu() {
		System.out.println("### Menu ###");
		System.out.println("1 - Inserir contato");
		System.out.println("2 - Listar contatos");
		System.out.println("3 - Editar contato");
		System.out.println("4 - Excluir contato");
		System.out.println("5 - Relatorio");
		System.out.println("0 - Sair");
	}
	
	public void relatorio() {
		System.out.println("1 - Relatorio - Idade media");
		System.out.println("2 - Relatorio - Idade media por genero");
		System.out.println("3 - Relatorio - Servico mais procurado???");
		System.out.println("4 - Relatorio - Servico mais procurado por genero???");
	}
	
	public void listar() {
		System.out.println("1 - Apenas listar contatos");
		System.out.println("2 - Listar em ordem alfabetica");
		System.out.println("3 - Listar por genero em ordem alfabetica");
	}
}