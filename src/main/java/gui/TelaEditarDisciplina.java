package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Disciplina;
import model.Turma;
import patternproject.FactoryDAO;
import patternproject.SingletonProfessor;
import persistencia.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaEditarDisciplina extends JFrame {

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
					TelaEditarDisciplina frame = new TelaEditarDisciplina(new Disciplina());
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
	public TelaEditarDisciplina(Disciplina d) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditarDisciplina = new JLabel("Editar Disciplina");
		lblEditarDisciplina.setBounds(159, 12, 150, 15);
		contentPane.add(lblEditarDisciplina);
		
		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setBounds(26, 44, 114, 15);
		contentPane.add(lblProfessor);
		
		textFieldCpf = new JTextField(d.getCpfProfessor());
		textFieldCpf.setEditable(false);
		textFieldCpf.setBounds(26, 61, 397, 19);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(26, 98, 80, 15);
		contentPane.add(lblCdigo);
		
		textFieldCodigo = new JTextField(d.getCodigo());
		textFieldCodigo.setBounds(26, 117, 397, 19);
		textFieldCodigo.setEditable(false);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(26, 148, 66, 15);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField(d.getNome());
		textFieldNome.setBounds(26, 165, 397, 19);
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
				FactoryDAO<Disciplina> ft = new FactoryDAO();
				
				String codigo = textFieldCodigo.getText();
				String nome = textFieldNome.getText();
				String cpfProfessor = SingletonProfessor.getInstance().getProfessor().getCpf();
				
				Disciplina d = new Disciplina();
				d.cadastrar(codigo, nome, cpfProfessor);
				
				Manager<Disciplina> manager = ft.getObjectDAO(d);
				
				manager.update();
				manager.exit();
				
				JOptionPane.showMessageDialog(null, "Disciplina atualizada com sucesso.");
				
				((DisciplinaTableModel)TelaDisciplina.tableDisciplinas.getModel()).update();
				
				dispose();
			}
		});
		contentPane.add(btnAtualizar);
	}
}
