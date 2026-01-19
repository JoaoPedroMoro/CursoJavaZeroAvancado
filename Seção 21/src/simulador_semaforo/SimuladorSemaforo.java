package simulador_semaforo;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class SimuladorSemaforo extends JFrame{

	private final Semaforo semaforo;
	
	private final PainelSemaforo painel;
	
	public SimuladorSemaforo() {
		
		super("Simulador de semáforo");
		
		this.semaforo = new Semaforo();
		
		this.painel = new PainelSemaforo(semaforo);
		
		setSize(300, 500);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		setResizable(false);
		
		setLayout(new BorderLayout());
		
		add(painel, BorderLayout.CENTER);
		
		semaforo.iniciar();
		
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			
			new SimuladorSemaforo().setVisible(true);
			
		});
		
	}

}
