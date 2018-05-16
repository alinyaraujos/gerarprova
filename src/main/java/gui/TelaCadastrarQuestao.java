package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrarQuestao extends JFrame {

	private JPanel contentPane;
	private JTextField saidaQuestao;
	private JTextField entradaA;
	private JTextField entradaB;
	private JTextField entradaC;
	private JTextField entradaD;
	private JTextField entradaE;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//botão cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaPrincipal().setVisible(true);
			}
		});
		btnCancelar.setBounds(102, 474, 89, 23);
		contentPane.add(btnCancelar);
		
		//ação salvar
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new TelaPrincipal().setVisible(true);
			}
		});
		btnSalvar.setBounds(231, 474, 89, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblCadastroDeQuestes = new JLabel("Cadastro de Quest\u00F5es");
		lblCadastroDeQuestes.setBounds(151, 36, 113, 14);
		contentPane.add(lblCadastroDeQuestes);
		
		saidaQuestao = new JTextField();
		saidaQuestao.setBounds(32, 99, 377, 49);
		contentPane.add(saidaQuestao);
		saidaQuestao.setColumns(10);
		
		JLabel lblEnunciado = new JLabel("Enunciado:");
		lblEnunciado.setBounds(32, 74, 70, 14);
		contentPane.add(lblEnunciado);
		
		JLabel lblA = new JLabel("A)");
		lblA.setBounds(31, 167, 46, 14);
		contentPane.add(lblA);
		
		entradaA = new JTextField();
		entradaA.setBounds(32, 185, 377, 20);
		contentPane.add(entradaA);
		entradaA.setColumns(10);
		
		JLabel lblB = new JLabel("B)");
		lblB.setBounds(31, 216, 46, 14);
		contentPane.add(lblB);
		
		entradaB = new JTextField();
		entradaB.setBounds(32, 233, 377, 20);
		contentPane.add(entradaB);
		entradaB.setColumns(10);
		
		JLabel lblC = new JLabel("C)");
		lblC.setBounds(31, 264, 46, 14);
		contentPane.add(lblC);
		
		entradaC = new JTextField();
		entradaC.setBounds(32, 278, 378, 20);
		contentPane.add(entradaC);
		entradaC.setColumns(10);
		
		JLabel lblD = new JLabel("D)");
		lblD.setBounds(32, 317, 46, 14);
		contentPane.add(lblD);
		
		entradaD = new JTextField();
		entradaD.setBounds(32, 331, 377, 20);
		contentPane.add(entradaD);
		entradaD.setColumns(10);
		
		JLabel lblE = new JLabel("E)");
		lblE.setBounds(32, 362, 46, 14);
		contentPane.add(lblE);
		
		entradaE = new JTextField();
		entradaE.setBounds(31, 376, 378, 20);
		contentPane.add(entradaE);
		entradaE.setColumns(10);
		
		JRadioButton rdbtnD = new JRadioButton("D");
		rdbtnD.setBounds(283, 422, 56, 23);
		contentPane.add(rdbtnD);
		
		JRadioButton rdbtnE = new JRadioButton("E");
		rdbtnE.setBounds(341, 422, 70, 23);
		contentPane.add(rdbtnE);
		
		JRadioButton rdbtnC = new JRadioButton("C");
		rdbtnC.setBounds(218, 422, 46, 23);
		contentPane.add(rdbtnC);
		
		JRadioButton rdbtnB = new JRadioButton("B");
		rdbtnB.setBounds(145, 422, 46, 23);
		contentPane.add(rdbtnB);
		
		JRadioButton rdbtnA = new JRadioButton("A");
		rdbtnA.setBounds(61, 422, 46, 23);
		contentPane.add(rdbtnA);
		
		JLabel lblGabarito = new JLabel("Gabarito:");
		lblGabarito.setBounds(32, 401, 46, 14);
		contentPane.add(lblGabarito);
	}
}
