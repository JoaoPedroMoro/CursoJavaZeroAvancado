package interface_grafica;

import javax.swing.*;
import java.awt.*;

public class Aula_5_ExemplosJTextArea {

	public static void main(String[] args) {

		JFrame janela = new JFrame("Exemplos JTextArea");
		
		janela.setSize(500, 400);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Definindo o gerenciador de layout da janela com 3 linhas, 1 coluna, 10 de espaçamento horizontal e 10 de espaçamento vertical
		janela.setLayout(new GridLayout(3, 1, 10, 10));
		
		JPanel painelBlocoNotas = new JPanel(new BorderLayout());
		
		painelBlocoNotas.setBorder(BorderFactory.createTitledBorder("Bloco de notas"));
		
		JTextArea areaNotas = new JTextArea(5, 30);
		
		JScrollPane rolagemNotas = new JScrollPane(areaNotas);
		
		painelBlocoNotas.add(rolagemNotas, BorderLayout.CENTER);
		
		JPanel painelLog = new JPanel(new BorderLayout());
		
		painelLog.setBorder(BorderFactory.createTitledBorder("Área de Log"));
		
		JTextArea areaLog = new JTextArea(5, 30);
		
		areaLog.setEditable(false);
		
		areaLog.setBackground(Color.BLACK);
		
		areaLog.setForeground(Color.GREEN);
		
		areaLog.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		JScrollPane rolagemLog = new JScrollPane(areaLog);
		
		painelLog.add(rolagemLog, BorderLayout.CENTER);
		
		JButton botaoAdicionarLog = new JButton("Adicionar Log");
		
		botaoAdicionarLog.addActionListener(e -> {
			areaLog.append("Nova linha de log gerada...\n");
		});
		
		painelLog.add(botaoAdicionarLog, BorderLayout.SOUTH);
		
		JPanel painelContador = new JPanel(new BorderLayout());
		
		painelContador.setBorder(BorderFactory.createTitledBorder("Contador de caracteres"));
		
		JTextArea areaContador = new JTextArea(5, 30);
		
		JScrollPane rolagemContador = new JScrollPane(areaContador);
		
		painelContador.add(rolagemContador, BorderLayout.CENTER);
		
		JLabel labelContador = new JLabel("Caracteres: 0");
		
		painelContador.add(labelContador, BorderLayout.SOUTH);
		
		// O addCaretListener detecta mudanças na posição do cursor de texto, ou seja, cada vez que alguma alteração
		// for realizada no cursor de texto, o código a seguir será executado.
		areaContador.addCaretListener(e -> {
			
			int totalCaracteres = areaContador.getText().length();
			
			labelContador.setText("Caracteres: " + totalCaracteres);
			
		});
		
		
		janela.add(painelBlocoNotas);
		janela.add(painelLog);
		janela.add(painelContador);
		
		janela.setVisible(true);
		
	}

}
