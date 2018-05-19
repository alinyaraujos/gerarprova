package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField entradaNome;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarAluno = new JLabel("Cadastrar Aluno");
		lblCadastrarAluno.setBounds(178, 25, 131, 14);
		contentPane.add(lblCadastrarAluno);
		
		JLabel lblNomeDoAluno = new JLabel("Nome do Aluno:");
		lblNomeDoAluno.setBounds(48, 86, 109, 14);
		contentPane.add(lblNomeDoAluno);
		
		entradaNome = new JTextField();
		entradaNome.setBounds(48, 101, 345, 20);
		contentPane.add(entradaNome);
		entradaNome.setColumns(10);
		
		JComboBox selecaoTurma = new JComboBox();
		selecaoTurma.setBounds(48, 151, 109, 20);
		contentPane.add(selecaoTurma);
		
		JLabel lblTurma = new JLabel("Turma:");
		lblTurma.setBounds(48, 132, 46, 14);
		contentPane.add(lblTurma);
		
		//a��o cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		btnCancelar.setBounds(96, 215, 89, 23);
		contentPane.add(btnCancelar);
		
		//a��o salvar
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalvar.setBounds(252, 215, 89, 23);
		contentPane.add(btnSalvar);
	}
}
