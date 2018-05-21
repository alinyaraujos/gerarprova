package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Questao;
import model.Turma;
import patternproject.FactoryDAO;
import persistencia.Manager;

public class TurmaTableModel extends AbstractTableModel{
	
	private String[] colunas = {"Código", "Ano", "Semestre"};
	private List<Turma> turmas;
	
	private final int COLUNA_CODIGO = 0;
	private final int COLUNA_ANO = 1;
	private final int COLUNA_SEMESTRE = 2;
	
	public TurmaTableModel() {
		this.update();
	}
	
	public void update() {
		FactoryDAO<Turma> fp = new FactoryDAO();
		
		Turma t = new Turma();
		
		Manager<Turma> turmaManager = fp.getObjectDAO(t);
		
		this.turmas = turmaManager.getAll();
		
		turmaManager.exit();
		
		fireTableDataChanged();
	}

	public int getColumnCount() {
		return this.colunas.length;
	}

	public int getRowCount() {
		return this.turmas.size();
	}
	
	public String getColumnName(int index) {
		return this.colunas[index];
	}

	public Object getValueAt(int row, int column) {
		Turma turma = this.turmas.get(row);
		
		switch (column) {
			case COLUNA_CODIGO:
				return turma.getCodigo();
			case COLUNA_ANO:
				return turma.getAno();
			case COLUNA_SEMESTRE:
				return turma.getSemestre();
		}
		
		return null;
	}
	
	public void setValueAt(Object value, int row, int column) {
		Turma turma = this.turmas.get(row);
		
		switch (column) {
			case COLUNA_CODIGO:
				turma.setCodigo((String) value);
				break;
			case COLUNA_ANO:
				turma.setAno((Integer) value);
				break;
			case COLUNA_SEMESTRE:
				turma.setSemestre((String) value);
				break;
		}
		
		fireTableDataChanged();
	}
	
	public Turma getTurma(int index) {
		return this.turmas.get(index);
	}
	
}
