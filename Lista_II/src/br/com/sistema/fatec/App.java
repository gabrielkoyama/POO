package br.com.sistema.fatec;

import br.com.negocio.fatec.ControleUtils;
import br.com.negocio.fatec.ControleMenu;
import br.com.negocio.fatec.ControleRelatorio;

public class App {
	public static void main(String[] args) throws Exception {
			
		ControleMenu menu = new ControleMenu();	
		ControleUtils ctrl = new ControleUtils();
	
		int opc = 9;
		while(opc != 0) {
			menu.menu();
			opc = ctrl.opcao();
			switch(opc) {
				case 1:
					menu.subMenuClientes();
					break;
				case 2:
					menu.subMenuVeiculos();
					break;
				case 3:
					menu.subMenuRevisao();
					break;
				case 4:
					menu.subMenuManutencao();
					break;
				case 5:
					ControleRelatorio controleRelatorio = new ControleRelatorio();
					controleRelatorio.relatorioServicos();
					break;
			}
		}
	}
}