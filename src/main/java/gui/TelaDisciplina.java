package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField entradaDisciplina;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeDisciplina = new JLabel("Cadastro de Disciplina");
		lblCadastroDeDisciplina.setBounds(152, 37, 110, 14);
		contentPane.add(lblCadastroDeDisciplina);
		
		JLabel lblNomeDaDisciplina = new JLabel("Nome da Disciplina:");
		lblNomeDaDisciplina.setBounds(39, 91, 102, 14);
		contentPane.add(lblNomeDaDisciplina);
		
		//a��o bot�o disciplina
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(85, 209, 89, 23);
		contentPane.add(btnCancelar);
		
		entradaDisciplina = new JTextField();
		entradaDisciplina.setBounds(39, 111, 362, 20);
		contentPane.add(entradaDisciplina);
		entradaDisciplina.setColumns(10);
		
		//a��o salvar
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalvar.setBounds(255, 209, 89, 23);
		contentPane.add(btnSalvar);
	}
}
