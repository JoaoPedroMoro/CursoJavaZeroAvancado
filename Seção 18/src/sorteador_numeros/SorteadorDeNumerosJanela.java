package sorteador_numeros;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public final class SorteadorDeNumerosJanela extends JFrame {
	
	private final JPanel painelEntrada = new JPanel(new GridBagLayout());
	
	private final JPanel painelResultado = new JPanel();
	
	private final JPanel painelRoot = new JPanel();
	
	private final JLabel rotuloMinimo = new JLabel("Valor mínimo:");
	
	private final JLabel rotuloMaximo = new JLabel("Valor máximo:");
	
	private final JTextField campoMinimo = new JTextField("1");
	
	private final JTextField campoMaximo = new JTextField("100");
	
	private final JButton botaoSortear = new JButton("Sortear");
	
	private final JLabel rotuloContagem = new JLabel("", SwingConstants.CENTER);
	
	private final JLabel rotuloResultado = new JLabel("", SwingConstants.CENTER);
	
	private final SorteioController controller = new SorteioController(this);
	
	public SorteadorDeNumerosJanela() {
		
		super("Sorteador de números");
		
		configurarJanelaBase();
		
		configurarFontes();
		
		montarPainelEntrada();
		
		montarPainelResultado();
		
		montarEstruturaGeral();
		
		conectarEventos();
		
	}
	
	private void configurarJanelaBase() {
		
		setSize(520, 320);
		
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setResizable(false);
		
	}
	
	private void configurarFontes() {
		
		Font fonteLabel = new Font("SansSerif", Font.PLAIN, 16);
		Font fonteCampo = new Font("SansSerif", Font.PLAIN, 16);	
		Font fonteBotao = new Font("SansSerif", Font.BOLD, 20);
		Font fonteContagem = new Font("SansSerif", Font.BOLD, 26);
		Font fonteResultado = new Font("SansSerif", Font.BOLD, 32);
		
		rotuloMinimo.setFont(fonteLabel);
		rotuloMaximo.setFont(fonteLabel);
		campoMinimo.setFont(fonteCampo);
		campoMaximo.setFont(fonteCampo);
		campoMinimo.setColumns(6);
		campoMaximo.setColumns(6);
		botaoSortear.setFont(fonteBotao);
		botaoSortear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rotuloContagem.setFont(fonteContagem);
		rotuloResultado.setFont(fonteResultado);
		rotuloResultado.setForeground(new Color(0x006400)); // verde-escuro
		
	}
	
	private void montarPainelEntrada() {
		
		painelEntrada.setBorder(new TitledBorder("Configuração do sorteio"));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(8,8,8,8);
		
		gbc.anchor = GridBagConstraints.LINE_END;
		
		gbc.gridx = 0;
		
		gbc.gridy = 0;
		
		painelEntrada.add(rotuloMinimo);
		
		gbc.gridx = 1;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		
		painelEntrada.add(campoMinimo, gbc);
		
		gbc.gridx = 0;
		
		gbc.gridy = 1;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		
		painelEntrada.add(rotuloMaximo, gbc);
		
		gbc.gridx = 1;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		
		painelEntrada.add(campoMaximo, gbc);
		
		gbc.gridx = 0;
		
		gbc.gridy = 2;
		
		gbc.gridwidth = 2;
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		painelEntrada.add(botaoSortear, gbc);
		
		campoMinimo.setMaximumSize(campoMinimo.getPreferredSize());
		
		campoMaximo.setMaximumSize(campoMaximo.getPreferredSize());
		
		botaoSortear.setMaximumSize(botaoSortear.getPreferredSize());
		
	}
	
	private void montarPainelResultado() {
		
		painelResultado.setLayout(new BoxLayout(painelResultado, BoxLayout.Y_AXIS));
		
		painelResultado.setBorder(new EmptyBorder(12, 0, 0, 0));
		
		rotuloContagem.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		rotuloResultado.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		painelResultado.add(rotuloContagem);
		
		painelResultado.add(Box.createVerticalStrut(6));
		
		painelResultado.add(rotuloResultado);
		
	}
	
	private void montarEstruturaGeral() {
		
		painelRoot.setLayout(new BoxLayout(painelRoot, BoxLayout.Y_AXIS));
		
		painelRoot.setBorder(new EmptyBorder(10,10,10,10));
		
		painelRoot.add(painelEntrada);
		
		painelRoot.add(Box.createVerticalStrut(10));
		
		painelRoot.add(painelResultado);
		
		add(painelRoot, BorderLayout.CENTER);
		
	}
	
	private void conectarEventos() {
		
		botaoSortear.addActionListener(controller);
		
	}

	public String getTextoMinimo() {
		
		return campoMinimo.getText();
		
	}

	public String getTextoMaximo() {
		
		return campoMaximo.getText();
		
	}
	
	public void exibirContagem(String texto) {
		
		rotuloContagem.setText(texto);
		
	}
	
	public void exibirResultado(String resultado) {
		
		rotuloResultado.setText(resultado);
		
	}
	
	public void habilitarBotao(boolean habilitar) {
		
		botaoSortear.setEnabled(habilitar);
	}
	

}
