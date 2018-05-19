package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Aluno;
import model.Turma;
import patternproject.FactoryDAO;
import persistencia.Manager;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField entradaNome;
	private JTextField entradaMatricula;
	private FactoryDAO<Aluno> fp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAluno frame = new TelaCadastroAluno();
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
	public TelaCadastroAluno() {
		this.fp = new FactoryDAO();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarAluno = new JLabel("Cadastrar Aluno");
		lblCadastrarAluno.setBounds(178, 25, 131, 14);
		contentPane.add(lblCadastrarAluno);
		
		JLabel lblNomeDoAluno = new JLabel("Nome do Aluno:");
		lblNomeDoAluno.setBounds(48, 110, 148, 14);
		contentPane.add(lblNomeDoAluno);
		
		entradaNome = new JTextField();
		entradaNome.setBounds(48, 128, 345, 20);
		contentPane.add(entradaNome);
		entradaNome.setColumns(10);
		
		JLabel lblTurma = new JLabel("Turma:");
		lblTurma.setBounds(48, 160, 74, 14);
		contentPane.add(lblTurma);
	
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(48, 59, 109, 14);
		contentPane.add(lblMatricula);
		
		entradaMatricula = new JTextField();
		entradaMatricula.setColumns(10);
		entradaMatricula.setBounds(48, 76, 345, 20);
		contentPane.add(entradaMatricula);
		
		final JComboBox selecaoTurma = new JComboBox();
		selecaoTurma.setModel(new TurmaComboBoxModel());
		selecaoTurma.setBounds(48, 179, 109, 20);
		contentPane.add(selecaoTurma);
		
		//a��o cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(200, 251, 109, 23);
		contentPane.add(btnCancelar);
		
		//a��o salvar
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				
				String codTurma = ((Turma) selecaoTurma.getSelectedItem()).getCodigo();
				
				aluno.cadastrar(Integer.parseInt(entradaMatricula.getText()), entradaNome.getText(), codTurma);
				Manager<Aluno> alunoManager = fp.getObjectDAO(aluno);
				alunoManager.create();
				alunoManager.exit();
				dispose();
			}
		});
		btnSalvar.setBounds(323, 251, 89, 23);
		contentPane.add(btnSalvar);
	}
}
