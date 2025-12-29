package interface_grafica;

import javax.swing.*;

import java.awt.*;

public class Aula_2_ExemplosJLabel {

	public static void main(String[] args) {

		JFrame janela = new JFrame("Exemplo JFrame 2");
		
		janela.setVisible(true);
		
		janela.setSize(400, 300);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setLayout(new BorderLayout(10, 10));
		
		JLabel rotulo1 = new JLabel("Sou um JLabel padrão");
		
		JLabel rotulo2 = new JLabel("Fonte maior e em negrito");
		
		rotulo2.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel rotulo3 = new JLabel("Texto em azul");
		
		rotulo3.setForeground(Color.BLUE);
		
		JLabel rotulo4 = new JLabel("Texto com fundo amarelo");
		
		rotulo4.setOpaque(true);
		
		rotulo4.setBackground(Color.YELLOW);
		
		ImageIcon iconeOriginal = new ImageIcon("C:\\Users\\jpgar\\eclipse-workspace\\Interface_Grafica\\src\\interface_grafica\\java.png");
		
		Image img = iconeOriginal.getImage();
		
		Image imgRedimensionada = img.getScaledInstance(100, 200, Image.SCALE_SMOOTH);
		
		ImageIcon iconeRedimensionado = new ImageIcon(imgRedimensionada);
		
		JLabel rotulo5 = new JLabel("Texto centralizado + icone", iconeRedimensionado, JLabel.CENTER);
		
		rotulo5.setHorizontalTextPosition(JLabel.CENTER);
		
		rotulo5.setVerticalTextPosition(JLabel.BOTTOM);
		
		JPanel painelTexto = new JPanel(new GridLayout(4, 1, 10, 10));
		
		painelTexto.add(rotulo1);
		
		painelTexto.add(rotulo2);
		
		painelTexto.add(rotulo3);
		
		painelTexto.add(rotulo4);
		
		janela.add(painelTexto, BorderLayout.CENTER);
		
		JPanel painelImagem = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		painelImagem.add(rotulo5);
		
		janela.add(painelImagem, BorderLayout.SOUTH);
		
		janela.pack();
		
		janela.setLocationRelativeTo(null);
		
		

	}

}
