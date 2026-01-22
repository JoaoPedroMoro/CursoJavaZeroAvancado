package simulador;

import javax.swing.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.*;

public class RepositorioContas {
	
	private static final String DIR_CONTAS = "contas";
	private static final String EXTENSAO = ".txt";
	private static final NumberFormat NF = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
	
	static {
		
		NF.setMinimumFractionDigits(2);
		
		NF.setMaximumFractionDigits(2);
		
	}
	
	private final List<Conta> listaContas = new ArrayList<>();
	
	public RepositorioContas(JFrame janelaPai) {
		
		prepararDiretorio(janelaPai);
		
		carregarContas(janelaPai);
		
	}
	
	public List<Conta> getListaContas(){
		
		return listaContas;
		
	}
	
	public void salvar(Conta conta, JFrame janelaPai) {
		
		File arquivo = obterArquivoConta(conta.getNome());
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
			
			bw.write("NOME=" + conta.getNome());
			
			bw.newLine();
			
			bw.write("SENHA=" + conta.getSenha());
			
			bw.newLine();
			
			bw.write("SALDO=" + conta.getSaldo());
			
			bw.newLine();
			
			bw.write("HISTORICO_START");
			
			bw.newLine();
			
			for (String linha : conta.getHistorico()) {
				
				bw.write(linha);
				
				bw.newLine();
				
			}
			
			bw.write("HISTORICO_END");
			
			bw.newLine();
			
		} catch (IOException ex) {
			
			ex.printStackTrace();
			
			JOptionPane.showMessageDialog(janelaPai, "Não foi possível salvar a conta \"" + conta.getNome() +
					"\".", "Erro de gravação", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	public Conta buscar(String nome, String senha) {
		
		for (Conta c : listaContas) {
			
			if (c.getNome().equalsIgnoreCase(nome) && c.getSenha().equals(senha)) return c;
			
		}
		
		return null;
		
	}
	
	public boolean existe(String nome) {
		
		for (Conta c : listaContas) {
			
			if (c.getNome().equalsIgnoreCase(nome)) return true;
			
		}
		
		return false;
		
	}
	
	public void adicionarConta(Conta conta) {
		
		listaContas.add(conta);
		
	}
	
	private void prepararDiretorio(JFrame janelaPai) {
		
		File dir = new File(DIR_CONTAS);
		
		if (!dir.exists() && !dir.mkdir()) {
			
			JOptionPane.showMessageDialog(janelaPai, 
					"Falha ao criar a pasta \"" + DIR_CONTAS + "\".\n" +
					"O programa continuará, mas sem salvar dados em disco.",
					"Aviso", JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	
	private void carregarContas(JFrame janelaPai) {
		
		File dir = new File(DIR_CONTAS);
		
		if (!dir.exists()) return;
		
		File[] arquivos = dir.listFiles((d, n) -> n.endsWith(EXTENSAO));
		
		if (arquivos == null) return;
		
		for (File arq : arquivos) {
			
			try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
				
				String linha;
				
				String nome = null, senha = null;
				
				double saldo = 0.0;
				
				List<String> hist = new ArrayList<>();
				
				boolean lendoHist = false;
				
				while ((linha = br.readLine()) != null) {
					
					if (!lendoHist) {
						
						if (linha.startsWith("NOME=")) nome = linha.substring(5); // Ignora os 5 primeiros caracteres NOME=
						else if (linha.startsWith("SENHA=")) senha = linha.substring(6);
						else if (linha.startsWith("SALDO=")) saldo = Double.parseDouble(linha.substring(6));
						else if (linha.equals("HISTORICO_START")) lendoHist = true;
						
					} else {
						
						if (linha.equals("HISTORICO_END")) break;
						
						hist.add(linha);
						
					}
					
				}
				
				if (nome != null && senha != null) {
					
					listaContas.add(new Conta(nome, senha, saldo, hist));
					
				}
				
			} catch (Exception ex) {
				
				ex.printStackTrace();
				
				JOptionPane.showMessageDialog(janelaPai, 
						"Falha ao ler \"" + arq.getName() + "\" - arquivo ignorado",
						"Erro de leitura", JOptionPane.WARNING_MESSAGE);
				
			}
			
		}
		
	}
	
	private File obterArquivoConta(String nomeConta) {
		
		String limpo = nomeConta.replaceAll("[^a-zA-Z0-9_-]", "_");
		
		return new File(DIR_CONTAS + File.separator + limpo + EXTENSAO);
		
	}

}
