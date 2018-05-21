package model;

import javax.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno {

	private int matricula;
	private String nome;
	private String codTurma;

	public void cadastrar(int matricula, String nome, String codTurma) {
		this.matricula = matricula;
		this.nome	   = nome;
		this.codTurma  = codTurma;
	}

	public void atualizar(int matricula, String nome, String codTurma) {

	}

	public void remover(int matricula) {

	}
	
	@Id
	@Column(name="matricula")
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="cod_turma")
	public String getCodTurma() {
		return codTurma;
	}

	public void setCodTurma(String codTurma) {
		this.codTurma = codTurma;
	}
	
	

}
