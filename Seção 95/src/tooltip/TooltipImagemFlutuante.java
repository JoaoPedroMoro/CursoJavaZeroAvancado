package tooltip;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TooltipImagemFlutuante {

	private final JWindow janela;
	private final JLabel rotuloTexto;
	private final JLabel rotuloImagem;
	
	public TooltipImagemFlutuante(Window dono) {
		
		janela = new JWindow(dono);
		
		JPanel conteudo = new JPanel(new BorderLayout(8, 8));
		
		conteudo.setBackground(new Color(255, 240, 255));
		
		conteudo.setBorder(new LineBorder(new Color(150, 180, 210), 2, true));
		
		rotuloTexto = new JLabel("", SwingConstants.LEFT);
		
		rotuloTexto.setFont(new Font("Arial", Font.BOLD, 14));
		
		rotuloImagem = new JLabel();
		
		rotuloImagem.setHorizontalAlignment(SwingConstants.CENTER);
		
		conteudo.add(rotuloTexto, BorderLayout.NORTH);
		
		conteudo.add(rotuloImagem, BorderLayout.CENTER);
		
		conteudo.setPreferredSize(new Dimension(280, 260));
		
		janela.setContentPane(conteudo);
		
		janela.pack();
		
	}
	
	public void mostrar(String texto, String caminhoImagem, int telaX, int telaY) {
		
		rotuloTexto.setText(texto != null ? "<html>" + texto.replace("\n", "<br>") + "</html>" : "");
		
		ImageIcon icone = carregarIcone(caminhoImagem);
		
		if (icone != null) {
			
			rotuloImagem.setIcon(icone);
			
			rotuloImagem.setText("");
			
		} else {
			
			rotuloImagem.setIcon(null);
			
			rotuloImagem.setText("Imagem não encontrada.");
			
		}
		
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = Math.min(telaX + 10, tela.width - janela.getWidth() - 4);
		int y = Math.min(telaY + 10, tela.height - janela.getHeight() - 4);
		
		janela.setLocation(x, y);
		
		janela.setVisible(true);
		
	}
	
	public void ocultar() {
		
		janela.setVisible(false);
		
	}
	
	private ImageIcon carregarIcone(String caminho) {
		
		try {
			
			if (caminho == null || caminho.isBlank()) return null;
			
			Image img = new ImageIcon(caminho).getImage();
			
			Image esc = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			
			return new ImageIcon(esc);
			
		} catch (Exception e) {
			
			return null;
		}
		
	}
	
}
