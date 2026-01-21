package tabuada;

import javax.swing.*;
import java.awt.*;
import tabuada.Constantes;

public class JanelaPrincipal extends JFrame {
	
	public JanelaPrincipal() {
		
		super("Jogo da tabuada");
		
		CardLayout cl = new CardLayout();
		
		setLayout(cl);
		
		PainelMenu pm = new PainelMenu();
		
		PainelJogo pj = new PainelJogo();
		
		add(pm, "menu");
		
		add(pj, "jogo");
		
		new ControleJogo(this, cl, pm, pj);
		
		setSize(Constantes.LARG, Constantes.ALT);
		
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
