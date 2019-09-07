package br.com.sistema.fatec;

import br.com.modelo.fatec.Agenda;
import br.com.negocio.fatec.Controle;
import br.com.negocio.fatec.Menu;

public class App {
	public static void main(String[] args) {
		int opc = 100;
		Menu m = new Menu();
		Agenda agenda = new Agenda();
		m.boasVindas();
		
		while(opc != 0) {
			m.menu();
			Controle ctrl = new Controle();
			opc = ctrl.opcao();
			if(opc == 1) {
				agenda.inserirContato();
			}
			if(opc == 2) {
				agenda.listarContato();
			}
		}	
	}
}
