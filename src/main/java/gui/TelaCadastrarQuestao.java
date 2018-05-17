package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Professor;
import model.Questao;
import model.Assunto;
import patternproject.FactoryDAO;
import persistencia.Manager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastrarQuestao extends JFrame {

	private JPanel contentPane;
	private JTextField saidaQuestao;
	private JTextField entradaA=null;
	private JTextField entradaB=null;
	private JTextField entradaC=null;
	private JTextField entradaD=null;
	private JTextField entradaE=null;
	private FactoryDAO<Questao> fp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarQuestao frame = new TelaCadastrarQuestao();
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
	public TelaCadastrarQuestao() {
		this.fp = new FactoryDAO();
		
		final JComboBox comboBoxAssunto = new JComboBox();
		
		final JComboBox comboBoxDisciplina = new JComboBox();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 605);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//bot�o cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		btnCancelar.setBounds(74, 534, 117, 23);
		contentPane.add(btnCancelar);
		
		final JComboBox comboBoxGabarito = new JComboBox();
		comboBoxGabarito.setModel(new DefaultComboBoxModel(new String[] {"", "A", "B", "C", "D", "E"}));
		comboBoxGabarito.setBounds(32, 419, 209, 24);
		contentPane.add(comboBoxGabarito);
		
		final JComboBox comboBoxNivel = new JComboBox();
		comboBoxNivel.setModel(new DefaultComboBoxModel(new String[] {"", "Facil", "Media", "Dificil"}));
		comboBoxNivel.setBounds(253, 419, 203, 24);
		contentPane.add(comboBoxNivel);
		
		//a��o salvar
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] assertivas = {entradaA.getText(), entradaB.getText(), entradaC.getText(), entradaD.getText(), entradaE.getText()};
				
				Questao q = new Questao();
				q.cadastrar(saidaQuestao.getText(), (String) comboBoxNivel.getSelectedItem(), 
						(String) comboBoxGabarito.getSelectedItem(), assertivas, ((Assunto) comboBoxAssunto.getSelectedItem()).getCodigo());
				Manager<Questao> questaoManager = fp.getObjectDAO(q);
				questaoManager.create();
				questaoManager.exit();
				
				JOptionPane.showMessageDialog(null, "Questao cadastrada com sucesso.");
				dispose();
			}
		});
		btnSalvar.setBounds(293, 534, 117, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblCadastroDeQuestes = new JLabel("Cadastro de Quest\u00F5es");
		lblCadastroDeQuestes.setBounds(163, 34, 169, 14);
		contentPane.add(lblCadastroDeQuestes);
		
		saidaQuestao = new JTextField();
		saidaQuestao.setBounds(32, 99, 424, 49);
		contentPane.add(saidaQuestao);
		saidaQuestao.setColumns(10);
		
		JLabel lblEnunciado = new JLabel("Enunciado:");
		lblEnunciado.setBounds(32, 74, 135, 14);
		contentPane.add(lblEnunciado);
		
		JLabel lblA = new JLabel("A)");
		lblA.setBounds(31, 167, 46, 14);
		contentPane.add(lblA);
		
		entradaA = new JTextField();
		entradaA.setBounds(32, 185, 424, 20);
		contentPane.add(entradaA);
		entradaA.setColumns(10);
		
		JLabel lblB = new JLabel("B)");
		lblB.setBounds(31, 216, 46, 14);
		contentPane.add(lblB);
		
		entradaB = new JTextField();
		entradaB.setBounds(32, 233, 424, 20);
		contentPane.add(entradaB);
		entradaB.setColumns(10);
		
		JLabel lblC = new JLabel("C)");
		lblC.setBounds(31, 264, 46, 14);
		contentPane.add(lblC);
		
		entradaC = new JTextField();
		entradaC.setBounds(32, 278, 424, 20);
		contentPane.add(entradaC);
		entradaC.setColumns(10);
		
		JLabel lblD = new JLabel("D)");
		lblD.setBounds(32, 317, 46, 14);
		contentPane.add(lblD);
		
		entradaD = new JTextField();
		entradaD.setBounds(32, 331, 424, 20);
		contentPane.add(entradaD);
		entradaD.setColumns(10);
		
		JLabel lblE = new JLabel("E)");
		lblE.setBounds(32, 362, 46, 14);
		contentPane.add(lblE);
		
		entradaE = new JTextField();
		entradaE.setBounds(31, 376, 424, 20);
		contentPane.add(entradaE);
		entradaE.setColumns(10);
		
		JLabel lblGabarito = new JLabel("Gabarito:");
		lblGabarito.setBounds(32, 401, 89, 14);
		contentPane.add(lblGabarito);
		
		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setBounds(32, 453, 89, 15);
		contentPane.add(lblDisciplina);
		
		JLabel lblAssunto = new JLabel("Assunto:");
		lblAssunto.setBounds(251, 455, 103, 15);
		contentPane.add(lblAssunto);
		
		comboBoxDisciplina.setModel(new DisciplinaComboBoxModel());
		comboBoxDisciplina.setBounds(32, 480, 209, 24);
		comboBoxDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxAssunto.setModel(new AssuntoComboBoxModel(comboBoxDisciplina.getSelectedItem()));
			}
		});
		contentPane.add(comboBoxDisciplina);
		
		comboBoxAssunto.setBounds(249, 480, 211, 24);
		contentPane.add(comboBoxAssunto);
		
		JLabel lblNvel = new JLabel("Nivel:");
		lblNvel.setBounds(253, 401, 66, 15);
		contentPane.add(lblNvel);
	}
}
