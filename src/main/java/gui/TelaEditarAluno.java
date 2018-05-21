package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Aluno;
import model.Assunto;
import model.Turma;
import patternproject.FactoryDAO;
import patternproject.SingletonProfessor;
import persistencia.Manager;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaEditarAluno extends JFrame {

	private JPanel contentPane;
	private JTextField entradaNome;
	private JTextField entradaMatricula;
	private JTextField turmaAtual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarAluno frame = new TelaEditarAluno(new Aluno(), new Object());
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
	public TelaEditarAluno(Aluno argAluno, final Object t) {
		final Aluno aluno = argAluno;
		
		System.out.println("Aluno"+aluno.getMatricula());
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 351);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnVoltar.setBounds(33, 270, 130, 25);
		contentPane.add(btnVoltar);
		
		
		JLabel lblNomeDoAluno = new JLabel("Nome do Aluno:");
		lblNomeDoAluno.setBounds(36, 82, 148, 14);
		contentPane.add(lblNomeDoAluno);
		
		entradaNome = new JTextField(aluno.getNome());
		entradaNome.setBounds(36, 99, 345, 20);
		contentPane.add(entradaNome);
		entradaNome.setColumns(10);
	
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(36, 16, 109, 14);
		contentPane.add(lblMatricula);
		
		entradaMatricula = new JTextField(""+aluno.getMatricula());
		entradaMatricula.setEditable(false);
		entradaMatricula.setBounds(34, 46, 345, 20);
		contentPane.add(entradaMatricula);
		entradaMatricula.setColumns(10);
		
		
		final JComboBox selecaoTurma = new JComboBox();
		selecaoTurma.setModel(new TurmaComboBoxModel());
		//selecaoTurma.setSelectedIndex(0,1[""]);
		selecaoTurma.setBounds(232, 193, 109, 20);
		contentPane.add(selecaoTurma);
		
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				FactoryDAO<Aluno> ft = new FactoryDAO();
				
				
				int matricula = Integer.parseInt(entradaMatricula.getText());
				String nome = entradaNome.getText();
				String codTurma = (selecaoTurma.getSelectedItem()==null) ? aluno.getCodTurma() : ((Turma)selecaoTurma.getSelectedItem()).getCodigo();
			
				Aluno alunoAtualizar = new Aluno();
				alunoAtualizar.cadastrar(matricula, nome, codTurma);
				
				Manager<Aluno> manager = ft.getObjectDAO(alunoAtualizar);
				
				manager.update();
				manager.exit();
				
				JOptionPane.showMessageDialog(null, "aluno atualizada com sucesso.");
				
				((AlunoTableModel)TelaAluno.table.getModel()).update(t);
				
				dispose();
			}
		});
		
		btnAtualizar.setBounds(274, 270, 130, 25);
		contentPane.add(btnAtualizar);
		
		JLabel lblNewLabel = new JLabel("Selecionar nova Turma:");
		lblNewLabel.setBounds(33, 193, 174, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblTurmaAtua = new JLabel("Turma Atual:");
		lblTurmaAtua.setBounds(33, 157, 112, 20);
		contentPane.add(lblTurmaAtua);
		
		turmaAtual = new JTextField(""+aluno.getCodTurma());
		turmaAtual.setBounds(143, 154, 146, 26);
		turmaAtual.setEditable(false);
		contentPane.add(turmaAtual);
		turmaAtual.setColumns(10);
	}
}
