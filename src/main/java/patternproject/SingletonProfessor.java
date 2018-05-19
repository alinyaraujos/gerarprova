package patternproject;

import model.Professor;

public class SingletonProfessor {
	
	private Professor professor;
	private static SingletonProfessor unicaInstance;

	private SingletonProfessor() {
	}

	public static synchronized SingletonProfessor getInstance() {
		if (unicaInstance == null)
			unicaInstance = new SingletonProfessor();
		return unicaInstance;
	}
	
    public void setProfessor(Professor professor) {
		this.professor = professor;
	}
    
    public Professor getProfessor() {
    	return this.professor;
    }
    
}
