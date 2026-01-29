package memoria;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Carta {
	
	private int id;
	private JButton botao;
	private boolean virada;
	private boolean removida;
	private ImageIcon icone;
	
	public Carta(int id) {
		
		this.id = id;
		this.botao = new JButton("?");
		this.botao.setFont(new Font("Arial", Font.BOLD, 24));
		this.virada = false;
		this.removida = false;
		carregarIcone();
		
	}
	
	private void carregarIcone() {
		
		String caminho = JogoMemoria.CAMINHO_IMAGENS + "img" + id + ".jpg";
		
		File f = new File(caminho);
		
		if (!f.exists()) {
			
			System.err.println("Imagem não encontrada: " + caminho);
			
			this.icone = new ImageIcon();
			
		} else {
			
			this.icone = new ImageIcon(caminho);
			
		}
		
	}
	
	public int getId() {return id;}
	
	public JButton getBotao() {return botao;}
	
	public boolean estaViradaParaBaixo() {return !virada;}
	
	public boolean foiRemovida() {return removida;}
	
	public void virarParaCima() {
		
		virada = true;
		
		botao.setText("");
		
		SwingUtilities.invokeLater(() -> {
			
			int largura = botao.getWidth() > 0 ? botao.getWidth() : 150;
			
			int altura = botao.getHeight() > 0 ? botao.getHeight() : 150;
			
			Image img = icone.getImage()
					.getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
			
			botao.setIcon(new ImageIcon(img));
			
		});
		
	}
	
	public void virarParaBaixo() {
		
		virada = false;
		
		botao.setIcon(null);
		
		botao.setText("?");
		
	}
	
	public void remover() {
		
		removida = true;
		
		botao.setEnabled(false);
		
	}

}
