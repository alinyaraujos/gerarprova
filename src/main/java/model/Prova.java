package model;

import java.util.ArrayList;

public class Prova {

	private String codigo;
	private String nome;
	private ArrayList<Questao> questoes;

	public void cadastrar(String nome, ArrayList<Questao> questoes) {

	}

	public void atualizar(String nome, ArrayList<Questao> questoes) {

	}

	public void remover(String codigo) {

	}

	//public File gerarProva() {
		//return null;
	//}

	public ArrayList<Questao> sortearQuestoes() {
		return null;
	}

	public ArrayList<Questao> listarQuestoes() {
		return null;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(ArrayList<Questao> questoes) {
		this.questoes = questoes;
	}
	
	

}
