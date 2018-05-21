package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Disciplina;
import model.Turma;
import patternproject.FactoryDAO;
import patternproject.SingletonProfessor;
import persistencia.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaDisciplina extends JFrame {

	private JPanel contentPane;
	private FactoryDAO<Disciplina> fp;
	private SingletonProfessor dados;
	static JTable tableDisciplinas;

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
		
		this.fp = new FactoryDAO();
		this.dados = SingletonProfessor.getInstance();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 379);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeDisciplina = new JLabel("Disciplinas");
		lblCadastroDeDisciplina.setBounds(189, 12, 176, 14);
		contentPane.add(lblCadastroDeDisciplina);
		
		
		//a��o bot�o disciplina
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		btnVoltar.setBounds(31, 313, 109, 23);
		contentPane.add(btnVoltar);		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 62, 392, 190);
		contentPane.add(scrollPane);
		
		tableDisciplinas = new JTable(new DisciplinaTableModel());
		scrollPane.setViewportView(tableDisciplinas);
		
		//a��o salvar
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new TelaCadastrarDisciplina().setVisible(true);
			}
		});
		btnCadastrar.setBounds(31, 264, 125, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(168, 263, 129, 25);
		btnEditar.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				int selectedRow = TelaDisciplina.tableDisciplinas.getSelectedRow();
				
				if (selectedRow > -1) {
					DisciplinaTableModel d = (DisciplinaTableModel) TelaDisciplina.tableDisciplinas.getModel();
					
					new TelaEditarDisciplina(d.getDisciplina(selectedRow)).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na tabela.");
				}
			}
		});
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(309, 263, 114, 25);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = TelaDisciplina.tableDisciplinas.getSelectedRow();
				
				if (selectedRow > -1) {
					DisciplinaTableModel tt= (DisciplinaTableModel) TelaDisciplina.tableDisciplinas.getModel();
					Disciplina t = tt.getDisciplina(selectedRow);
					int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir a disciplina " + t.getCodigo() + " ?", null, JOptionPane.YES_NO_OPTION);
					
					if (resposta == 0) {
						FactoryDAO<Disciplina> ft = new FactoryDAO();
						
						Manager<Disciplina> manager = ft.getObjectDAO(t);
						
						manager.delete(t.getCodigo());
						manager.exit();
						
						((DisciplinaTableModel)TelaDisciplina.tableDisciplinas.getModel()).update();
						
						JOptionPane.showMessageDialog(null, "Disciplina excluída com sucesso.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha na tabela.");
				}
			}
		});
		contentPane.add(btnExcluir);
	}
}
