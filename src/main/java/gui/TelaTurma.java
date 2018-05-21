package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.query.Query;

import model.Turma;
import patternproject.FactoryDAO;
import persistencia.Manager;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

public class TelaTurma extends JFrame {

	private JPanel contentPane;	
	private JTable table;
	private FactoryDAO<Turma> fp;

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
		setBounds(100, 100, 805, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTelaTurma = new JLabel("Tela Turma");
		lblTelaTurma.setBounds(363, 28, 125, 14);
		contentPane.add(lblTelaTurma);
		
		JLabel lblTurmas = new JLabel("Turmas:");
		lblTurmas.setBounds(41, 62, 89, 14);
		contentPane.add(lblTurmas);
		
		// bot�o cadastrar turma
		JButton btnNovaTurma = new JButton("Nova Turma");
		btnNovaTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaCadastraTurma().setVisible(true);
			}
		});
		btnNovaTurma.setBounds(77, 362, 163, 23);
		contentPane.add(btnNovaTurma);
		
		//acao editar turma
		JButton btnEditarTurma = new JButton("Editar Turma");
		btnEditarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnEditarTurma.setBounds(290, 362, 198, 23);
		contentPane.add(btnEditarTurma);
		
		//bot�o excluir turma
		JButton btnExcluirTurma = new JButton("Excluir Turma");
		btnExcluirTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluirTurma.setBounds(548, 362, 138, 23);
		contentPane.add(btnExcluirTurma);
		
		//tela principal
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		voltar.setBounds(33, 422, 89, 23);
		contentPane.add(voltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 101, 663, 245);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
}
