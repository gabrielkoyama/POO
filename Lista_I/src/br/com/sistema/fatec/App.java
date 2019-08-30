package br.com.sistema.fatec;

import br.com.modelo.fatec.Agenda;
import br.com.modelo.fatec.Contato;
import br.com.negocio.fatec.Controle;
import br.com.negocio.fatec.Menu;

public class App {
	public static void main(String[] args) throws Exception {
		Menu m 			= new Menu();
		Agenda ag 		= new Agenda();
		Controle ctrl 	= new Controle();

		m.boasVindas();
		
		int opc = 999;
		while(opc != 0) {
			m.menu();
			opc = ctrl.opcao();
			switch(opc) {
				case 1:
					ag.inserirContato();
					break;
				case 2:
					ctrl.listar();
					break;
				case 3:
					ag.remover();
					break;
			}
		}
	}
}







































