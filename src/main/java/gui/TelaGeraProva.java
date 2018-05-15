package gerarProva;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(34, 88, 379, 20);
		contentPane.add(comboBox);
		
		JLabel lblAssunto = new JLabel("Assunto:");
		lblAssunto.setBounds(34, 130, 46, 14);
		contentPane.add(lblAssunto);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(34, 145, 379, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblNmeroDeQuestes = new JLabel("N\u00FAmero de Quest\u00F5es:");
		lblNmeroDeQuestes.setBounds(34, 186, 114, 14);
		contentPane.add(lblNmeroDeQuestes);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(34, 205, 63, 20);
		contentPane.add(comboBox_2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(267, 287, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(102, 287, 89, 23);
		contentPane.add(btnCancelar);
	}
}
