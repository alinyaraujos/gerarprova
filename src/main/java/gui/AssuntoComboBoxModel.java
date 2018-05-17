package gui;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import model.Assunto;
import model.Disciplina;
import patternproject.FactoryDAO;
import persistencia.AssuntoDAO;
import persistencia.Manager;

public class AssuntoComboBoxModel extends AbstractListModel<Assunto> implements ComboBoxModel<Assunto> {

	private List<Assunto> ComputerComps;
	private Assunto selection;
	private FactoryDAO<Assunto> fp;
	
	public AssuntoComboBoxModel(Object d) {
		this.fp = new FactoryDAO();
		
		Assunto a = new Assunto();
		
		Manager<Assunto> assuntoManager = fp.getObjectDAO(a);
		
		this.ComputerComps = ((AssuntoDAO) assuntoManager).getByDisciplina((Disciplina) d);
		
		assuntoManager.exit();
	}
	
	public Assunto getElementAt(int index) {
		return this.ComputerComps.get(index);
	}

	public int getSize() {
		return this.ComputerComps.size();
	}

	public Assunto getSelectedItem() {
		return this.selection;
	}

	public void setSelectedItem(Object a) {
		this.selection = (Assunto) a;
	}

}
