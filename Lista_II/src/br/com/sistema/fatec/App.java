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
import br.com.modelo.fatec.Veiculo;
import br.com.negocio.fatec.Controle;
import br.com.negocio.fatec.Menu;

public class App {
	public static void main(String[] args) throws Exception {
			
		Agenda agenda;
		Menu menu = new Menu();	
		Controle ctrl = new Controle();
		Controle x;

		int opc = 999;
		while(opc != 0) {
			menu.menu();
			opc = ctrl.opcao();
			switch(opc) {
				case 1:
					menu.common();
					x = new Controle();
					switch(x.opcao()) {
						case 1:
							agenda = new Agenda();
							Pessoa p = new Pessoa();
							Map<Pessoa, Veiculo> dados = new HashMap<Pessoa, Veiculo>();
							dados = agenda.getDados();
							
							dados.get(p);
							System.out.println();
							
							System.out.println("cadastrar");
							break;
						case 2:
							System.out.println("listar");
							break;
						}
					break;
				case 2:
					menu.common();
					break;
				case 3:
					menu.servico();
					break;
				case 4:
					System.out.println("relatorio");
					break;
			}
		}
	}
}