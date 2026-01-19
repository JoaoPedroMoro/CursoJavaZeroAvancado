package calculadora_modena_svc;

import calculadora_modena_svc.CalculadoraVision;
import calculadora_modena_svc.CalculadoraModel;
import calculadora_modena_svc.CalculadoraController;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			
			CalculadoraModel modelo = new CalculadoraModel();
			
			CalculadoraVision visao = new CalculadoraVision();
			
			new CalculadoraController(modelo, visao);
			
			visao.setVisible(true);
			
		});

	}

}
