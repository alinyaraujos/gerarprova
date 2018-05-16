package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaGeraProva extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGeraProva frame = new TelaGeraProva();
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
	public TelaGeraProva() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGerarProva = new JLabel("Gerar Prova");
		lblGerarProva.setBounds(173, 36, 63, 14);
		contentPane.add(lblGerarProva);
		
		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setBounds(34, 74, 63, 14);
		contentPane.add(lblDisciplina);
		
		JComboBox selecaoDisciplina = new JComboBox();
		selecaoDisciplina.setBounds(34, 88, 379, 20);
		contentPane.add(selecaoDisciplina);
		
		JLabel lblAssunto = new JLabel("Assunto:");
		lblAssunto.setBounds(34, 130, 46, 14);
		contentPane.add(lblAssunto);
		
		JComboBox selecaoAssunto = new JComboBox();
		selecaoAssunto.setBounds(34, 145, 379, 20);
		contentPane.add(selecaoAssunto);
		
		JLabel lblNmeroDeQuestes = new JLabel("N\u00FAmero de Quest\u00F5es:");
		lblNmeroDeQuestes.setBounds(34, 186, 114, 14);
		contentPane.add(lblNmeroDeQuestes);
		
		JComboBox numeroQuestao = new JComboBox();
		numeroQuestao.setBounds(34, 205, 63, 20);
		contentPane.add(numeroQuestao);
		
		//ação salvar
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaPrincipal().setVisible(true);
			}
		});
		btnSalvar.setBounds(267, 287, 89, 23);
		contentPane.add(btnSalvar);
		
		//ação cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaPrincipal().setVisible(true);
			}
		});
		btnCancelar.setBounds(102, 287, 89, 23);
		contentPane.add(btnCancelar);
	}
}
