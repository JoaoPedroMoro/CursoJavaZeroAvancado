package tooltip;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TabelaComCaixaDeDica extends JPanel {
	
	private final JTable tabela;
	
	private CaixaDeDica dicaAtual;
	
	public TabelaComCaixaDeDica() {
		
		setLayout(new BorderLayout());
		
		DefaultTableModel modelo = new DefaultTableModel(
				
				new Object[][] {
					{"Carlos", 34, "Engenheiro"},
					{"Ana", 28, "Médica"},
					{"Pedro", 45, "Professor"},
	                {"Maria", 23, "Estudante"},
	                {"Cesar", 30, "Enfermeiro"},
	                {"Paulo", 23, "Médico"},
	                {"João", 25, "Desenvolvedor"},
	                {"Luiza", 24, "Psicóloga"},
	                {"Ricardo", 22, "Estudante"}
				},
				
				new String[] {"Nome", "Idade", "Profissão"}
				
		) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
				
			}
			
		};
		
		tabela = new JTable(modelo);
		
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabela.setRowHeight(28);
		
		tabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scroll = new JScrollPane(tabela);
		
		add(scroll, BorderLayout.CENTER);
		
		tabela.addMouseMotionListener(new MouseAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				
				exibirDicaHTML(e);
				
			}
			
		});
		
		tabela.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				if (dicaAtual != null) {
					
					dicaAtual.esconder();
					
					dicaAtual = null;
					
				}
				
			}
			
		});
		
	}
		
	private void exibirDicaHTML(MouseEvent e) {
		
		int linha = tabela.rowAtPoint(new Point(e.getX(), e.getY()));
		
		if (linha >= 0) {
			
			String nome = tabela.getValueAt(linha, 0).toString();
			
			String idade = tabela.getValueAt(linha, 1).toString();
			
			String profissao = tabela.getValueAt(linha, 2).toString();
			
			String textoHTML = "<html>"
                    + "<b>Nome:</b> " + nome + "<br>"
                    + "<b>Idade:</b> " + idade + "<br>"
                    + "<b>Profissão:</b> " + profissao
                    + "</html>";
			
			if (dicaAtual != null) dicaAtual.esconder();
			
			dicaAtual = new CaixaDeDica(tabela);
			
			Point localTela = e.getLocationOnScreen();
			
			dicaAtual.mostrar(localTela.x + 10, localTela.y + 10, textoHTML);
			
		} else {
			
			if (dicaAtual != null) {
				
				dicaAtual.esconder();
				dicaAtual = null;
				
			}
			
		}
		
	}
		

}
