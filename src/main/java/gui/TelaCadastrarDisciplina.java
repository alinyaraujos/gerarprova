package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Disciplina;
import patternproject.FactoryDAO;
import patternproject.SingletonProfessor;
import persistencia.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastrarDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCpf;
	private JTextField textFieldCodigo;
	private JTextField textFieldNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarDisciplina frame = new TelaCadastrarDisciplina();
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
	public TelaCadastrarDisciplina() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarDisciplina = new JLabel("Cadastrar Disciplina");
		lblCadastrarDisciplina.setBounds(151, 12, 170, 15);
		contentPane.add(lblCadastrarDisciplina);
		
		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setBounds(24, 38, 90, 15);
		contentPane.add(lblProfessor);
		
		final String cpf = SingletonProfessor.getInstance().getProfessor().getCpf();
		
		textFieldCpf = new JTextField(cpf);
		textFieldCpf.setEditable(false);
		textFieldCpf.setBounds(24, 54, 395, 19);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(24, 85, 90, 15);
		contentPane.add(lblCdigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(24, 103, 395, 19);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(24, 134, 66, 15);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(24, 150, 395, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(66, 214, 114, 25);
		contentPane.add(btnCancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = textFieldCodigo.getText();
				String nome = textFieldNome.getText();
				
				Disciplina disciplina = new Disciplina();
				disciplina.cadastrar(codigo, nome, cpf);
				
				FactoryDAO<Disciplina> fp = new FactoryDAO();
				
				Manager<Disciplina> disciplinaManager = fp.getObjectDAO(disciplina);
				disciplinaManager.create();
				disciplinaManager.exit();
				
				((DisciplinaTableModel)TelaDisciplina.tableDisciplinas.getModel()).update();
				
				dispose();
				
				JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso.");
			}
		});
		btnSalvar.setBounds(250, 214, 114, 25);
		contentPane.add(btnSalvar);
	}
}
