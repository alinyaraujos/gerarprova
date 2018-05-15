package gerarProva;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastraAssunto extends JFrame {

	private JPanel contentPane;
	private JTextField entradaConteudo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastraAssunto frame = new TelaCadastraAssunto();
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
	public TelaCadastraAssunto() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeAssuntos = new JLabel("Cadastro de Assuntos");
		lblCadastroDeAssuntos.setBounds(143, 34, 148, 14);
		contentPane.add(lblCadastroDeAssuntos);
		
		entradaConteudo = new JTextField();
		entradaConteudo.setBounds(36, 95, 368, 20);
		contentPane.add(entradaConteudo);
		entradaConteudo.setColumns(10);
		
		JLabel lblNomeDoContedo = new JLabel("Nome do Conte\u00FAdo:");
		lblNomeDoContedo.setBounds(35, 70, 122, 14);
		contentPane.add(lblNomeDoContedo);
		
		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setBounds(36, 137, 71, 14);
		contentPane.add(lblDisciplina);
		
		JComboBox disciplina = new JComboBox();
		disciplina.setBounds(36, 162, 368, 20);
		contentPane.add(disciplina);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaPrincipal().setVisible(true);
			}
		});
		btnCancelar.setBounds(87, 227, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(250, 227, 89, 23);
		contentPane.add(btnSalvar);
	}
}
