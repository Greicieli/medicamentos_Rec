package br.sc.senai.web.dominio;

public class Medicamento {
	private Long idMedicamento;
	private String nome;
	private Double dosagem;
	private Double intervalo;
	private Double duracao;
	
	public Long getIdMedicamento() {
		return idMedicamento;
	}
	public void setIdMedicamento(Long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getDosagem() {
		return dosagem;
	}
	
	public void setDosagem(Double dosagem) {
		this.dosagem = dosagem;
	}
	
	public Double getIntervalo() {
		return intervalo;
	}
	
	public void setIntervalo(Double intervalo) {
		this.intervalo = intervalo;
	}
	
	public Double getDuracao() {
		return duracao;
	}
	
	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}

}
