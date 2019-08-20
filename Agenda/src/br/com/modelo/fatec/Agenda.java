package br.com.modelo.fatec;

import java.util.ArrayList;
import java.util.List;

import br.com.negocio.fatec.Controle;

public class Agenda {
	public List<Contato> contatos = new ArrayList<Contato>();
	
	public void listarContato() {
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
		}
	}
	
	public void inserirContato() {
		System.out.println("Por favor, digite um nome para o contato");
		Controle ctrl = new Controle();
		Contato c = new Contato(ctrl.texto());
		contatos.add(c);
	}
}
