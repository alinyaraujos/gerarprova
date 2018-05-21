package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Questao;
import model.Turma;
import model.Aluno;
import model.Assunto;
import model.Disciplina;
import patternproject.FactoryDAO;
import persistencia.AlunoDAO;
import persistencia.AssuntoDAO;
import persistencia.Manager;

public class AssuntoTableModel extends AbstractTableModel{
	
	private String[] colunas = {"Código", "Nome", "Disciplina"};
	private List<Assunto> assuntos;
	
	private final int COLUNA_CODIGO = 0;
	private final int COLUNA_NOME = 1;
	private final int COLUNA_DISCIPLINA = 2;
	
	public AssuntoTableModel() {
		this.update();
	}
	
	public void update() {
		FactoryDAO<Assunto> fp = new FactoryDAO();
		
		Assunto a = new Assunto();
		
		Manager<Assunto> assuntoManager = fp.getObjectDAO(a);
		this.assuntos =  ((AssuntoDAO) assuntoManager).getAll();
		assuntoManager.exit();
		
		fireTableDataChanged();
	}

	public int getColumnCount() {
		return this.colunas.length;
	}

	public int getRowCount() {
		return this.assuntos.size();
	}
	
	public String getColumnName(int index) {
		return this.colunas[index];
	}

	public Object getValueAt(int row, int column) {
		Assunto assunto = this.assuntos.get(row);
		
		switch (column) {
			case COLUNA_CODIGO:
				return assunto.getCodigo();
			case COLUNA_NOME:
				return assunto.getNome();
			case COLUNA_DISCIPLINA:
				return assunto.getCodDisciplina();
		}
		
		return null;
	}
	
	public void setValueAt(Object value, int row, int column) {
		Assunto assunto = this.assuntos.get(row);
		
		switch (column) {
			case COLUNA_CODIGO:
				assunto.setCodigo((Integer) value);
				break;
			case COLUNA_NOME:
				assunto.setNome((String) value);
				break;
			case COLUNA_DISCIPLINA:
				assunto.setCodDisciplina((String) value);
				break;
		}
		
		fireTableDataChanged();
	}
	public Assunto getAssunto(int index) {
		return this.assuntos.get(index);
	}
}
