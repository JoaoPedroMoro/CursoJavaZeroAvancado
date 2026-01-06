package interface_grafica;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import java.awt.*;
import java.util.regex.Pattern;

public class Aula_11_ExemploJTable_CRUD {

	public static void main(String[] args) {
		
        // Solicita que a criação da interface seja executada de 
	    // 			forma assíncrona dentro da Event Dispatch Thread, 
	    // 			garantindo segurança para a UI.
        // Usamos "Aula11_ExemploJTable_CRUD::criarTela" como 
	    // 			referência de método (lambda simplificada).
        // Assim, o método criarTela() será chamado quando a 
	    // 			thread de eventos estiver pronta.
        SwingUtilities.invokeLater(Aula_11_ExemploJTable_CRUD::criarTela);

	}
	
	private static void criarTela() {
		
		JFrame janela = new JFrame("JFrame - CRUD + Pesquisa (Exemplo didático");
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setSize(900, 500);
		
		janela.setLocationRelativeTo(null);
		
		janela.setLayout(new BorderLayout(10, 10));
		
		String[] colunas = {"ID", "Nome"};
		
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
				
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				
				return columnIndex == 0 ? Integer.class : String.class;
				
			}
			
		};
		
		modelo.addRow(new Object[] {1, "Ana"});
		modelo.addRow(new Object[] {2, "Bruno"});
		modelo.addRow(new Object[] {3, "Carlos"});
		
		JTable tabela = new JTable(modelo);
		
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabela.setRowHeight(24);
		
		tabela.setAutoCreateRowSorter(true);
		
		TableColumnModel cols = tabela.getColumnModel();
		
		cols.getColumn(0).setPreferredWidth(80);
		
		cols.getColumn(1).setPreferredWidth(300);
		
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
		
		tabela.setRowSorter(sorter);
		
		JScrollPane rolagem = new JScrollPane(tabela);
		
		janela.add(rolagem, BorderLayout.CENTER);
		
		JPanel topo = new JPanel(new BorderLayout(8, 8));
		
		JPanel painelBusca = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
		
		painelBusca.add(new JLabel("Pesquisar"));
		
		JTextField campoPesquisa = new JTextField(25);
		
		JButton btLimparPesquisa = new JButton("Limpar");
		
		painelBusca.add(campoPesquisa);
		
		painelBusca.add(btLimparPesquisa);
		
		JLabel lblContagem = new JLabel("Exibidos: 0 | Total: 0");
		
		JPanel painelContagem = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
		
		painelContagem.add(lblContagem);
		
		topo.add(painelBusca, BorderLayout.WEST);
		
		topo.add(painelContagem, BorderLayout.EAST);
		
		janela.add(topo, BorderLayout.NORTH);
		
		DocumentListener listenerFiltro = new DocumentListener() {
			
			private void aplicar() {
				
				String termo = campoPesquisa.getText().trim();
				
				if (termo.isEmpty()) {
					
					sorter.setRowFilter(null);
					
				} else {
					
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(termo)));
					
				}
				
				atualizarContagem(tabela, modelo, lblContagem);
				
			}
			
			public void insertUpdate(DocumentEvent e) {aplicar(); }
			
			public void removeUpdate(DocumentEvent e) {aplicar(); }
			
			public void changedUpdate(DocumentEvent e) { aplicar(); }
			
		};
		
		campoPesquisa.getDocument().addDocumentListener(listenerFiltro);
		
		btLimparPesquisa.addActionListener(e -> {
			
			campoPesquisa.setText("");
			
			sorter.setRowFilter(null);
			
			atualizarContagem(tabela, modelo, lblContagem);
			
		});
		
		JPanel rodape = new JPanel(new GridBagLayout());
		
		rodape.setBorder(BorderFactory.createTitledBorder("Cadastro simples"));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(6, 6, 6, 6);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
		
		rodape.add(new JLabel("ID: "), gbc);
		
		JTextField campoId = new JTextField(10);
		
		gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1;
		
		rodape.add(campoId, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
		
		rodape.add(new JLabel("Nome:"), gbc);
		
		JTextField campoNome = new JTextField(30);
		
		gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 1;
		
		rodape.add(campoNome, gbc);
		
		JPanel botoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		JButton btAdicionar = new JButton("Adicionar");
		
		JButton btAlterar = new JButton("Alterar");
		
		JButton btExcluir = new JButton("Excluir");
		
		JButton btLimpar = new JButton("Limpar campos");
		
		botoes.add(btAdicionar);
		botoes.add(btAlterar);
		botoes.add(btExcluir);
		botoes.add(btLimpar);
		
		gbc.gridx = 0;  gbc.gridy = 2; gbc.gridwidth = 2; gbc.weightx = 0;
		
		rodape.add(botoes, gbc);
		
		janela.add(rodape, BorderLayout.SOUTH);
		
		atualizarContagem(tabela, modelo, lblContagem);
		
		tabela.getSelectionModel().addListSelectionListener(e -> {
			
			if (!e.getValueIsAdjusting()) {
				
				int viewRow = tabela.getSelectedRow();
				
				if (viewRow >= 0) {
					
					int modelRow = tabela.convertRowIndexToModel(viewRow);
					
					Object id = modelo.getValueAt(modelRow, 0);
					
					Object nome = modelo.getValueAt(modelRow, 1);
					
					campoId.setText(String.valueOf(id));
					
					campoNome.setText(nome == null ? "" : nome.toString());
				}
			}
		});
		
		tabela.addMouseListener(new java.awt.event.MouseAdapter() {

		    @Override 
		    public void mouseClicked(java.awt.event.MouseEvent e) {

		        if (e.getClickCount() == 2) {

		            int row = tabela.getSelectedRow();

		            if (row >= 0) {

		                int m = tabela.convertRowIndexToModel(row);

		                campoId.setText(String.valueOf(modelo.getValueAt(m, 0)));

		                campoNome.setText(String.valueOf(modelo.getValueAt(m, 1)));
		                
		            }
		        }
		    }
		});
		
		tabela.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("DELETE"), "Excluir Linha");
		
		tabela.getActionMap().put("Excluir Linha", new AbstractAction() {
			
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				excluirSelecionado(janela, tabela, modelo, lblContagem);
				
			}
			
		});
		
		btAdicionar.addActionListener(e -> {
			
			String sId = campoId.getText().trim();
			String nome = campoNome.getText().trim();
			
			if (sId.isEmpty() || nome.isEmpty()) {
				
				JOptionPane.showMessageDialog(janela, "Preencha ID e Nome");
				return;
				
			}
			
			Integer id;
			
			try {
				
				id = Integer.valueOf(sId);
				
			} catch (NumberFormatException ex) {
				
				JOptionPane.showMessageDialog(janela, "ID deve ser número inteiro");
				return;
				
			}
			
			if (existeId(modelo, id)) {
				
				JOptionPane.showMessageDialog(janela, "Já existe um registro com esse ID.");
				return;
				
			}
			
			modelo.addRow(new Object[] {id, nome});
			
			limparCampos(campoId, campoNome);
			
			atualizarContagem(tabela, modelo, lblContagem);
			
		});
		
		btAlterar.addActionListener(e -> {
			
			int viewRow = tabela.getSelectedRow();
			
			if (viewRow <0) {
				
				JOptionPane.showMessageDialog(janela, "Selecione uma linha para alterar");
				
				return;
				
			}
			
			String sId = campoId.getText().trim();
			
			String nome = campoNome.getText().trim();
			
			if (sId.isEmpty() || nome.isEmpty()) {
				
				JOptionPane.showMessageDialog(janela, "Preencha ID e Nome");
				
				return;
				
			}
			
			Integer idNovo;
			
			try {
				
				idNovo = Integer.valueOf(sId);
				
			} catch (NumberFormatException ex) {
				
				JOptionPane.showMessageDialog(janela, "ID deve ser um número inteiro.");
				return;
				
			}
			
			int modelRow = tabela.convertRowIndexToModel(viewRow);
			
			Integer idAtual = (Integer) modelo.getValueAt(modelRow, 0);
			
			if (!idNovo.equals(idAtual) && existeId(modelo, idNovo)) {
				
				JOptionPane.showMessageDialog(janela, "Já existe um registro com esse novo ID");
				
				return;
				
			}
			
			modelo.setValueAt(idNovo, modelRow, 0);
			
			modelo.setValueAt(nome, modelRow, 1);
			
			atualizarContagem(tabela, modelo, lblContagem);
			
			JOptionPane.showMessageDialog(janela, "Registro alterado");
			
		});
		
		btExcluir.addActionListener(e -> {excluirSelecionado(janela, tabela, modelo, lblContagem);});
		
		btLimpar.addActionListener(e -> limparCampos(campoId, campoNome));
		
		janela.setVisible(true);
		
		
	}
	
	private static void atualizarContagem(JTable tabela, DefaultTableModel modelo, JLabel lbl) {
		
		int total = modelo.getRowCount();
		
		int exibidos = tabela.getRowCount();
		
		lbl.setText("Exibidos: " + exibidos + " | Total: " + total);
		
	}
	
	private static boolean existeId(DefaultTableModel modelo, int id) {
		
		for (int i = 0; i < modelo.getRowCount(); i++) {
			
			Object val = modelo.getValueAt(i, 0);
			
			if (val instanceof Integer && (Integer) val == id) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	private static void excluirSelecionado(JFrame janela, JTable tabela, DefaultTableModel modelo, JLabel lblContagem) {
		
		int viewRow = tabela.getSelectedRow();
		
		if (viewRow < 0) {
			
			JOptionPane.showMessageDialog(janela, "Selecione uma linha para excluir");
			
			return;
			
		}
		
		int op = JOptionPane.showConfirmDialog(janela, "Excluir a linha selecionada?", "Confirmação", JOptionPane.YES_NO_OPTION);
		
		if (op == JOptionPane.YES_OPTION) {
			
			int modelRow = tabela.convertRowIndexToModel(viewRow);
			
			modelo.removeRow(modelRow);
			
			atualizarContagem(tabela, modelo, lblContagem);
		}
		
	}
	
	private static void limparCampos(JTextField campoId, JTextField campoNome) {
		
		campoId.setText("");
		
		campoNome.setText("");
		
		campoId.requestFocus();
		
	}

}
