package model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "prova_contem_questoes")
public class ProvaQuestao {
	
	
	private int questoesCodigo;
	private int provaCodigo;
	
	public void cadastrar(int questoesCodigo, int provaCodigo) {
		this.questoesCodigo=questoesCodigo;
		this.provaCodigo=provaCodigo;
	}

	public void atualizar(String nome, List<Questao> questoes) {

	}

	public void remover(String codigo) {

	}
	
	public List<Questao> sortearQuestoes() {
		return null;
	}

	public List<Questao> listarQuestoes() {
		return null;
	}
	
	@Id
	@Column(name = "questoes_codigo")
	public int getQuestoesCodigo() {
		return questoesCodigo;
	}

	public void setQuestoesCodigo(int questoesCodigo) {
		this.questoesCodigo = questoesCodigo;
	}

	@Column(name = "prova_codigo")
	public int getProvaCodigo() {
		return provaCodigo;
	}

	public void setProvaCodigo(int provaCodigo) {
		this.provaCodigo = provaCodigo;
	}
	
	

}
