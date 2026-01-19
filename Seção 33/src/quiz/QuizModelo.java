package quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizModelo {
	
	private final List<Pergunta> perguntas;
	
	private final String[] respostasUsuario;
	
	private int indiceAtual = 0;
	
	private int pontuacao = 0;
	
	public QuizModelo() {
		
		perguntas = new ArrayList<>();
		
		montarPerguntasPadrao();
		
		respostasUsuario = new String[perguntas.size()];
		
	}
	
	private void montarPerguntasPadrao() {
		
		perguntas.add(new Pergunta(
				"Qual a capital do Brasil?",
				new String[] {"Brasília", "São Paulo", "Rio de Janeiro", "Belo Horizonte"},
				0));
		
		perguntas.add(new Pergunta(
                "Qual destes é um mamífero marinho?",
                new String[]{"Tubarão", "Golfinho", "Pinguim", "Polvo"},
                1));
		
		perguntas.add(new Pergunta(
                "Quanto é 9 + 6?",
                new String[]{"12", "15", "17", "14"},
                1));
		
		perguntas.add(new Pergunta(
                "Quem pintou a Mona Lisa?",
                new String[]{"Michelangelo", "Leonardo da Vinci", "Van Gogh", "Pablo Picasso"},
                1));
		
		perguntas.add(new Pergunta(
                "Qual cor resulta de misturar amarelo e azul?",
                new String[]{"Verde", "Roxo", "Laranja", "Marrom"},
                0));
		
	}
	
	public Pergunta getPerguntaAtual() {
		
		return perguntas.get(indiceAtual);
		
	}
	
	public void responder(int indiceAlternativa) {
		
		Pergunta p = getPerguntaAtual();
		
		respostasUsuario[indiceAtual] = p.getAlternativas()[indiceAlternativa];
		
		if (indiceAlternativa == p.getIndiceCorreto()) {
			
			pontuacao++;
			
		}
		
		indiceAtual++;
		
	}
	
	public boolean temProximaPergunta() {
		
		return indiceAtual < perguntas.size();
		
	}
	
	public int getPontuacao() {
		
		return pontuacao;
		
	}
	
	public int getTotalPerguntas() {
		
		return perguntas.size();
		
	}
	
	public int getIndiceAtual() {
		
		return indiceAtual;
		
	}
	
	public List<Pergunta> getPerguntas() {
		
		return perguntas;
	
	}
	
	public String[] getRespostasUsuario() {
		
		return respostasUsuario;
	}

}
