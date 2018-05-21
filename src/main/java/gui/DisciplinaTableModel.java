package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Disciplina;
import patternproject.FactoryDAO;
import persistencia.Manager;

// TableModel criado para alimentar a tabela de disciplinas
public class DisciplinaTableModel extends AbstractTableModel{
	
	private String[] colunas = {"Código", "Nome"};
	private List<Disciplina> disciplinas;
	
	private final int COLUNA_CODIGO = 0;
	private final int COLUNA_NOME = 1;
	
	//Ao ser instanciado realiza a chamada para o método update
	public DisciplinaTableModel() {
		this.update();
	}
	
	// Atualiza a lista de displinas realizando uma busca no banco, e logo após atualiza a tabela chamando o
	// método fireTableDataChanged
	public void update() {
		FactoryDAO<Disciplina> fp = new FactoryDAO();
		
		Disciplina d = new Disciplina();
		
		Manager<Disciplina> turmaManager = fp.getObjectDAO(d);
		
		this.disciplinas = turmaManager.getAll();
		
		turmaManager.exit();
		
		fireTableDataChanged();
	}

	public int getColumnCount() {
		return this.colunas.length;
	}

	public int getRowCount() {
		return this.disciplinas.size();
	}
	
	public String getColumnName(int index) {
		return this.colunas[index];
	}

	public Object getValueAt(int row, int column) {
		Disciplina disciplina = this.disciplinas.get(row);
		
		switch (column) {
			case COLUNA_CODIGO:
				return disciplina.getCodigo();
			case COLUNA_NOME:
				return disciplina.getNome();
		}
		
		return null;
	}
	
	public void setValueAt(Object value, int row, int column) {
		Disciplina disciplina = this.disciplinas.get(row);
		
		switch (column) {
			case COLUNA_CODIGO:
				disciplina.setCodigo((String) value);
				break;
			case COLUNA_NOME:
				disciplina.setNome((String) value);
				break;
		}
		
		fireTableDataChanged();
	}
	
	public Disciplina getDisciplina(int index) {
		return this.disciplinas.get(index);
	}
	
}
