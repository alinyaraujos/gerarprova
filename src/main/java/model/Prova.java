package model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "prova")
public class Prova {

	private int codigo;
	private String nome;
	private String codTurma;
	private List<Questao> questoes;
	
	public void cadastrar(String nome, String codTurma) {
		this.nome 	  = nome; 
		this.codTurma = codTurma;
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
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
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
