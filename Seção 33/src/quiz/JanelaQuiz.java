package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JanelaQuiz extends JFrame {
	
	private final QuizModelo modelo = new QuizModelo();
	
	private final JLabel lblInfo = new JLabel("", SwingConstants.CENTER);
	
	private final PainelPergunta painelPergunta;
	
	public JanelaQuiz() {
		
		super("Quiz de perguntas e respostas");
		
		setExtendedState(MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout(10, 10));
		
		lblInfo.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(lblInfo, BorderLayout.NORTH);
		
		painelPergunta = new PainelPergunta(this::tratarCliqueAlternativa);
		
		add(painelPergunta, BorderLayout.CENTER);
		
		atualizarTela();
		
		setVisible(true);
		
	}
	
	private void tratarCliqueAlternativa(ActionEvent evt) {
		
		for (int i = 0; i < 4; i++) {
			
			if (evt.getSource() == painelPergunta.getBotaoAlternativa(i)) {
				
				modelo.responder(i);
				
				break;
				
			}
			
		}
		
		if (modelo.temProximaPergunta()) {
			
			atualizarTela();
			
			 
		} else {
			
			new TelaResultado(this, modelo).setVisible(true);
			
			
		}
	}
	
	private void atualizarTela() {
		
		painelPergunta.mostrarPergunta(modelo.getPerguntaAtual());
		
		lblInfo.setText(String.format("Pontuação: %d   |   Pergunta %d / %d",
				modelo.getPontuacao(), 
				modelo.getIndiceAtual() + 1, 
				modelo.getTotalPerguntas()));
		
	}

}
