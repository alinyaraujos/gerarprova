package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Disciplina;
import model.Turma;
import patternproject.FactoryDAO;
import patternproject.SingletonProfessor;
import persistencia.Manager;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField entradaDisciplina;
	private JTextField entradaCodigo;
	private FactoryDAO<Disciplina> fp;
	private SingletonProfessor dados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDisciplina frame = new TelaDisciplina();
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
	public TelaDisciplina() {
		
		this.fp = new FactoryDAO();
		this.dados = SingletonProfessor.getInstance();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeDisciplina = new JLabel("Cadastro de Disciplina");
		lblCadastroDeDisciplina.setBounds(147, 39, 176, 14);
		contentPane.add(lblCadastroDeDisciplina);
		
		JLabel lblNomeDaDisciplina = new JLabel("Nome da Disciplina:");
		lblNomeDaDisciplina.setBounds(39, 131, 155, 14);
		contentPane.add(lblNomeDaDisciplina);
		
		entradaDisciplina = new JTextField();
		entradaDisciplina.setBounds(39, 153, 362, 20);
		contentPane.add(entradaDisciplina);
		entradaDisciplina.setColumns(10);
		
		JLabel label = new JLabel("Codigo:");
		label.setBounds(39, 67, 155, 23);
		contentPane.add(label);
		
		entradaCodigo = new JTextField();
		entradaCodigo.setColumns(10);
		entradaCodigo.setBounds(39, 95, 362, 20);
		contentPane.add(entradaCodigo);
		
		
		//a��o bot�o disciplina
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		btnCancelar.setBounds(85, 209, 109, 23);
		contentPane.add(btnCancelar);		
		
		//a��o salvar
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Disciplina disciplina = new Disciplina();
				
				disciplina.cadastrar(entradaCodigo.getText(), entradaDisciplina.getText(), dados.getProfessor().getCpf());
				Manager<Disciplina> disciplinaManager = fp.getObjectDAO(disciplina);
				disciplinaManager.create();
				disciplinaManager.exit();
				dispose();
			}
		});
		btnSalvar.setBounds(255, 209, 89, 23);
		contentPane.add(btnSalvar);
	}
}
