package simulador_semaforo;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PainelSemaforo extends JPanel implements PropertyChangeListener {
	
	private final Semaforo semaforo;
	
	public PainelSemaforo(Semaforo semaforo) {
		
		this.semaforo = semaforo;
		
		this.semaforo.addObservador(this);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
//		g.setColor(Color.DARK_GRAY);
		g.setColor(Color.LIGHT_GRAY);
		
		g.fillRect(0, 0, getWidth(), getHeight());
		
		int diametro = 80;
		
		int espacamento = 30;
		
		int x = (getWidth() - diametro) / 2;
		
		int y = 40;
		
		for (EstadoSemaforo est : EstadoSemaforo.values()) {
			
			Color cor;
			
			switch(est) {
			
				case VERMELHO:
					
					cor = semaforo.getEstadoAtual() == EstadoSemaforo.VERMELHO
					? Color.RED
					: new Color(60, 0, 0);
				
					break;
					
				case AMARELO:
					
					cor = semaforo.getEstadoAtual() == EstadoSemaforo.AMARELO
					? Color.YELLOW
					: new Color(60, 60, 0);
				
					break;
					
				default:
					
					cor = semaforo.getEstadoAtual() == EstadoSemaforo.VERDE
					? Color.GREEN 
					: new Color(0, 60, 0);
					
					break;
			
			}
			
			g.setColor(cor);
			
			g.fillOval(x,  y,  diametro, diametro);
			
			y += diametro + espacamento;
			
		}
		
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("Arial", Font.BOLD, 20));
		
		String textoInstrucao = "Instrução: " + semaforo.getEstadoAtual().getInstrucao();
		
		String textoTempo = "Tempo: " + semaforo.getTempoRestante() + "s";
		
		g.drawString(textoInstrucao, 20, getHeight() - 50);
		
		g.drawString(textoTempo, 20, getHeight() - 25);
		
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		repaint();
		
	}

}
