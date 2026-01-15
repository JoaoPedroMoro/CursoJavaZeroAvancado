package interface_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Aula_19_ProjetoMensagensSwing {
	
	public static void main(String[] args) {
		
		try {
			
			for (UIManager.LookAndFeelInfo i : UIManager.getInstalledLookAndFeels()) {
				
				if ("Nimbus".equals(i.getName())) {
					
					UIManager.setLookAndFeel(i.getClassName());
					
					break;
					
				}
			}
		} catch (Exception ignored) {}
		
	    // "SwingUtilities.invokeLater" agenda a execução do método "criarTela" na 
    	//			*Event Dispatch Thread* (EDT).
	    // A EDT é a thread responsável por manipular a interface gráfica no Swing.
	    // Isso garante que toda a criação da GUI ocorra no fluxo correto, 
    	//			evitando bugs de concorrência.
	    // O uso da notação "::" chama diretamente o método estático 
    	//			criarTela (referência de método).
		SwingUtilities.invokeLater(Aula_19_ProjetoMensagensSwing::criarTela);
		
	}
	
	private static void criarTela() {
		
		JFrame janela = new JFrame("JOptionPane - Catálogo de Mensagens");
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setSize(750, 600);
		
		janela.setLayout(new BorderLayout(10, 10));
		
		JLabel titulo = new JLabel("Clique em um botãp para ver o tipo de mensagem correspondente");
		
		titulo.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));
		
		janela.add(titulo, BorderLayout.NORTH);
		
		JPanel botoes = new JPanel(new GridLayout(0, 2, 10, 10));
		
		botoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		botoes.add(criarBotao("Informação", e -> JOptionPane.showMessageDialog(janela, "Operação concluída com sucesso!", 
				"Mensagem de informação", JOptionPane.INFORMATION_MESSAGE)));
		
		botoes.add(criarBotao("Aviso", e -> JOptionPane.showMessageDialog(janela, "Atenção: verifique os dados informados.", 
				"Mensagem de aviso", JOptionPane.WARNING_MESSAGE)));
	
		botoes.add(criarBotao("Erro", e -> JOptionPane.showMessageDialog(janela, "Ocorreu um erro ao salvar o arquivo.", 
				"Mensagem de erri", JOptionPane.ERROR_MESSAGE)));
		
		botoes.add(criarBotao("Pergunta", e -> JOptionPane.showMessageDialog(janela, "Você tem certeza disso?", 
				"Mensagem de pergunta", JOptionPane.QUESTION_MESSAGE)));
		
		botoes.add(criarBotao("Simples (Plain)", e -> JOptionPane.showMessageDialog(janela, "Mensagem simples, sem ícone.", 
				"Mensagem simples", JOptionPane.PLAIN_MESSAGE)));
		
		botoes.add(criarBotao("Confirmar (Sim/Não)", e -> {
			
			int op = JOptionPane.showConfirmDialog(janela, "Deseja realmente continuar?", 
					"Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			JOptionPane.showMessageDialog(janela, "Você escolheu: " + decodeYesNo(op));
			
		}));
		
		botoes.add(criarBotao("Confirmar (Sim/Não/Cancelar)", e -> {
			
			int op = JOptionPane.showConfirmDialog(janela, "Salvar as alterações antes de sair?", 
					"Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			JOptionPane.showMessageDialog(janela, "Você escolheu: " + decodeYesNoCancel(op));
			
		}));
		
		botoes.add(criarBotao("Entrada de texto", e -> {
			
			String nome = JOptionPane.showInputDialog(janela, "Qual é seu nome?", "Entrada de texto", JOptionPane.QUESTION_MESSAGE);
			
			if (nome != null) {
				
				JOptionPane.showMessageDialog(janela, "Olá, " + nome + "!");
			}
			
		}));
		
		botoes.add(criarBotao("Entrada com opções (Combo", e -> {
			
			String[] linguagens = {"Java", "JavaScript", "Python", "C#", "Go"};
			
			String escolha = (String) JOptionPane.showInputDialog(janela, "Escolha sua linguagem favorita", 
					"Entrada com opções", JOptionPane.QUESTION_MESSAGE, null, linguagens, linguagens[0]);
			
			if (escolha != null) {
				
				JOptionPane.showMessageDialog(janela, "Você escolheu: " + escolha);
			}
			
		}));
		
		botoes.add(criarBotao("Opções personalizadas", e -> {
			
			Object[] opcoes = {"Salvar", "Não Salvar", "Cancelar"};
			
			int op = JOptionPane.showOptionDialog(janela, "O documento foi alterado. O que deseja fazer?", "Opções"
					, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);
			
			JOptionPane.showMessageDialog(janela, "Você escolheu: " + decodeCustomOption(op, opcoes));
			
		}));
		
		botoes.add(criarBotao("Mensagem com HTML", e -> {
			
			String html = """
					<html>
					  <h3 style='margin:0'>Atualização disponível</h3>
					  <p>Uma nova versão está pronta para download.</p>
					  <ul>
					    <li>Correções de bugs</li>
					    <li>Melhorias de performance</li>
					  </ul>
					</html>
					""";
			
			JOptionPane.showMessageDialog(janela, html, "HTML", JOptionPane.INFORMATION_MESSAGE);
			
		}));
		
		botoes.add(criarBotao("Componente customizado", e -> {
			
			JPanel painel = new JPanel(new GridLayout(0, 2, 6, 6));
			
			JTextField usuario = new JTextField();
			
			JPasswordField senha = new JPasswordField();
			
			painel.add(new JLabel("Usuário:"));
			
			painel.add(usuario);
			
			painel.add(new JLabel("Senha:"));
			
			painel.add(senha);
			
			int op = JOptionPane.showConfirmDialog(janela, painel, "Login (Exemplo de componente", 
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			
			if (op == JOptionPane.OK_OPTION) {
				
				JOptionPane.showMessageDialog(janela, 
						"Usuário: " + usuario.getText() + "\nSenha: " + new String(senha.getPassword()));
				
			}
			
		}));
		
		botoes.add(criarBotao("Ícone customizado", e -> {
			
			Icon icone = iconeQuadrado(new Color(0x3F, 0x8E, 0xFC), 48); // Azul
			
			JOptionPane.showMessageDialog(janela, "Esta é uma mensagem com um ícone customizado (sem arquivo externo).", 
					"Ícone customizado", JOptionPane.INFORMATION_MESSAGE, icone);
			
		}));
		
		janela.add(new JScrollPane(botoes), BorderLayout.CENTER);
		
		JLabel status = new JLabel("Pronto");
		
		status.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
		
		janela.add(status, BorderLayout.SOUTH);
		
		janela.setVisible(true);
		
	}
	
	private static JButton criarBotao(String texto, java.awt.event.ActionListener acao) {
		
		JButton b = new JButton(texto);
		
		b.addActionListener(acao);
		
		return b;
		
	}
	
	private static String decodeYesNo(int op) {
		
		return switch(op) {
		
			case JOptionPane.YES_OPTION -> "Sim";
			
			case JOptionPane.NO_OPTION -> "Não";
			
			default -> "Fechou a janela";
		
		};
		
	}
	
	private static String decodeYesNoCancel(int op) {
		
		return switch(op) {
		
			case JOptionPane.YES_OPTION -> "Sim";
			
			case JOptionPane.NO_OPTION -> "Não";
			
			case JOptionPane.CANCEL_OPTION -> "Cancelar";
			
			default -> "Fechou a janela";
		};
	}
	
	private static String decodeCustomOption(int op, Object[] opcoes) {
		
		if (op >= 0 && op < opcoes.length) {
			
			return String.valueOf(opcoes[op]);
			
		}
		
		return "Fechou a janela";
	}
	
	private static Icon iconeQuadrado(Color cor, int tamanho) {
		
		BufferedImage img = new BufferedImage(tamanho, tamanho, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g = img.createGraphics();
		
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setColor(cor);
		
		g.fillRoundRect(2,  2,  tamanho - 4, tamanho - 4, 12, 12);
		
		g.setColor(cor.darker());
		
		g.drawRoundRect(2, 2, tamanho - 4, tamanho - 4, 12, 12);
		
		g.dispose();
		
		return new ImageIcon(img);
	}

}
