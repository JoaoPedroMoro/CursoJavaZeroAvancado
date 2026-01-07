package interface_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Aula_13_ExemplosMenuBar {

	public static void main(String[] args) {

		JFrame janela = new JFrame("Exemplo JMenuBar (Melhorador)");
		
		janela.setSize(600, 400);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setLayout(new BorderLayout());
		
		JLabel barraStatus = new JLabel("Pronto");
		
		barraStatus.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
		
		janela.add(barraStatus, BorderLayout.SOUTH);
		
		JMenuBar barraMenu = new JMenuBar();
		
		JMenu menuArquivo = new JMenu("Arquivo");
		
		JMenu menuEditar = new JMenu("Editar");
		
		JMenu menuExibir = new JMenu("Exibir");
		
		JMenu menuAjuda = new JMenu("Ajuda");
		
		menuArquivo.setMnemonic(KeyEvent.VK_A); // Alt + A
		
		menuEditar.setMnemonic(KeyEvent.VK_E); // Alt + E
		
		menuExibir.setMnemonic(KeyEvent.VK_X); // Alt + X
		
		menuAjuda.setMnemonic(KeyEvent.VK_J); // // Alt + J
		
		JMenuItem itemNovo = new JMenuItem("Novo");
		
		JMenuItem itemAbrir = new JMenuItem("Abrir ...");
		
		JMenuItem itemSalvar = new JMenuItem("Salvar");
		
		JMenuItem itemSair = new JMenuItem("Sair");
		
		// Define Ctrl+N como atalho de teclado para acionar o item "Novo".
		itemNovo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
	
		// Define Ctrl+O como atalho de teclado para acionar o item "Abrir...".
		itemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
	
		// Define Ctrl+S como atalho de teclado para acionar o item "Salvar".
		itemSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
	
		// Define Ctrl+Q como atalho de teclado para acionar o item "Sair".
		itemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		
		JMenu menuRecentes = new JMenu("Recentes");
		
		JMenuItem rec1 = new JMenuItem("Projeto1.txt");
		
		JMenuItem rec2 = new JMenuItem("Relatório.pdf");
		
		JMenuItem rec3 = new JMenuItem("Notas.md");
		
		menuRecentes.add(rec1);
		
		menuRecentes.add(rec2);
		
		menuRecentes.add(rec3);
		
		menuArquivo.add(itemNovo);
		
		menuArquivo.add(itemAbrir);
		
		menuArquivo.add(itemSalvar);
		
		menuArquivo.add(menuRecentes);
		
		menuArquivo.addSeparator();
		
		menuArquivo.add(itemSair);
		
		JMenuItem itemRecortar = new JMenuItem("Recortar");
		
		JMenuItem itemCopiar = new JMenuItem("Copiar");
		
		JMenuItem itemColar = new JMenuItem("Colar");
		
		menuEditar.add(itemRecortar);
		
		menuEditar.add(itemCopiar);
		
		menuEditar.add(itemColar);
		
		JCheckBoxMenuItem itemStatus = new JCheckBoxMenuItem("Mostrar barra de status", true);
		
		menuExibir.add(itemStatus);
		
		JMenuItem itemSobre = new JMenuItem("Sobre ...");
		
		menuAjuda.add(itemSobre);
		
		itemNovo.addActionListener(e -> JOptionPane.showMessageDialog(janela,  "Arquivo > Novo"));
		
		itemAbrir.addActionListener(e -> JOptionPane.showMessageDialog(janela, "Arquivo > Abrir ..."));
		
		itemSalvar.addActionListener(e -> JOptionPane.showMessageDialog(janela, "Arquivo > Salvar"));
		
		rec1.addActionListener(e -> JOptionPane.showMessageDialog(janela, "Arquivo > Recentes > Projeto1.txt"));
		
		rec2.addActionListener(e -> JOptionPane.showMessageDialog(janela, "Arquivo > Recentes > Relatorio.pdf"));
		
		rec3.addActionListener(e -> JOptionPane.showMessageDialog(janela, "Arquivo > Recentes > Notas.md"));
		
		itemRecortar.addActionListener(e -> JOptionPane.showMessageDialog(janela, "Editar > Recortar"));
		
		itemCopiar.addActionListener(e -> JOptionPane.showMessageDialog(janela, "Editar > Copiar"));
		
		itemColar.addActionListener(e -> JOptionPane.showMessageDialog(janela, "Editar > Colar"));
		
		itemStatus.addActionListener(e -> {
			
			boolean visivel = itemStatus.isSelected();
			
			barraStatus.setVisible(visivel);
			
			JOptionPane.showMessageDialog(janela, "Exibir > Mostrar barra de status: " + (visivel ? "Ativado" : "Desativado"));
			
		});
		
		itemSobre.addActionListener(e -> {
			
			JOptionPane.showMessageDialog(janela, "Exemplo simples de JMenuBar\nAutor: João Pedro\nVersão: 1.0", "Sobre", JOptionPane.INFORMATION_MESSAGE);
			
		});
		
		itemSair.addActionListener(e -> System.exit(0));
		
		barraMenu.add(menuArquivo);
		
		barraMenu.add(menuEditar);
		
		barraMenu.add(menuExibir);
		
		barraMenu.add(menuAjuda);
		
		janela.setJMenuBar(barraMenu);
		
		janela.add(new JScrollPane(new JTextArea("Área de trabalho...\nUse os menus acima.")), BorderLayout.CENTER);
		
		janela.setVisible(true);

	}

}
