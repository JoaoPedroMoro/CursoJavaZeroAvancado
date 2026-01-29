package memoria;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JogoMemoria extends JFrame {

	private static final int LINHAS = 4;
	private static final int COLUNAS = 5;
	private static final int TOTAL_PARES = (LINHAS * COLUNAS) / 2;
	public static final String CAMINHO_IMAGENS =
	"C:\\Users\\jpgar\\eclipse-workspace\\JogoMemoria\\src\\memoria\\";
	private JPanel painelCartas;
	private JLabel labelPontos;
	private JButton btnReiniciar;
	private Carta primeiraCarta;
	private Carta segundaCarta;
	private int tentativas;
	private int paresEncontrados;
	private List<Carta> cartas;
	private Timer timerAutoFechar;
	private GerenciadorPontuacao gerPontuacao;
	
	public JogoMemoria() {
		
		super("Jogo da Memória - 10 Imagens");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		gerPontuacao = new GerenciadorPontuacao();
		
		inicializarInterface();
		
		iniciarJogo();
		
		setVisible(true);
		
	}
	
	private void inicializarInterface() {
		
		labelPontos = new JLabel("Pontos: " + gerPontuacao.getPontuacaoTotal());
		
		labelPontos.setFont(new Font("Arial", Font.BOLD, 20));
		
		btnReiniciar = new JButton("Reiniciar Jogo");
		
		btnReiniciar.setFont(new Font("Arial", Font.PLAIN, 18));
		
		btnReiniciar.addActionListener(e -> iniciarJogo());
		
		JPanel painelTopo = new JPanel(new BorderLayout(10, 10));
		
		painelTopo.add(labelPontos, BorderLayout.WEST);
		
		painelTopo.add(btnReiniciar, BorderLayout.EAST);
		
		add(painelTopo, BorderLayout.NORTH);
		
		painelCartas = new JPanel(new GridLayout(LINHAS, COLUNAS, 5, 5));
		
		add(painelCartas, BorderLayout.CENTER);
		
	}
	
	private void iniciarJogo() {
		
		painelCartas.removeAll();
		
		tentativas = 0;
		
		paresEncontrados = 0;
		
		primeiraCarta = null;
		segundaCarta = null;
		
		List<Integer> ids = new ArrayList<>();
		
		for (int i = 1; i <= TOTAL_PARES; i++) {
			
			ids.add(i);
			
			ids.add(i);
			
		}
		
		Collections.shuffle(ids);
		
		cartas = new ArrayList<>();
		
		for (int id : ids) {
			
			Carta c = new Carta(id);
			
			c.getBotao().addActionListener(ev -> clicarCarta(c));
			
			cartas.add(c);
			
			painelCartas.add(c.getBotao());
			
		}
		
		painelCartas.revalidate();
		
		painelCartas.repaint();
		
		SwingUtilities.invokeLater(() -> {
			
			cartas.forEach(Carta::virarParaCima);
			
			new Timer(10_000, e -> {
				
				((Timer)e.getSource()).stop();
				
				cartas.stream()
					  .filter(c -> !c.foiRemovida())
					  .forEach(Carta::virarParaBaixo);		
			}).start();
			
		});
		
	}
	
	private void clicarCarta(Carta carta) {
		
		if (primeiraCarta != null && segundaCarta != null) {return;}
		
		if (!carta.estaViradaParaBaixo() || carta.foiRemovida()) {return;}
		
		carta.virarParaCima();
		
		if(primeiraCarta == null) {
			
			primeiraCarta = carta;
			
			if (timerAutoFechar != null && timerAutoFechar.isRunning()) {timerAutoFechar.stop();}
			
			timerAutoFechar = new Timer(5_000, e -> {
				
				if (segundaCarta == null && primeiraCarta != null) {
					
					primeiraCarta.virarParaBaixo();
					
					primeiraCarta = null;
					
				}
				
				((Timer)e.getSource()).stop();
			});
			
			timerAutoFechar.setRepeats(false);
			
			timerAutoFechar.start();
			
		} else {
			
			if (timerAutoFechar != null && timerAutoFechar.isRunning()) {timerAutoFechar.stop();}
			
			segundaCarta = carta;
			
			tentativas++;
			
			new Timer(700, e -> {
				
				((Timer)e.getSource()).stop();
				
				verificarPar();
			}).start();;
			
		}
		
	}
	
	private void verificarPar() {
		
		if (primeiraCarta.getId() == segundaCarta.getId()) {
			
			
			primeiraCarta.remover();
			
			segundaCarta.remover();
			
			paresEncontrados++;
			
			if (paresEncontrados == TOTAL_PARES) {encerrarJogo();}
			
		} else {
			
			primeiraCarta.virarParaBaixo();
			
			segundaCarta.virarParaBaixo();
			
		}
		
		primeiraCarta = null;
		segundaCarta = null;
		
	}
	
	private void encerrarJogo() {
		
		final int PONTOS_POR_VITORIA = 10;
		
		gerPontuacao.adicionarPontos(PONTOS_POR_VITORIA);
		
		String mensagem = 
				"Parabéns! Você concluiu em " + tentativas + " tentativas.\n" +
				"Pontuação desta partida: " + PONTOS_POR_VITORIA + "\n" +
				"Pontuação total: " + gerPontuacao.getPontuacaoTotal();
		
		JOptionPane.showMessageDialog(this, 
				mensagem,
				"Jogo da Memória Concluído",
				JOptionPane.INFORMATION_MESSAGE);
		
		labelPontos.setText("Pontos: " + gerPontuacao.getPontuacaoTotal());
		
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(JogoMemoria::new);
	}
	
}
