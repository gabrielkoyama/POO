package br.com.sistema.fatec;

import java.util.ArrayList;
import java.util.Collections;

import br.com.modelo.fatec.Agenda;
import br.com.modelo.fatec.Contato;
import br.com.modelo.fatec.Servico;
import br.com.negocio.fatec.Controle;
import br.com.negocio.fatec.ControleServico;
import br.com.negocio.fatec.Menu;
import br.com.negocio.fatec.Relatorio;

public class App {
	public static void main(String[] args) throws Exception {
			
		ControleServico cs 							= new ControleServico();
		ArrayList<Servico> servicos 				= new ArrayList<Servico>();
		ArrayList<Contato> contatos 				= new ArrayList<Contato>();
		Menu menu 									= new Menu();
		Agenda agenda 								= new Agenda();	
		Controle ctrl 								= new Controle();
		Controle x;	
		servicos = cs.init();
		contatos = ctrl.init();
		
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
							for (Contato contato : ctrl.ordena(contatos, "all")) {
								System.out.println(contato.All() + "\n");
							}
							break;
						case "3":
							System.out.println("Masculino:\n");
							for (Contato contato : ctrl.ordena(contatos, "m")) {
								System.out.println(contato.All());
							}
							System.out.println();
							
							System.out.println("Feminino:\n");
							for (Contato contato : ctrl.ordena(contatos, "f")) {
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
								System.out.println("Masculino: " + relatorio.idadeMedia(ctrl.ordena(contatos, "m")) + "\n");
								System.out.println("Feminino: " + relatorio.idadeMedia(ctrl.ordena(contatos, "f")) + "\n");
								
							} catch (Exception e) {
								System.out.println("Formato de data de nascimento errada");
							}
							break;
						case "3":
//							relatorio.getServicoMaisProcurado(ctrl.getContServicos());
							break;
						case "4":
//							ctrl.contatosPorGenero(contatos);
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