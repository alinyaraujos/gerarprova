package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
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
import model.Turma;
import patternproject.FactoryDAO;

public class TelaCadastrarProva extends JFrame {

	private JPanel contentPane;
	private JTextField numeroQuestao;
	private JTextField entradaApelido;
	private FactoryDAO<Turma> fpTurma;
	private GeraProva gp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarProva frame = new TelaCadastrarProva();
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
	public TelaCadastrarProva() {
		
		this.gp = new GeraProva();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGerarProva = new JLabel("Gerar Prova");
		lblGerarProva.setBounds(173, 35, 105, 14);
		contentPane.add(lblGerarProva);
		
		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setBounds(34, 139, 127, 23);
		contentPane.add(lblDisciplina);
		
		JLabel lblAssunto = new JLabel("Assunto:");
		lblAssunto.setBounds(34, 214, 98, 14);
		contentPane.add(lblAssunto);
		
		JLabel lblNmeroDeQuestes = new JLabel("N\u00FAmero de Quest\u00F5es:");
		lblNmeroDeQuestes.setBounds(34, 339, 204, 14);
		contentPane.add(lblNmeroDeQuestes);
		
		numeroQuestao = new JTextField();
		numeroQuestao.setBounds(34, 364, 141, 29);
		contentPane.add(numeroQuestao);
		
		JLabel label = new JLabel("Turma:");
		label.setBounds(34, 81, 127, 23);
		contentPane.add(label);		
		
		JLabel lblApelido = new JLabel("Apelido:");
		lblApelido.setBounds(34, 275, 204, 14);
		contentPane.add(lblApelido);
		
		entradaApelido = new JTextField();
		entradaApelido.setBounds(34, 300, 379, 23);
		contentPane.add(entradaApelido);
		
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(235, 339, 98, 14);
		contentPane.add(lblNivel);
		
		final JComboBox selecaoTurma = new JComboBox();
		selecaoTurma.setModel(new TurmaComboBoxModel());
		selecaoTurma.setBounds(34, 114, 379, 20);
		contentPane.add(selecaoTurma);
		
		final JComboBox comboBoxNivel = new JComboBox();
		comboBoxNivel.setModel(new DefaultComboBoxModel(new String[] {"", "Facil", "Media", "Dificil"}));
		comboBoxNivel.setBounds(235, 369, 178, 20);
		contentPane.add(comboBoxNivel);
		
		final JComboBox selecaoAssunto = new JComboBox();
		selecaoAssunto.setBounds(34, 239, 379, 20);
		contentPane.add(selecaoAssunto);
		
		final JComboBox selecaoDisciplina = new JComboBox();
		selecaoDisciplina.setModel(new DisciplinaComboBoxModel());
		selecaoDisciplina.setBounds(34, 169, 379, 20);
		selecaoDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selecaoAssunto.setModel(new AssuntoComboBoxModel(selecaoDisciplina.getSelectedItem()));
			}
		});
		contentPane.add(selecaoDisciplina);
		
		
		//ação salvar
		
		JButton btnSalvar = new JButton("Gerar PDF");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int num = Integer.parseInt(numeroQuestao.getText());
				
					boolean gerarProva = gp.geraPdf(num, ((Assunto) selecaoAssunto.getSelectedItem()), entradaApelido.getText());
					System.out.println(gerarProva);
					if(gerarProva) {
						JOptionPane.showMessageDialog(null, "Prova salva com sucesso! Caso deseje gerar o pdf click no botão: 'Gerar PDf'");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Quantidade de questões não existem cadastrada no banco");
					}
					
				}catch (Exception exception) {
					System.out.println(exception.getMessage());
				}
			}
		});
		btnSalvar.setBounds(328, 419, 122, 29);
		contentPane.add(btnSalvar);
		
		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int num = Integer.parseInt(numeroQuestao.getText());
				
					System.out.println(((Assunto) selecaoAssunto.getSelectedItem()));
					System.out.println(((Turma) selecaoTurma.getSelectedItem()).getCodigo());
					boolean gerarProva = gp.salvaProva(num,((Assunto) selecaoAssunto.getSelectedItem()), ((Turma) selecaoTurma.getSelectedItem()).getCodigo(), entradaApelido.getText());
					
					System.out.println(gerarProva);
					if(gerarProva) {
						JOptionPane.showMessageDialog(null, "Prova salva com sucesso! Caso deseje gerar o pdf click no botão: 'Gerar PDf'");
					}else {
						JOptionPane.showMessageDialog(null, "Quantidade de questões não existem cadastrada no banco");
					}
					
				}catch (Exception exception) {
					System.out.println(exception.getMessage());
				}
			}
		});
		button.setBounds(138, 435, 122, 29);
		contentPane.add(button);
		
		
		//ação cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(328, 467, 122, 23);
		contentPane.add(btnCancelar);
	}
}
