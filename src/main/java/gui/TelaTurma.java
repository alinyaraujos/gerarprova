package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaTurma extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTurma frame = new TelaTurma();
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
	public TelaTurma() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTelaTurma = new JLabel("Tela Turma");
		lblTelaTurma.setBounds(223, 33, 125, 14);
		contentPane.add(lblTelaTurma);
		
		JLabel lblTurmas = new JLabel("Turmas:");
		lblTurmas.setBounds(41, 62, 59, 14);
		contentPane.add(lblTurmas);
		
		JTextPane mostraTurmas = new JTextPane();
		mostraTurmas.setEditable(false);
		mostraTurmas.setBounds(37, 95, 438, 176);
		contentPane.add(mostraTurmas);
		
		// botão cadastrar turma
		JButton btnNovaTurma = new JButton("Nova Turma");
		btnNovaTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaCadastraTurma().setVisible(true);
			}
		});
		btnNovaTurma.setBounds(37, 305, 114, 23);
		contentPane.add(btnNovaTurma);
		
		//acao editar turma
		JButton btnEditarTurma = new JButton("Editar Turma");
		btnEditarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarTurma.setBounds(200, 305, 117, 23);
		contentPane.add(btnEditarTurma);
		
		//botão excluir turma
		JButton btnExcluirTurma = new JButton("Excluir Turma");
		btnExcluirTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluirTurma.setBounds(372, 305, 103, 23);
		contentPane.add(btnExcluirTurma);
		
		//tela principal
		JButton voltar = new JButton("<----");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaPrincipal().setVisible(true);
			}
		});
		voltar.setBounds(11, 389, 89, 23);
		contentPane.add(voltar);
	}
}
