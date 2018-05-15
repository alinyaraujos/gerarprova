package model;
public class Questao {

	private int codigo;
	private String enunciado;
	private String nivel;
	private String[] assertivas = new String[5];

	public void cadastrar(String enunciado, String nivel, String[] assertivas, int codAssunto) {

	}

	public void atualizar(String enunciado, String nivel, String[] assertivas, int codAssunto) {

	}

	public void remover(int codigo) {

	}

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

	public String[] getAssertivas() {
		return assertivas;
	}

	public void setAssertivas(String[] assertivas) {
		this.assertivas = assertivas;
	}
	
	

}
