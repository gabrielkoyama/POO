package sistema;
import modelo.Pessoa;
import pacote.Controle;
import pacote.ControlePessoa;
import pacote.Menu;

public class App {

	public static void main(String[] args) throws Exception {
		ControlePessoa c 	= new ControlePessoa();
		Controle ctrl 		= new Controle();
		Pessoa p 			= new Pessoa();
		Menu menu 			= new Menu();
		
		
		int opcao = 999;
		while(opcao != 0) {
			menu.menu();
			opcao = ctrl.opcao();
			
			if(opcao == 1) {
				p = c.getPessoa();
				c.salvar(p);
			}
		}
	}

}
