package GeradorCPFInterface;

import javax.swing.*;
import java.awt.*;

public class CpfFrame extends JFrame {
	
	private final JTextField campoCpfGerado = new JTextField();
	
	private final JTextField campoCpfParaValidar = new JTextField();
	
	private final JLabel resultadoValidacao = new JLabel("", SwingConstants.CENTER);
	
	public CpfFrame() {
		
		super("Gerador e Validador de CPF");
		
		configurarJanela();
		
		adicionarComponentes();
		
		registrarEventos();
		
	}
	
	private void configurarJanela() {
		
		setSize(500, 380);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		setResizable(false);
		
		setLayout(new GridLayout(5, 1, 12, 12));
		
	}
	
	private void adicionarComponentes() {
		
		Font fonteCampoGerado = new Font("Arial", Font.BOLD, 22);
		
		Font fonteCampoEntrada = new Font("Arial", Font.PLAIN, 20);
		
		Font fonteBotao = new Font("Arial", Font.BOLD, 18);
		
		Font fonteResultado = new Font("Arial", Font.BOLD, 18);
		
		campoCpfGerado.setFont(fonteCampoGerado);
		
		campoCpfGerado.setHorizontalAlignment(SwingConstants.CENTER);
		
		campoCpfGerado.setEditable(false);
		
		add(campoCpfGerado);
		
		JButton botaoGerar = new JButton("Gerar CPF");
		
		botaoGerar.setFont(fonteBotao);
		
		add(botaoGerar);
		
		campoCpfParaValidar.setFont(fonteCampoEntrada);
		
		campoCpfParaValidar.setHorizontalAlignment(SwingConstants.CENTER);
		
		campoCpfParaValidar.setToolTipText("Digite um CPF com ou sem pontuação");
		
		add(campoCpfParaValidar);
		
		JButton botaoValidar = new JButton("Validar CPF");
		
		botaoValidar.setFont(fonteBotao);
		
		add(botaoValidar);
		
		resultadoValidacao.setFont(fonteResultado);
		
		add(resultadoValidacao);
		
		botaoGerar.addActionListener(e -> {
			
			String cpf = CpfUtil.gerarCpf();
			
			campoCpfGerado.setText(cpf);
			
		});
		
		botaoValidar.addActionListener(e -> {
			
			String cpfDigitado = campoCpfParaValidar.getText().replaceAll("[^\\d]", "");
			
			if (cpfDigitado.length() != 11) {
				
				setResultado("CPF inválido (deve ter 11 dígitos)", Color.RED);
				
				return;
				
			}
			
			boolean valido = CpfUtil.validarCpf(cpfDigitado);
			
			if (valido) {
				
				setResultado("CPF válido!", new Color(0, 128, 0));
				
			} else {
				
				setResultado("CPF inválido!", Color.RED);
				
			}
			
		});
		
	}
	
	private void setResultado(String texto, Color cor) {
		
		resultadoValidacao.setText(texto);
		
		resultadoValidacao.setForeground(cor);
		
	}
	
	private void registrarEventos() {
		
		
		
	}

}
