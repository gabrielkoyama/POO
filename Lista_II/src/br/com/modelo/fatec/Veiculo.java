package br.com.modelo.fatec;

public class Veiculo {
	protected String numero_placa;
	protected String modelo;
	protected String ano_fabricacao;
	protected String valor;
	
	public String getNumero_placa() {
		return numero_placa;
	}
	public void setNumero_placa(String numero_placa) {
		this.numero_placa = numero_placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAno_fabricacao() {
		return ano_fabricacao;
	}
	public void setAno_fabricacao(String ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
}
