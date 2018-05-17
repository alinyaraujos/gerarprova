package teste;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import model.Professor;
import persistencia.ProfessorDAO;

public class ProfessorDAOTeste {
	Professor professor;
	ProfessorDAO dao;
	
	@Before
	public void setUp(){
		professor = new Professor();
		professor.cadastrar("CPFDOCARA","nome", "email", "instituicao");
		dao = new ProfessorDAO(professor);
	}
	
	
	//funcionou
	@Test
	@Ignore
	public void testCreate() {
		if(dao.create()) {
			System.out.println("funcionou");
		}else {
			fail("erro");
		}	
		
	}

	@Test
	@Ignore
	public void testUpdate() {
		
	}

	// Teste para deletar, funcionou;
	@Test
	public void testDelete() {
		ProfessorDAO dao = new ProfessorDAO(professor);
		if(dao.delete("CPFDOCARA")) {
			JOptionPane.showMessageDialog(null, "funcionou, o delete!");
		}else {
			fail("erro no delete!!");
		}
	}
	
	//o teste vai verificar o funcionamento , execução do metodo do método, , agora para verificar o efeito do metodo no banco de dados foi usada tecnica de depuração
	
	@Test
	@Ignore
	public void listar() {
		try {
			dao.getAll();			
		}catch(Exception ex) {
			fail("erro"+ex);
		}
					
	}

}
