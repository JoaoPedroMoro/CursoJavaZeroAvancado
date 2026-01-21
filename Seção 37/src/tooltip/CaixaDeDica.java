package tooltip;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.border.LineBorder;

public class CaixaDeDica {
	
	private final JWindow janelaDica;
	
	private final JLabel labelDica;
	
	public CaixaDeDica(java.awt.Component pai) {
		
		janelaDica = new JWindow(javax.swing.SwingUtilities.getWindowAncestor(pai));
		
		labelDica = new JLabel();
		
		labelDica.setOpaque(true);
		
		labelDica.setBackground(new Color(255, 255, 200));
		
		labelDica.setBorder(new LineBorder(Color.GRAY, 1));
		
		labelDica.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
		
		janelaDica.getContentPane().add(labelDica);
		
		janelaDica.pack();
		
	}
	
	public void mostrar(int x, int y, String textoHTML) {
		
		labelDica.setText(textoHTML);
		
		labelDica.setSize(labelDica.getPreferredSize());
		
		janelaDica.setSize(labelDica.getPreferredSize());
		
		janelaDica.setLocation(x, y);
		
		janelaDica.setVisible(true);
		
	}
	
	public void esconder() {
		
		janelaDica.setVisible(false);
		
	}

}
