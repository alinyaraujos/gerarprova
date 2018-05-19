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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Assunto;
import model.GeraProva;

public class TelaGerarProvaEscolha extends JFrame {

	private JPanel contentPane;

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
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
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
	}
}
