package gui;

import java.util.ArrayList;
import java.util.List;

import model.Disciplina;
import model.Turma;
import patternproject.FactoryDAO;
import persistencia.Manager;

public class TableTurma {
	
	private List<Turma> ComputerComps;
	private Disciplina selection;
	private FactoryDAO<Turma> fp;
	
	public  void listTurmas(String valorProcurado) {
		this.fp = new FactoryDAO();
		Turma t = new Turma();
		
		Manager<Turma> turmaManager = fp.getObjectDAO(t);
		this.ComputerComps = turmaManager.getAll();
		turmaManager.exit();
	}

	
}
