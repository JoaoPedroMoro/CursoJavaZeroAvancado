package interface_grafica;

import javax.swing.*;
import java.awt.*;

public class Aula_16_Avancado_JSplitPane {

	public static void main(String[] args) {

		JFrame f = new JFrame("JSplitPane - duas áreas redimension[aveis");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setSize(700, 450);
		
		JTextArea editor = new JTextArea("Área esquerda (editor de texto)");
		
		editor.setLineWrap(true);
		
		editor.setWrapStyleWord(true);
		
		JTextArea preview = new JTextArea("Área direita (visualização)");
		
		preview.setEditable(false);
		
		editor.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			
			
			void sync() {preview.setText(editor.getText());}
			
			public void insertUpdate(javax.swing.event.DocumentEvent e) {sync();}
			
			public void removeUpdate(javax.swing.event.DocumentEvent e) {sync();}
			
			public void changedUpdate(javax.swing.event.DocumentEvent e) {sync();}
			
		});
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(editor), new JScrollPane(preview));
		
		split.setDividerLocation(0.5);
		
		split.setResizeWeight(0.5);
		
		f.add(split);
		
		f.setVisible(true);
		
	}

}
