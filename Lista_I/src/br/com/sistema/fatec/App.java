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
import br.com.modelo.fatec.Contato;
import br.com.modelo.fatec.Servico;
import br.com.negocio.fatec.Controle;
import br.com.negocio.fatec.ControleServico;
import br.com.negocio.fatec.Menu;
import br.com.negocio.fatec.Relatorio;

public class App {
	public static void main(String[] args) throws Exception {
			
		ControleServico cs 						= new ControleServico();
		ArrayList<Servico> servicos 			= new ArrayList<Servico>();
		
		Menu menu 								= new Menu();
		Agenda agenda 							= new Agenda();	
		ArrayList<Contato> contatos 			= new ArrayList<Contato>();
		ArrayList<Contato> contatosOrdenados 	= new ArrayList<Contato>();
		Controle ctrl 							= new Controle();
		Contato ctt 							= new Contato();
		Controle x;	
		contatos = ctrl.init();
		servicos = cs.init();
		
//		Separando por genero
		ArrayList<Contato> listaAuxM = new ArrayList<Contato>();
		for (Contato contato : contatos) if(contato.getGenero().toUpperCase().contains("M")) listaAuxM.add(contato);
		
		
//		Separando por genero
		ArrayList<Contato> listaAuxF = new ArrayList<Contato>();
		for (Contato contato : contatos) if(contato.getGenero().toUpperCase().contains("F")) listaAuxF.add(contato);
//		
//		
////		ORDENANDO -- DEPOIS TIRAR DAQUI - e melhorar a funcao 
		ArrayList<String> listaAux = new ArrayList<String>(); 
		for (Contato contato : contatos) listaAux.add(contato.getNome());
		
		
		Collections.sort(listaAux);
		for (String nome : listaAux) for (Contato z : contatos) if(z.getNome() == nome) contatosOrdenados.add(z);

//		for (Servico servico : servicos) {
//			System.out.println(servico.list());
//		}
		
//		int opc = 0;
		int opc = 99;
		while(opc != 0) {
			contatos = ctrl.init();
			servicos = cs.init();
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
							for (Contato c : contatosOrdenados) {
								System.out.println(c.All() + "\n");
							}
							break;
						case "3":
							System.out.println("Masculino:\n");
							for (Contato contato : listaAuxM) {
								System.out.println(contato.All());
							}
							System.out.println();
							
							System.out.println("Feminino:\n");
							for (Contato contato : listaAuxF) {
								System.out.println(contato.All());
							}
							System.out.println();
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
					Relatorio relatorio = new Relatorio();
					x = new Controle();
					switch (x.texto()) {
						case "1":
							try {
								System.out.println("\n" + relatorio.idadeMedia(contatos) + "\n");								
							} catch (Exception e) {
								System.out.println("Formato de data de nascimento errada");
							}
							break;
						case "2":
							try {
								System.out.println("Masculino: " + relatorio.idadeMedia(listaAuxM) + "\n");
								System.out.println("Feminino: " + relatorio.idadeMedia(listaAuxF) + "\n");
								
							} catch (Exception e) {
								System.out.println("Formato de data de nascimento errada");
							}
							break;
						case "3":
							relatorio.getServicoMaisProcurado(ctrl.getContServicos());
							break;
						case "4":
							ctrl.contatosPorGenero(contatos);
							break;
					}
					break;
				case 6:
					menu.servicosSubMenu();
					x = new Controle();
					switch (x.texto()) {
					case "1":
						cs.listar(servicos);
						break;
					case "2":
						cs.salvar(cs.getServicoInput(contatos));						
						break;
					}
				break;
			}
		}
	}
}