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
import javax.swing.JOptionPane;
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel lblAssunto = new JLabel("Assunto:");
		lblAssunto.setBounds(34, 130, 98, 14);
		contentPane.add(lblAssunto);
		
		JLabel lblNmeroDeQuestes = new JLabel("N\u00FAmero de Quest\u00F5es:");
		lblNmeroDeQuestes.setBounds(34, 193, 204, 14);
		contentPane.add(lblNmeroDeQuestes);
		
		numeroQuestao = new JTextField();
		numeroQuestao.setBounds(34, 223, 114, 35);
		contentPane.add(numeroQuestao);

		final JComboBox selecaoAssunto = new JComboBox();
		selecaoAssunto.setBounds(34, 145, 379, 20);
		contentPane.add(selecaoAssunto);
		
		final JComboBox selecaoDisciplina = new JComboBox();
		selecaoDisciplina.setModel(new DisciplinaComboBoxModel());
		selecaoDisciplina.setBounds(34, 88, 379, 20);
		selecaoDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selecaoAssunto.setModel(new AssuntoComboBoxModel(selecaoDisciplina.getSelectedItem()));
			}
		});
		contentPane.add(selecaoDisciplina);
		
		//a��o salvar
		try {
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					GeraProva gp = new GeraProva();
					int num = Integer.parseInt(numeroQuestao.getText());
				
					boolean gerarProva = gp.geraPdf(num, ((Assunto) selecaoAssunto.getSelectedItem()), null);
					System.out.println(gerarProva);
					if(gerarProva) {
						JOptionPane.showMessageDialog(null, "Prova salva com sucesso! Caso deseje gerar o pdf click no bot�o: 'Gerar PDf'");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Quantidade de quest�es n�o existem cadastrada no banco");
					}
					
				}catch (Exception exception) {
					System.out.println(exception.getMessage());
				}
			}
		});
		btnSalvar.setBounds(267, 287, 89, 23);
		contentPane.add(btnSalvar);
		
		//a��o cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(102, 287, 89, 23);
		contentPane.add(btnCancelar);
	}
}
