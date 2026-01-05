package interface_grafica;

//======================================================================
//Importações de bibliotecas necessárias para a GUI.
//- javax.swing.*  → componentes Swing (JFrame, JPanel, JLabel, JButton,
//                 JComboBox, JOptionPane, BorderFactory, etc.).
//- java.awt.*     → classes de AWT, principalmente Layouts (GridLayout,
//                 FlowLayout, BorderLayout), cores (Color) e dimensões.
//======================================================================
import javax.swing.*;

import java.awt.*;

public class Aula_9_ExemploJComboBox {

	public static void main(String[] args) {

		JFrame janela = new JFrame("Exemplos JComboBox");
		
		janela.setSize(400, 300);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setLayout(new GridLayout(3, 1, 10, 10));
		
		JPanel painelItens = new JPanel(new FlowLayout());
		
		painelItens.setBorder(BorderFactory.createTitledBorder("Escolha um item"));
		
		String[] itens = {"Item 1", "Item 2", "Item 3"};
		
		JComboBox<String> comboItens = new JComboBox<>(itens);
		
		JButton botaoMostrar = new JButton("Mostrar seleção");
		
		botaoMostrar.addActionListener(e -> {
			
			String selecionado = (String) comboItens.getSelectedItem();
			
		
			JOptionPane.showMessageDialog(janela, "Você escolheu " + selecionado);
			
		});
		
		painelItens.add(comboItens);
		
		painelItens.add(botaoMostrar);
		
		janela.add(painelItens);
		
		JPanel painelPaises = new JPanel(new FlowLayout());
		
		painelPaises.setBorder(BorderFactory.createTitledBorder("Selecione o seu país"));
		
		String[] paises = {"Brasil", "Argentina", "Chile", "Estados Unidos", "Japão"};
		
		JComboBox<String> comboPaises = new JComboBox<>(paises);
		
		painelPaises.add(new JLabel("País: "));
		
		painelPaises.add(comboPaises);
		
		janela.add(painelPaises);
		
		JPanel painelCores = new JPanel(new FlowLayout());
		
		painelCores.setBorder(BorderFactory.createTitledBorder("Trocar cor de fundo"));
		
		String[] cores = {"Branco", "Amarelo", "Verde", "Azul"};
		
		JComboBox<String> comboCores = new JComboBox<>(cores);
		
		JPanel painelExemplo = new JPanel();
		
		painelExemplo.setPreferredSize(new Dimension(100, 50));
		
		painelExemplo.setBackground(Color.WHITE);
		
		comboCores.addActionListener(e -> {
			
			String corSelecionada = (String) comboCores.getSelectedItem();
			
			switch (corSelecionada) {
			
				case "Amarelo":
					painelExemplo.setBackground(Color.YELLOW);
					break;
					
				case "Verde":
					painelExemplo.setBackground(Color.GREEN);
					break;
					
				case "Azul":
					painelExemplo.setBackground(Color.CYAN);
					break;
			
				default:
					painelExemplo.setBackground(Color.WHITE);
					
			}
			
		});
		
		painelCores.add(comboCores);
		
		painelCores.add(painelExemplo);
		
		janela.add(painelCores);
		
		janela.setVisible(true);

	}

}
