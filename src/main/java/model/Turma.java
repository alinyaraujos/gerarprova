package model;
import javax.persistence.*;

@Entity
@Table(name = "turma")
public class Turma {
	
	private int ano;
	private String semestre;
	private String codigo;
	private String cpfProfessor;

	public void cadastrar(String codigo, int ano, String semestre, String cpfProfessor) {
		this.codigo=codigo;
		this.ano=ano;
		this.semestre=semestre;
		this.cpfProfessor=cpfProfessor;
	}

	public void atualizar(String codigo, int ano, String semestre, String cpfProfessor) {

	}

	public void remover(String codigo) {

	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	@Column(name = "cpf_professor")
	public String getCpfProfessor() {
		return cpfProfessor;
	}

	public void setCpfProfessor(String cpfProfessor) {
		this.cpfProfessor = cpfProfessor;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	@Id
	@Column(name = "codigo")
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return this.codigo;
	}
}
