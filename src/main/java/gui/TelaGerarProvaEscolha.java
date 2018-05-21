package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Assunto;
import model.GeraProva;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;

public class TelaGerarProvaEscolha extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerarProvaEscolha frame = new TelaGerarProvaEscolha();
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
	public TelaGerarProvaEscolha() {
		String [] colunas = {"Nome", "Telefone", "Email"};
		Object [][] dados = {
				{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
				{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
				{"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
			};
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 752, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGerarProva = new JLabel("Gerar Prova");
		lblGerarProva.setBounds(145, 36, 98, 14);
		contentPane.add(lblGerarProva);

		
		//ação salvar
		JButton btnSalvar = new JButton("Gerar aleatória");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaGeraProva().setVisible(true);
				dispose();
			}
		});
		btnSalvar.setBounds(233, 106, 148, 23);
		contentPane.add(btnSalvar);
		
		//ação cancelar
		JButton btnCancelar = new JButton("Escolher por turma");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaCadastrarProva().setVisible(true);
				 dispose();
			}
		});
		btnCancelar.setBounds(51, 106, 167, 23);
		contentPane.add(btnCancelar);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(false);
		tabbedPane.setBounds(264, 454, -161, -165);
		contentPane.add(tabbedPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(157, 145, 4, 22);
		contentPane.add(textArea);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(600, 206, -154, -89);
		contentPane.add(tabbedPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(627, 453, -601, -247);
		contentPane.add(scrollPane);
		
		table_1 = new JTable(dados, colunas);
		table_1.setBounds(101, 249, 328, 89);
		contentPane.add(table_1);
	}
}
