package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class TelaAluno extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAluno frame = new TelaAluno();
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
	public TelaAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExcluirAluno = new JButton("Excluir Aluno");
		btnExcluirAluno.setBounds(251, 242, 123, 23);
		contentPane.add(btnExcluirAluno);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
		btnCadastrarAluno.setBounds(66, 242, 123, 23);
		contentPane.add(btnCadastrarAluno);
		
		JLabel lblMenAluno = new JLabel("Men\u00FA Aluno");
		lblMenAluno.setBounds(185, 11, 89, 14);
		contentPane.add(lblMenAluno);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(66, 124, 308, 82);
		contentPane.add(textPane);
		
		JLabel lblVisualizarAlunos = new JLabel("Visualizar Alunos: ");
		lblVisualizarAlunos.setBounds(66, 86, 174, 14);
		contentPane.add(lblVisualizarAlunos);
		
		JComboBox turmaAluno = new JComboBox();
		turmaAluno.setBounds(66, 100, 308, 20);
		contentPane.add(turmaAluno);
		
		JButton voltar = new JButton("<<<<<<");
		voltar.setBounds(10, 300, 89, 23);
		contentPane.add(voltar);
	}
}
