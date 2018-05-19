package gui;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import model.Turma;
import patternproject.FactoryDAO;
import persistencia.Manager;

public class TurmaComboBoxModel extends AbstractListModel<Turma> implements ComboBoxModel<Turma> {

	private List<Turma> ComputerComps;
	
	private Turma selection;
	private FactoryDAO<Turma> fp;
	
	public TurmaComboBoxModel() {
		this.fp = new FactoryDAO();
		
		Turma t = new Turma();
		
		Manager<Turma> turmaManager = fp.getObjectDAO(t);
		
		this.ComputerComps = turmaManager.getAll();
		
		turmaManager.exit();
	}
	
	public Turma getElementAt(int index) {
		return ComputerComps.get(index);
	}

	public int getSize() {
		return ComputerComps.size();
	}

	public Turma getSelectedItem() {
		return this.selection;
	}

	public void setSelectedItem(Object t) {
		this.selection = (Turma) t;
	}

}
