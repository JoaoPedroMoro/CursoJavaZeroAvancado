package interface_grafica;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;

public class Aula_1_ExemplosComponentesBasicos {

	public static void main(String[] args) {

		JFrame janela = new JFrame("Componentes Básicos = Swing");
		
		janela.setSize(500,400);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setLayout(new GridLayout(0, 2, 10, 10));
		
		JButton btnLabel = new JButton("Exemplo JLabel");
		
		JButton btnButton = new JButton("Exemplo JButton");

		JButton btnTextField = new JButton("Exemplo JTextField");
		
		JButton btnTextArea = new JButton("Exemplo JTextArea");
		
		JButton btnPassword = new JButton("Exemplo JPasswordField");
		
		JButton btnCheckBox = new JButton("Exemplo JCheckBox");
		
		JButton btnRadio = new JButton("Exemplo JRadioButton");
		
		JButton btnCombo = new JButton("Exemplo JComboBox");
		
		JButton btnList = new JButton("Exemplo JList");
		
		JButton btnTable = new JButton("Exemplo JTable");
		
		JButton btnTree = new JButton("Exemplo JTree");
		
		janela.add(btnLabel);
		
		janela.add(btnButton);
		
		janela.add(btnTextField);
		
		janela.add(btnTextArea);
		
		janela.add(btnPassword);
		
		janela.add(btnCheckBox);
		
		janela.add(btnRadio);
		
		janela.add(btnCombo);
		
		janela.add(btnList);
		
		janela.add(btnTable);
		
		janela.add(btnTree);
		
		btnLabel.addActionListener(e -> {
			
			JOptionPane.showMessageDialog(
					
					janela,
					
					new JLabel("Sou um JLabel (rótulo de texto)!")
					
					);
		});
		
		btnButton.addActionListener(e -> {
			
			JButton botao = new JButton("Clique em mim!");
					
			JOptionPane.showMessageDialog(
					janela,
					botao,
					"Exemplo JButton",
					JOptionPane.PLAIN_MESSAGE);
			
		});
		
		btnTextField.addActionListener(e -> {
			
			JTextField campo = new JTextField(15);
			
			JOptionPane.showMessageDialog(
					janela,
					campo,
					"Digite algo (JTextField)",
					JOptionPane.PLAIN_MESSAGE
					);
		});
		
		btnTextArea.addActionListener(e -> {
			
			JTextArea area = new JTextArea(5, 20);
			
			JScrollPane rolagem = new JScrollPane(area);
			
			JOptionPane.showMessageDialog(
					janela,
					rolagem,
					"Digite várias linhas (JTextArea)",
					JOptionPane.PLAIN_MESSAGE
					);		
		});
		
		btnPassword.addActionListener(e -> {
			
			JPasswordField senha = new JPasswordField(10);
			
			JOptionPane.showMessageDialog(
					janela,
					senha,
					"Digite a senha (JPasswordField)",
					JOptionPane.PLAIN_MESSAGE
					);
		});
		
		btnCheckBox.addActionListener(e -> {
			
			JCheckBox check = new JCheckBox("Aceito os termos");
			
			JOptionPane.showMessageDialog(
					janela,
					check,
					"Exemplo CheckBox",
					JOptionPane.PLAIN_MESSAGE
					);
		});
		
		btnRadio.addActionListener(e -> {
			
			JRadioButton opc1 = new JRadioButton("Opção 1");
			
			JRadioButton opc2 = new JRadioButton("Opção 2");
			
			ButtonGroup grupo = new ButtonGroup();
			
			grupo.add(opc1);
			
			grupo.add(opc2);
			
			JPanel painel = new JPanel();
			
			painel.add(opc1);
			
			painel.add(opc2);
			
			JOptionPane.showMessageDialog(
					janela,
					painel,
					"Exemplo JRadioButton",
					JOptionPane.PLAIN_MESSAGE
					);
		});
		
		btnCombo.addActionListener(e -> {
			
			String[] itens = {"Item 1", "Item 2", "Item 3"};
			
			JComboBox<String> combo = new JComboBox<>(itens);
			
			JOptionPane.showMessageDialog(
					janela, 
					combo, 
					"Exemplo JComboBox", 
					JOptionPane.PLAIN_MESSAGE
					);
		});
		
		btnList.addActionListener(e -> {
			
			String[] itens = {"Maçã", "Banana", "Laranja", "Uva"};
			
			JList<String> lista = new JList<>(itens);
			
			JScrollPane rolagem = new JScrollPane(lista);
			
			JOptionPane.showMessageDialog(
					janela, 
					rolagem, 
					"Exemplo JList", 
					JOptionPane.PLAIN_MESSAGE
					);
		});
		
		btnTable.addActionListener(e -> {
			
			String[] colunas = {"ID", "Nome"};
			
			Object[][] dados = {
					{1, "Ana"},
					{2, "Bruno"},
					{3, "Carlos"}
			};
			
			JTable tabela = new JTable(new DefaultTableModel(dados, colunas));
			
			JScrollPane rolagem = new JScrollPane(tabela);
			
			JOptionPane.showMessageDialog(
					janela,
					rolagem,
					"Exemplo JTable",
					JOptionPane.PLAIN_MESSAGE
					);
		});
		
		btnTree.addActionListener(e -> {
			
			DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Pastas");
			
			DefaultMutableTreeNode pasta1 = new DefaultMutableTreeNode("Documentos");
			
			DefaultMutableTreeNode pasta2 = new DefaultMutableTreeNode("Imagens");
			
			raiz.add(pasta1);
			
			raiz.add(pasta2);
			
			JTree arvore = new JTree(raiz);
			
			JScrollPane rolagem = new JScrollPane(arvore);
			
			JOptionPane.showMessageDialog(
					janela,
					rolagem,
					"Exemplo JTree",
					JOptionPane.PLAIN_MESSAGE
					);
		});
		
		janela.setVisible(true);

	}

}
