package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Turma;
import patternproject.FactoryDAO;
import patternproject.SingletonProfessor;
import persistencia.Manager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaEditarTurma extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigo;
	private JTextField textFieldSemestre;
	private JTextField textFieldAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarTurma frame = new TelaEditarTurma(new Turma());
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
	public TelaEditarTurma(Turma argTurma) {
		final Turma turma = argTurma;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnVoltar.setBounds(59, 232, 130, 25);
		contentPane.add(btnVoltar);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(27, 12, 83, 15);
		contentPane.add(lblCdigo);
		
		textFieldCodigo = new JTextField(turma.getCodigo());
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setBounds(27, 33, 392, 19);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblSemestre = new JLabel("Semestre:");
		lblSemestre.setBounds(27, 64, 168, 15);
		contentPane.add(lblSemestre);
		
		textFieldSemestre = new JTextField(turma.getSemestre());
		textFieldSemestre.setBounds(27, 85, 392, 19);
		contentPane.add(textFieldSemestre);
		textFieldSemestre.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(27, 116, 66, 15);
		contentPane.add(lblAno);
		
		textFieldAno = new JTextField("" + turma.getAno());
		textFieldAno.setBounds(27, 141, 392, 19);
		contentPane.add(textFieldAno);
		textFieldAno.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				FactoryDAO<Turma> ft = new FactoryDAO();
				
				String codigo = textFieldCodigo.getText();
				int ano = Integer.parseInt(textFieldAno.getText());
				String semestre = textFieldSemestre.getText();
				String cpfProfessor = SingletonProfessor.getInstance().getProfessor().getCpf();
				
				Turma t = new Turma();
				t.cadastrar(codigo, ano, semestre, cpfProfessor);
				
				Manager<Turma> manager = ft.getObjectDAO(t);
				
				manager.update();
				manager.exit();
				
				JOptionPane.showMessageDialog(null, "Turma atualizada com sucesso.");
				
				((TurmaTableModel)TelaTurma.tableTurmas.getModel()).update();
				
				dispose();
			}
		});
		
		btnAtualizar.setBounds(276, 232, 130, 25);
		contentPane.add(btnAtualizar);
	}
}
