package gui;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import model.Disciplina;
import model.Professor;
import patternproject.FactoryDAO;
import persistencia.Manager;

public class DisciplinaComboBoxModel extends AbstractListModel<Disciplina> implements ComboBoxModel<Disciplina> {

	private List<Disciplina> ComputerComps;
	
	private Disciplina selection;
	private FactoryDAO<Disciplina> fp;
	
	public DisciplinaComboBoxModel() {
		this.fp = new FactoryDAO();
		
		Disciplina d = new Disciplina();
		
		Manager<Disciplina> disciplinaManager = fp.getObjectDAO(d);
		
		this.ComputerComps = disciplinaManager.getAll();
		
		disciplinaManager.exit();
	}
	
	public Disciplina getElementAt(int index) {
		return ComputerComps.get(index);
	}

	public int getSize() {
		return ComputerComps.size();
	}

	public Disciplina getSelectedItem() {
		return this.selection;
	}

	public void setSelectedItem(Object d) {
		this.selection = (Disciplina) d;
	}

}
