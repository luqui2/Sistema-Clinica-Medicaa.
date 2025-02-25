package tabelas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import agenda.NovaAgenda;
import mouse.MouseFunction;
import paciente.AddPaciente;
import paciente.EditarPaciente;
import principal.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JTable;
import banco.QueryBd;
import entidades.Paciente;
import model.PacienteTableModel;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class TabelaPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jTabelaPaciente;
	private JTextField txtPesquisar;
	private ArrayList<Paciente> pacientes = new ArrayList<>();
	private Connection con;
	PacienteTableModel paciente_tableModel = new PacienteTableModel();

	private NovaAgenda novaAgenda;

	public TabelaPaciente(Connection con, NovaAgenda novaAgenda) {
		setResizable(false);

		this.novaAgenda = novaAgenda;

		this.con = con;
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TabelaPaciente.class.getResource("/Imagens/mask_icon_134856 (2).png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 11, 1121, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1139, 692);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 81, 1070, 453);
		panel_1.add(scrollPane);

		jTabelaPaciente = new JTable();

		scrollPane.setViewportView(jTabelaPaciente);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(TabelaPaciente.class.getResource("/Imagens/trash.png")));
		btnExcluir.setBounds(255, 21, 90, 34);
		panel_1.add(btnExcluir);

		JLabel lblPesquisarr = new JLabel("Pesquisar:");
		lblPesquisarr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPesquisarr.setBounds(356, 28, 67, 17);
		panel_1.add(lblPesquisarr);

		txtPesquisar = new JTextField();

		txtPesquisar.setBounds(424, 21, 530, 34);
		panel_1.add(txtPesquisar);
		txtPesquisar.setColumns(10);

		btnExcluir.setBackground(new java.awt.Color(0, 102, 52));
		btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
		btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
		btnExcluir.setBorder(null);
		btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		btnExcluir.setDoubleBuffered(true);

		JButton btnEditar = new JButton("Editar");

		btnEditar.setIcon(new ImageIcon(TabelaPaciente.class.getResource("/Imagens/edit.png")));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnEditar.setDoubleBuffered(true);
		btnEditar.setBorder(null);
		btnEditar.setBackground(new Color(0, 102, 52));
		btnEditar.setBounds(144, 21, 90, 35);
		panel_1.add(btnEditar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon(TabelaPaciente.class.getResource("/Imagens/plus-black-symbol.png")));
		btnNovo.setForeground(Color.WHITE);
		btnNovo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNovo.setDoubleBuffered(true);
		btnNovo.setBorder(null);
		btnNovo.setBackground(new Color(0, 102, 52));
		btnNovo.setBounds(33, 21, 90, 35);
		panel_1.add(btnNovo);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setIcon(new ImageIcon(TabelaPaciente.class.getResource("/Imagens/search.png")));
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnPesquisar.setDoubleBuffered(true);
		btnPesquisar.setBorder(null);
		btnPesquisar.setBackground(new Color(0, 102, 52));
		btnPesquisar.setBounds(963, 21, 129, 34);
		panel_1.add(btnPesquisar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TabelaPaciente.class.getResource("/Imagens/trash.png")));
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLimpar.setDoubleBuffered(true);
		btnLimpar.setBorder(null);
		btnLimpar.setBackground(Color.RED);
		btnLimpar.setBounds(963, 21, 129, 34);
		panel_1.add(btnLimpar);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setIconTextGap(6);
		btnContinuar.setIcon(new ImageIcon(TabelaPaciente.class.getResource("/Imagens/checked.png")));
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnContinuar.setDoubleBuffered(true);
		btnContinuar.setBorder(null);
		btnContinuar.setBackground(new Color(0, 102, 52));
		btnContinuar.setBounds(584, 555, 146, 40);
		panel_1.add(btnContinuar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIconTextGap(6);
		btnCancelar.setIcon(new ImageIcon(TabelaPaciente.class.getResource("/Imagens/error.png")));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancelar.setDoubleBuffered(true);
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setBounds(424, 555, 146, 40);
		panel_1.add(btnCancelar);

		btnLimpar.setVisible(false);

		// Metodo responsavel por instanciar todos os passageiros no Jtable

		QueryBd banco = new QueryBd(con);

		banco.exibirAlllPacientes(paciente_tableModel);

		// Instanciando meu proprio model (jtable)

		jTabelaPaciente.setModel(paciente_tableModel);

		// Escutadores + fun�oes

		excluirPaciente(btnExcluir);

		adicionarPaciente(btnNovo);

		editarPaciente(btnEditar, jTabelaPaciente);

		pesquisarClick(btnPesquisar, txtPesquisar, paciente_tableModel, banco);

		pesquisarPressedKey(btnPesquisar, banco, btnLimpar, null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TabelaPaciente.class.getResource("/Imagens/aaaaaaaaaaaaaaa.jpg")));
		lblNewLabel.setBounds(0, -4, 1118, 624);
		panel_1.add(lblNewLabel);

		continuar(btnContinuar);
		cancelar(btnCancelar);

	}

	public void cancelar(JButton btnCancelar) {

		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
	}

	public void continuar(JButton btnContinuar) {

		btnContinuar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (jTabelaPaciente.getSelectedRow() != -1) {
					int linha = jTabelaPaciente.getSelectedRow();

					String id = jTabelaPaciente.getValueAt(linha, 0).toString();
					String nome = jTabelaPaciente.getValueAt(linha, 1).toString();
					String cpf = jTabelaPaciente.getValueAt(linha, 2).toString();
					String endereco = jTabelaPaciente.getValueAt(linha, 3).toString();
					String email = jTabelaPaciente.getValueAt(linha, 4).toString();

					novaAgenda.setarPaciente(nome, id);
					novaAgenda.setLocationRelativeTo(null);

					novaAgenda.setVisible(true);

					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Por Favor, Selecione um Paciente", "Paciente Invalido",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});
	}

	public void pesquisarPressedKey(JButton btnPesquisar, QueryBd banco, JButton btnLimpar, JLabel lblt1) {

		// Evento ao digita
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (txtPesquisar.getText().trim().length() <= 1) // vai procurar de 3 em 3 digitos
				{

					// Metodo que atualiza a jtable
					paciente_tableModel.limpaTabela(paciente_tableModel.getRowCount());
					banco.exibirAlllPacientes(paciente_tableModel);

					btnPesquisar.setVisible(true);
					btnLimpar.setVisible(false);

				}

				else {

					String nome = txtPesquisar.getText();

					banco.pesquisarPaciente(nome, paciente_tableModel);

					btnPesquisar.setVisible(false);
					btnLimpar.setVisible(true);

					limpar(btnLimpar, txtPesquisar, banco, btnPesquisar);

				}

			}

		});

	}

	// metodos

	public void pesquisarClick(JButton btnPesquisar, JTextField txtPesquisar2, PacienteTableModel paciente_tableModel2,
			QueryBd banco) {

		// PESQUISAR

		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				NovaAgenda kk = new NovaAgenda(con, null);
				kk.setLocationRelativeTo(null);
				kk.setVisible(true);

				dispose();

				if (txtPesquisar.getText().trim().equals("")) {

					// Metodo que atualiza a jtable
					paciente_tableModel.limpaTabela(paciente_tableModel.getRowCount());
					banco.exibirAlllPacientes(paciente_tableModel);

				} else {
					String nome = txtPesquisar.getText();

					banco.pesquisarPaciente(nome, paciente_tableModel);

				}

			}
		});

	}

	public void editarPaciente(JButton btnEditar, JTable jTabelaPaciente2) {

		// editar escutador
		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				editarPaciente(jTabelaPaciente);

			}
		});

	}

	public void limpar(JButton btnlimpar, JTextField txtpesquisar, QueryBd banco, JButton btnPesquisar) {

		btnlimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtpesquisar.setText("");
				reseta(txtpesquisar, banco, btnlimpar, btnPesquisar);

			}
		});

	}

	public void reseta(JTextField txtPesquisar, QueryBd banco, JButton btnlimpar, JButton btnPesquisar) {

		// Metodo que atualiza a jtable
		paciente_tableModel.limpaTabela(paciente_tableModel.getRowCount());
		btnlimpar.setVisible(false);
		btnPesquisar.setVisible(true);
		banco.exibirAlllPacientes(paciente_tableModel);

	}

	public void editarPaciente(JTable jTabelaPaciente) {

		if (jTabelaPaciente.getSelectedRow() != -1) {
			int linha = jTabelaPaciente.getSelectedRow();

			String id = jTabelaPaciente.getValueAt(linha, 0).toString();
			String nome = jTabelaPaciente.getValueAt(linha, 1).toString();
			String cpf = jTabelaPaciente.getValueAt(linha, 2).toString();
			String endereco = jTabelaPaciente.getValueAt(linha, 3).toString();
			String email = jTabelaPaciente.getValueAt(linha, 4).toString();

			EditarPaciente novoPaciente = new EditarPaciente(paciente_tableModel, con, nome, cpf, endereco, email, id);
			novoPaciente.setLocationRelativeTo(null);
			novoPaciente.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(null, "Por Favor, Selecione um Paciente", "Paciente Invalido",
					JOptionPane.ERROR_MESSAGE);

		}

	}

	public void adicionarPaciente(JButton btnNovo)

	{
		btnNovo.addActionListener(new ActionListener() // Escutador
		{
			@Override
			public void actionPerformed(ActionEvent e) {

				AddPaciente novoPaciente = new AddPaciente(paciente_tableModel, con);
				novoPaciente.setLocationRelativeTo(null);
				novoPaciente.setVisible(true);

			}
		});

	}

	public void excluirPaciente(JButton btnExcluir) {

		btnExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// metodo que verifica se a linha esta selecionada(se nao estiver ela valera -1)

				if (jTabelaPaciente.getSelectedRow() != -1) {

					int i = JOptionPane.showConfirmDialog(null, "Deseja Excluir o paciente selecionado?", "Passageiros",
							JOptionPane.OK_CANCEL_OPTION);

					if (i == JOptionPane.YES_OPTION) {
						System.out.println("Clicou em Sim");

						String cpf = jTabelaPaciente.getValueAt(jTabelaPaciente.getSelectedRow(), 2).toString();

						paciente_tableModel.removeLinha(jTabelaPaciente.getSelectedRow(), cpf, con, jTabelaPaciente); // metodo
																														// que
																														// exclui
																														// a
																														// linha

					}

					else if (i == JOptionPane.CANCEL_OPTION) {

						System.out.println("Clicou em N�o");

					}

				}

				// se nao tiver nehum paciente selecioando
				else {

					JOptionPane.showMessageDialog(null, "Por Favor, Selecione um Paciente", "Paciente Invalido",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});

	}

	public void home(JLabel lblInicio)

	{

		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				MenuPrincipal home = new MenuPrincipal(con);
				home.setLocationRelativeTo(null);
				home.setVisible(true);
				dispose();

			}
		});

	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
}