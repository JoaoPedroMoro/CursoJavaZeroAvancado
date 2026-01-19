package calculadora_modena_svc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculadoraVision extends JFrame{
	
	private final JTextField campoVisor;
	
	private final JPanel painelBotoes;
	
	public CalculadoraVision() {
		
		super("Calculadora Moderna");
		
		setSize(400, 500);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		setResizable(false);
		
		campoVisor = new JTextField("0");
		
		campoVisor.setHorizontalAlignment(SwingConstants.RIGHT);
	
		campoVisor.setFont(new Font("Arial", Font.BOLD, 30));
		
		campoVisor.setEditable(false);
		
		campoVisor.setBackground(Color.WHITE);
		
		painelBotoes = new JPanel(new GridLayout(5, 4, 5, 5));
		
		painelBotoes.setBackground(Color.LIGHT_GRAY);
		
		// Definição dos botões da calculadora
		String[] rotulos = {
		        "CE", "C", "⌫", "÷", 
		        "7",  "8", "9", "×",     
		        "4",  "5", "6", "−",    
		        "1",  "2", "3", "+",    
		        "0",  ",", "=", ""      
		};
		
		for (String txt : rotulos) {
			
			JButton b = new JButton(txt);
			
			b.setFont(new Font("Arial", Font.BOLD, 20));
			
			if (txt.equals("")) {
				
				b.setEnabled(false);
				
			}
			
			painelBotoes.add(b);
			
		}
		
		setLayout(new BorderLayout(5, 5));
		
		add(campoVisor, BorderLayout.NORTH);
		
		add(painelBotoes, BorderLayout.CENTER);
		
	}
	
	public void registrarController(ActionListener listener) {

		for (Component c : painelBotoes.getComponents()) {

			if (c instanceof JButton botao) {
				
				botao.addActionListener(listener);
				
			}
			
			
		}
		
	}
	
	public void atualizarVisor(String texto) {
		
		campoVisor.setText(texto);
		
	}
	
	public String lerVisor() {
		
		return campoVisor.getText();
		
	}

}
