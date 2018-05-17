package model;

import javax.persistence.*;

@Entity
@Table(name = "assunto")
public class Assunto {

	
	private int codigo;
	private String nome;
	private String codDisciplina;

	public void cadastrar(String nome, String codDisciplina) {
		this.nome=nome;
		this.codDisciplina=codDisciplina;
	}

	public void atualizar(String nome, String codDisciplina) {

	}

	public void remover(int codigo) {

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name="cod_disciplina")
	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}
