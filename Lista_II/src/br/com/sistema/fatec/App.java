package br.com.sistema.fatec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import br.com.modelo.fatec.Agenda;
import br.com.modelo.fatec.Pessoa;
import br.com.negocio.fatec.Controle;
import br.com.negocio.fatec.Menu;

public class App {
	public static void main(String[] args) throws Exception {
			
		Menu menu 							= new Menu();
		Agenda agenda 						= new Agenda();	
		ArrayList<Pessoa> contatos 		= new ArrayList<Pessoa>();
		ArrayList<Pessoa> contatosM 		= new ArrayList<Pessoa>();
		ArrayList<Pessoa> contatosF 		= new ArrayList<Pessoa>();
		Controle ctrl 						= new Controle();
		Controle x;
		contatos = ctrl.init();
		ArrayList<String> nomes 			= new ArrayList<String>();
		
		Map<String, Pessoa> contatosMap = new HashMap<String, Pessoa>(); 
		contatosMap = ctrl.getContatosMap();
				
		for (Entry<String, Pessoa> entry : contatosMap.entrySet()) {
//		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		    nomes.add(entry.getValue().getNome());
		}
		
		Collections.sort(nomes);
		System.out.println(nomes);
		

		int opc = 999;
		while(opc != 0) {
			contatos = ctrl.init();
			menu.menu();
			opc = ctrl.opcao();
			switch(opc) {
				case 1:
					ctrl.salvar(agenda.getContato());
					break;
				case 2:
					menu.listar();
					x = new Controle();
					switch (x.texto()) {
						case "1":
							agenda.listar(contatos);
							break;
						case "2":
							System.out.println("\n\n\t\tTODO\n\n");
							break;
						case "3":
							System.out.println("\n\n\t\tTODO\n\n");
							break;
					}
					break;
				case 3:
					agenda.editar(contatos);
					break;
				case 4:
					agenda.remover(contatos);
					break;
				case 5:
					menu.relatorio();
					x = new Controle();
					switch (x.texto()) {
						case "1":
							System.out.println("\n\n\t\tTODO\n\n");
							break;
						case "2":
							System.out.println("\n\n\t\tTODO\n\n");
							break;
						case "3":
							System.out.println("\n\n\t\tTODO\n\n");
							break;
						case "4":
							System.out.println("\n\n\t\tTODO\n\n");
							break;
					}
					break;
			}
		}
	}
}








// TESTES 


//ArrayList<Contato> teste = new ArrayList<Contato>();
//Contato c = new Contato();
//
//Contato remove = new Contato();
//
//
//Contato editOld = new Contato();
//Contato editNew= new Contato();
//
//c.setNome("Gabriel");
//c.setTelefone("23123123");
//c.setData_nasc("adsad");
//c.setGenero("a");
//
//teste.add(c);
//
//for (Contato contato : teste) {
//	remove = contato;
//}
//
////removendo
////teste.remove(remove);
//
//for (Contato contato : teste) {
//	System.out.println(contato.All());			
//}
//
//System.out.println("\n\n");
//
//
////editando
//for (Contato contato : teste) {
//	editNew.setNome("asds");
//	editNew.setData_nasc("asasds");
//	editNew.setTelefone("asdsad");
//	editNew.setGenero("asd");
//	teste.set(teste.indexOf(contato), editNew);
//}
//
//for (Contato contato : teste) {
//	System.out.println(contato.All());			
//}
//







































