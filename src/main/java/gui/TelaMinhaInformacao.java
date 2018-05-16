package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Professor;
import patternproject.FactoryDAO;
import persistencia.Manager;
import persistencia.ProfessorDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaMinhaInformacao extends JFrame {

	private JPanel contentPane;
	private JTextField entradaCpf;
	private JTextField entradaNome;
	private JTextField entradaEmail;
	private JTextField entradaInstituicao;
	private FactoryDAO<Professor> fp;

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
		this.fp = new FactoryDAO();
		List<Professor> professores;
		Professor p = new Professor();
		
		Manager<Professor> professorManager = fp.getObjectDAO(p);
		
		professores = professorManager.getAll();
		
		if (professores.size() > 0)
			p = professores.get(0);
		
		professorManager.exit();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 342);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformaesPessoais = new JLabel("Informa\u00E7\u00F5es Pessoais");
		lblInformaesPessoais.setBounds(135, 31, 170, 14);
		contentPane.add(lblInformaesPessoais);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(26, 75, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(275, 75, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(26, 131, 89, 14);
		contentPane.add(lblEmail);
		
		JLabel lblInstituio = new JLabel("Institui\u00E7\u00E3o:");
		lblInstituio.setBounds(26, 181, 117, 14);
		contentPane.add(lblInstituio);
		
		entradaCpf = new JTextField(p.getCpf());
		entradaCpf.setBounds(275, 100, 149, 20);
		if (p.getCpf() != null)
			entradaCpf.setEditable(false);
		contentPane.add(entradaCpf);
		entradaCpf.setColumns(10);
		
		entradaNome = new JTextField(p.getNome());
		entradaNome.setBounds(26, 100, 238, 20);
		contentPane.add(entradaNome);
		entradaNome.setColumns(10);
		
		entradaEmail = new JTextField(p.getEmail());
		entradaEmail.setBounds(26, 150, 398, 20);
		contentPane.add(entradaEmail);
		entradaEmail.setColumns(10);
		
		entradaInstituicao = new JTextField(p.getInstituicao());
		entradaInstituicao.setBounds(26, 206, 398, 20);
		contentPane.add(entradaInstituicao);
		entradaInstituicao.setColumns(10);
		
		//a��o cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		btnCancelar.setBounds(96, 258, 117, 23);
		contentPane.add(btnCancelar);
		
		//a��o salvar
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(entradaEmail.getText());
				Professor professor = new Professor();
				professor.cadastrar(entradaCpf.getText(),entradaNome.getText(),entradaEmail.getText() , entradaInstituicao.getText());
				Manager<Professor> professorManager = fp.getObjectDAO(professor);
				professorManager.update();
				professorManager.exit();
				
				JOptionPane.showMessageDialog(null, "Os dados foram atualizados com sucesso.");
				
				dispose();
			}
		});
		btnSalvar.setBounds(251, 258, 117, 23);
		contentPane.add(btnSalvar);
	}
}

