package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Assunto;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class TelaAluno extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		
		//a��o exlcuir
		JButton btnExcluirAluno = new JButton("Excluir Aluno");
		btnExcluirAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluirAluno.setBounds(251, 269, 160, 23);
		contentPane.add(btnExcluirAluno);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		btnCadastrarAluno.setBounds(32, 269, 160, 23);
		contentPane.add(btnCadastrarAluno);
		
		JLabel lblMenAluno = new JLabel("Alunos");
		lblMenAluno.setBounds(199, 12, 89, 14);
		contentPane.add(lblMenAluno);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 92, 379, 152);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		final JComboBox turmaAluno = new JComboBox();
		turmaAluno.setModel(new TurmaComboBoxModel());
		turmaAluno.setBounds(103, 56, 308, 20);
		turmaAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(new AlunoTableModel(turmaAluno.getSelectedItem()));
			}
		});
		contentPane.add(turmaAluno);
		
		//bot�o voltar
		JButton voltar = new JButton("Cancelar");
		voltar.setForeground(Color.DARK_GRAY);
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		voltar.setBounds(150, 307, 160, 23);
		contentPane.add(voltar);
		
		JLabel lblVisualizarAlunosPor = new JLabel("Turma:");
		lblVisualizarAlunosPor.setBounds(32, 59, 78, 14);
		contentPane.add(lblVisualizarAlunosPor);
		
	
	}
}

