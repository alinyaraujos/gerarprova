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
import javax.swing.JScrollPane;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 462);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTelaTurma = new JLabel("Turmas");
		lblTelaTurma.setBounds(223, 33, 125, 14);
		contentPane.add(lblTelaTurma);
		
		JLabel lblTurmas = new JLabel("Turmas:");
		lblTurmas.setBounds(41, 62, 59, 14);
		contentPane.add(lblTurmas);
		
		// bot�o cadastrar turma
		JButton btnNovaTurma = new JButton("Nova Turma");
		btnNovaTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaCadastraTurma().setVisible(true);
			}
		});
		btnNovaTurma.setBounds(41, 332, 130, 23);
		contentPane.add(btnNovaTurma);
		
		//acao editar turma
		JButton btnEditarTurma = new JButton("Editar Turma");
		btnEditarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarTurma.setBounds(211, 332, 130, 23);
		contentPane.add(btnEditarTurma);
		
		//bot�o excluir turma
		JButton btnExcluirTurma = new JButton("Excluir Turma");
		btnExcluirTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluirTurma.setBounds(372, 332, 130, 23);
		contentPane.add(btnExcluirTurma);
		
		//tela principal
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		voltar.setBounds(41, 396, 89, 23);
		contentPane.add(voltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 88, 455, 229);
		contentPane.add(scrollPane);
		
		JTable tableTurmas = new JTable(new TurmaTableModel());
		scrollPane.setViewportView(tableTurmas);
	}
}