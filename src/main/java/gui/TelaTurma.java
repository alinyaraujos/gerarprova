package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.hibernate.type.YesNoType;

import model.Turma;
import patternproject.FactoryDAO;
import persistencia.Manager;

public class TelaTurma extends JFrame {

	private JPanel contentPane;
	private TurmaTableModel turmaTableModel;
	static JTable tableTurmas;

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 88, 455, 229);
		contentPane.add(scrollPane);
		
		this.turmaTableModel = new TurmaTableModel();
		
		TelaTurma.tableTurmas = new JTable(turmaTableModel);
		scrollPane.setViewportView(TelaTurma.tableTurmas);
		
		// bot�o cadastrar turma
		JButton btnNovaTurma = new JButton("Nova Turma");
		btnNovaTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaCadastraTurma(turmaTableModel).setVisible(true);
			}
		});
		btnNovaTurma.setBounds(41, 332, 130, 23);
		contentPane.add(btnNovaTurma);
		
		//acao editar turma
		JButton btnEditarTurma = new JButton("Editar Turma");
		btnEditarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = TelaTurma.tableTurmas.getSelectedRow();
				
				if (selectedRow > -1) {
					TurmaTableModel t = (TurmaTableModel) TelaTurma.tableTurmas.getModel();
					
					new TelaEditarTurma(t.getTurma(selectedRow)).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na tabela.");
				}
			}
		});
		btnEditarTurma.setBounds(211, 332, 130, 23);
		contentPane.add(btnEditarTurma);
		
		//bot�o excluir turma
		JButton btnExcluirTurma = new JButton("Excluir Turma");
		btnExcluirTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = TelaTurma.tableTurmas.getSelectedRow();
				
				if (selectedRow > -1) {
					TurmaTableModel tt= (TurmaTableModel) TelaTurma.tableTurmas.getModel();
					Turma t = tt.getTurma(selectedRow);
					int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir a turma " + t.getCodigo() + " ?", null, JOptionPane.YES_NO_OPTION);
					
					if (resposta == 0) {
						FactoryDAO<Turma> ft = new FactoryDAO();
						
						Manager<Turma> manager = ft.getObjectDAO(t);
						
						manager.delete(t.getCodigo());
						manager.exit();
						
						((TurmaTableModel)TelaTurma.tableTurmas.getModel()).update();
						
						JOptionPane.showMessageDialog(null, "Turma excluída com sucesso.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na tabela.");
				}
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
	}
}