package interface_grafica;

import javax.swing.*;
import java.awt.*;

public class Aula_11_ExemploAvancado_JTabbedPane_MultiplasAbas {

	public static void main(String[] args) {

		JFrame f = new JFrame("JTabbedPane- Múltiplas abas");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setSize(500, 350);
		
		JTabbedPane abas = new JTabbedPane();
		
		// Aba 1
		
		JTextArea area = new JTextArea("Aba de texto ...\nVocê pode digitar aqui.");
		
		abas.addTab("Texto", new JScrollPane(area));
		
		// Aba 2
		
		String[] itens = {"Item 1", "Item 2", "Item 3"};
		
		JList<String> lista = new JList<>(itens);
		
		abas.addTab("Lista", new JScrollPane(lista));
		
		// Aba 3
		
		JPanel config = new JPanel(new FlowLayout());
		
		config.add(new JLabel("Opção"));
		
		config.add(new JCheckBox("Ativar recurso"));
		
		abas.addTab("Config", config);
		
		f.add(abas);
		
		f.setVisible(true);

	}

}
