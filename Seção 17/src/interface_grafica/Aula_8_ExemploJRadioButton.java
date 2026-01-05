package interface_grafica;

import javax.swing.*;

import java.awt.*;

public class Aula_8_ExemploJRadioButton {

	public static void main(String[] args) {
		
		
		JFrame janela = new JFrame("Exemplos JRadioButton");
		
		janela.setSize(400,300);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setLayout(new GridLayout(3, 1, 10, 10));
		
		JPanel painelOpcoes = new JPanel(new FlowLayout());
		
		painelOpcoes.setBorder(BorderFactory.createTitledBorder("Escolha uma opção"));
		
		JRadioButton opc1 = new JRadioButton("Opção 1");
		
		JRadioButton opc2 = new JRadioButton("Opção 2");
		
		ButtonGroup grupo1 = new ButtonGroup();
		
		grupo1.add(opc1);
		
		grupo1.add(opc2);
		
		JButton botaoMostrar = new JButton("Mostrar seleção");
		
		botaoMostrar.addActionListener(e -> {
			
			String escolha = opc1.isSelected() ? "Opção 1" : (opc2.isSelected() ? "Opção 2" : "Nenhum");
			
			JOptionPane.showMessageDialog(janela, "Você escolheu: " + escolha);
			
		});
		
		painelOpcoes.add(opc1);
		
		painelOpcoes.add(opc2);
		
		painelOpcoes.add(botaoMostrar);
		
		JPanel painelSexo = new JPanel(new FlowLayout());
		
		painelSexo.setBorder(BorderFactory.createTitledBorder("Selecione o sexo"));
		
		JRadioButton masc = new JRadioButton("Masculino");
		
		JRadioButton fem = new JRadioButton("Feminino");
		
		ButtonGroup grupo2 = new ButtonGroup();
		
		grupo2.add(masc);
		
		grupo2.add(fem);
		
		painelSexo.add(masc);
		
		painelSexo.add(fem);
		
		JPanel painelPagamento = new JPanel(new FlowLayout());
		
		painelPagamento.setBorder(BorderFactory.createTitledBorder("Forma de pagamento"));
		
		JRadioButton cartao = new JRadioButton("Cartão");
		
		JRadioButton boleto = new JRadioButton("Boleto");
		
		JRadioButton pix = new JRadioButton("Pix");
		
		ButtonGroup grupo3 = new ButtonGroup();
		
		grupo3.add(cartao);
		
		grupo3.add(boleto);
		
		grupo3.add(pix);
		
		JButton botaoPagamento = new JButton("Confirmar pagamento");
		
		botaoPagamento.addActionListener(e -> {
			
			String pagamento = "";
			
			if (cartao.isSelected()) pagamento = "Cartão";
			
			else if (pix.isSelected()) pagamento = "Pix";
			
			else if (boleto.isSelected()) pagamento = "Boleto";
			
			else pagamento = "Nenhuma forma escolhida";
			
			JOptionPane.showMessageDialog(janela, "Pagamento via: " + pagamento);
			
		});
		
		painelPagamento.add(cartao);
		
		painelPagamento.add(pix);
		
		painelPagamento.add(boleto);
		
		painelPagamento.add(botaoPagamento);
		
		janela.add(painelOpcoes);
		
		janela.add(painelSexo);
		
		janela.add(painelPagamento);
		
		janela.setVisible(true);
		

	}

}
