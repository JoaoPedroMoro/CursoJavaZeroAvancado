package GeradorCPFInterface;

import javax.swing.SwingUtilities;

public class CpfApp {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			
			new CpfFrame().setVisible(true);
			
		});

	}

}
