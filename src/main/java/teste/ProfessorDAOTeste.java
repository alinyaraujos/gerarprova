package teste;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import model.Professor;
import persistencia.ProfessorDAO;

public class ProfessorDAOTeste {
	Professor professor = new Professor();
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	
	/*
	 testCreate está sendo usado para verificar se houve algum problema durante o ato de
	 salvar os dados referentes ao professor no banco de dados;  
	 */
	@Test
	@Ignore
	public void testCreate() {
		
		
		professor.cadastrar("cccc", "nome","e-mail", "instituicao");
		ProfessorDAO dao = new ProfessorDAO(professor);
		
		if(dao.create()) {
			JOptionPane.showMessageDialog(null, "funcionou!");
		}else {
			fail("erro, não salvou");
		}
		
	}

	@Test
	@Ignore
	public void testUpdate() {
	
		
	}

	/*
	 Teste para deletar, funcionou, tá passando mesmo que o cpf n exista
	 */
	@Test
	public void testDelete() {
		ProfessorDAO dao = new ProfessorDAO(professor);
		if(dao.delete("cpf")) {
			JOptionPane.showMessageDialog(null, "funcionou, o delete!");
		}else {
			fail("erro no delete!!");
		}
	}
	
	//rever esse teste
	@Test
	@Ignore
	public void listar() {
		
		Professor professor = new Professor();
		professor.cadastrar("jjjj", "nome","e-mail", "instituicao");
		ProfessorDAO dao = new ProfessorDAO(professor);
		
		for(Professor p: dao.getAll()) {
			JOptionPane.showMessageDialog(null, "Descrição: "+p.getNome());
		}
				
		
	}
	
	

}
