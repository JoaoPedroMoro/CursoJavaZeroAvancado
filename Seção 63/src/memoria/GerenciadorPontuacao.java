package memoria;

import java.io.*;

public class GerenciadorPontuacao {

	private static final String ARQ_PONTOS = "pontos_memoria.txt";
	
	private int pontuacaoTotal;
	
	public GerenciadorPontuacao() {
		
		carregarPontuacao();
		
	}
	
	public int getPontuacaoTotal() {return pontuacaoTotal;}
	
	public void adicionarPontos(int pontos) {
		
		pontuacaoTotal += pontos;
		
		salvarPontuacao();
		
	}
	
	private void carregarPontuacao() {
		
		File f = new File(ARQ_PONTOS);
		
		if (!f.exists()) {
			
			pontuacaoTotal = 0;
			
			return;
			
		}
		
		try (
        		
				FileReader fr = new FileReader(f);
	        		
				BufferedReader br = new BufferedReader(fr)
	            		
	        ) {
			
			String linha = br.readLine().trim();
			
			pontuacaoTotal = Integer.parseInt(linha);
			
		} catch (Exception e) {
			
			pontuacaoTotal = 0;
			
		}
		
	}
	
	private void salvarPontuacao() {
		
		try (
			
			FileWriter fw = new FileWriter(ARQ_PONTOS);
			BufferedWriter bw = new BufferedWriter(fw)
			
		){
			
			bw.write(String.valueOf(pontuacaoTotal));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
