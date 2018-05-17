package model;

import javax.persistence.*;

@Entity
@Table(name = "professor")
public class Professor {
	
	private String cpf;
	private String nome;
	private String email;
	private String instituicao;

	public void cadastrar(String cpf, String nome, String email, String instituicao) {
		this.cpf 			= cpf;
		this.nome 			= nome;
		this.email 			= email;
		this.instituicao 	= instituicao;
	}

	public void atualizar(String cpf, String nome, String email, String instituicao) {

	}

	public void remover(String cpf) {

	}
	
	@Id
	@Column(name = "cpf")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	@Override
	public String toString() {
		return "Professor [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", instituicao=" + instituicao + "]";
	}
	
	

}
