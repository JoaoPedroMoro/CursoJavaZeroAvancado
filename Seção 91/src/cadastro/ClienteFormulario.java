package cadastro;

import cadastro.Cliente;
import cadastro.ClienteDAO;
import cadastro.ValidadorEmail;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class ClienteFormulario extends JDialog {
	
	private final JTextField campoNome = new JTextField(30);
	private final JTextField campoEmail = new JTextField(30);
	private final JTextField campoTelefone = new JTextField(20);
	
	private final JButton btnSalvar = new JButton("Salvar");
	private final JButton btnCancelar = new JButton("Cancelar");
	
	private final ClienteDAO dao = new ClienteDAO();
	private Cliente clienteEdicao; // Objeto Cliente que será editado no formulário.
	
	private boolean confirmado = false;
	
	private final Font FONTE_ROTULO = new Font("SansSerif", Font.BOLD, 16);
	private final Font FONTE_CAMPO = new Font("SansSerif", Font.PLAIN, 16);
	private final Font FONTE_BOTAO = new Font("SansSerif", Font.BOLD, 16);
	private final Font FONTE_TITULO = new Font("SansSerif", Font.BOLD, 18);
	 
	public ClienteFormulario(Frame dono, Cliente clienteEdicao) {
		
		super(dono, true);
		
		this.clienteEdicao = clienteEdicao;
		
		setTitle(clienteEdicao == null ? "Novo Cliente" : "Editar Cliente");
		
		setMinimumSize(new Dimension(720, 320));
		
		setLocationRelativeTo(dono);
		
		setLayout(new BorderLayout(0, 0));
		
		setResizable(false);
		
		JPanel painelCampos = new JPanel(new GridBagLayout());
		
		painelCampos.setBorder(new TitledBorder(
				BorderFactory.createCompoundBorder(new EmptyBorder(12, 12, 0, 12), 
						BorderFactory.createLineBorder(new Color(220, 220, 220))
				),
				"Dados do Cliente", TitledBorder.LEFT,
				TitledBorder.TOP,
				FONTE_TITULO
		));
		
		painelCampos.setBackground(Color.WHITE);
		
		GridBagConstraints gbc = new GridBagConstraints();	
		gbc.insets = new Insets(12, 12, 6, 12);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0;
		
		JLabel lblNome = new JLabel("Nome:");
		JLabel lblEmail = new JLabel("E-mail:");
		JLabel lblTelefone = new JLabel("Telefone (opcional):");
		
		lblNome.setFont(FONTE_ROTULO);
		lblEmail.setFont(FONTE_ROTULO);
		lblTelefone.setFont(FONTE_ROTULO);
		
		campoNome.setFont(FONTE_CAMPO);
		campoEmail.setFont(FONTE_CAMPO);
		campoTelefone.setFont(FONTE_CAMPO);
		
		campoNome.setPreferredSize(new Dimension(420, 36));
		campoEmail.setPreferredSize(new Dimension(420, 36));
		campoTelefone.setPreferredSize(new Dimension(260, 36));
		
		campoNome.setToolTipText("Informe o nome completo (obrigatório).");
		campoEmail.setToolTipText("Informe um e-mail válido (obrigatório e único).");
		campoTelefone.setToolTipText("Opcional. Ex.: (11) 99999-9999");
		
		// Coluna 0 - posicionamento dos rótulos
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0; gbc.gridy = 0; 
		painelCampos.add(lblNome, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		painelCampos.add(lblEmail, gbc);
		
		gbc.gridx = 0; gbc.gridy = 2;
		painelCampos.add(lblTelefone, gbc);
		
		// Coluna 1 - campos de entrada;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1;
		painelCampos.add(campoNome, gbc);
		
		gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 1;
		painelCampos.add(campoEmail, gbc);
		
		gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 1;
		painelCampos.add(campoTelefone, gbc);
		
		add(painelCampos, BorderLayout.CENTER);
		
		JPanel painelRodape = new JPanel(new BorderLayout());
		painelRodape.setBorder(new EmptyBorder(10, 12, 12, 12));
		painelRodape.setBackground(new Color(245, 245, 245));
		
		JPanel botoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 6));
		botoes.setOpaque(false);
		btnSalvar.setFont(FONTE_BOTAO);
		btnCancelar.setFont(FONTE_BOTAO);
		
		btnSalvar.setMnemonic('S');
		btnCancelar.setMnemonic('C');
		
		btnSalvar.setToolTipText("Salvar (Enter).");
		btnCancelar.setToolTipText("Cancelar (Esc).");
		
		botoes.add(btnSalvar);
		botoes.add(btnCancelar);
		painelRodape.add(botoes, BorderLayout.EAST);
		
		add(painelRodape, BorderLayout.SOUTH);
		
		btnCancelar.addActionListener(e -> dispose());
		btnSalvar.addActionListener(this::salvarAcao);
		
		getRootPane().setDefaultButton(btnSalvar);  // Setando enter
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
			.put(KeyStroke.getKeyStroke("ESCAPE"), "fechar"); // Setando esc
		getRootPane().getActionMap().put("fechar", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {dispose();}
			
		});
		
		if (clienteEdicao != null) preencherCampos();
		
		SwingUtilities.invokeLater(() -> campoNome.requestFocusInWindow());
		
	}
	
	private void preencherCampos() {
		
		campoNome.setText(clienteEdicao.getNome());
		campoEmail.setText(clienteEdicao.getEmail());
		campoTelefone.setText(clienteEdicao.getTelefone());
		
	}
	
	private void salvarAcao(ActionEvent ev) {salvar();}
	
	private void salvar() {
		
		String nome = campoNome.getText().trim();
		String email = campoEmail.getText().trim();
		String telefone = campoTelefone.getText().trim();
		
		if (nome.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Informe o nome.", "Validação",JOptionPane.WARNING_MESSAGE);
			campoNome.requestFocus();
			return;
		}
		
		if (!ValidadorEmail.ehValido(email)) {
			JOptionPane.showMessageDialog(this, "E-mail inválido.", "Validação", JOptionPane.WARNING_MESSAGE);
			
			campoEmail.requestFocus();
			
			return;
			
			
		}
		
		try {
			
			if (clienteEdicao == null) {
				
				Cliente novo = new Cliente(nome, email, telefone.isEmpty() ? null : telefone);
				
				dao.inserir(novo);
				
			} else {
				
				clienteEdicao.setNome(nome);
				clienteEdicao.setEmail(email);
				clienteEdicao.setTelefone(telefone.isEmpty() ? null : telefone);
				
				dao.atualizar(clienteEdicao);
				
			}
			
			confirmado = true;
			
			dispose();
			
		} catch (SQLException e) {
			
			String msg = e.getMessage();
			
			if (msg != null && msg.toLowerCase().contains("duplicate")) {
				
				JOptionPane.showMessageDialog(this, "Já existe um cliente com este e-mail.",
						"Erro de banco", JOptionPane.ERROR_MESSAGE);
				
				campoEmail.requestFocus();
				
			} else {
				
				JOptionPane.showMessageDialog(this, 
						"Erro de banco: " + msg,
						"Erro de banco", JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		
	}
	
	public boolean foiConfirmado() { return confirmado; }

}
