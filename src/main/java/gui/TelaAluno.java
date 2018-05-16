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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ação exlcuir
		JButton btnExcluirAluno = new JButton("Excluir Aluno");
		btnExcluirAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluirAluno.setBounds(251, 242, 123, 23);
		contentPane.add(btnExcluirAluno);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaCadastroAluno().setVisible(true);
			}
		});
		btnCadastrarAluno.setBounds(66, 242, 123, 23);
		contentPane.add(btnCadastrarAluno);
		
		JLabel lblMenAluno = new JLabel("Men\u00FA Aluno");
		lblMenAluno.setBounds(185, 11, 89, 14);
		contentPane.add(lblMenAluno);
		
		JTextPane mostraAlunos = new JTextPane();
		mostraAlunos.setBounds(66, 124, 308, 82);
		contentPane.add(mostraAlunos);
		
		JComboBox turmaAluno = new JComboBox();
		turmaAluno.setBounds(66, 100, 308, 20);
		contentPane.add(turmaAluno);
		
		//botão voltar
		JButton voltar = new JButton("<<<<<<");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaPrincipal().setVisible(true);
				 
			}
		});
		voltar.setBounds(10, 300, 89, 23);
		contentPane.add(voltar);
		
		JLabel lblVisualizarAlunosPor = new JLabel("Visualizar alunos por turma:");
		lblVisualizarAlunosPor.setBounds(66, 81, 179, 14);
		contentPane.add(lblVisualizarAlunosPor);
	}
}
