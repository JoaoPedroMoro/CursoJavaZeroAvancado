package cadastro;

import cadastro.Cliente;
import cadastro.ClienteDAO;
import cadastro.ClienteTabelaModelo;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.time.format.DateTimeFormatter;

public class TelaCadastroClientes extends JFrame {
	
	private final JTextField campoFiltroNome = new JTextField(20);
	private final JTextField campoFiltroEmail = new JTextField(30);
	
	private final JButton btnPesquisar = new JButton("Pesquisar");
	private final JButton btnLimparFiltro = new JButton("Limpar Filtro");
	
	private final ClienteTabelaModelo modeloTabela = new ClienteTabelaModelo();
	
	private final JTable tabela = new JTable(modeloTabela);
	
	private final TableRowSorter<ClienteTabelaModelo> ordenador = new TableRowSorter<>(modeloTabela);
	
	private final JButton btnNovo = new JButton("Novo");
	private final JButton btnEditar = new JButton("Editar");
	private final JButton btnExcluir = new JButton("Excluir");
	private final JButton btnAtualizar = new JButton("Atualizar");
	private final JButton btnExportar = new JButton("Exportar");
	
	private final JLabel rotuloStatus = new JLabel("Pronto.");
	
	private final ClienteDAO dao = new ClienteDAO();
	
	public TelaCadastroClientes() {
		
		super("Cadastro de Clientes");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(980, 620);
		
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout(8, 8));
		
		JPanel painelFiltros = new JPanel(new GridBagLayout());
		painelFiltros.setBorder(new EmptyBorder(10, 10, 0, 10));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(4, 6, 4, 6);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0; gbc.gridy = 0;
		
		painelFiltros.add(new JLabel("Filtro por nome:"), gbc);
		
		gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1.0;
		
		painelFiltros.add(campoFiltroNome, gbc);
		
		gbc.gridx = 2; gbc.gridy = 0;
		
		painelFiltros.add(new JLabel("Filtro por e-mail"), gbc);
		
		gbc.gridx = 3; gbc.gridy = 0; gbc.weightx = 1.0;
		
		painelFiltros.add(campoFiltroEmail, gbc);
		
		gbc.gridx = 4; gbc.gridy = 0;
		
		painelFiltros.add(btnPesquisar, gbc);
		
		gbc.gridx = 5; gbc.gridy = 0;
		
		painelFiltros.add(btnLimparFiltro, gbc);
		
		add(painelFiltros, BorderLayout.NORTH);
		
		tabela.setRowSorter(ordenador);
		
		tabela.setFillsViewportHeight(true);
		
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabela.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		tabela.setRowHeight(26);
		
		tabela.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
		
		tabela.addMouseListener(new java.awt.event.MouseAdapter() {
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				
				if (e.getClickCount() == 2 && tabela.getSelectedRow() >= 0) {

					editarSelecionado();
					
				}
			}
		});
		
		JScrollPane rolagem = new JScrollPane(tabela);
		
		rolagem.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		add(rolagem, BorderLayout.CENTER);
		
		JPanel painelInferior = new JPanel(new BorderLayout());
		
		painelInferior.setBorder(new EmptyBorder(0, 10, 10, 10));
		
		JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 6));
		
		painelBotoes.add(btnNovo);
		painelBotoes.add(btnEditar);
		painelBotoes.add(btnExcluir);
		painelBotoes.add(btnAtualizar);
		painelBotoes.add(btnExportar);
		
		painelInferior.add(painelBotoes, BorderLayout.NORTH);
		
		JPanel barraStatus = new JPanel(new BorderLayout());
		
		barraStatus.setBorder(BorderFactory.createMatteBorder(1, 0,  0, 0, Color.LIGHT_GRAY));
		
		rotuloStatus.setBorder(new EmptyBorder(6, 6, 6, 6));
		
		barraStatus.add(rotuloStatus, BorderLayout.CENTER);
		
		painelInferior.add(barraStatus, BorderLayout.SOUTH);
		
		add(painelInferior, BorderLayout.SOUTH);
		
		btnNovo.setToolTipText("Cadastrar novo cliente (Insert)");
		btnEditar.setToolTipText("Editar cliente selecionado (Enter ou duplo-clique)");
		btnExcluir.setToolTipText("Excluir cliente selecionado (Delete)");
		btnAtualizar.setToolTipText("Recarregar a lista do banco");
		btnExportar.setToolTipText("Exportar dados para Excel (.csv) (Ctrl+E)");
		btnPesquisar.setToolTipText("Aplicar filtros de Nome/E-mail");
		btnLimparFiltro.setToolTipText("Limpar filtros e mostrar todos");
		
		JPopupMenu menu = new JPopupMenu();
		JMenuItem miEditar = new JMenuItem("Editar");
		JMenuItem miExcluir = new JMenuItem("Excluir");
		
		menu.add(miEditar);
		menu.add(miExcluir);
		
		miEditar.addActionListener(e -> btnEditar.doClick());
		miExcluir.addActionListener(e -> btnExcluir.doClick());
		
		tabela.setComponentPopupMenu(menu);
		
		InputMap im = tabela.getInputMap(JComponent.WHEN_FOCUSED);
		
		ActionMap am = tabela.getActionMap();
		
		im.put(KeyStroke.getKeyStroke("INSERT"), "novo");
		
		am.put("novo", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) { btnNovo.doClick(); }
		});
		
		im.put(KeyStroke.getKeyStroke("ENTER"), "editar");
		
		am.put("editar", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) { btnEditar.doClick(); }
			
		});
		
		im.put(KeyStroke.getKeyStroke("DELETE"), "excluir");
		
		am.put("excluir", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) { btnExcluir.doClick(); }
			
		});
		
		im.put(KeyStroke.getKeyStroke("control E"), "exportar");
		
		am.put("exportar", new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) { btnExportar.doClick(); }
			
		});
		
		btnPesquisar.addActionListener(this::acaoPesquisar);
		
		btnLimparFiltro.addActionListener(e -> {
			campoFiltroNome.setText("");
			campoFiltroEmail.setText("");
			ordenador.setRowFilter(null);
			atualizarListaCompleta();
		});
		
		btnNovo.addActionListener(e -> abrirFormulario(null));
		
		btnEditar.addActionListener(e -> editarSelecionado());
		
		btnExcluir.addActionListener(e -> excluirSelecionado());
		
		btnAtualizar.addActionListener(e -> atualizarListaCompleta());
		
		btnExportar.addActionListener(e -> exportarClientes());
		
		DocumentListener listener = new DocumentListener() {
			private void onChange() { /* busca somente ao clicar em pesquisar */}
			public void insertUpdate(DocumentEvent e) { onChange(); }
			public void removeUpdate(DocumentEvent e) { onChange(); }
			public void changedUpdate(DocumentEvent e) { onChange(); }
		};
		
		campoFiltroNome.getDocument().addDocumentListener(listener);
		campoFiltroEmail.getDocument().addDocumentListener(listener);
		
		atualizarListaCompleta();
		
	}
	
	private void acaoPesquisar(ActionEvent e) {
		
		String nome = campoFiltroNome.getText().trim();
		String email = campoFiltroEmail.getText().trim();
		
		try {
			
			if (!nome.isEmpty() && email.isEmpty()) {
				
				List<Cliente> lista = dao.buscaPorNome(nome);
				
				modeloTabela.substituirDados(lista);
				
				rotuloStatus.setText("Encontrados " + lista.size() + " registro(s) por nome.");
				
				return;
				
			}
			
			if (nome.isEmpty() && !email.isEmpty()) {
				
				List<Cliente> lista = dao.listarTodos();
				
				lista.removeIf(c -> c.getEmail() == null || !c.getEmail().toLowerCase().contains(email.toLowerCase()));
				
				modeloTabela.substituirDados(lista);
				
				rotuloStatus.setText("Encontrados " + lista.size() + " registro(s) por e-mail.");
				
				return;
				
			}
			
			if (!nome.isEmpty() && email.isEmpty()) {
				
				List<Cliente> lista = dao.buscaPorNome(nome);
				
				lista.removeIf(c -> c.getEmail() == null || !c.getEmail().toLowerCase().contains(email.toLowerCase()));
				
				modeloTabela.substituirDados(lista);
				
				rotuloStatus.setText("Encontrados " + lista.size() + " registro(s) por nome + e-mail.");
				
				return;
				
			}
			
			atualizarListaCompleta();
			
		} catch (SQLException ex) {
			
			mostrarErroBanco(ex);
			
		}
		
	}
	
	private void atualizarListaCompleta() {
		
		try {
			
			List<Cliente> todos = dao.listarTodos();
			
			modeloTabela.substituirDados(todos);
			
			rotuloStatus.setText("Total: " + todos.size() + " registro(s).");
			
		} catch (SQLException ex) {
			
			mostrarErroBanco(ex);
			
		}
		
	}
	
	private void abrirFormulario(Cliente clienteEdicao) {
		
		ClienteFormulario form = new ClienteFormulario(this, clienteEdicao);
		
		form.setVisible(true);
		
		if (form.foiConfirmado()) { atualizarListaCompleta(); }
		
	}
	
	private void editarSelecionado() {
		
		int linhaView = tabela.getSelectedRow();
		
		if (linhaView < 0) {

			JOptionPane.showMessageDialog(this, 
					"Selecione um cliente na tabela.",
					"Atenção",
					JOptionPane.WARNING_MESSAGE
			);
			
			return;
			
		}
		
		int linhaModelo = tabela.convertRowIndexToModel(linhaView);
		
		Cliente cliente = modeloTabela.getClienteEm(linhaModelo);
		
		abrirFormulario(cliente);
			
	}

	private void excluirSelecionado() {
		
		int linhaView = tabela.getSelectedRow();
		
		if (linhaView < 0) {

			JOptionPane.showMessageDialog(this, 
					"Selecione um cliente na tabela.",
					"Atenção",
					JOptionPane.WARNING_MESSAGE			
			);
			
			return;
			
		}
		
		int opc = JOptionPane.showConfirmDialog(this, 
				"Confirma excluir o cliente selecionado?",
				"Confirmação",
				JOptionPane.YES_NO_OPTION);
		
		if (opc != JOptionPane.YES_OPTION) return;
		
		int linhaModelo = tabela.convertColumnIndexToModel(linhaView);
		
		Cliente cliente = modeloTabela.getClienteEm(linhaModelo);
		
		try {
			
			boolean ok = dao.deleterPorID(cliente.getId());
			
			if (ok) {
				
				modeloTabela.removerEm(linhaModelo);
				
				rotuloStatus.setText("Cliente removido.");
				
			} else {
				
				JOptionPane.showMessageDialog(this, 
						"Cliente não encontrado (pode ter sido removido por outro usuário).",
						"Info",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		} catch (SQLException ex) {
			
			mostrarErroBanco(ex);
			
		}
			
	}
	
	private void exportarClientes() {
		
		if (tabela.getRowCount() == 0) {
			
			JOptionPane.showMessageDialog(this, "Não há dados para exportar.",
					"Atenção", JOptionPane.WARNING_MESSAGE);
			
			return;
			
		}
		
		JFileChooser chooser = new JFileChooser();
		
		chooser.setDialogTitle("Salvar como (Excel .csv)");
		
		chooser.setSelectedFile(new File("clientes.csv"));
		
		if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;
		
		File destino = chooser.getSelectedFile();
		
		if (!destino.getAbsolutePath().toLowerCase().endsWith(".csv")) {
			destino = new File(destino.getAbsolutePath() + ".csv");
		}
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		try (

			    OutputStreamWriter osw = new OutputStreamWriter(
			        new FileOutputStream(destino),
			        Charset.forName("windows-1252")
			    );
			    BufferedWriter w = new BufferedWriter(osw)		
		) {
			
			w.write("sep="); // Indicado para o excel o separador
			
			w.newLine();
			
			w.write("ID;Nome;E-mail;Telefone;Criado em");
			
			w.newLine();
			
			for(int i = 0; i < tabela.getRowCount(); i++) {
				int linhaModelo = tabela.convertColumnIndexToModel(i);
				Cliente c = modeloTabela.getClienteEm(linhaModelo);
				String linha = s(c.getId()) + ";" +
	                    s(c.getNome()) + ";" +
	                    s(c.getEmail()) + ";" +
	                    s(c.getTelefone()) + ";" +
	                    (c.getCriadoEm() == null ? "" : s(c.getCriadoEm().format(fmt)));
				w.write(linha);
				w.newLine();
			} 
			
		} catch (Exception ex) {
			
			JOptionPane.showMessageDialog(this, "Falha ao exportar: " + ex.getMessage(),
    	            "Erro", JOptionPane.ERROR_MESSAGE);
    	    return;
    	    
		}
		
		JOptionPane.showMessageDialog(this,
    	        "Exportado com acentuação correta em:\n" + destino.getAbsolutePath(),
    	        "Sucesso",
    	        JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	private static String s(Object o) {
		
		if (o == null) return "";
		
		String s = String.valueOf(o);
		
		s = s.replace("\r\r", "\n").replace("\r", "\n");
		
		boolean precisaAspas = s.indexOf(';') >= 0 || s.indexOf('"') >= 0 || s.indexOf('\n') >= 0;
		
		if (precisaAspas) {
	        s = "\"" + s.replace("\"", "\"\"") + "\"";
	    }
		
		return s;
 		
	}
	
	private void mostrarErroBanco(SQLException e) {
		
		String msg = e.getMessage();
		
		if (msg != null && msg.toLowerCase().contains("duplicate")) {
			
			JOptionPane.showMessageDialog(this, "Erro: já existe um cliente com este e-mail.",
					"Erro de banco", JOptionPane.ERROR_MESSAGE);
			
		} else {
			
			JOptionPane.showMessageDialog(
                    this,
                    "Erro de banco: " + msg,
                    "Erro de Banco",
                    JOptionPane.ERROR_MESSAGE
            );
			
		}
		
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() ->
        	new TelaCadastroClientes().setVisible(true) 
		);

	}

}
