package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGerarProva = new JButton("Gerar Prova");
		btnGerarProva.setBounds(169, 216, 101, 23);
		contentPane.add(btnGerarProva);
		
		JButton btnMinhasInformaes = new JButton("Minhas Informa\u00E7\u00F5es");
		btnMinhasInformaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new TelaMinhaInformacao().setVisible(true);
			}
		});
		btnMinhasInformaes.setBounds(27, 99, 158, 23);
		contentPane.add(btnMinhasInformaes);
		
		JButton btnTurmas = new JButton("Turmas");
		btnTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new TelaTurma().setVisible(true);
			}
		});
		btnTurmas.setBounds(27, 133, 158, 23);
		contentPane.add(btnTurmas);
		
		JButton btnAlunos = new JButton("Alunos");
		btnAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new TelaAluno().setVisible(true);
			}
		});
		btnAlunos.setBounds(27, 167, 158, 23);
		contentPane.add(btnAlunos);
		
		JButton btnDisciplinas = new JButton("Disciplinas");
		btnDisciplinas.setBounds(252, 99, 158, 23);
		contentPane.add(btnDisciplinas);
		
		JButton btnAssuntos = new JButton("Assuntos");
		btnAssuntos.setBounds(252, 133, 158, 23);
		contentPane.add(btnAssuntos);
		
		JButton btnQuestes = new JButton("Quest\u00F5es");
		btnQuestes.setBounds(252, 167, 158, 23);
		contentPane.add(btnQuestes);
		
		JLabel lblGeraprova = new JLabel("GeraProva");
		lblGeraprova.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/image/foto.jpg")));
		lblGeraprova.setBounds(-36, 0, 487, 58);
		contentPane.add(lblGeraprova);
	}
}
