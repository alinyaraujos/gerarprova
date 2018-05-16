package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//acao Gera prova
		JButton btnGerarProva = new JButton("Gerar Prova");
		btnGerarProva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaGeraProva().setVisible(true);
			}
		});
		btnGerarProva.setBounds(169, 216, 101, 23);
		contentPane.add(btnGerarProva);
		
		//ação minha informação
		JButton btnMinhasInformaes = new JButton("Minhas Informa\u00E7\u00F5es");
		btnMinhasInformaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new TelaMinhaInformacao().setVisible(true);
			}
		});
		btnMinhasInformaes.setBounds(27, 99, 158, 23);
		contentPane.add(btnMinhasInformaes);
		
		// ação Turmas
		JButton btnTurmas = new JButton("Turmas");
		btnTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new TelaTurma().setVisible(true);
			}
		});
		btnTurmas.setBounds(27, 133, 158, 23);
		contentPane.add(btnTurmas);
		
		//Ação alunos
		JButton btnAlunos = new JButton("Alunos");
		btnAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new TelaAluno().setVisible(true);
			}
		});
		btnAlunos.setBounds(27, 167, 158, 23);
		contentPane.add(btnAlunos);
		
		//Ação disciplina
		JButton btnDisciplinas = new JButton("Disciplinas");
		btnDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaDisciplina().setVisible(true);
			}
		});
		btnDisciplinas.setBounds(252, 99, 158, 23);
		contentPane.add(btnDisciplinas);
		
		//Ação assuntos
		JButton btnAssuntos = new JButton("Assuntos");
		btnAssuntos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaCadastraAssunto().setVisible(true);
			}
		});
		btnAssuntos.setBounds(252, 133, 158, 23);
		contentPane.add(btnAssuntos);
		
		// ação questões
		JButton btnQuestes = new JButton("Quest\u00F5es");
		btnQuestes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaCadastrarQuestao().setVisible(true);
			}
		});
		btnQuestes.setBounds(252, 167, 158, 23);
		contentPane.add(btnQuestes);
		
		JLabel lblGeraprova = new JLabel("GeraProva");
		lblGeraprova.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/image/foto.jpg")));
		lblGeraprova.setBounds(-36, 0, 487, 58);
		contentPane.add(lblGeraprova);
	}
}
