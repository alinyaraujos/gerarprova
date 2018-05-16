package patternproject;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Assunto;
import model.Disciplina;
import model.Professor;
import model.Prova;
import model.Questao;
import model.Turma;
import persistencia.AlunoDAO;
import persistencia.AssuntoDAO;
import persistencia.DisciplinaDAO;
import persistencia.Manager;
import persistencia.ProfessorDAO;
import persistencia.ProvaDAO;
import persistencia.QuestaoDAO;
import persistencia.TurmaDAO;

public  class FactoryDAO <T>{
	
	
	public Manager getObjectDAO(T object) {
		if(object instanceof Aluno) {
			return new AlunoDAO((Aluno)object);
		}
		if(object instanceof Assunto) {
			return new AssuntoDAO((Assunto)object);
		}
		if(object instanceof Disciplina) {
			return new DisciplinaDAO((Disciplina)object);
		}
		if(object instanceof Professor) {
			return new ProfessorDAO((Professor)object);
		}
		if(object instanceof Prova) {
			return new ProvaDAO((Prova)object);
		}
		if(object instanceof Questao) {
			return new QuestaoDAO((Questao)object);
		}
		if(object instanceof Turma) {
			return new TurmaDAO((Turma)object);
		}
		return null;
	}
}
