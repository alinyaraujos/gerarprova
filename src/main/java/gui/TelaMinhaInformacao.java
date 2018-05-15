package gerarProva;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMinhaInformacao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMinhaInformacao frame = new TelaMinhaInformacao();
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
	public TelaMinhaInformacao() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformaesPessoais = new JLabel("Informa\u00E7\u00F5es Pessoais");
		lblInformaesPessoais.setBounds(151, 30, 113, 14);
		contentPane.add(lblInformaesPessoais);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(26, 75, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(275, 75, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(26, 131, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblInstituio = new JLabel("Institui\u00E7\u00E3o:");
		lblInstituio.setBounds(26, 181, 68, 14);
		contentPane.add(lblInstituio);
		
		textField = new JTextField();
		textField.setBounds(275, 100, 149, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(26, 100, 238, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(26, 150, 398, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(26, 206, 398, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaMinhaInformacao().setVisible(true);
			}
		});
		btnCancelar.setBounds(96, 258, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new TelaMinhaInformacao().setVisible(true);
			}
		});
		btnSalvar.setBounds(251, 258, 89, 23);
		contentPane.add(btnSalvar);
	}
}
