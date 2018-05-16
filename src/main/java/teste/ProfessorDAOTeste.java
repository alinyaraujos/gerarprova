package teste;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

import model.Professor;
import persistencia.ProfessorDAO;

public class ProfessorDAOTeste {

	@Before
	public void setUp() throws Exception {
	}
	
	
	/*
	 testCreate está sendo usado para verificar se houve algum problema durante o ato de
	 salvar os dados referentes ao professor no banco de dados;  
	 */
	@Test
	public void testCreate() {
		
		Professor professor = new Professor();
		professor.cadastrar("cpf", "nome","e-mail", "instituicao");
		ProfessorDAO dao = new ProfessorDAO(professor);
		
		if(dao.create()) {
			JOptionPane.showMessageDialog(null, "funcionou!");
		}else {
			fail("erro, não salvou");
		}
		
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
