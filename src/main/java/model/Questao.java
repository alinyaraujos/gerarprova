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
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Column(name="enunciado")
	public String getEnunciado() {
		return this.enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	@Column(name="nivel")
	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Column(name="assertiva_a")
	public String getAssertivaA() {
		return this.assertivaA;
	}

	public void setAssertivaA(String assertivaA) {
		this.assertivaA = assertivaA;
	}

	@Column(name="assertiva_b")
	public String getAssertivaB() {
		return this.assertivaB;
	}

	public void setAssertivaB(String assertivaB) {
		this.assertivaB = assertivaB;
	}
	
	@Column(name="assertiva_c")
	public String getAssertivaC() {
		return this.assertivaC;
	}

	public void setAssertivaC(String assertivaC) {
		this.assertivaC = assertivaC;
	}

	@Column(name="assertiva_d")
	public String getAssertivaD() {
		return this.assertivaD;
	}

	public void setAssertivaD(String assertivaD) {
		this.assertivaD = assertivaD;
	}

	@Column(name="assertiva_e")
	public String getAssertivaE() {
		return this.assertivaE;
	}

	public void setAssertivaE(String assertivaE) {
		this.assertivaE = assertivaE;
	}

	@Column(name="cod_assunto")
	public int getCodAssunto() {
		return this.codAssunto;
	}

	public void setCodAssunto(int codAssunto) {
		this.codAssunto = codAssunto;
	}

	@Column(name="gabarito")
	public String getGabarito() {
		return this.gabarito;
	}

	public void setGabarito(String gabarito) {
		this.gabarito = gabarito;
	}

	@Override
	public String toString() {
		return "Questao [codigo=" + codigo + ", enunciado=" + enunciado + ", nivel=" + nivel + ", gabarito=" + gabarito
				+ ", assertivaA=" + assertivaA + ", assertivaB=" + assertivaB + ", assertivaC=" + assertivaC
				+ ", assertivaD=" + assertivaD + ", assertivaE=" + assertivaE + ", codAssunto=" + codAssunto + "]";
	}

}
