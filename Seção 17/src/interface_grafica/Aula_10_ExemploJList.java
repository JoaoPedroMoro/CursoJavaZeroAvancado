package interface_grafica;

import javax.swing.*;

import java.awt.*;

public class Aula_10_ExemploJList {

	public static void main(String[] args) {

		JFrame janela = new JFrame("Exemplos JList");
		
		janela.setSize(500,300);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setLayout(new GridLayout(3, 1, 10, 10));
		
		JPanel painelSimples = new JPanel(new BorderLayout());
		
		painelSimples.setBorder(BorderFactory.createTitledBorder("Seleção simples"));
		
		String[] frutas = {"Maçã", "Banana", "Laranja", "Uva", "Pera"};
		
		JList<String> listaSimples = new JList<>(frutas);
		
		listaSimples.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton botaoMostrarSimples = new JButton("Mostrar seleção");
		
		botaoMostrarSimples.addActionListener(e -> {
			
			String selecionado = listaSimples.getSelectedValue();
			
			JOptionPane.showMessageDialog(janela, selecionado != null ? "Você escolheu " + selecionado : "Nenhuma fruta selecionada");
			
		});
		
		painelSimples.add(new JScrollPane(listaSimples), BorderLayout.CENTER);
		
		painelSimples.add(botaoMostrarSimples, BorderLayout.SOUTH);
		
		janela.add(painelSimples);
		
		JPanel painelMultipla = new JPanel(new BorderLayout());
		
		painelMultipla.setBorder(BorderFactory.createTitledBorder("Seleção múltipla"));
		
		String[] cores = {"Vermelho", "Azul", "Verde", "Amarelo", "Preto", "Branco"};
		
		JList<String> listaMultipla = new JList<>(cores);
		
		listaMultipla.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JButton botaoMostarMultiplos = new JButton("Mostar seleção");
		
		botaoMostarMultiplos.addActionListener(e -> {
			
			java.util.List<String> selecionados = listaMultipla.getSelectedValuesList();
			
			if (selecionados.isEmpty()) {
				
				JOptionPane.showMessageDialog(janela, "Nenhuma cor selecionada");
				
			} else {
				
				JOptionPane.showMessageDialog(janela, "Você escolheu: " + selecionados);
				
			}
			
		});
		
		painelMultipla.add(new JScrollPane(listaMultipla), BorderLayout.CENTER);
		
		painelMultipla.add(botaoMostarMultiplos, BorderLayout.SOUTH);
		
		janela.add(painelMultipla);
		
		JPanel painelFixado = new JPanel(new BorderLayout());
		
		painelFixado.setBorder(BorderFactory.createTitledBorder("Lista com altura fixa"));
		
		String[] animais = {"Cachorro", "Gato", "Elefante", "Cavalo", "Leão", "Tigre"};
		
		JList<String> listaAnimais = new JList<>(animais);
		
		listaAnimais.setVisibleRowCount(3);
		
		painelFixado.add(new JScrollPane(listaAnimais), BorderLayout.CENTER);
		
		janela.add(painelFixado);
		
		janela.setVisible(true);


	}

}
