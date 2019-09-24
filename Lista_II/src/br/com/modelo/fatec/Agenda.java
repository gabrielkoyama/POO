package br.com.modelo.fatec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.negocio.fatec.Controle;

public class Agenda {
	
	public Map<Pessoa, Veiculo> getDados() throws Exception {
		
		Controle ctrl 	= new Controle();
		Pessoa c 		= new Pessoa();
		Veiculo v		= new Veiculo();
	
		Map<Pessoa, Veiculo> res = new HashMap<Pessoa, Veiculo>();
		
		System.out.println("Digite o nome do cliente: ");
		c.setNome(ctrl.texto());
		
		System.out.println("Digite o telefone do cliente: ");
		c.setTelefone(ctrl.texto());
		
		System.out.println("Digite o endereço do cliente: ");
		c.setEndereco(ctrl.texto());
		
		System.out.println("Digite o CPF do cliente: ");
		c.setCpf(ctrl.texto());
		
		System.out.println("Digite o modelo do carro: ");
		v.setModelo(ctrl.texto());
		
		System.out.println("Digite a placa do carro: ");
		v.setNumero_placa(ctrl.texto());
		
		System.out.println("Digite o ano de fabricação do carro: ");
		v.setAno_fabricacao(ctrl.texto());
		
		System.out.println("Digite o valor do carro: ");
		v.setValor(ctrl.texto());
		
		res.put(c,v);
		
		return res;
	}
	
	public void remover(ArrayList<Pessoa> contatos) throws IOException {
		Controle ctrl 		= new Controle();
		Pessoa remove 		= new Pessoa();
		boolean found 		= false;
		String nome;
		
		System.out.println("Digite o nome do contato que deseja remover: ");
		nome = ctrl.texto();
		
		for (Pessoa contato : contatos) {
			if(contato.getNome().contains(nome)) {
				found = true;
				System.out.println("Encontrado! \n");
				System.out.println(contato.All());
				System.out.println("Tem certeza que deseja remover " + contato.getNome() + " dos seus contato?[S/N]");
				String confirm = ctrl.texto();
				if(confirm.contains("s") || confirm.contains("S")) {
					System.out.println("Removido com sucesso!");
					remove = contato;
				}
			}
		}
		if(!found) System.out.println("Contato nao encontrado");
		contatos.remove(remove);
		ctrl.salvarLista(contatos);
	
	}
	
	public void listar(ArrayList<Pessoa> contatos) {
		for (Pessoa contato : contatos) {
			System.out.println(contato.All() + "\n");
		}
	}
	
//	public void editar(ArrayList<Pessoa> contatos) throws Exception {
//		Controle ctrl 		= new Controle();
//		boolean found 		= false;
//		String nome;
//		Agenda agenda = new Agenda();
//		System.out.println("Digite o nome do contato que deseja editar: ");
//		nome = ctrl.texto();
//		for (Pessoa contato : contatos) {
//			if(contato.getNome().contains(nome)) {
//				found = true;
//				System.out.println("Encontrado! \n");
//				System.out.println(contato.All());
//				System.out.println("Tem certeza que deseja editar " + contato.getNome() + "?[S/N]");
//				String confirm = ctrl.texto();
//				if(confirm.contains("s") || confirm.contains("S")) {
//					contatos.set(contatos.indexOf(contato), agenda.getContato());
//					System.out.println("Editado com sucesso!");
//				}
//			}
//		}
//		if(!found) System.out.println("Contato nao encontrado");
//		
////		VERIFICACAO
////		for (Contato contato : contatos) {
////			System.out.println(contato.All());
////		}
//		
//		ctrl.salvarLista(contatos);
//	}

}