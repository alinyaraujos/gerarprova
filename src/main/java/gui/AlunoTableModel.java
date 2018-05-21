package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Questao;
import model.Turma;
import model.Aluno;
import model.Disciplina;
import patternproject.FactoryDAO;
import persistencia.AlunoDAO;
import persistencia.AssuntoDAO;
import persistencia.Manager;

public class AlunoTableModel extends AbstractTableModel{
	
	private String[] colunas = {"Matricula", "Nome", "Codigo da Turma"};
	private List<Aluno> alunos;
	
	private final int COLUNA_MATRICULA = 0;
	private final int COLUNA_NOME = 1;
	private final int COLUNA_COD_TURMA = 2;
	
	public AlunoTableModel(Object t) {
		this.update(t);
	}
	
	public void update(Object t) {
		FactoryDAO<Aluno> fp = new FactoryDAO();
		
		Aluno a = new Aluno();
		
		Manager<Aluno> alunoManager = fp.getObjectDAO(a);
		this.alunos =  ((AlunoDAO) alunoManager).getByTurma((Turma)t);
		alunoManager.exit();
		
		fireTableDataChanged();
	}

	public int getColumnCount() {
		return this.colunas.length;
	}

	public int getRowCount() {
		return this.alunos.size();
	}
	
	public String getColumnName(int index) {
		return this.colunas[index];
	}

	public Object getValueAt(int row, int column) {
		Aluno Aluno = this.alunos.get(row);
		
		switch (column) {
			case COLUNA_MATRICULA:
				return Aluno.getMatricula();
			case COLUNA_NOME:
				return Aluno.getNome();
			case COLUNA_COD_TURMA:
				return Aluno.getCodTurma();
		}
		
		return null;
	}
	
	public void setValueAt(Object value, int row, int column) {
		Aluno Aluno = this.alunos.get(row);
		
		switch (column) {
			case COLUNA_MATRICULA:
				Aluno.setMatricula((Integer) value);
				break;
			case COLUNA_NOME:
				Aluno.setNome((String) value);
				break;
			case COLUNA_COD_TURMA:
				Aluno.setCodTurma((String) value);
				break;
		}
		
		fireTableDataChanged();
	}
	public Aluno getAluno(int index) {
		return this.alunos.get(index);
	}
}
