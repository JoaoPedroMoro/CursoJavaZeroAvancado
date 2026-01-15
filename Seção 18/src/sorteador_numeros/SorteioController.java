package sorteador_numeros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class SorteioController implements ActionListener {
	
	private final SorteadorDeNumerosJanela ui;
	
	private Timer temporizador;
	
	private int contador;
	
	public SorteioController(SorteadorDeNumerosJanela ui) {
		
		this.ui = ui;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		iniciarProcedimentoDeSorteio();
		
	}
	
	private void iniciarProcedimentoDeSorteio() {
		
		ui.exibirContagem("");
		
		ui.exibirResultado("");
		
		final int minimo;
		
		final int maximo;
		
		try {
			
			minimo = Integer.parseInt(ui.getTextoMinimo().trim());
			
			maximo = Integer.parseInt(ui.getTextoMaximo().trim());
			
		} catch (NumberFormatException ex) {
			
			JOptionPane.showMessageDialog(null, "Digite valores numéricos inteiros!", "Erro de entrada", JOptionPane.ERROR_MESSAGE);
			
			return;
			
		}
		
		if (minimo > maximo) {
			
			JOptionPane.showMessageDialog(null, "O valor mínimo é não pode ser maior que o valor máximo!", "Intervalo inválido", JOptionPane.WARNING_MESSAGE);
			
			return;
			
		}
		
		ui.habilitarBotao(false);
		
		contador = 5;
		
		ui.exibirContagem("Começando em: " + contador);
		
		// Vai rodar a cada 1000 milissegundos (1 segundo)
		temporizador = new Timer(1_000, evento -> {
			
			contador --;
			
			if (contador > 0) {
				
				ui.exibirContagem("Revelando em: " + contador);
				
			} else {
				
				temporizador.stop();
				
				int resultado = UtilNumeroAleatorio.sortear(minimo, maximo);
				
				ui.exibirContagem("Fim da contagem!");
				
				ui.exibirResultado("Número sorteado: " + resultado);
				
				ui.habilitarBotao(true);
				
			}
		});
		
		temporizador.start();
	}

}
