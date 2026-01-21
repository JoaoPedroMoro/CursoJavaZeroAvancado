package tabuada;

import javax.swing.SwingUtilities;

public class TabuadaApp {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			
			new JanelaPrincipal().setVisible(true);
			
		});

	}

}
