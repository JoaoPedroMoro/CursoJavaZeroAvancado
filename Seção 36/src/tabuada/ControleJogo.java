package tabuada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//	Importa a classe ArrayDeque, uma estrutura de dados baseada em fila dupla (deque), que
//            	permite adicionar/remover elementos do início ou fim com eficiência.
import java.util.ArrayDeque;
//	Importa a interface Deque, que representa uma fila dupla (Double-Ended Queue), onde é 
//				possível inserir e remover elementos dos dois lados.
import java.util.Deque;
import java.util.Random;

public class ControleJogo {
	
	private final JFrame frame;
	
	private final CardLayout layout;
	
	private final PainelMenu painelMenu;
	
	private final PainelJogo painelJogo;
	
	private final Random rng = new Random();
	
	private static final int VIDAS_INICIAIS = 3;
	
	private static final int TEMPO_QUESTAO = 10;
	
	private static final int PONTOS_ACERTO = 10;
	
	private boolean modoAleatorio;
	
	private int tabuada;
	
	private Deque<int[]> fila;
	
	private int vidas;
	
	private int pontos;
	
	private int acertos;
	
	private int tempo;
	
	private int resposta;
	
	private javax.swing.Timer cronometro;
	
	public ControleJogo(JFrame f, CardLayout cl, PainelMenu pm, PainelJogo pj) {
		
		frame = f;
		
		layout = cl;
		
		painelMenu = pm;
		
		painelJogo = pj;
		
		pm.getBtnAleatorio().addActionListener(e -> iniciarAleatorio());
		
		pm.getBtnIniciarTabuada().addActionListener(e -> {
			
			try {
				
				int n = Integer.parseInt(pm.getCampoNumeroTabuada().getText().trim());
				
				iniciarTabuadaEspecifica(n);
				
			} catch (NumberFormatException ex) {
				
				JOptionPane.showMessageDialog(
						frame,
						"Digite um número entre 1 e 10",
						"Entrada inválida",
						JOptionPane.WARNING_MESSAGE
				);
				
			}
			
		});
		
		pj.getBtnResponder().addActionListener(e -> verificarResposta());
		
		pj.getCampoResposta().addActionListener(e -> verificarResposta());
		
	}
	
	private void iniciarAleatorio() {
		
		modoAleatorio = true;
		
		prepararNovoJogo();
		
		layout.show(frame.getContentPane(), "jogo");
		
		novaPergunta();
		
	}
	
	private void iniciarTabuadaEspecifica(int n) {
		
		if (n < 1 || n > 10) {
			
			JOptionPane.showMessageDialog(frame, "Digite um número entre 1 e 10");
			
			return;
			
		}
		
		modoAleatorio = false;
		
		tabuada = n;
		
		fila = new ArrayDeque<>();
		
		for (int i = 1; i <= 10; i++) {
			
			fila.add(new int[] {n, i});
			
		}
		
		prepararNovoJogo();
		
		layout.show(frame.getContentPane(), "jogo");
		
		novaPergunta();
		
	}
	
	private void prepararNovoJogo() {
		
		vidas = VIDAS_INICIAIS;
		
		pontos = 0;
		
		acertos = 0;
		
		painelJogo.atualizarPontos(pontos);
		
		painelJogo.atualizarAcertos(acertos);
		
		painelJogo.atualizarVidas(vidas);
		
		painelJogo.limparFeedback();
		
		painelJogo.getCampoResposta().setText("");
		
		painelJogo.getCampoResposta().setEnabled(true);
		
		painelJogo.getBtnResponder().setEnabled(true);
		
	}
	
	private void novaPergunta() {
		
		if (!modoAleatorio && fila.isEmpty()) {
			
			fimDeJogo(true);
			
			return;
			
		}
		
		int a, b;
		
		if (modoAleatorio) {
			
			a = rng.nextInt(10) + 1;
			
			b = rng.nextInt(10) + 1;
			
		} else {
			
			int[] p = fila.pollFirst();
			
			a = p[0];
			
			b = p[1];
			
		}
		
		resposta = a * b;
		
		painelJogo.definirQuestao(a + " x " + b + " = ?");
		
		tempo = TEMPO_QUESTAO;
		
		painelJogo.atualizarTempo(tempo);
		
		iniciarCronometro();
		
	}
	
	private void iniciarCronometro() {
		
		if (cronometro != null) {
			
			cronometro.stop();
			
		}
		
		cronometro = new javax.swing.Timer(1000, e -> {
			
			tempo--;
			
			painelJogo.atualizarTempo(tempo);
			
			if (tempo == 0) {
				
				cronometro.stop();
				
				perdeuVida();
				
			}
			
		});
		
		cronometro.start();
		
	}
	
	private void verificarResposta() {
		
		String t = painelJogo.getCampoResposta().getText().trim();
		
		if (t.isEmpty()) return;
		
		int val;
		
		try {
			
			val = Integer.parseInt(t);
			
		} catch (NumberFormatException ex) {
			
			painelJogo.mostrarMensagem("Digite apenas números");
			
			return;
			
		}
			
		painelJogo.getCampoResposta().setText("");
		
		cronometro.stop();
		
		if (val == resposta) {
			
			pontos += PONTOS_ACERTO;
			
			acertos++;
			
			painelJogo.atualizarPontos(pontos);
			
			painelJogo.atualizarAcertos(acertos);
			
			painelJogo.mostrarFeedbackCorreto();
			
			novaPergunta();
			
		} else {
			
			painelJogo.mostrarFeedbackIncorreto();
			
			perdeuVida();
			
		}	
		
	}
	
	private void perdeuVida() {
		
		vidas--;
		
		painelJogo.atualizarVidas(vidas);
		
		if (vidas == 0 ) {
			
			fimDeJogo(false);
			
		} else {
			
			novaPergunta();
			
		}
	}
	
	private void fimDeJogo(boolean concluido) {
		
		if (cronometro != null) {
			
			cronometro.stop();
			
		}
		
		painelJogo.getCampoResposta().setEnabled(false);
		
		painelJogo.getBtnResponder().setEnabled(false);
		
		String msg = concluido ? 
				"Parabéns! Você concluiu esta tabuada.\nPontos: " + pontos + "\nAcertos: " + acertos
				: "Fim de jogo.\nPontos: " + pontos + "\nAcertos: " + acertos;
		
		painelJogo.mostrarMensagem(msg);
		
		layout.show(frame.getContentPane(), "menu");
		
	}

}
