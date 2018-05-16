package model;

import javax.persistence.*;

@Entity
@Table(name = "disciplina")
public class Disciplina {

	private String codigo;
	private String nome;
	private String cpfProfessor;

	public void cadastrar(String codigo, String nome, String cpfProfessor) {
		this.codigo			=codigo;
		this.nome			=nome;
		this.cpfProfessor	=cpfProfessor;
	}

	public void atualizar(String codigo, String nome, String cpfProfessor) {

	}

	public void remover(String codigo) {

	}
	@Id
	@Column(name = "codigo")
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

	@Column(name = "cpf_professor")
	public String getCpfProfessor() {
		return cpfProfessor;
	}

	public void setCpfProfessor(String cpfProfessor) {
		this.cpfProfessor = cpfProfessor;
	}

}
