package model;

import javax.persistence.*;

@Entity
@Table(name="questao")
public class Questao {

	private int codigo;
	private String enunciado;
	private String nivel;
	private String gabarito;
	private String assertivaA;
	private String assertivaB;
	private String assertivaC;
	private String assertivaD;
	private String assertivaE;
	private int codAssunto;

	public void cadastrar(int codigo, String enunciado, String nivel, String gabarito, String[] assertivas, int codAssunto) {
		this.codigo = codigo;
		this.enunciado = enunciado;
		this.nivel = nivel;
		this.gabarito = gabarito;
		this.assertivaA = assertivas[0];
		this.assertivaB = assertivas[1];
		this.assertivaC = assertivas[2];
		this.assertivaD = assertivas[3];
		this.assertivaE = assertivas[4];
		this.codAssunto = codAssunto;
	}

	public void atualizar(String enunciado, String nivel, String[] assertivas, int codAssunto) {

	}

	public void remover(int codigo) {

	}
	
	@Id
	@Column(name="codigo")
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Column(name="assertiva_a")
	public String getAssertivaA() {
		return assertivaA;
	}

	public void setAssertivaA(String assertivaA) {
		this.assertivaA = assertivaA;
	}

	@Column(name="assertiva_c")
	public String getAssertivaB() {
		return assertivaB;
	}

	public void setAssertivaB(String assertivaB) {
		this.assertivaB = assertivaB;
	}
	
	@Column(name="assertiva_c")
	public String getAssertivaC() {
		return assertivaC;
	}

	public void setAssertivaC(String assertivaC) {
		this.assertivaC = assertivaC;
	}

	@Column(name="assertiva_d")
	public String getAssertivaD() {
		return assertivaD;
	}

	public void setAssertivaD(String assertivaD) {
		this.assertivaD = assertivaD;
	}

	@Column(name="assertiva_e")
	public String getAssertivaE() {
		return assertivaE;
	}

	public void setAssertivaE(String assertivaE) {
		this.assertivaE = assertivaE;
	}

	@Column(name="cod_assunto")
	public int getCodAssunto() {
		return codAssunto;
	}

	public void setCodAssunto(int codAssunto) {
		this.codAssunto = codAssunto;
	}

}
