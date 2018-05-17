package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Assunto;
import model.GeraProva;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaGeraProva extends JFrame {

	private JPanel contentPane;
	private JTextField numeroQuestao;

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
		
		final JComboBox selecaoAssunto = new JComboBox();
		
		final JComboBox selecaoDisciplina = new JComboBox();
		
		
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
		lblDisciplina.setBounds(34, 74, 127, 14);
		contentPane.add(lblDisciplina);
		
		
		selecaoDisciplina.setModel(new DisciplinaComboBoxModel());
		selecaoDisciplina.setBounds(34, 88, 379, 20);
		selecaoDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selecaoAssunto.setModel(new AssuntoComboBoxModel(selecaoDisciplina.getSelectedItem()));
			}
		});
		
		contentPane.add(selecaoDisciplina);
		
		JLabel lblAssunto = new JLabel("Assunto:");
		lblAssunto.setBounds(34, 130, 98, 14);
		contentPane.add(lblAssunto);
		
		selecaoAssunto.setBounds(34, 145, 379, 20);
		contentPane.add(selecaoAssunto);
		
		JLabel lblNmeroDeQuestes = new JLabel("N\u00FAmero de Quest\u00F5es:");
		lblNmeroDeQuestes.setBounds(34, 193, 204, 14);
		contentPane.add(lblNmeroDeQuestes);
		
		numeroQuestao = new JTextField();
		numeroQuestao.setBounds(34, 223, 114, 35);
		contentPane.add(numeroQuestao);

		
		//ação salvar
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeraProva gp = new GeraProva();
				int num = Integer.parseInt(numeroQuestao.getText());
				gp.geraPdf(num, ((Assunto) selecaoAssunto.getSelectedItem()));
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
