package calculadora_modena_svc;

import calculadora_modena_svc.CalculadoraModel;
import calculadora_modena_svc.CalculadoraVision;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Definindo a classe que atua como controller na arquitetura MVC.
 * A classe controller recebe os eventos da interface gráfica e decide como interagir com o modelo e com a visão.
 * */

public class CalculadoraController implements ActionListener {
	
	private final CalculadoraModel modelo;
	
	private final CalculadoraVision visao;
	
	private boolean novoNumero = true;
	
	public CalculadoraController(CalculadoraModel modelo, CalculadoraVision visao) {
		
		this.modelo = modelo;
		
		this.visao = visao;
		
		visao.registrarController(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Captura o texto do botão que foi pressionado pelo usuário.
		String textoBotao = e.getActionCommand();
		
		// Tratamento dos botões numéricos
		if (textoBotao.matches("[0-9]")) {
			
			// Verifica se o visor está mostrando apenas o 0 ou se a flag está marcada como true, indicando que o visor deve ser sobrescrito
			if (visao.lerVisor().equals("0") || novoNumero) {
				
				visao.atualizarVisor(textoBotao);
				
			} else {
				
				// Concatenando o número digitado com o número que já estava antes. Ex: 1 -> 12
				visao.atualizarVisor(visao.lerVisor() + textoBotao);
				
			}
			
			novoNumero = false;
			
			return;
			
		}
		
		// Tratamento da virgula decimal (padrão brasileiro)
		if (textoBotao.equals(",")) {
			
			// Verifica se já existe alguma virgula, já que apenas 1 pode ser inserida
			if (!visao.lerVisor().contains(",")) {
				
				visao.atualizarVisor(visao.lerVisor() + ",");
				
			} 
			
			return;
			
		}
		
		// Botões de limpeza C (Limpeza total) e CE (Limpeza apenas a entrada aparecendo no visor)
		if (textoBotao.equals("C")) {
			
			modelo.limpar();
			
			visao.atualizarVisor("0");
			
			novoNumero = true;
			
			return;
			
		}
		
		if (textoBotao.equals("CE")) {
			
			visao.atualizarVisor("0");
			
			novoNumero = true;
			
			return;
			
		}
		
		// Tratamento do botão backspace (apagar) ⌫
		if (textoBotao.equals("⌫")) {
			
			String atual = visao.lerVisor();
			
			if (atual.length() > 1) {
				
				visao.atualizarVisor(atual.substring(0, atual.length() - 1));
				
			} else {
				
				visao.atualizarVisor("0");
				
				novoNumero = true;
				
			}
			
			return;
			
		}
		
		// Tratamento dos operadores
		if (textoBotao.matches("[+−×÷]")) {
			
			// Transformando o valor de String para double e substituindo a virgula pelo ponto para efetuar o calculo corretamente.
			double valor = Double.parseDouble(visao.lerVisor().replace(',', '.'));
			
			modelo.definirPrimeiroNumero(valor);
			
			modelo.definirOperador(textoBotao);
			
			novoNumero = true;
			
			return;
			
		}
		
		// Cálculo do resultado
		if (textoBotao.equals("=")) {
			
			double segundo = Double.parseDouble(visao.lerVisor().replace(',', '.'));
			
			modelo.definirSegundoNumero(segundo);
			
			try {
				
				double resultado = modelo.calcular();
				
				// Voltando ao formato brasileiro para mostrar na tela
				String txt = Double.toString(resultado).replace('.', ',');
				
				if (txt.endsWith(",0")) {
					
					txt = txt.replace(",0", "");
					
				}
				
				visao.atualizarVisor(txt);
				
			} catch (ArithmeticException ex) {
				
				visao.atualizarVisor("Erro");
				
				novoNumero = true;
				
				modelo.definirOperador("");
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
