package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Turma;
import model.Professor;
import patternproject.FactoryDAO;
import patternproject.SingletonProfessor;
import persistencia.Manager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private FactoryDAO<Turma> fpTurma;
	private FactoryDAO<Professor> fpProfessor;
	private SingletonProfessor dados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		
		this.fpProfessor = new FactoryDAO();
		this.dados = SingletonProfessor.getInstance();
		
		List<Professor> professores;
		Professor p = new Professor();
		Manager<Professor> professorManager = fpProfessor.getObjectDAO(p);
		
		professores = professorManager.getAll();
		
		if (professores.size() > 0) {
			p = professores.get(0);
			dados.setProfessor(p);
		}
		professorManager.exit();

		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//acao Gera prova
		JButton btnGerarProva = new JButton("Gerar Prova");
		btnGerarProva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaCadastrarProva().setVisible(true);
			}
		});
		btnGerarProva.setBounds(162, 218, 145, 23);
		contentPane.add(btnGerarProva);
		
		//a��o minha informa��o
		JButton btnMinhasInformaes = new JButton("Minhas Informa\u00E7\u00F5es");
		btnMinhasInformaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new TelaMinhaInformacao().setVisible(true);
			}
		});
		btnMinhasInformaes.setBounds(12, 99, 178, 23);
		contentPane.add(btnMinhasInformaes);
		
		// a��o Turmas
		JButton btnTurmas = new JButton("Turmas");
		btnTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new TelaTurma().setVisible(true);
			}
		});
		btnTurmas.setBounds(12, 134, 178, 23);
		contentPane.add(btnTurmas);
		
		//A��o alunos
		JButton btnAlunos = new JButton("Alunos");
		btnAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new TelaAluno().setVisible(true);
			}
		});
		btnAlunos.setBounds(12, 169, 178, 23);
		contentPane.add(btnAlunos);
		
		//A��o disciplina
		JButton btnDisciplinas = new JButton("Disciplinas");
		btnDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaDisciplina().setVisible(true);
			}
		});
		btnDisciplinas.setBounds(252, 99, 178, 23);
		contentPane.add(btnDisciplinas);
		
		//A��o assuntos
		JButton btnAssuntos = new JButton("Assuntos");
		btnAssuntos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaAssunto().setVisible(true);
			}
		});
		btnAssuntos.setBounds(252, 133, 178, 23);
		contentPane.add(btnAssuntos);
		
		// a��o quest�es
		JButton btnQuestes = new JButton("Quest\u00F5es");
		btnQuestes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaCadastrarQuestao().setVisible(true);
			}
		});
		btnQuestes.setBounds(252, 167, 178, 23);
		contentPane.add(btnQuestes);
		
		JLabel lblGeraprova = new JLabel("GeraProva");
		lblGeraprova.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/image/foto.jpg")));
		lblGeraprova.setBounds(-36, 0, 487, 58);
		contentPane.add(lblGeraprova);
	}
}

