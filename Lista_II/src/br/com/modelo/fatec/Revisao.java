package br.com.modelo.fatec;

public class Revisao {

	public Pessoa pessoa;
	public Veiculo veiculo;
	public String data;
	public String status; //1: ok, 2: cancelado
	
	public String toString() {
		
		String p = pessoa.toString() + "\n";
		String v = veiculo.toString() + "\n";
		String d = "Data de Agendamento: " + this.getData() + "\n";
		
		return p+v+d;		
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
}
