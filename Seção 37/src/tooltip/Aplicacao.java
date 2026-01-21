package tooltip;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JFrame janela = new JFrame("Tabela com Tooltip");
				
				janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				janela.setSize(600, 400);
				
				janela.setLocationRelativeTo(null);
				
				TabelaComCaixaDeDica painel = new TabelaComCaixaDeDica();
				
				janela.getContentPane().add(painel);
				
				janela.setVisible(true);
				
			}
			
		});
		
	}

}
