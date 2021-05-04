package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import Controller.FuncionarioDAO;
import Model.Funcionario;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FuncionarioView {
	
	private JFrame frame;
	private JTextField txtBuscarId;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioView window = new FuncionarioView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FuncionarioView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Navega\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Navega\u00E7\u00E3o", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 0, 510, 74);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("|<");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(10, 29, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(109, 29, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton(">");
		btnNewButton_1_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(208, 29, 89, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton(">|");
		btnNewButton_1_1_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1.setBounds(307, 29, 89, 23);
		panel.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Fechar");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton_1_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1_1.setBounds(406, 29, 89, 23);
		panel.add(btnNewButton_1_1_1_1);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioDAO funcionario = new FuncionarioDAO();
				Integer id = Integer.parseInt(txtBuscarId.getText());
				Funcionario p1 = funcionario.findById(id);
				txtID.setText(p1.getId().toString());
				txtNome.setText(p1.getNome());
				txtEmail.setText(p1.getEmail());
			}
		});
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setBounds(399, 84, 101, 24);
		frame.getContentPane().add(btnPesquisar);
		
		txtBuscarId = new JTextField();
		txtBuscarId.setBounds(337, 85, 52, 23);
		frame.getContentPane().add(txtBuscarId);
		txtBuscarId.setColumns(10);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(10, 139, 36, 20);
		frame.getContentPane().add(txtID);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 195, 231, 20);
		frame.getContentPane().add(txtNome);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 247, 231, 20);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 114, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 170, 46, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setBounds(10, 222, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioDAO func = new FuncionarioDAO();
				Funcionario funcionario = new Funcionario(null, txtNome.getText(), txtEmail.getText());
				func.save(funcionario);
				JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
			}
		});
		btnGravar.setFont(new Font("Verdana", Font.BOLD, 11));
		btnGravar.setBackground(Color.WHITE);
		btnGravar.setBounds(53, 286, 89, 34);
		frame.getContentPane().add(btnGravar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioDAO funcionario = new FuncionarioDAO();
				int id = Integer.parseInt(txtID.getText());
				try {
					funcionario.update(id, txtNome.getText(), txtEmail.getText());
					JOptionPane.showMessageDialog(null, "Registro atualizado com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro: " + e1.getMessage());
				} 
			}
		});
		btnAlterar.setFont(new Font("Verdana", Font.BOLD, 11));
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setBounds(165, 287, 89, 33);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Deletar");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioDAO funcionario = new FuncionarioDAO();
				Integer id = Integer.parseInt(txtID.getText());
				if(txtID.equals(0)) {
					JOptionPane.showMessageDialog(null, "Não há nenhum registro para ser excluído.");
				} else {
					funcionario.delete(id);
					JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
				}
			}
		});
		btnExcluir.setFont(new Font("Verdana", Font.BOLD, 11));
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(289, 287, 89, 33);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnCancelar.setFont(new Font("Verdana", Font.BOLD, 11));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(400, 287, 100, 33);
		frame.getContentPane().add(btnCancelar);
		frame.setBounds(100, 100, 526, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void limparCampos() {
		txtID.setText(null);
		txtNome.setText(null);
		txtEmail.setText(null);
	}
}
