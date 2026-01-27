package mercado;

//Importa a interface MongoClient do driver do MongoDB. Essa interface permite conectar a um servidor MongoDB.
import com.mongodb.client.MongoClient;
//Importa a classe MongoClients que tem métodos para criar uma conexão com o MongoDB.
import com.mongodb.client.MongoClients;
//Importa a interface MongoCollection para trabalhar com coleções (tabelas) no banco MongoDB.
import com.mongodb.client.MongoCollection;
//Importa a interface MongoDatabase para representar e manipular o banco de dados MongoDB.
import com.mongodb.client.MongoDatabase;
//Importa a classe Document que representa um documento (registro) no MongoDB.
//É como se fosse uma linha de uma tabela, com chave e valor.
import org.bson.Document;
//Importa a classe ObjectId que representa o identificador único gerado automaticamente pelo MongoDB.
//Ele é usado como o "ID" de cada documento no banco.
import org.bson.types.ObjectId;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame; 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane; 
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class SupermercadoApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
    }

}


class ConexaoMongo {

	 private static final String URI = "mongodb://localhost:27017";
	 private static final String DB_NAME = "supermercado_db";
	 private static MongoClient mongoClient;
	 private static MongoDatabase database;
	
	 public static MongoDatabase getDatabase() {
	
	     if (database == null) {
	
	         mongoClient = MongoClients.create(URI);
	
	         database = mongoClient.getDatabase(DB_NAME);
	         
	     }
	
	     return database;
	 }

}

class LoginFrame extends JFrame {

	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	public LoginFrame() {
		
		setTitle("Login - Sistema de Supermercado");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 220);
		setLocationRelativeTo(null);
		
		JPanel painel = new JPanel(new GridBagLayout());
		
		TitledBorder tb = BorderFactory.createTitledBorder("Acesso ao sistema");
		
		// Aqui combinamos duas bordas usando CompoundBorder:
				 // - A borda externa é a borda com o título que acabamos 
				 //			de criar (“Acesso ao Sistema”).
				 // - A borda interna é uma EmptyBorder, que adiciona um 
				 //			espaço (margem) de 10 pixels em todos os lados 
				 //			internos do painel.
				 // Esse espaço evita que os elementos fiquem colados nas 
				 //			bordas, deixando a interface mais "respirável" e elegante.
		painel.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), tb));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		painel.add(new JLabel("Usuário:"), gbc);
		
		gbc.gridx = 1;
		
		txtUsuario = new JTextField(15);
		
		painel.add(txtUsuario, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		painel.add(new JLabel("Senha:"), gbc);
		
		gbc.gridx = 1;
		
		txtSenha = new JPasswordField(15);
		
		painel.add(txtSenha, gbc);
		
		JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
		
		JButton btnEntrar = new JButton("Entrar");
		
		btnEntrar.addActionListener(e -> fazerLogin());
		
		painelBotoes.add(btnEntrar);
		
		JButton btnCadastrar = new JButton("Cadastrar Usuário");
		
		btnCadastrar.addActionListener(e -> {
			
			CadastroUsuarioFrame cad = new CadastroUsuarioFrame(this);
			
			cad.setVisible(true);
			
		});
		
		painelBotoes.add(btnCadastrar);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		
		painel.add(painelBotoes, gbc);
		
		add(painel);
		
	}
	
	public void fazerLogin() {
		
		String usuario = txtUsuario.getText().trim();
		
		String senha = new String(txtSenha.getPassword());
		
		MongoDatabase db = ConexaoMongo.getDatabase();
		MongoCollection<Document> col = db.getCollection("usuarios");
		
		Document encontrado = col.find(
		        new Document("usuario", usuario) 
		            .append("senha", senha)      
		    ).first(); 
		
		if (encontrado != null) {
			
			TelaPrincipal tela = new TelaPrincipal();
			
			tela.setVisible(true);
			
			dispose();
			
		} else {

			JOptionPane.showMessageDialog(this, 
					"Usuário ou senha inválidos!",
					"Erro de login",
					JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
}

class CadastroUsuarioFrame extends JDialog {

	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	
	public CadastroUsuarioFrame(Frame owner) {
		
		super(owner, "Cadastrar usuário", true);
		
		setSize(350, 200);
		
		setLocationRelativeTo(owner);
		
		JPanel painel = new JPanel(new GridLayout(3, 2, 10, 10));
		
		painel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		painel.add(new JLabel("Novo usuário:"));
		
		txtUsuario = new JTextField();
		
		painel.add(txtUsuario);
		
		painel.add(new JLabel("Senha:"));
		
		txtSenha = new JPasswordField();
		
		painel.add(txtSenha);
		
		painel.add(new JLabel());
		
		JButton btnSalvar = new JButton("Salvar");
		
		btnSalvar.addActionListener(e -> salvarUsuario());
		
		painel.add(btnSalvar);
		
		add(painel);
		
	}
	
	private void salvarUsuario() {
		
		String usuario = txtUsuario.getText().trim();
		
		String senha = new String(txtSenha.getPassword());
		
		if (usuario.isEmpty() || senha.isEmpty()) { 
			JOptionPane.showMessageDialog(this, "Preencha usuário e senha!", "Atenção", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		MongoCollection<Document> col = ConexaoMongo.getDatabase().getCollection("usuarios");
		
		Document existente = col.find(new Document("usuario", usuario)).first();
		
		if (existente != null) {
			JOptionPane.showMessageDialog(this, "Usuário já existe, escolha outro nome!", "Atenção", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		col.insertOne(new Document("usuario", usuario).append("senha", senha));
		
		JOptionPane.showMessageDialog(this,
				"Usuário cadastrado com sucesso!",
				"Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
		
		dispose();
		
	}
	
}

class TelaPrincipal extends JFrame{
	
	private JTabbedPane tabbedPane;
	private PainelVendas painelVendas;
	
	public TelaPrincipal() {
		
		setTitle("Supermercado - Tela Principal (vendas)");
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuCad = new JMenu("Cadastros");
		
		JMenuItem miForn = new JMenuItem("Fornecedores");
		
		miForn.addActionListener(e -> new FornecedorFrame(this).setVisible(true));
		
		JMenuItem miProd = new JMenuItem("Produtos");
		
		miProd.addActionListener(e -> new ProdutoFrame(this).setVisible(true));
		
		JMenuItem miCli = new JMenuItem("Clientes");
		
		miCli.addActionListener(e -> new ClienteFrame(this).setVisible(true));
		
		JMenuItem miUsr = new JMenuItem("Usuarios");
		
		miUsr.addActionListener(e -> new UsuarioFrame(this).setVisible(true));
		
		menuCad.add(miForn);
		
		menuCad.add(miProd);
		
		menuCad.add(miCli);
		
		menuCad.add(miUsr);
		
		JMenu menuVendas = new JMenu("Vendas");
		
		JMenuItem miIrVendas = new JMenuItem("Ir para vendas");
		
		miIrVendas.addActionListener(e -> {
			tabbedPane.setSelectedIndex(0);
		});
		
		menuVendas.add(miIrVendas);
		
		JMenu menuRelatorios = new JMenu("Relatórios");
		
		JMenuItem miRel = new JMenuItem("Gerar Relatório");
		
		miRel.addActionListener(e -> {
			
			RelatorioFrame rel = new RelatorioFrame(this);
			
			rel.setVisible(true);
			
		});
		
		menuRelatorios.add(miRel);
		
		menuBar.add(menuCad);
		
		menuBar.add(menuVendas);
		
		menuBar.add(menuRelatorios);
		
		setJMenuBar(menuBar);
		
		tabbedPane = new JTabbedPane();
		
		painelVendas = new PainelVendas();
		
		tabbedPane.addTab("Vendas", painelVendas);
		
		add(tabbedPane);
		
	}
	
	public void atualizarClientesVendas() {
	    painelVendas.atualizarClientes();
	}

	
}

class PainelVendas extends JPanel {
	
	private JTextField txtCodigoProduto, txtQuantidade, txtDesconto;
	private JCheckBox chkCpfNaNota;
	private JComboBox<String> comboClientes;
	private DefaultTableModel modeloCarrinho;
	private JTable tabelaCarrinho;
	
	public PainelVendas() {
		
		setLayout(new BorderLayout(10, 10));
		
		setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JPanel painelTopo = new JPanel(new GridBagLayout());
		
		TitledBorder tb = BorderFactory.createTitledBorder("Venda de Produtos");
		
		painelTopo.setBorder(tb);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		painelTopo.add(new JLabel("Código do Produto:"), gbc);
		
		gbc.gridx = 1;
		
		txtCodigoProduto = new JTextField(10);
		
		painelTopo.add(txtCodigoProduto, gbc);
		
		gbc.gridx = 0;
		
		gbc.gridy = 1;
		
		painelTopo.add(new JLabel("Quantidade:"), gbc);
		
		gbc.gridx = 1;
		
		txtQuantidade = new JTextField("1", 10);
		
		painelTopo.add(txtQuantidade, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		chkCpfNaNota = new JCheckBox("CPF na nota?");
		
		painelTopo.add(chkCpfNaNota, gbc);
		
		gbc.gridx = 1;
		
		comboClientes = new JComboBox<>();
		
		carregarClientes();
		
		painelTopo.add(comboClientes, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		
		gbc.gridwidth = 2;
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		JButton btnAdicionar = new JButton("Adicionar Item ao Carrinho");
		
		btnAdicionar.addActionListener(e -> adicionarItem());
		
		painelTopo.add(btnAdicionar, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		
		gbc.gridwidth = 1;
		
		gbc.anchor = GridBagConstraints.WEST;
		
		painelTopo.add(new JLabel("Desconto (R$):"), gbc);
		
		gbc.gridx = 1;
		
		txtDesconto = new JTextField("0", 10);
		
		painelTopo.add(txtDesconto, gbc);
		
		add(painelTopo, BorderLayout.NORTH);
		
		modeloCarrinho = new DefaultTableModel();
		
		modeloCarrinho.addColumn("Código");
		
		modeloCarrinho.addColumn("Descrição");
		
		modeloCarrinho.addColumn("Preço Unit.");
		
		modeloCarrinho.addColumn("Quantidade");
		
		modeloCarrinho.addColumn("Subtotal");
		
		tabelaCarrinho = new JTable(modeloCarrinho);
		
		tabelaCarrinho.setDefaultEditor(Object.class, null);
		
		JScrollPane scrollCarrinho = new JScrollPane(tabelaCarrinho);
		
		scrollCarrinho.setBorder(BorderFactory.createTitledBorder("Carrinho de compras"));
		
		add(scrollCarrinho, BorderLayout.CENTER);
		
		JPanel painelRodape = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btnRemover = new JButton("Remover Item");
		
		btnRemover.addActionListener(e -> removerItemCarrinho());
		
		painelRodape.add(btnRemover);
		
		JButton btnFinalizar = new JButton("Finalizar Venda");
		
		btnFinalizar.addActionListener(e -> finalizarVenda());
		
		painelRodape.add(btnFinalizar);
		
		add(painelRodape, BorderLayout.SOUTH);
		
	}
	
	private void adicionarItem() {

		String cod = txtCodigoProduto.getText().trim();
		
		String qtdeStr = txtQuantidade.getText().trim();
	
		if (cod.isEmpty() || qtdeStr.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Preencha código e quantidade!"); 
	        return; 
		}
		
		int qtde;
		
		try {
			
			qtde = Integer.parseInt(qtdeStr);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this,
	                "Quantidade inválida!");
	        return; 
		}
		
		MongoCollection<Document> colProd = ConexaoMongo.getDatabase().getCollection("produtos");
		Document produto = colProd.find(new Document("codigo", cod)).first();
		
		if (produto == null) {
			JOptionPane.showMessageDialog(this,
	                "Produto não encontrado!");
	        return; 
		}
		
		String descricao = produto.getString("descricao");
		
		double preco = produto.getDouble("preco");
		
		double subtotal = preco * qtde;
		
		modeloCarrinho.addRow(new Object[] {cod, descricao, preco, qtde, subtotal});
		
	}
		
	private void removerItemCarrinho() {
		
		int row = tabelaCarrinho.getSelectedRow();
		
		if (row == -1) {
			JOptionPane.showMessageDialog(this,
	                "Selecione um item no carrinho para remover!");
	        return; 
		}
		
		modeloCarrinho.removeRow(row);
		
	}
	
	private void finalizarVenda() {
		
		if (modeloCarrinho.getRowCount() == 0) {
			JOptionPane.showMessageDialog(this,
	                "Carrinho vazio!");
	        return; 
		}
		
		double desconto;
		
		try {	
			desconto = Double.parseDouble(txtDesconto.getText().trim());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this,
	                "Desconto inválido!");
	        return; 	
		}
		
		double totalSemDesconto = 0.0;
		
		for (int i = 0; i < modeloCarrinho.getRowCount(); i++) {

			double sub = (double) modeloCarrinho.getValueAt(i, 4);
			
			totalSemDesconto += sub;
			
		}
		
		double valorAPagar = totalSemDesconto - desconto;
		
		if (valorAPagar < 0) valorAPagar = 0;
		
		if (!verificarEAbaterEstoque()) return;
		
		MongoCollection<Document> colProd = ConexaoMongo.getDatabase().getCollection("produtos");
		
		List<Document> itensVenda = new ArrayList<>();
		
		Set<String> fornecedoresEnvolvidos = new HashSet<>();
		
		for (int i = 0; i < modeloCarrinho.getRowCount(); i++) {
			
			String cod = (String) modeloCarrinho.getValueAt(i, 0);
			
			String desc = (String) modeloCarrinho.getValueAt(i, 1);
			
			double preco = (double) modeloCarrinho.getValueAt(i, 2);
			
			int qtde = (int) modeloCarrinho.getValueAt(i, 3);
			
			double sub = (double) modeloCarrinho.getValueAt(i, 4);
			
			Document p = colProd.find(new Document("codigo", cod)).first();
			
			String fornNome = (p != null) ? p.getString("fornecedorNome") : "";
			
			if (fornNome == null) fornNome = "";
			
			if (!fornNome.isEmpty()) fornecedoresEnvolvidos.add(fornNome);
			
			Document itemDoc = new Document("codigo", cod)
					.append("descricao", desc)
					.append("precoUnit", preco)
					.append("quantidade", qtde)
					.append("subtotal", sub)
					.append("fornecedor", fornNome);
			
			itensVenda.add(itemDoc);
			
		}
		
		String clienteNome = "";
		String clienteCpf = "";
		
		if (comboClientes.getSelectedIndex() > 0) {

			String selectedClient = (String) comboClientes.getSelectedItem();
			
			int idxCpf = selectedClient.indexOf("(CPF:");
			
			if (idxCpf != -1) {
				
				clienteNome = selectedClient.substring(0, idxCpf).trim();
				
				int idxClose = selectedClient.indexOf(")", idxCpf);
				
				if (idxClose > idxCpf) {
					
					clienteCpf = selectedClient.substring(idxCpf + 5, idxClose).trim();
					
					if (clienteCpf.startsWith(":")) clienteCpf = clienteCpf.substring(1).trim();
					
				}
				
			} else {

				clienteNome = selectedClient.trim();
				
			}
			
		}
		
		MongoCollection<Document> colVendas = ConexaoMongo.getDatabase().getCollection("vendas");
		
		Document vendaDoc = new Document("data", new Date())  
		        .append("totalSemDesconto", totalSemDesconto)
		        .append("desconto", desconto)
		        .append("totalFinal", valorAPagar)
		        .append("itens", itensVenda)
		        .append("fornecedores", new ArrayList<>(fornecedoresEnvolvidos))
		        .append("clienteNome", clienteNome)
		        .append("clienteCPF", clienteCpf);
		
		colVendas.insertOne(vendaDoc);
		
		StringBuilder sb = new StringBuilder("===== RECIBO DE COMPRA =====\n\n");
		
		for (int i = 0; i < modeloCarrinho.getRowCount(); i++) {
			
			String cod = (String) modeloCarrinho.getValueAt(i, 0);
		    String desc = (String) modeloCarrinho.getValueAt(i, 1);
		    double preco = (double) modeloCarrinho.getValueAt(i, 2);
		    int qtde = (int) modeloCarrinho.getValueAt(i, 3);
		    double sub = (double) modeloCarrinho.getValueAt(i, 4);
		    sb.append("Produto: ").append(cod).append(" - ").append(desc)
		      .append("\n  Preço Unit: R$").append(preco)     
		      .append(" x ").append(qtde)                       
		      .append(" = R$").append(sub)                            
		      .append("\n\n");
			
		}
		
		sb.append("Valor Total (sem desconto): R$").append(totalSemDesconto).append("\n");
		sb.append("Desconto: R$").append(desconto).append("\n");
		sb.append("Valor a Pagar: R$").append(valorAPagar).append("\n\n");
		
		if (!clienteNome.isEmpty()) {
			
			sb.append("Cliente: ").append(clienteNome);
			
			if (!clienteCpf.isEmpty()) sb.append("(CPF: ").append(clienteCpf).append(")");
			
			sb.append("\n");
			
		} else sb.append("Compra sem cliente selecionado.\n");
		
		sb.append("============================\n");
		
		JOptionPane.showMessageDialog(this, sb.toString(),
				"Recibo de compra", JOptionPane.INFORMATION_MESSAGE);
		
		modeloCarrinho.setRowCount(0);
		
		txtDesconto.setText("0");
		
	} 
	
	private boolean verificarEAbaterEstoque() {
		
		MongoCollection<Document> colProd = ConexaoMongo.getDatabase().getCollection("produtos");
		
		for (int i = 0; i < modeloCarrinho.getRowCount(); i++) {
			
			String cod = (String) modeloCarrinho.getValueAt(i, 0);
			
			int qtde = (int) modeloCarrinho.getValueAt(i, 3);
			
			Document prod = colProd.find(new Document("codigo", cod)).first();
			
			if (prod == null) {
				JOptionPane.showMessageDialog(this, "Produto não encontrado no banco: " + cod);
				return false;
			}
			
			if (!prod.containsKey("estoque")) {
				JOptionPane.showMessageDialog(this, 
						"Produto sem campo 'estoque: " + cod);
				return false;
			}
			
			int estAtual = prod.getInteger("estoque", 0);
			
			if (qtde > estAtual) {
				JOptionPane.showMessageDialog(this,
						"Estoque insuficiente para " + cod + " (Estoque atual: " + estAtual + ", necessário: " + qtde + ")");
				return false;
			}
			
		}
		
		for (int i = 0; i < modeloCarrinho.getRowCount(); i++) {
			
			String cod = (String) modeloCarrinho.getValueAt(i, 0);
			
			int qtde = (int) modeloCarrinho.getValueAt(i, 3);
			
			Document prod = colProd.find(new Document("codigo", cod)).first();
			
			int estAtual = prod.getInteger("estoque", 0);
			
			int novoEst = estAtual - qtde;
			
			Object id = prod.getObjectId("_id");
			
			colProd.updateOne(new Document("_id", id), new Document("$set", new Document("estoque", novoEst)));
			
		}
		
		return true;
		
	}
	
	private void carregarClientes() {
		
		comboClientes.addItem("Selecione um cliente ...");
		
		MongoCollection<Document> col = ConexaoMongo.getDatabase().getCollection("clientes");
		
		for (Document doc : col.find()) {
			
			String nome = doc.getString("nome");
			
			String cpf = doc.getString("cpf");
			
			comboClientes.addItem(nome + " (CPF: " + cpf + ")");
			
		}
		
	}
	
	public void atualizarClientes() {
	    comboClientes.removeAllItems();
	    carregarClientes();
	}

	
}

class FornecedorFrame extends JDialog {

	private JTextField txtId, txtNome, txtCnpj, txtTelefone, txtEmail;
	
	private DefaultTableModel modeloTabela;
	
	private JTable tabela;
	
	public FornecedorFrame(Frame owner) {
		
		super(owner, "Cadastro de Fornecedores", true);
		
		setSize(700, 500);
		
		setLocationRelativeTo(owner);
		
		JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
		
		painelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		add(painelPrincipal);
		
		JPanel painelForm = new JPanel(new GridBagLayout());
		
		TitledBorder tb = BorderFactory.createTitledBorder("Dados do Fornecedor");
		
		painelForm.setBorder(tb);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		txtId = new JTextField();
		
		txtId.setVisible(false);
		
		gbc.gridx=0;gbc.gridy=0;
		
		painelForm.add(new JLabel("Nome:"), gbc);
		
		gbc.gridx = 1;
		
		txtNome = new JTextField(20);
		
		painelForm.add(txtNome, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		
		painelForm.add(new JLabel("CNPJ:"), gbc);
		
		gbc.gridx = 1;
		
		txtCnpj = new JTextField(20);
		
		painelForm.add(txtCnpj, gbc);
		
		gbc.gridx = 0; gbc.gridy = 2;
		
		painelForm.add(new JLabel("Telefone:"), gbc);
		
		gbc.gridx = 1;
		
		txtTelefone = new JTextField(20);
		
		painelForm.add(txtTelefone, gbc);
		
		gbc.gridx = 0; gbc.gridy = 3;
		
		painelForm.add(new JLabel("E-mail:"), gbc);
		
		gbc.gridx = 1;
		
		txtEmail = new JTextField(40);
		
		painelForm.add(txtEmail, gbc);
		
		JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
		
		JButton btnNovo = new JButton("Novo");
		
		btnNovo.addActionListener(e -> limpar());
		
		painelBotoes.add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar/Atualizar");
		
		btnSalvar.addActionListener(e -> salvarOuAtual());
		
		painelBotoes.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		
		btnExcluir.addActionListener(e -> excluir());
		
		painelBotoes.add(btnExcluir);
		
		gbc.gridx = 0;gbc.gridy = 4;gbc.gridwidth = 2;
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		painelForm.add(painelBotoes, gbc);
		
		painelPrincipal.add(painelForm, BorderLayout.NORTH);
		
		modeloTabela = new DefaultTableModel();
		
		modeloTabela.addColumn("ID");
		
		modeloTabela.addColumn("Nome");
		
		modeloTabela.addColumn("CNPJ");
		
		modeloTabela.addColumn("Telefone");
		
		modeloTabela.addColumn("E-mail");
		
		tabela = new JTable(modeloTabela);
		
		tabela.setDefaultEditor(Object.class, null);
		
		tabela.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (e.getClickCount() == 2 && tabela.getSelectedRow() != -1) {
					
					carregarCampos(tabela.getSelectedRow());
					
				}
				
			}
			
		});
		
		JScrollPane scroll = new JScrollPane(tabela);
		
		scroll.setBorder(BorderFactory.createTitledBorder("Lista de Fornecedores"));
		
		painelPrincipal.add(scroll, BorderLayout.CENTER);
		
		carregarFornecedores();
		
	}
	
	private void carregarCampos(int row) {
		
		txtId.setText((String) modeloTabela.getValueAt(row, 0));		
		txtNome.setText((String) modeloTabela.getValueAt(row, 1));	
		txtCnpj.setText((String) modeloTabela.getValueAt(row, 2));		
		txtTelefone.setText((String) modeloTabela.getValueAt(row, 3));
		txtEmail.setText((String) modeloTabela.getValueAt(row, 4));
		
	}
	
	private void limpar() {
		
		txtId.setText("");
		txtNome.setText("");
		txtCnpj.setText("");
		txtTelefone.setText("");
		txtEmail.setText("");
		
	}
	
	private void salvarOuAtual() {
		
		String nome = txtNome.getText().trim();
		String cnpj = txtCnpj.getText().trim();
		String tel = txtTelefone.getText().trim();
		String em = txtEmail.getText().trim();
		
		if (nome.isEmpty() || cnpj.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Preencha ao menos Nome e CNPJ",
					"Atenção", JOptionPane.WARNING_MESSAGE);
					return;
		}
		
		MongoCollection<Document> col = ConexaoMongo.getDatabase().getCollection("fornecedores");
		
		String id = txtId.getText().trim();
		
		if (id.isEmpty()) {
			
			Document doc = new Document("nome", nome)
					.append("cnpj", cnpj)
					.append("telefone", tel)
					.append("email", em);
			
			col.insertOne(doc);
			
			JOptionPane.showMessageDialog(this, 
				"Fornecedor inserido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		} else {

			Object objId = new ObjectId(id);
			
			Document filtro = new Document("_id", objId);
			
			Document update = new Document("$set",
					new Document("nome", nome)
					.append("cnpj", cnpj)
					.append("telefone", tel)
					.append("email", em));
			
			col.updateOne(filtro, update);
			
			JOptionPane.showMessageDialog(this, "Fornecedor atualizado!",
					"Suesso", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		limpar();
		
		carregarFornecedores();
		
	}
	
	private void excluir() {
		
		String id = txtId.getText().trim();
		
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(this, 
					"Selecione um fornecedor para excluir!",
					"Atenção",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		int resp = JOptionPane.showConfirmDialog(this, 
				"Deseja realmente excluir esse fornecedor?",
				"Confirmação", JOptionPane.YES_NO_OPTION);
		
		if (resp == JOptionPane.YES_OPTION) {
			ConexaoMongo.getDatabase().getCollection("fornecedores").deleteOne(new Document("_id", new ObjectId(id)));
			
			limpar();
			
			carregarFornecedores();
		}
		
	}
	
	private void carregarFornecedores() {
		
		modeloTabela.setRowCount(0);
		
		MongoCollection<Document> col = ConexaoMongo.getDatabase().getCollection("fornecedores");
		
		for (Document doc : col.find()) {
			
			ObjectId id = doc.getObjectId("_id");
			String nome = doc.getString("nome");
			String cnpj = doc.getString("cnpj");
			String tel = doc.getString("telefone");
			String em = doc.getString("email");
			
			modeloTabela.addRow(new Object[] {
		             id.toHexString(),
		             nome,
		             cnpj,
		             tel,
		             em
		         });
			
		}
		
	}
	
}

class FornecedorItem {
	
	private ObjectId id;
	private String nome;
	
	public FornecedorItem(ObjectId id, String nome) {
		
		this.id = id;
		this.nome = nome;
		
	}
	
	public ObjectId getId() {return id;}
	
	public String getNome() {return nome;}
	
	@Override
	public String toString() {return nome;}
	
}

class ProdutoFrame extends JDialog {
	
	private JTextField txtId;
	private JTextField txtCodigo;
	private JTextField txtDescricao;
	private JTextField txtPreco;
	private JTextField txtEstoque;
	
	private JComboBox<FornecedorItem> comboFornecedor;
	
	private DefaultTableModel modeloTabela;
	
	private JTable tabela;
	
	public ProdutoFrame(Frame owner) {
		
		super(owner, "Cadastro de Produtos", true);
		
		setSize(700, 600);
		
		setLocationRelativeTo(owner);
		
		JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
		
		painelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		add(painelPrincipal);
		
		JPanel painelForm = new JPanel(new GridBagLayout());
		
		TitledBorder tb = BorderFactory.createTitledBorder("Dados do Produto");
		
		painelForm.setBorder(tb);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		txtId = new JTextField();
		txtId.setVisible(true);
		
		gbc.gridx = 0; gbc.gridy = 0;
		
		painelForm.add(new JLabel("Còdigo:"), gbc);
		
		gbc.gridx = 1;
		
		txtCodigo = new JTextField(15);
		
		painelForm.add(txtCodigo, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		
		painelForm.add(new JLabel("Descrição:"), gbc);
		
		gbc.gridx = 1;
		
		txtDescricao = new JTextField(15);
		
		painelForm.add(txtDescricao, gbc);
		
		gbc.gridx = 0; gbc.gridy = 2;
		
		painelForm.add(new JLabel("Preço:"), gbc);
		
		gbc.gridx = 1;
		
		txtPreco = new JTextField(15);
		
		painelForm.add(txtPreco, gbc);
		
		gbc.gridx = 0; gbc.gridy = 3;
		
		painelForm.add(new JLabel("Estoque:"), gbc);
		
		gbc.gridx = 1;
		
		txtEstoque = new JTextField(15);
		
		painelForm.add(txtEstoque, gbc);
		
		gbc.gridx = 0; gbc.gridy = 4;
		
		painelForm.add(new JLabel("Fornecedor:"), gbc);
		
		gbc.gridx = 1;
		
		comboFornecedor = new JComboBox<>();
		
		carregarFornecedoresNoCombo();
		
		painelForm.add(comboFornecedor, gbc);
		
		JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
		
		JButton btnNovo = new JButton("Novo");
		
		btnNovo.addActionListener(e -> limparCampos());
		
		painelBotoes.add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar/Atualizar");
		
		btnSalvar.addActionListener(e -> salvarOuAtualizar());
		
		painelBotoes.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		
		btnExcluir.addActionListener(e -> excluirProduto());
		
		painelBotoes.add(btnExcluir);
		
		gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		
		painelForm.add(painelBotoes, gbc);
		
		painelPrincipal.add(painelForm, BorderLayout.NORTH);
		
		modeloTabela = new DefaultTableModel();
		
		modeloTabela.addColumn("ID");
		modeloTabela.addColumn("Código");
		modeloTabela.addColumn("Descrição");
		modeloTabela.addColumn("Preço");
		modeloTabela.addColumn("Estoque");
		modeloTabela.addColumn("FornecedorID");
		modeloTabela.addColumn("FornecedorNome");
		
		tabela = new JTable(modeloTabela);
		tabela.setDefaultEditor(Object.class, null);
		tabela.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && tabela.getSelectedRow() != -1) carregarProdutosNosCampos(tabela.getSelectedRow());
			}
			
			
		});
		
		JScrollPane scroll = new JScrollPane(tabela);
		
		scroll.setBorder(BorderFactory.createTitledBorder("Lista de Produtos"));
		
		painelPrincipal.add(scroll, BorderLayout.CENTER);
		
		carregarProdutos();
		
	}
	
	private void limparCampos() {
		
		txtId.setText("");
		txtCodigo.setText("");
		txtDescricao.setText("");
		txtPreco.setText("");
		txtEstoque.setText("");
		comboFornecedor.setSelectedIndex(0);
		
	}
	
	private void carregarProdutos() {
		
		modeloTabela.setRowCount(0);
		
		MongoCollection<Document> col = ConexaoMongo.getDatabase().getCollection("produtos");
		
		for (Document doc : col.find()) {
			
			ObjectId id = doc.getObjectId("_id");
			String codigo = doc.getString("codigo");
	        String descricao = doc.getString("descricao");
	        double preco = doc.getDouble("preco");
	        int estoque = doc.getInteger("estoque", 0);
	        String fornId = doc.getString("fornecedorId");
	        String fornNome = doc.getString("fornecedorNome");
	        modeloTabela.addRow(new Object[]{
	            id.toHexString(),
	            codigo,
	            descricao,  
	            preco,  
	            estoque, 
	            fornId,
	            fornNome
	        });
			
		}
		
	}
	
	private void salvarOuAtualizar() {
		
		String cod = txtCodigo.getText().trim();
		String desc = txtDescricao.getText().trim();
		String precoStr = txtPreco.getText().trim();
		String estStr = txtEstoque.getText().trim();
		
		if (cod.isEmpty() || desc.isEmpty() || precoStr.isEmpty() || estStr.isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Preencha Código, Descrição, Preço E Estoque!",
					"Atenção", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		double preco;
		
		int estoque;
		
		try {
			
			preco = Double.parseDouble(precoStr);
			
			estoque = Integer.parseInt(estStr);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, 
					"Preço ou Estoque inválido!",
					"Erro",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		FornecedorItem fornSel = (FornecedorItem) comboFornecedor.getSelectedItem();
		
		if (fornSel == null || fornSel.getId() == null) {
			JOptionPane.showMessageDialog(this,
			        "Selecione um fornecedor válido!",  //
			        "Atenção",                       
			        JOptionPane.WARNING_MESSAGE);   
			    return;
		}
		
		MongoCollection<Document> col = ConexaoMongo.getDatabase().getCollection("produtos");
		String id = txtId.getText().trim();
		
		if (id.isEmpty()) {
			Document doc = new Document("codigo", cod)        
		            .append("descricao", desc)            
		            .append("preco", preco)                    
		            .append("estoque", estoque)        
		            .append("fornecedorId", fornSel.getId().toHexString())  
		            .append("fornecedorNome", fornSel.getNome());        
		    col.insertOne(doc);
		    JOptionPane.showMessageDialog(this,
		        "Produto inserido!",     
		        "Sucesso",                  
		        JOptionPane.INFORMATION_MESSAGE); 
		} else {
			ObjectId objId = new ObjectId(id);
			Document updateDoc = new Document("codigo", cod)                 
	        	    .append("descricao", desc)                           
	        	    .append("preco", preco)                                        
	        	    .append("estoque", estoque)                                       
	        	    .append("fornecedorId", fornSel.getId().toHexString())           
	        	    .append("fornecedorNome", fornSel.getNome());                      

	        	col.updateOne(new Document("_id", objId),
	        	              new Document("$set", updateDoc));
	        	JOptionPane.showMessageDialog(this,
	        	    "Produto atualizado!",   
	        	    "Sucesso",    
	        	    JOptionPane.INFORMATION_MESSAGE); 
		}
		
		limparCampos();
		
		carregarProdutos();
		
	}
	
	private void excluirProduto() {
		
		String id = txtId.getText().trim();
		
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(this,
		            "Selecione um produto para excluir!",
		            "Atenção",
		            JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		int resp = JOptionPane.showConfirmDialog(this, 
				"Deseja realmente excluir esse produto?",
				"Confirmação",
				JOptionPane.YES_NO_OPTION);
		
		if (resp == JOptionPane.YES_OPTION) {
			ConexaoMongo.getDatabase().getCollection("produtos")
			.deleteOne(new Document("_id", new ObjectId(id)));
			limparCampos();
			carregarProdutos();
		}
		
	}
	
	private void carregarFornecedoresNoCombo() {
		
		comboFornecedor.removeAllItems();
		
		comboFornecedor.addItem(new FornecedorItem(null, "Selecione ..."));
		
		MongoCollection<Document> colForn = ConexaoMongo.getDatabase().getCollection("fornecedores");
		
		for (Document doc : colForn.find()) {
			ObjectId id = doc.getObjectId("_id");
			String nome = doc.getString("nome");
			
			comboFornecedor.addItem(new FornecedorItem(id, nome));
		}
	}
	
	private void carregarProdutosNosCampos(int row) {
		txtId.setText((String) modeloTabela.getValueAt(row, 0));
		txtCodigo.setText((String) modeloTabela.getValueAt(row, 1));
		txtDescricao.setText((String) modeloTabela.getValueAt(row, 2));
		
		double preco = (double) modeloTabela.getValueAt(row, 3);
		txtPreco.setText(String.valueOf(preco));
		
		int est = (int) modeloTabela.getValueAt(row, 4);
		txtEstoque.setText(String.valueOf(est));
		
		String fornIdStr = (String) modeloTabela.getValueAt(row, 5);
		String fornNome = (String) modeloTabela.getValueAt(row, 6);
		
		if (fornIdStr != null) {
			ObjectId fornId = new ObjectId(fornIdStr);
			for (int i = 0; i < comboFornecedor.getItemCount(); i++) {
				
				FornecedorItem fi = comboFornecedor.getItemAt(i);
				
				if (fi.getId() != null && fi.getId().equals(fornId)) {
		             comboFornecedor.setSelectedIndex(i);
		             break;
		             
		         }
				
			}
		}
		
	}
	
}

class ClienteFrame extends JDialog {
	
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtCpf;
	private DefaultTableModel modeloTabela;
	private JTable tabela;
	private TelaPrincipal telaPrincipal;

	
	public ClienteFrame(TelaPrincipal owner) {
		
		super(owner, "Cadastro de Clientes", true);
		
		this.telaPrincipal = owner;
		
		setSize(600, 400);
		
		setLocationRelativeTo(owner);
		
		JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
		
		painelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		add(painelPrincipal);
		
		JPanel painelForm = new JPanel(new GridBagLayout());
		
		TitledBorder tb = BorderFactory.createTitledBorder("Dados do cliente");
		
		painelForm.setBorder(tb);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		txtId = new JTextField();
		txtId.setVisible(false);
		
		gbc.gridx = 0; gbc.gridy = 0;
		
		painelForm.add(new JLabel("Nome:"), gbc);
		
		gbc.gridx = 1;
		
		txtNome = new JTextField(40);
		
		painelForm.add(txtNome, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		
		painelForm.add(new JLabel("CPF:"), gbc);
		
		gbc.gridx = 1;
		
		txtCpf = new JTextField(14);
		
		painelForm.add(txtCpf, gbc);
		
		JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
		
		JButton btnNovo = new JButton("Novo");
		
		btnNovo.addActionListener(e -> limpar());
		
		painelBotoes.add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar/Atualizar");
		
		btnSalvar.addActionListener(e -> salvarOuAtualizar());
		
		painelBotoes.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		
		btnExcluir.addActionListener(e -> excluir());
		
		painelBotoes.add(btnExcluir);
		
		gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		
		painelForm.add(painelBotoes, gbc);
		
		painelPrincipal.add(painelForm, BorderLayout.NORTH);
		
		modeloTabela = new DefaultTableModel();
		
		modeloTabela.addColumn("ID");
		
		modeloTabela.addColumn("Nome");
		
		modeloTabela.addColumn("CPF");
		
		tabela = new JTable(modeloTabela);
		
		tabela.setDefaultEditor(Object.class, null);
		
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && tabela.getSelectedRow() != -1) {
					carregarCampos(tabela.getSelectedRow());
				}
			}
		});
		
		JScrollPane scroll = new JScrollPane(tabela);
		
		scroll.setBorder(BorderFactory.createTitledBorder("Lista de Clientes"));
		
		painelPrincipal.add(scroll, BorderLayout.CENTER);
		
		carregarClientes();
		
	}
	
	private void carregarClientes() {
		
		modeloTabela.setRowCount(0);
		
		MongoCollection<Document> col = ConexaoMongo.getDatabase().getCollection("clientes");
		
		for (Document doc : col.find()) {
			ObjectId id = doc.getObjectId("_id");
	        String nome = doc.getString("nome");
	        String cpf = doc.getString("cpf");
	        modeloTabela.addRow(new Object[]{ id.toHexString(), nome, cpf });
		}
		
	}
	
	private void carregarCampos(int row) {
		txtId.setText((String) modeloTabela.getValueAt(row, 0));
	    txtNome.setText((String) modeloTabela.getValueAt(row, 1));
	    txtCpf.setText((String) modeloTabela.getValueAt(row, 2));	
	}
	
	private void limpar() {
	    txtId.setText("");
	    txtNome.setText("");
	    txtCpf.setText("");
	}
	
	private void salvarOuAtualizar() {

	    String nome = txtNome.getText().trim();
	    String cpf = txtCpf.getText().trim();

	    if (nome.isEmpty() || cpf.isEmpty()) {
	        JOptionPane.showMessageDialog(this,
	            "Preencha nome e CPF!",      
	            "Atenção",                 
	            JOptionPane.WARNING_MESSAGE);   
	        return;  
	    }
	    
		MongoCollection<Document> col = ConexaoMongo.getDatabase().getCollection("clientes");
		String id = txtId.getText().trim();
		if (id.isEmpty()) {
		    Document doc = new Document("nome", nome).append("cpf", cpf);
		    col.insertOne(doc);
		    JOptionPane.showMessageDialog(this,
		        "Cliente inserido!",       
		        "Sucesso",            
		        JOptionPane.INFORMATION_MESSAGE); 
		} else {
		    ObjectId objId = new ObjectId(id);
		    Document up = new Document("$set",
		        new Document("nome", nome).append("cpf", cpf)
		    );
		    col.updateOne(new Document("_id", objId), up);
		    JOptionPane.showMessageDialog(this,
		        "Cliente atualizado!",     
		        "Sucesso",       
		        JOptionPane.INFORMATION_MESSAGE); 
		}
		
		if (telaPrincipal != null) {
		    telaPrincipal.atualizarClientesVendas();
		}

		limpar();

		carregarClientes();

    }
	
	private void excluir() {

	    String id = txtId.getText().trim();

	    if (id.isEmpty()) {
	        JOptionPane.showMessageDialog(this,
	            "Selecione um cliente para excluir!", 
	            "Atenção",                      
	            JOptionPane.WARNING_MESSAGE);    
	        return; 
	    }

	    int resp = JOptionPane.showConfirmDialog(this,
	        "Deseja realmente excluir este cliente?", 
	        "Confirmação",                      
	        JOptionPane.YES_NO_OPTION);         

	    if (resp == JOptionPane.YES_OPTION) {
	        ConexaoMongo.getDatabase().getCollection("clientes")
	            .deleteOne(new Document("_id", new ObjectId(id)));

	        limpar();

	        carregarClientes();
	        
	    }
	}
	
}

class UsuarioFrame extends JDialog {

	 private JTextField txtId;
	 private JTextField txtUsuario;
	 private JPasswordField txtSenha;
	 private DefaultTableModel modeloTabela;
	 private JTable tabela;

	 public UsuarioFrame(Frame owner) {
	    
	     super(owner, "Gerenciar Usuários", true);
	     setSize(600, 400);
	     setLocationRelativeTo(owner);
		 JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
		 painelPrincipal.setBorder(new EmptyBorder(10,10,10,10));
		 add(painelPrincipal);

		 JPanel painelForm = new JPanel(new GridBagLayout());

		 TitledBorder tb = BorderFactory.createTitledBorder("Dados do Usuário");
		 painelForm.setBorder(tb);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		txtId = new JTextField();

		txtId.setVisible(false);

		gbc.gridx = 0; gbc.gridy = 0;
		painelForm.add(new JLabel("Usuário:"), gbc);

		gbc.gridx = 1;
		txtUsuario = new JTextField(20);
		painelForm.add(txtUsuario, gbc);

		gbc.gridx = 0; gbc.gridy = 1;
		painelForm.add(new JLabel("Senha:"), gbc);

		gbc.gridx = 1;
		txtSenha = new JPasswordField(20);
		painelForm.add(txtSenha, gbc);

		JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(e -> limpar());
		painelBotoes.add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar/Atualizar");
		btnSalvar.addActionListener(e -> salvarOuAtualizar());
		painelBotoes.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(e -> excluirUsuario());
		painelBotoes.add(btnExcluir);

		gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		painelForm.add(painelBotoes, gbc);
		painelPrincipal.add(painelForm, BorderLayout.NORTH);

		modeloTabela = new DefaultTableModel();

		modeloTabela.addColumn("ID");
		modeloTabela.addColumn("Usuário");
		modeloTabela.addColumn("Senha");
		tabela = new JTable(modeloTabela);
		tabela.setDefaultEditor(Object.class, null);
		tabela.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {

		        if(e.getClickCount() == 2 && tabela.getSelectedRow() != -1) {
		            carregarCampos(tabela.getSelectedRow()); 
		        }
		    }
		});

		JScrollPane scroll = new JScrollPane(tabela);

		scroll.setBorder(BorderFactory.createTitledBorder("Lista de Usuários"));
		
		painelPrincipal.add(scroll, BorderLayout.CENTER);
		
		carregarUsuarios();

	}

	private void carregarUsuarios() {
	    modeloTabela.setRowCount(0);

	    MongoCollection<Document> col = ConexaoMongo.getDatabase().getCollection("usuarios");

	    for (Document doc : col.find()) {
	        ObjectId id = doc.getObjectId("_id");
	        String usr = doc.getString("usuario");
	        String pwd = doc.getString("senha");
	        modeloTabela.addRow(new Object[] {
	            id.toHexString(), usr, pwd
	        });
	        
	    }
	}

	private void carregarCampos(int row) {
	    txtId.setText((String) modeloTabela.getValueAt(row, 0));
	    txtUsuario.setText((String) modeloTabela.getValueAt(row, 1));
	    txtSenha.setText((String) modeloTabela.getValueAt(row, 2));
	}
	
	private void limpar() {
	    txtId.setText("");
	    txtUsuario.setText("");
	    txtSenha.setText("");    
	}

	private void salvarOuAtualizar() {
	    String usuario = txtUsuario.getText().trim();
	    String senha = new String(txtSenha.getPassword());

	    if (usuario.isEmpty() || senha.isEmpty()) {
	        JOptionPane.showMessageDialog(this,
	            "Preencha Usuário e Senha!", 
	            "Atenção",                      
	            JOptionPane.WARNING_MESSAGE);    
	        return;
	        
	    }

		MongoCollection<Document> col = ConexaoMongo.getDatabase().getCollection("usuarios");
	
		String id = txtId.getText().trim();

		if(id.isEmpty()) {

		     Document existente = col.find(new Document("usuario", usuario)).first();

		     if (existente != null) {
		         JOptionPane.showMessageDialog(this,
		             "Usuário já existe, escolha outro nome!",
		             "Atenção",                            
		             JOptionPane.WARNING_MESSAGE);          
		         return;
		         
		     }
		     Document doc = new Document("usuario", usuario)
		             .append("senha", senha);  
		     col.insertOne(doc);
		     JOptionPane.showMessageDialog(this,
		         "Usuário inserido!",           
		         "Sucesso",                        
		         JOptionPane.INFORMATION_MESSAGE);  
       } else {

           ObjectId objId = new ObjectId(id);

           Document up = new Document("$set",                   
               new Document("usuario", usuario)                  
                     .append("senha", senha)                      
           );

           col.updateOne(new Document("_id", objId), up);

           JOptionPane.showMessageDialog(this,
               "Usuário atualizado!",               
               "Sucesso",                          
               JOptionPane.INFORMATION_MESSAGE);    
       }
  
       limpar();
       carregarUsuarios();

   }

	private void excluirUsuario() {

	    String id = txtId.getText().trim();

	    if(id.isEmpty()) {
	        JOptionPane.showMessageDialog(this,                     
	            "Selecione um usuário para excluir!",               
	            "Atenção",                                         
	            JOptionPane.WARNING_MESSAGE);                       
	        return;
	        
	    }

		int resp = JOptionPane.showConfirmDialog(this,
		     "Deseja realmente excluir este usuário?",
		     "Confirmação",
		     JOptionPane.YES_NO_OPTION);
	
		if (resp == JOptionPane.YES_OPTION) {
		     
		     ConexaoMongo.getDatabase().getCollection("usuarios")
		         .deleteOne(new Document("_id", new ObjectId(id)));
		     limpar();
		     carregarUsuarios();
		     
		}

   }

	
}

class RelatorioFrame extends JDialog {

	 private JTextField txtDataIni;
	 private JTextField txtDataFim;
	 private JTextField txtFornecedor;
	 private JTextField txtProduto;
	 private JTextField txtCliente;
	 private DefaultTableModel modeloTabela;
	 private JTable tabela;
	 
	 public RelatorioFrame(Frame owner) {
	    super(owner, "Relatório de Vendas (cada item em uma linha)", true);
	    setSize(1200, 500);
	    setLocationRelativeTo(owner);
	    
		JPanel painelPrincipal = new JPanel(new BorderLayout(10,10));
		painelPrincipal.setBorder(new EmptyBorder(10,10,10,10));
		add(painelPrincipal);
		
		JPanel painelFiltros = new JPanel(new GridBagLayout());
		TitledBorder tb = BorderFactory.createTitledBorder("Filtros de Vendas");
		painelFiltros.setBorder(tb);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0; gbc.gridy = 0;
		painelFiltros.add(new JLabel("Data Inicial (dd/MM/yyyy):"), gbc);

		gbc.gridx = 1;
		txtDataIni = new JTextField(10);
		painelFiltros.add(txtDataIni, gbc);

		gbc.gridx = 2;
		painelFiltros.add(new JLabel("Data Final (dd/MM/yyyy):"), gbc);

		gbc.gridx = 3;
		txtDataFim = new JTextField(10);
		painelFiltros.add(txtDataFim, gbc);

		gbc.gridx = 0; gbc.gridy = 1;
		painelFiltros.add(new JLabel("Fornecedor (parte do nome):"), gbc);

		gbc.gridx = 1;
		txtFornecedor = new JTextField(10);
		painelFiltros.add(txtFornecedor, gbc);

		gbc.gridx = 2;
		painelFiltros.add(new JLabel("Produto (parte da descrição):"), gbc);

		gbc.gridx = 3;
		txtProduto = new JTextField(10);
		painelFiltros.add(txtProduto, gbc);

		gbc.gridx = 0; gbc.gridy = 2;
		painelFiltros.add(new JLabel("Cliente (nome ou CPF):"), gbc);

		gbc.gridx = 1;
		txtCliente = new JTextField(10);
		painelFiltros.add(txtCliente, gbc);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(e -> pesquisar());
		gbc.gridx = 2; gbc.gridy = 2; gbc.gridwidth = 2;
		painelFiltros.add(btnPesquisar, gbc);

		painelPrincipal.add(painelFiltros, BorderLayout.NORTH);

		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("ID Venda");
		modeloTabela.addColumn("Data");
		modeloTabela.addColumn("Cliente");
		modeloTabela.addColumn("CPF");
		modeloTabela.addColumn("Fornecedor (Item)");
		modeloTabela.addColumn("Produto");
		modeloTabela.addColumn("Qtd");
		modeloTabela.addColumn("Preço Unit.");
		modeloTabela.addColumn("Subtotal (Item)");
		modeloTabela.addColumn("Desconto (Venda)");
		modeloTabela.addColumn("Total s/Desc (Venda)");
		modeloTabela.addColumn("Total c/Desc (Venda)");

		tabela = new JTable(modeloTabela);
		tabela.setDefaultEditor(Object.class, null);

		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBorder(
		    BorderFactory.createTitledBorder("Resultados de Vendas (uma linha por item)")
		);
		painelPrincipal.add(scroll, BorderLayout.CENTER);

		JPanel painelRodape = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		JButton btnExportar = new JButton("Exportar CSV");
		btnExportar.addActionListener(e -> exportarCSV());
		painelRodape.add(btnExportar);
		painelPrincipal.add(painelRodape, BorderLayout.SOUTH);

	}

	 private void pesquisar() {
	     modeloTabela.setRowCount(0);
	     String dataIniStr = txtDataIni.getText().trim();
	     String dataFimStr = txtDataFim.getText().trim();
	     String fornStr = txtFornecedor.getText().trim().toLowerCase();
	     String prodStr = txtProduto.getText().trim().toLowerCase();
	     String cliStr = txtCliente.getText().trim().toLowerCase();
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 Date dtIni = null;
		 Date dtFim = null;

		 try {
		      if (!dataIniStr.isEmpty())
		          dtIni = sdf.parse(dataIniStr);
		      if (!dataFimStr.isEmpty())
		          dtFim = sdf.parse(dataFimStr);
		  } catch (ParseException ex) {
		      JOptionPane.showMessageDialog(this,
		              "Datas inválidas! Formato deve ser dd/MM/yyyy", 
		              "Erro",                                        
		              JOptionPane.ERROR_MESSAGE);                    
		      return;
		  }

		if (dtIni != null) dtIni = zerarHora(dtIni);
		if (dtFim != null) dtFim = fimDia(dtFim);

		MongoDatabase db = ConexaoMongo.getDatabase();
		MongoCollection<Document> colVendas = db.getCollection("vendas");

		for (Document vendaDoc : colVendas.find()) {
		    Date dataVenda = vendaDoc.getDate("data");
		    if (dataVenda != null) {
		        if (dtIni != null && dataVenda.before(dtIni)) {
		            continue;      
		        }
		        if (dtFim != null && dataVenda.after(dtFim)) {
		            continue;  
		        }
		    }

			String clienteNome = vendaDoc.getString("clienteNome");
			if (clienteNome == null) clienteNome = "";
			
			String clienteCPF = vendaDoc.getString("clienteCPF");
			if (clienteCPF == null) clienteCPF = "";
	

			String clienteCompleto = (clienteNome + " " + clienteCPF).toLowerCase();

			if (!cliStr.isEmpty()) {
			     if (!clienteCompleto.contains(cliStr)) {
			         continue;
			     }		  
			}

			double totalSemDesc = vendaDoc.getDouble("totalSemDesconto");
			double desconto = vendaDoc.getDouble("desconto");
			double totalFinal = vendaDoc.getDouble("totalFinal");
			ObjectId idVenda = vendaDoc.getObjectId("_id");

			List<Document> itens = vendaDoc.getList("itens", Document.class);

			if (itens == null) itens = new ArrayList<>();

			for (Document item : itens) {
			    String fornItem = item.getString("fornecedor");
			    if (fornItem == null) fornItem = "";
			    if (!fornStr.isEmpty() && !fornItem.toLowerCase().contains(fornStr)) {
			        continue;
			    }
				String descProduto = item.getString("descricao");
				if (descProduto == null) descProduto = "";
				if (!prodStr.isEmpty() && !descProduto.toLowerCase().contains(prodStr)) {
				     continue;
				}

				int qtde = item.getInteger("quantidade", 0);
				double precoUnit = item.getDouble("precoUnit");
				double subtotal = item.getDouble("subtotal");
				String dataStr = "N/A";
				if (dataVenda != null) {
				    dataStr = sdf.format(dataVenda); 
				}

				modeloTabela.addRow(new Object[]{
				    (idVenda != null ? idVenda.toHexString() : ""),
				    dataStr,
				    clienteNome,
				    clienteCPF,
				    fornItem,
				    descProduto,
				    qtde,
				    String.format("%.2f", precoUnit),
				    String.format("%.2f", subtotal),
				    String.format("%.2f", desconto),
				    String.format("%.2f", totalSemDesc),
				    String.format("%.2f", totalFinal)	    
				});

           }
       }
   }

	private Date zerarHora(Date date) {
	    
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.set(Calendar.HOUR_OF_DAY, 0);
	    c.set(Calendar.MINUTE, 0);
	    c.set(Calendar.SECOND, 0);
	    c.set(Calendar.MILLISECOND, 0);
	    return c.getTime();
	    
	}

	private Date fimDia(Date date) {

	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.set(Calendar.HOUR_OF_DAY, 23);
	    c.set(Calendar.MINUTE, 59);
	    c.set(Calendar.SECOND, 59);
	    c.set(Calendar.MILLISECOND, 999);
	    return c.getTime();
	    
	}

	private void exportarCSV() {

	    if (modeloTabela.getRowCount() == 0) {
	        JOptionPane.showMessageDialog(
	            this,                         
	            "Não há dados para exportar!", 
	            "Atenção",                  
	            JOptionPane.WARNING_MESSAGE
	        );
	        return; 
	    }
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Salvar Relatório CSV");
		int retorno = fc.showSaveDialog(this);
		if (retorno == JFileChooser.APPROVE_OPTION) {
		      File file = fc.getSelectedFile();
		      if (!file.getName().toLowerCase().endsWith(".csv")) {
		         file = new File(file.getAbsolutePath() + ".csv");
		      }
			  try (PrintWriter pw = new PrintWriter(
			          new OutputStreamWriter(
			              new FileOutputStream(file), 
			              StandardCharsets.UTF_8))) {
			      pw.write('\uFEFF');
		      for (int c = 0; c < modeloTabela.getColumnCount(); c++) {
		          pw.print(modeloTabela.getColumnName(c));
		          if (c < modeloTabela.getColumnCount() - 1) {
		              pw.print(";");
		          }
		      }
		      pw.println();

			  for (int r = 0; r < modeloTabela.getRowCount(); r++) {
			       for (int c = 0; c < modeloTabela.getColumnCount(); c++) {
			           Object val = modeloTabela.getValueAt(r, c);
			           pw.print(val == null ? "" : val.toString());
			           if (c < modeloTabela.getColumnCount() - 1) {
			               pw.print(";");
			           }
			       }
			       pw.println();
			       
			  }  
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this,
	                "Erro ao salvar CSV: " + ex.getMessage(),
	                "Erro", JOptionPane.ERROR_MESSAGE);
	            return;
	            
	        }
			JOptionPane.showMessageDialog(this,
			    "Relatório exportado com sucesso em:\n" + file.getAbsolutePath(),
			    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	    }
	}

}
