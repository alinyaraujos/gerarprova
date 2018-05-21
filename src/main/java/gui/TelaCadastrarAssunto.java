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
import patternproject.FactoryDAO;
import patternproject.SingletonProfessor;
import persistencia.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class TelaCadastrarAssunto extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarAssunto frame = new TelaCadastrarAssunto();
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
	public TelaCadastrarAssunto() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 258);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarAssunto = new JLabel("Cadastrar Assunto");
		lblCadastrarAssunto.setBounds(151, 12, 170, 15);
		contentPane.add(lblCadastrarAssunto);
		
		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setBounds(24, 38, 90, 15);
		contentPane.add(lblDisciplina);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(24, 106, 66, 15);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(24, 128, 395, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		final JComboBox comboBox = new JComboBox(new DisciplinaComboBoxModel());
		comboBox.setBounds(24, 54, 395, 24);
		contentPane.add(comboBox);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(63, 184, 114, 25);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnCancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				Disciplina d = (Disciplina) comboBox.getSelectedItem();
				
				Assunto assunto = new Assunto();
				assunto.cadastrar(nome, d.getCodigo());
				
				FactoryDAO<Assunto> fp = new FactoryDAO();
				
				Manager<Assunto> disciplinaManager = fp.getObjectDAO(assunto);
				disciplinaManager.create();
				disciplinaManager.exit();
				
				((AssuntoTableModel)TelaAssunto.tableAssuntos.getModel()).update();
				
				dispose();
				
				JOptionPane.showMessageDialog(null, "Assunto cadastrado com sucesso.");
			}
		});
		btnSalvar.setBounds(250, 184, 114, 25);
		contentPane.add(btnSalvar);
	
	}
}
