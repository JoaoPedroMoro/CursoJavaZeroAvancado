package efeito;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AplicacaoEfeitoRevelacao {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			
			try {
				
				JFrame janela = new JFrame("Efeito de Revelação Dinâmica");
				
				janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				String caminhoInferior = "C:\\Users\\jpgar\\eclipse-workspace\\EfeitoRevelacaoDinamica\\src\\imagens\\imagem-inferior.jpg";
				
				String caminhoSuperior = "C:\\Users\\jpgar\\eclipse-workspace\\EfeitoRevelacaoDinamica\\src\\imagens\\imagem-superior.jpg";
				
				PainelRevelacao painel = new PainelRevelacao(caminhoInferior, caminhoSuperior);
				
				janela.getContentPane().add(painel);
				
				janela.pack();
				
				janela.setLocationRelativeTo(null);
				
				janela.setVisible(true);
				
			} catch (Exception erro) {
				
				erro.printStackTrace();
				
			}
		});

	}

}
