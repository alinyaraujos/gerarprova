package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Professor;
import model.Turma;
import patternproject.FactoryDAO;
import patternproject.SingletonProfessor;
import persistencia.Manager;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastraTurma extends JFrame {

	private JPanel contentPane;
	private JTextField entradaTurma;
	private JTextField ano;
	private JTextField semestre;
	private FactoryDAO<Turma> fp;
	private SingletonProfessor dados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastraTurma frame = new TelaCadastraTurma(new TurmaTableModel());
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
	public TelaCadastraTurma(TurmaTableModel tableModel) {
		
		final TurmaTableModel table = tableModel;
		
		this.fp = new FactoryDAO();
		this.dados = SingletonProfessor.getInstance();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 367);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarTurma = new JLabel("Cadastrar Turma");
		lblCadastrarTurma.setBounds(163, 38, 178, 14);
		contentPane.add(lblCadastrarTurma);
		
		JLabel lblCdigoDaTurma = new JLabel("C\u00F3digo da Turma:");
		lblCdigoDaTurma.setBounds(38, 68, 152, 14);
		contentPane.add(lblCdigoDaTurma);
		
		entradaTurma = new JTextField();
		entradaTurma.setBounds(38, 91, 354, 20);
		contentPane.add(entradaTurma);
		entradaTurma.setColumns(10);
		
		JLabel labelAno = new JLabel("Ano:");
		labelAno.setBounds(38, 127, 152, 14);
		contentPane.add(labelAno);
		
		ano = new JTextField();
		ano.setColumns(10);
		ano.setBounds(38, 149, 354, 20);
		contentPane.add(ano);
		
		JLabel label_1 = new JLabel("Semestre:");
		label_1.setBounds(38, 185, 152, 14);
		contentPane.add(label_1);
		
		semestre = new JTextField();
		semestre.setColumns(10);
		semestre.setBounds(38, 215, 354, 20);
		contentPane.add(semestre);
		
		//a��o cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 dispose();
			}
		});
		
		btnCancelar.setBounds(106, 252, 110, 23);
		contentPane.add(btnCancelar);
		
		//a��o salvar
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Turma turma = new Turma();
				turma.cadastrar(entradaTurma.getText(), Integer.parseInt(ano.getText()) ,semestre.getText(), dados.getProfessor().getCpf());
				Manager<Turma> turmaManager = fp.getObjectDAO(turma);
				turmaManager.create();
				turmaManager.exit();
				
				table.update();
				dispose();
			}
		});
		btnSalvar.setBounds(242, 252, 89, 23);
		contentPane.add(btnSalvar);
		
	}
}
