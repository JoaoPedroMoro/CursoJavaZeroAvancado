package tabuada;

import javax.swing.*;
import java.awt.*;

public class PainelMenu extends JPanel {
	
	private final JButton btnAleatorio = new JButton("Treinar tabuadas 1-10 (Aleatório)");
	
	private final JTextField campoNumeroTabuada = new JTextField(5);
	
	private final JButton btnIniciarTabuada = new JButton("Treinar tabuada específica");
	
	PainelMenu(){
		
//		setLayout(new GridLayout());
		setLayout(new GridBagLayout());

		
		setBackground(Color.WHITE);
		
		GridBagConstraints g = new GridBagConstraints();
		
		g.anchor = GridBagConstraints.CENTER;
		g.weightx = 1.0;
		
		g.insets = new Insets(10, 10, 10, 10);
		
		g.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel titulo = new JLabel("Jogo da Tabuada", SwingConstants.CENTER);
		
		titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 28f));
		
		g.gridy = 0;
		
		add(titulo, g);
		
		JLabel instr = new JLabel("Escolha o modo de jogo:", SwingConstants.CENTER);
		
		instr.setFont(instr.getFont().deriveFont(16f));
		
		g.gridy = 1;
		
		add(instr, g);
		
//		btnAleatorio.setBackground(new Color(0x4CAF50));
		btnAleatorio.setBackground(Constantes.VERDE);
		
//		btnAleatorio.setForeground(Color.WHITE);
		btnAleatorio.setForeground(Constantes.FUNDO);
		
		g.gridy = 2;
		
		add(btnAleatorio, g);
		
		JLabel espec = new JLabel("Ou digite a tabuada desejada (1-10):", SwingConstants.CENTER);
		
		espec.setFont(espec.getFont().deriveFont(16f));
		
		g.gridy = 3;
		
		add(espec, g);
		
		JPanel linha = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		linha.add(campoNumeroTabuada);
		
		linha.add(btnIniciarTabuada);
		
		g.gridy = 4;
		
		add(linha, g);	
		
	}

	public JButton getBtnAleatorio() {
		
		return btnAleatorio;
		
	}

	public JTextField getCampoNumeroTabuada() {
		
		return campoNumeroTabuada;
		
	}

	public JButton getBtnIniciarTabuada() {
		
		return btnIniciarTabuada;
		
	}

}
