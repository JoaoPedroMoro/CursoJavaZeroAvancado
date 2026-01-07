package interface_grafica;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Aula_12_ExemploJTree {

	public static void main(String[] args) {

		JFrame janela = new JFrame("Exemplo JTree");
		
		janela.setSize(300,300);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Pastas");
		
		DefaultMutableTreeNode documentos = new DefaultMutableTreeNode("Documentos");
		
		DefaultMutableTreeNode imagens = new DefaultMutableTreeNode("Imagens");
		
		raiz.add(documentos);
		
		raiz.add(imagens);
		
		JTree arvore = new JTree(raiz);
		
		JScrollPane rolagem = new JScrollPane(arvore);
		
		janela.add(rolagem);

		janela.setVisible(true);

	}

}
