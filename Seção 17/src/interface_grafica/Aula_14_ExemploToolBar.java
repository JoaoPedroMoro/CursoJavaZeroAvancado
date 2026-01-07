package interface_grafica;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;       

public class Aula_14_ExemploToolBar {

	public static void main(String[] args) {
		
        // ==================================================================================================
        // Agenda a criação da interface (criarTela) para ser executada na 
    	//			Event Dispatch Thread (EDT), que é a thread responsável 
    	//			por todas as operações de UI no Swing.
    	// Usar invokeLater garante segurança de thread e evita condições 
    	//			de corrida ao manipular componentes gráficos.
        // A referência de método Aula14_ExemploToolBar::criarTela é um 
    	//			atalho elegante para um Runnable.
        // ==================================================================================================
        SwingUtilities.invokeLater(Aula_14_ExemploToolBar::criarTela);

	}
	
	private static void criarTela() {
		
		JFrame janela = new JFrame("Exemplo JToolBar (Melhorado)");
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setSize(700, 450);
		
		janela.setLocationRelativeTo(null);
		
		janela.setLayout(new BorderLayout());
		
		JTextArea area = new JTextArea();
		
		area.setLineWrap(true);
		
		area.setWrapStyleWord(true);
		
		area.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JScrollPane rolagem = new JScrollPane(area);
		
		janela.add(rolagem, BorderLayout.CENTER);
		
		JLabel status = new JLabel("Pronto");
		
		status.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
		
		janela.add(status, BorderLayout.SOUTH);
		
		Action acNovo = new AbstractAction("➕ Novo") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				area.setText("");
				
				status.setText("Novo documento criado.");
				
				area.requestFocusInWindow();
				
			}
		};
		
		acNovo.putValue(Action.SHORT_DESCRIPTION, "Novo (Ctrl+N)");
		
		Action acSalvar = new AbstractAction("💾 Salvar") {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String conteudo = area.getText();
				JOptionPane.showMessageDialog(janela, "Conteúdo salvo! (" + conteudo.length() + " caracteres)", "Salvar", JOptionPane.INFORMATION_MESSAGE);
				
				status.setText("Documento salvo");
				
			}
			
		};
		
		acSalvar.putValue(Action.SHORT_DESCRIPTION, "Salvar (Ctrl+S)");
		
		acSalvar.setEnabled(false);
		
		Action acPesquisar = new AbstractAction("🔍 Pesquisar") {

		    @Override
		    public void actionPerformed(ActionEvent e) {

		        String termo = JOptionPane.showInputDialog(janela, "O que deseja buscar?");
		        
		        if (termo == null || termo.isEmpty()) return;

		        String txt = area.getText();

		        int idx = txt.toLowerCase().indexOf(termo.toLowerCase());

		        if (idx >= 0) {

		            area.requestFocusInWindow();

		            area.select(idx, idx + termo.length());

		            status.setText("Encontrado: \"" + termo + "\"");

		        } else {

		            JOptionPane.showMessageDialog(janela, "Termo não encontrado.");

		            status.setText("Nada encontrado para \"" + termo + "\"");
		            
		        }
		    }
		};

		acPesquisar.putValue(Action.SHORT_DESCRIPTION, "Pesquisar (Ctrl+F)");

		Action acImprimir = new AbstractAction("🖨️ Imprimir") {

		    @Override
		    public void actionPerformed(ActionEvent e) {

		        int linhas = area.getLineCount();

		        JOptionPane.showMessageDialog(
		                janela,
		                "Simulação de impressão: " + linhas + " linha(s).",
		                "Imprimir",
		                JOptionPane.INFORMATION_MESSAGE
		        );

		        status.setText("Impressão simulada.");
		        
		    }
		};

		acImprimir.putValue(Action.SHORT_DESCRIPTION, "Imprimir (Ctrl+P)");
		
		Action acSair = new AbstractAction("⏻ Sair") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		};
		
		acSair.putValue(Action.SHORT_DESCRIPTION, "Sair (Ctrl+Q)");
		
		JToolBar barra = new JToolBar("Ferramentas");
		
		barra.setFloatable(true);
		
		barra.setRollover(true);
		
		barra.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		
		JButton btNovo = barra.add(acNovo);
		
		JButton btSalvar = barra.add(acSalvar);
		
		JButton btPesquisar = barra.add(acPesquisar);
		
		JButton btImprimir = barra.add(acImprimir);
		
		barra.addSeparator();
		
		JToggleButton tgWrap = new JToggleButton("↩ Quebra");
		
		tgWrap.setToolTipText("Alternar quebra de linha");
		
		tgWrap.setSelected(true);
		
		tgWrap.addActionListener(e -> {
			
			boolean w = tgWrap.isSelected();
			
			area.setLineWrap(w);
			
			area.setWrapStyleWord(w);
			
			status.setText("Quebra de linha: " + (w ? "Ativada" : "Desativada"));
			
		});
		
		barra.add(tgWrap);
		
		JToggleButton tgNegrito = new JToggleButton("𝐁 Negrito");
		
		tgNegrito.setToolTipText("Alternar negrito");
		
		tgNegrito.addActionListener(e -> {

		    Font f = area.getFont();

		    int estilo = tgNegrito.isSelected() ? Font.BOLD : Font.PLAIN;

		    area.setFont(f.deriveFont(estilo, f.getSize2D()));

		    status.setText("Negrito: " + (tgNegrito.isSelected() ? "Ativado" : "Desativado"));
		    
		});
		
		barra.add(tgNegrito);
		
		barra.add(new JLabel("  Tamanho: "));
		
		JSpinner spTam = new JSpinner(new SpinnerNumberModel(14, 8, 64, 1));
		
		spTam.setToolTipText("Tamanho da fonte");
		
		spTam.addChangeListener(e -> {

		    Font f = area.getFont();

		    int tamanho = (Integer) spTam.getValue();

		    area.setFont(f.deriveFont((float) tamanho));

		    status.setText("Tamanho da fonte: " + tamanho);
		    
		});
		
		barra.add(spTam);
		
		barra.addSeparator();
		
		JButton btSair = barra.add(acSair);
		
		btNovo.setToolTipText("Criar novo (Ctrl+N)");
		
		btSalvar.setToolTipText("Salvar (Ctrl+S)");
		
		btPesquisar.setToolTipText("Pesquisar (Ctrl+F)");
		
		btImprimir.setToolTipText("Imprimir (Ctrl+P)");
		
		btSair.setToolTipText("Sair (Ctrl+Q)");
		
		janela.add(barra, BorderLayout.NORTH);

		JRootPane root = janela.getRootPane();

		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
		    .put(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "novo");

		root.getActionMap().put("novo", acNovo);

		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
		    .put(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "salvar");

		root.getActionMap().put("salvar", acSalvar);

		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
		    .put(KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "pesquisar");

		root.getActionMap().put("pesquisar", acPesquisar);

		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
		    .put(KeyStroke.getKeyStroke(KeyEvent.VK_P, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "imprimir");

		root.getActionMap().put("imprimir", acImprimir);

		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
		    .put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "sair");

		root.getActionMap().put("sair", acSair);

		area.getDocument().addDocumentListener(new DocumentListener() {

		    private void atualizar() {
		        acSalvar.setEnabled(area.getText().length() > 0);
		    }

		    public void insertUpdate(DocumentEvent e) { atualizar(); }

		    public void removeUpdate(DocumentEvent e) { atualizar(); }

		    public void changedUpdate(DocumentEvent e) { atualizar(); }
		    
		});


		status.setText("Pronto. Use a barra de ferramentas ou atalhos.");

		janela.setVisible(true);
		
	}

}
