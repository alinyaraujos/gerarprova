package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Aluno;
import model.Assunto;
import model.Turma;
import patternproject.FactoryDAO;
import persistencia.Manager;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class TelaAluno extends JFrame {

	private JPanel contentPane;
	static JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAluno frame = new TelaAluno();
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
	public TelaAluno() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 593, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroAluno().setVisible(true);
			}
		});
		btnCadastrarAluno.setBounds(32, 269, 160, 23);
		contentPane.add(btnCadastrarAluno);
		
		JLabel lblMenAluno = new JLabel("Alunos");
		lblMenAluno.setBounds(199, 12, 89, 14);
		contentPane.add(lblMenAluno);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 92, 508, 152);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		final JComboBox turmaAluno = new JComboBox();
		turmaAluno.setModel(new TurmaComboBoxModel());
		turmaAluno.setBounds(103, 56, 308, 20);
		turmaAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(new AlunoTableModel(turmaAluno.getSelectedItem()));
			}
		});
		contentPane.add(turmaAluno);
		
		//acao editar aluno
		JButton btnEditarTurma = new JButton("Editar Aluno");
		btnEditarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = TelaAluno.table.getSelectedRow();
				
				if (selectedRow > -1) {
					AlunoTableModel a = (AlunoTableModel) TelaAluno.table.getModel();
					
					new TelaEditarAluno(a.getAluno(selectedRow), turmaAluno.getSelectedItem()).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na tabela.");
				}
			}
		});
		btnEditarTurma.setBounds(226, 266, 158, 29);
		contentPane.add(btnEditarTurma);
		
		//bot�o excluir turma
		JButton btnExcluirAluno = new JButton("Excluir Aluno");
		btnExcluirAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = TelaAluno.table.getSelectedRow();
				
				if (selectedRow > -1) {
					AlunoTableModel aa= (AlunoTableModel)  TelaAluno.table.getModel();
					Aluno a = aa.getAluno(selectedRow);
					int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o aluno " + a.getMatricula() + " ?", null, JOptionPane.YES_NO_OPTION);
					
					if (resposta == 0) {
						FactoryDAO<Aluno> ft = new FactoryDAO();
						
						Manager<Aluno> manager = ft.getObjectDAO(a);
						
						manager.delete(a.getMatricula());
						manager.exit();
						
						((AlunoTableModel)TelaAluno.table.getModel()).update(turmaAluno.getSelectedItem());
						
						JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na tabela.");
				}
			}
		});
		btnExcluirAluno.setBounds(412, 269, 160, 23);
		contentPane.add(btnExcluirAluno);
		
		//botï¿½o voltar
		JButton voltar = new JButton("Cancelar");
		voltar.setForeground(Color.DARK_GRAY);
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		voltar.setBounds(412, 308, 160, 23);
		contentPane.add(voltar);
		
		JLabel lblVisualizarAlunosPor = new JLabel("Turma:");
		lblVisualizarAlunosPor.setBounds(32, 59, 78, 14);
		contentPane.add(lblVisualizarAlunosPor);
	
	}
}

