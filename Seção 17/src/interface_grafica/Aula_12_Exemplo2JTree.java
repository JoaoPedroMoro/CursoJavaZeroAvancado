package interface_grafica;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class Aula_12_Exemplo2JTree {

	public static void main(String[] args) {
		
		JFrame janela = new JFrame("Exemplo JTree - Melhorado");
		
		janela.setSize(600, 450);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setLayout(new BorderLayout(8, 8));
		
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Pastas");
		
		DefaultMutableTreeNode documentos = new DefaultMutableTreeNode("Documentos");
		
		documentos.add(new DefaultMutableTreeNode("Currículo.docx"));
		
		documentos.add(new DefaultMutableTreeNode("Relatorio.pdf"));
		
		DefaultMutableTreeNode imagens = new DefaultMutableTreeNode("Imagens");
		
		imagens.add(new DefaultMutableTreeNode("Foto1.jpg"));
		
		imagens.add(new DefaultMutableTreeNode("Logo.png"));
		
		raiz.add(documentos);
		
		raiz.add(imagens);
		
		// Modelo da árvore (necessário para CRUD)
		DefaultTreeModel modelo = new DefaultTreeModel(raiz);
		
		JTree arvore = new JTree(modelo);
		
		arvore.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		JScrollPane rolagem = new JScrollPane(arvore);
		
		JLabel lblCaminho = new JLabel("Selecione um nó ...");
		
		lblCaminho.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
		
		arvore.addTreeSelectionListener(e -> {
			
			TreePath path = e.getPath();
			
			if (path != null) {
				
				lblCaminho.setText("Caminho: " + pathToString(path));
				
			} else {
				
				lblCaminho.setText("Selecione um nó ...");
				
			}
			
		});
		
		JPanel rodape = new JPanel(new GridLayout());
		
		rodape.setBorder(BorderFactory.createTitledBorder("Ações"));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(6, 6, 6, 6);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0;
		
		gbc.gridy = 0;
		
		gbc.weightx = 1.0;
		
		JTextField campoNome = new JTextField();
		
		rodape.add(campoNome, gbc);
		
		gbc.gridx = 1;
		
		gbc.gridy = 0;
		
		gbc.weightx = 0;
		
		JPanel botoes =  new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
		
		JButton btAdicionar = new JButton("Adicionar filho");
		
		JButton btRenomear = new JButton("Renomear");
		
		JButton btRemover = new JButton("Remover");
		
		botoes.add(btAdicionar);
		
		botoes.add(btRenomear);
		
		botoes.add(btRemover);
		
		rodape.add(botoes, gbc);
		
		btAdicionar.addActionListener(e -> {
			
			DefaultMutableTreeNode selecionado = getSelecionado(arvore);
			
			if (selecionado == null) {
				
				JOptionPane.showMessageDialog(janela, "Selecione um nó para adicionar o filho.");
				return;
				
			}
			
			String nome = campoNome.getText().trim();
			
			if (nome.isEmpty()) {
				
				JOptionPane.showMessageDialog(janela, "Digite um nome no campo para o novo nó.");
				return;
				
			}
			
			DefaultMutableTreeNode novo = new DefaultMutableTreeNode(nome);
			
			modelo.insertNodeInto(novo,  selecionado, selecionado.getChildCount());
			
			TreePath caminho = new TreePath(modelo.getPathToRoot(novo));
			
			arvore.scrollPathToVisible(caminho);
			
			arvore.setSelectionPath(caminho);
			
			campoNome.setText("");
			
		});
		
		btRenomear.addActionListener(e -> {
			
			DefaultMutableTreeNode selecionado = getSelecionado(arvore);
			
			if (selecionado == null) {
				
				JOptionPane.showMessageDialog(janela, "Selecione um nó para renomear.");
				return;
				
			}
			
			if (selecionado.isRoot()) {
				
				JOptionPane.showMessageDialog(janela, "A raiz não pode ser renomeada.");
				return;
				
			}
			
			String novoNome = campoNome.getText().trim();
			
			if (novoNome.isEmpty()) {
				
				JOptionPane.showMessageDialog(janela, "Digite um novo nome no campo.");
				return;
				
			}
			
			selecionado.setUserObject(novoNome);
			
			modelo.nodeChanged(selecionado);
			
			arvore.setSelectionPath(new TreePath(modelo.getPathToRoot(selecionado)));
			
			campoNome.setText("");
			
		});
		
		btRemover.addActionListener(e -> {
			
			DefaultMutableTreeNode selecionado = getSelecionado(arvore);
			
			if (selecionado == null) {
				
				JOptionPane.showMessageDialog(janela, "Selecione um nó para remover.");
				return;
				
			}
			
			if (selecionado.isRoot()) {
				
				JOptionPane.showMessageDialog(janela, "A raiz não pode ser removida.");
				return;
				
			}
			
			int op = JOptionPane.showConfirmDialog(janela, "Remover\"" + selecionado.getUserObject() + "\"?" , "Confirmação", JOptionPane.YES_NO_OPTION);
			
			if (op == JOptionPane.YES_OPTION) {
				
				MutableTreeNode pai = (MutableTreeNode) selecionado.getParent();
				
				int idx = pai != null ? ((DefaultMutableTreeNode) pai).getIndex(selecionado) : -1;
				
				modelo.removeNodeFromParent(selecionado);
				
				if (pai != null) {
					
					TreePath caminhoPai = new TreePath(modelo.getPathToRoot((TreeNode) pai));
					
					arvore.setSelectionPath(caminhoPai);
					
					arvore.scrollRowToVisible(Math.max(0,  -1));
					
				}
			}
		});
		
		arvore.addTreeSelectionListener(e -> {
			
			DefaultMutableTreeNode sel = getSelecionado(arvore);
			
			if (sel != null) {
				
				campoNome.setText(String.valueOf(sel.getUserObject()));
				
			}
			
		});
		
		janela.add(lblCaminho, BorderLayout.NORTH);
		
		janela.add(rolagem, BorderLayout.CENTER);
		
		janela.add(rodape, BorderLayout.SOUTH);
		
		expandirTudo(arvore);
		
		janela.setVisible(true);

	}
	
	private static DefaultMutableTreeNode getSelecionado(JTree arvore) {
		
		TreePath path = arvore.getSelectionPath();
	
		if (path == null) return null;
		
		return (DefaultMutableTreeNode) path.getLastPathComponent();
		
	}
	
	private static String pathToString(TreePath path) {
		
		Object[] nos = path.getPath();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < nos.length; i++) {
			
			sb.append(nos[i].toString());
			
			if (i < nos.length - 1) sb.append("/");
			
		}
		
		return sb.toString();
		
	}
	
	private static void expandirTudo(JTree arvore) {
		
		for (int i = 0; i < arvore.getRowCount(); i++) {
			
			arvore.expandRow(i);
			
		}
	}

}
