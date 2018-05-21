package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Assunto;
import model.Disciplina;
import model.Turma;
import patternproject.FactoryDAO;
import patternproject.SingletonProfessor;
import persistencia.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaEditarAssunto extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDisciplina;
	private JTextField textFieldNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarAssunto frame = new TelaEditarAssunto(new Assunto());
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
	public TelaEditarAssunto(Assunto a) {
		final Assunto assuntoArg = a;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditarAssunto = new JLabel("Editar Assunto");
		lblEditarAssunto.setBounds(159, 12, 150, 15);
		contentPane.add(lblEditarAssunto);
		
		JLabel lblProfessor = new JLabel("Disciplina:");
		lblProfessor.setBounds(26, 44, 114, 15);
		contentPane.add(lblProfessor);
		
		textFieldDisciplina = new JTextField(a.getCodDisciplina());
		textFieldDisciplina.setEditable(false);
		textFieldDisciplina.setBounds(26, 61, 397, 19);
		contentPane.add(textFieldDisciplina);
		textFieldDisciplina.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Nome:");
		lblCdigo.setBounds(26, 98, 80, 15);
		contentPane.add(lblCdigo);
		
		textFieldNome = new JTextField(a.getNome());
		textFieldNome.setBounds(26, 117, 397, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(51, 216, 114, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnVoltar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(252, 216, 114, 25);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FactoryDAO<Assunto> ft = new FactoryDAO();
				
				String disciplina = textFieldDisciplina.getText();
				String nome = textFieldNome.getText();
				
				Assunto as = new Assunto();
				as.cadastrar(nome, disciplina);
				as.setCodigo(assuntoArg.getCodigo());
				
				Manager<Disciplina> manager = ft.getObjectDAO(as);
				
				manager.update();
				manager.exit();
				
				JOptionPane.showMessageDialog(null, "Assunto atualizado com sucesso.");
				
				((AssuntoTableModel)TelaAssunto.tableAssuntos.getModel()).update();
				
				dispose();
			}
		});
		contentPane.add(btnAtualizar);
	}
}
