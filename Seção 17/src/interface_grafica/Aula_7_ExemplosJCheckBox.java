package interface_grafica;

import javax.swing.*;

import java.awt.*;

public class Aula_7_ExemplosJCheckBox {

	public static void main(String[] args) {

		JFrame janela = new JFrame("Exemplos JCheckBox");
		
		janela.setSize(400,300);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setLayout(new GridLayout(3, 1, 10, 10));
		
		JPanel painelTermos = new JPanel(new FlowLayout());
		
		painelTermos.setBorder(BorderFactory.createTitledBorder("Aceitar termos"));

		JCheckBox checkTermos = new JCheckBox("Aceito os termos de uso");
		
		JButton botaoConfirmar = new JButton("Confirmar");
		
		botaoConfirmar.addActionListener(e -> {
			
			if (checkTermos.isSelected()) {
				
				JOptionPane.showMessageDialog(janela, "Você aceitou os termos!");
				
			} else {
				
				JOptionPane.showMessageDialog(janela, "Você precisa aceitar os termos!");
				
			}
		});
		
		painelTermos.add(checkTermos);
		
		painelTermos.add(botaoConfirmar);
		
		janela.add(painelTermos);
		
		JPanel painelOpcoes = new JPanel(new FlowLayout());
		
		painelOpcoes.setBorder(BorderFactory.createTitledBorder("Escolha seus hobbies."));
		
		JCheckBox opc1 = new JCheckBox("Leitura");
		
		JCheckBox opc2 = new JCheckBox("Esportes");
		
		JCheckBox opc3 = new JCheckBox("Música");
		
		JButton botaoVerificar = new JButton("Verificar seleção.");
		
		botaoVerificar.addActionListener(e -> {
			
			StringBuilder hobbies = new StringBuilder("Você gosta de: ");
			
			if (opc1.isSelected()) hobbies.append("Ler ");
			
			if (opc2.isSelected()) hobbies.append("Esportes ");
			
			if (opc3.isSelected()) hobbies.append("Música ");
			
			JOptionPane.showMessageDialog(janela, hobbies.toString());

		});
		 
		painelOpcoes.add(opc1);
		
		painelOpcoes.add(opc2);
		
		painelOpcoes.add(opc3);
		
		painelOpcoes.add(botaoVerificar);
		
		janela.add(painelOpcoes);
		
		JPanel painelFuncao = new JPanel(new FlowLayout());
		
		painelFuncao.setBorder(BorderFactory.createTitledBorder("Ativar/Desativar Notificações"));
		
		JCheckBox checkNotificacao = new JCheckBox("Ativar notificações");
		
		JLabel status = new JLabel("Notificações ativas");
		
		checkNotificacao.addActionListener(e -> {
			
			if (checkNotificacao.isSelected()) {
				
				status.setText("Notificações ativas");
				
				status.setForeground(Color.GREEN);
				
			} else {
				
				status.setText("Notificações desativadas");
				
				status.setForeground(Color.RED);
				
			}
		});
		
		painelFuncao.add(checkNotificacao);
		
		painelFuncao.add(status);
		
		janela.add(painelFuncao);
		
		janela.setVisible(true);
	}

}
