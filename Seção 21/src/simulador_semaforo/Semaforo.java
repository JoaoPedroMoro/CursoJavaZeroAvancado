package simulador_semaforo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Semaforo {
	
	private EstadoSemaforo estadoAtual;
	
	private int tempoRestante;
	
	private final Timer timer;
	
	private final PropertyChangeSupport observadores = new PropertyChangeSupport(this);
	
	public Semaforo() {
		
		this.estadoAtual = EstadoSemaforo.VERMELHO;
		
		this.tempoRestante = estadoAtual.getDuracao();
		
		this.timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				avancarTempo();
				
				
			}
		});
		
	}
	
	public void iniciar() {
		
		timer.start();
		
	}
	
	public void pausar() {
		
		timer.stop();
		
	}
	
	public void addObservador(PropertyChangeListener ouvinte) {
		
		observadores.addPropertyChangeListener(ouvinte);
		
	}
	
	private void avancarTempo() {
		
		int antigoTempo = this.tempoRestante;
		
		tempoRestante--;
		
		observadores.firePropertyChange("tempoRestante", antigoTempo, tempoRestante);
		
		if (tempoRestante <= 0) {
			
			EstadoSemaforo antigo = estadoAtual;
			
//			this.estadoAtual = EstadoSemaforo.values()[
//			    (estadoAtual.ordinal() + 1) % EstadoSemaforo.values().length                                           
//           ];
			this.estadoAtual = estadoAtual.proximo();
			
			this.tempoRestante = estadoAtual.getDuracao();
			
			observadores.firePropertyChange("estadoAtual", antigo, estadoAtual);
			
		}
		
	}
	
	public EstadoSemaforo getEstadoAtual() {
		
		return estadoAtual;
		
	}
	
	public int getTempoRestante() {

		return tempoRestante;
		
	}
		
}
