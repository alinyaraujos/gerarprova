package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastraTurma extends JFrame {

	private JPanel contentPane;
	private JTextField entradaTurma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastraTurma frame = new TelaCadastraTurma();
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
	public TelaCadastraTurma() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarTurma = new JLabel("Cadastrar Turma");
		lblCadastrarTurma.setBounds(163, 38, 88, 14);
		contentPane.add(lblCadastrarTurma);
		
		JLabel lblCdigoDaTurma = new JLabel("C\u00F3digo da Turma:");
		lblCdigoDaTurma.setBounds(38, 88, 152, 14);
		contentPane.add(lblCdigoDaTurma);
		
		entradaTurma = new JTextField();
		entradaTurma.setBounds(38, 104, 354, 20);
		contentPane.add(entradaTurma);
		entradaTurma.setColumns(10);
		
		//a��o cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 dispose();
			}
		});
		
		btnCancelar.setBounds(81, 202, 89, 23);
		contentPane.add(btnCancelar);
		
		//a��o salvar
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 dispose();
			}
		});
		btnSalvar.setBounds(266, 202, 89, 23);
		contentPane.add(btnSalvar);
	}

}
