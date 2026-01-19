package quiz;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaResultado extends JDialog {
	
	public TelaResultado(JFrame pai, QuizModelo modelo) {
		
		super(pai, "Resultados do quiz", true);
		
		setSize(900, 650);
		
		setLocationRelativeTo(pai);
		
		setLayout(new BorderLayout(10, 10));
		
		double percentual = modelo.getPontuacao() * 100.0 / modelo.getTotalPerguntas();
		
		String situacao = (percentual >= 70.0) ? "Aprovado" : "Reprovado";
		
		JLabel lblResumo = new JLabel(String.format("<html><b>Pontuação:</b> %d / %d   (%.1f%%) - <b>%s</b></html>",
				modelo.getPontuacao(),
				modelo.getTotalPerguntas(),
				percentual, 
				situacao),
				SwingConstants.CENTER);
		
		lblResumo.setFont(new Font("Arial", Font.BOLD, 22));
		
		add(lblResumo, BorderLayout.NORTH);
		
		String[] colunas = {"Pergunta", "Resposta do Usuário", "Resposta correta", "Acertou?"};
		
		Object[][] dados = montarDadosTabela(modelo);
		
		JTable tabela = new JTable(dados, colunas);
		
		tabela.setRowHeight(32);
		
		tabela.setFont(new Font("Arial", Font.PLAIN, 15));
		
		tabela.setEnabled(false);
		
		tabela.getColumnModel().getColumn(0).setPreferredWidth(340);
		
		add(new JScrollPane(tabela), BorderLayout.CENTER);
		
		JButton btnFechar = new JButton("Fechar");
		
		btnFechar.setFont(new Font("Arial", Font.BOLD, 18));
		
		btnFechar.addActionListener(e -> {
			
			dispose();
			
			pai.dispose();
			
			System.exit(0);
			
		});
		
		JPanel painelSul = new JPanel();
		
		painelSul.add(btnFechar);
		
		add(painelSul, BorderLayout.SOUTH);
		
	}
	
	private Object[][] montarDadosTabela(QuizModelo modelo) {
		
		List<Pergunta> perguntas = modelo.getPerguntas();
		
		String[] respUser = modelo.getRespostasUsuario();
		
		Object[][] dados = new Object[perguntas.size()][4];
		
		for (int i = 0; i < perguntas.size() ; i++) {
			
			Pergunta p = perguntas.get(i);
			
			String respCerta = p.getAlternativas()[p.getIndiceCorreto()];
			
			boolean acertou = respCerta.equals(respUser[i]);
			
			dados[i][0] = p.getEnunciado();
			
			dados[i][1] = respUser[i];
			
			dados[i][2] = respCerta;
			
			dados[i][3] = acertou ? "Sim" : "Não";
			
		}
		
		return dados;
		
	}

}
