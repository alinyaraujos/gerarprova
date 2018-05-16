package model;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "prova")
public class Prova {

	private int codigo;
	private String nome;
	private String codTurma;
	private ArrayList<Questao> questoes;

	public void cadastrar(int codigo, String nome, String codTurma, ArrayList<Questao> questoes) {
		this.codigo	  = codigo;
		this.nome 	  = nome; 
		this.codTurma = codTurma;
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
	
	@Id
	@Column(name = "codigo")
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Column(name="apelido")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Transient
	public ArrayList<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(ArrayList<Questao> questoes) {
		this.questoes = questoes;
	}

	@Column(name="turma_codigo")
	public String getCodTurma() {
		return codTurma;
	}

	public void setCodTurma(String codTurma) {
		this.codTurma = codTurma;
	}
	
}
