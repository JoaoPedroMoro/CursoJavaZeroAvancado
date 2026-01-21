package tabuada;

import javax.swing.*;
import java.awt.*;

public class PainelJogo extends JPanel {

	private final JLabel lblQuestao = new JLabel("", SwingConstants.CENTER);
	
	private final JTextField campoResposta = new JTextField(6);
	
	private final JButton btnResponder = new JButton("Responder");
	
	private final JLabel lblPontos = new JLabel("Pontos: 0");
	
	private final JLabel lblAcertos = new JLabel("Acertos: 0");
	
	private final JLabel lblVidas = new JLabel("Vidas: 3");
	
	private final JLabel lblTempo = new JLabel("Tempo: 10");
	
	private final JLabel lblFeedback = new JLabel("", SwingConstants.CENTER);
	
	PainelJogo() {
		
		setLayout(new GridLayout(0, 1, 0, 12));
		
		setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		
		setBackground(Constantes.BRANCO);
		
		lblQuestao.setFont(lblQuestao.getFont().deriveFont(Font.BOLD, 30f));
		
		add(lblQuestao);
		
		JPanel linha = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		
		campoResposta.setFont(campoResposta.getFont().deriveFont(22f));
		
		linha.add(campoResposta);
		
		btnResponder.setBackground(Constantes.LARANJA);
		
		btnResponder.setForeground(Constantes.FUNDO);
		
		linha.add(btnResponder);
		
		add(linha);
		
		Font f = lblPontos.getFont().deriveFont(18f);
		
		for (JLabel l : new JLabel[] {lblPontos, lblAcertos, lblVidas, lblTempo, lblFeedback})
			
			l.setFont(f);
		
		add(lblPontos);
		
		add(lblAcertos);
		
		add(lblVidas);
		
		add(lblTempo);
		
		add(lblFeedback);
		
	}
	
	JTextField getCampoResposta() {
		
		return campoResposta;
		
	}
	
	JButton getBtnResponder() {
		
		return btnResponder;
		
	}
	
	void definirQuestao(String q) {
		
		lblQuestao.setText(q);
		
	}
	
	void atualizarTempo(int t) {
		
		lblTempo.setText("Tempo: " + t);
		
	}
	
	void atualizarPontos(int p) {
		
		lblPontos.setText("Pontos: " + p);
		
	}
	
	void atualizarAcertos(int a) {
		
		lblAcertos.setText("Acertos: " + a);
		
	}
	
	void atualizarVidas(int v) {
		
		lblVidas.setText("Vidas: " + v);
		
	}
	
	void mostrarMensagem(String msg) {
		
		JOptionPane.showMessageDialog(this,  msg, "Info", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	void limparFeedback() {
		
		lblFeedback.setText("");
		
	}
	
	void mostrarFeedbackCorreto() {
		
		lblFeedback.setForeground(Constantes.VERDE);
		
		lblFeedback.setText("Correto!");
		
	}
	
	void mostrarFeedbackIncorreto() {
		
		lblFeedback.setForeground(Constantes.VERMELHOR);
		
		lblFeedback.setText("Incorreto!");
		
	}
	
}
