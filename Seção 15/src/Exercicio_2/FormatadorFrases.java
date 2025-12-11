package Exercicio_2;

// Importando a classe nativa Normalizer da biblioteca padrão do Java, ela pode ser útil para remover acentos de letras
import java.text.Normalizer;

public class FormatadorFrases {
	
	private String frase;
	
	public FormatadorFrases (String frase) {
		
		this.frase = frase;
		
	}
	
	public void upperCase() {
		
		this.frase = this.frase.toUpperCase();
		
	}
	
	public void lowerCase() {
		
		this.frase = this.frase.toLowerCase();
		
	}
	
	// Esse método deixa apenas a primeira letra da frase em maiúscula e todo o resto e minúscula.
	public void capitalizar() {
		
		if (frase == null || frase.isEmpty()) return;
		
		String f = frase.trim(); // trim() remove espaços no início e no fim da string
		
		if (f.isEmpty()) {
			
			this.frase = f;
			
			return;
			
		}
		
		// substring(0, 1) vai receber todos os caracteres a partir da posição 0 até a posição 1.
		String primeiraLetra = f.substring(0, 1).toUpperCase();
		
		// substring(1) vai receber todos os caracteres a partir da posição 1.
		String restanteFrase = f.substring(1).toLowerCase();
		
		this.frase = primeiraLetra + restanteFrase;
		
	}
	
	// Esse método deixa todas as primeiras letras de cada palavra em maiuscula, como se fosse um formato de um título
	public void formatoTitulo() {
		
		if (frase == null || frase.isEmpty()) return;
		
		// Cria um vetor de Strings chamado "palavras"
	    // Primeiro aplica trim() para remover espaços extras do começo e do fim
	    // Depois transforma toda a frase em minúsculas com toLowerCase()
	    // Por fim, divide a frase em partes (palavras) usando split("\\s+"), que separa por 1 ou mais espaços
		String[] palavras = frase.trim().toLowerCase().split("\\s+");
		
		// StringBuilder é usado para montar textos de forma eficiente dentro de laços.
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < palavras.length ;i++) {
			
			String p = palavras[i];
			
			// As vezes o split pode gerar palavras vazias
			if (p.length() > 0) {
				
				String primeira = p.substring(0, 1).toUpperCase();
				
				String resto = p.substring(1);
				
				sb.append(primeira).append(resto);
				
			}
			
			// Separando as palavras por espaços
			if (i < palavras.length - 1) sb.append(" ");
		}
		
		this.frase = sb.toString();
		
	}
	
	public int contarVogais() {
		
		if (frase == null || frase.isEmpty()) return 0;
		
		// Criando a constante de todas as vogais que consideramos na lingua portuguesa
		final String VOGAIS = "aeiouàèèòùáéíóúãõâêîôû";
		
		int contagem = 0;
		
		String f = frase.toLowerCase();
		
		for (int i = 0; i < f.length() ;i++) {
			
			char c = f.charAt(i);
			
			if(VOGAIS.indexOf(c) >= 0) {
				
				contagem++;
				
			}
			
		}
		
		return contagem;
	}
	
	public int contarConsoantes() {
		
		if (frase == null || frase.isEmpty()) return 0;
		
		// Criando a constante de todas as consoantes que consideramos na lingua portuguesa
		final String CONSOANTES = "bcdfghjklmnpqrstuvwxzç";
		
		int contagem = 0;
		
		String f = frase.toLowerCase();
		
		for (int i = 0; i < f.length() ;i++) {
			
			char c = f.charAt(i);
			
			if(CONSOANTES.indexOf(c) >= 0) {
				
				contagem++;
				
			}
			
		}
		
		return contagem;
		
	}
	
	public int contarLetraA() {
		
		if (frase == null || frase.isEmpty()) return 0;
		
		String f = frase.toLowerCase();
		
		int total = 0;
		
		// Encontra a posição do primeiro 'a' na frase, se não achar nada retorna -1
		int idx = f.indexOf('a');
		
		while (idx != -1) {
			
			total++;
			
			// Busca a próxima ocorrência da letra 'a' a partir da última encontrada
			idx = f.indexOf('a', idx + 1);
			
		}
		
		return total;
		
	}
	
	public int procurarPalavra(String palavra) {
		
		if (frase == null || frase.isEmpty()) return 0;
		
		String f = frase.toLowerCase();
		
		String p = palavra.toLowerCase();
		
		if (p.isEmpty()) return 0;
		
		int total = 0;
		
		// Essa variável vai guardar a osição inicial de onde começou a procurar dentro da frase.
		int from = 0;
		
		int posicao;
		
		// Inicia um laço while que a cada repetição vai procurar a palavra 'p' dentro da frase 'f' a partir da posição from.
		// Se não encontrar nada, vai retornar -1 e encerrar o laço
		while ((posicao = f.indexOf(p, from)) != -1) {
			
			total++;
			
			// Atualiza a variavel from e começa a busca a partir da proxima palavra
			from = posicao + p.length();
			
		}
		
		return total;
		
	}
	
	public String obterFrase() {
		
		return this.frase;
		
	}
	
	public static String removerAcentos(String texto) {  

	    if (texto == null) return null;

	    // Cria uma variável chamada "norm". O método Normalizer.normalize transforma os caracteres do texto em sua forma base
	    // Exemplo: "á" vira "a" + um acento separado. O parâmetro Normalizer.Form.NFD significa "Canonical Decomposition", ou seja,
	    // 	separa o caractere base dos acentos
	    String norm = Normalizer.normalize(texto, Normalizer.Form.NFD);

	    // Retorna o texto normalizado removendo os caracteres de acentuação
	    // O método replaceAll usa uma expressão regular para  
		//			remover todos os sinais
	    // "\p{InCombiningDiacriticalMarks}+" corresponde a todos os  
		//			diacríticos (acentos)
	    // Resultado final: texto sem acentos
	    return norm.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	    
	} 
	

}
