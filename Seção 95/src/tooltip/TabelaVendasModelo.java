package tooltip;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TabelaVendasModelo extends AbstractTableModel {
	
	private final String[] colunas = {"Vendedor", "Produto", "Total (R$)"};
	
	private final List<Venda> vendas = new ArrayList<>();
	
	public void setVendas(List<Venda> lista) {
		
		vendas.clear();
		
		if (lista!=null) { vendas.addAll(lista); }
		
		fireTableDataChanged();
		
	}
	
	public Venda getVendaAt(int linha) {
		
		if (linha < 0 || linha >= vendas.size()) return null;
		
		return vendas.get(linha);
		
	}
	
	@Override
	public int getRowCount() { return vendas.size(); }
	
	@Override
	public int getColumnCount() { return colunas.length; }
	
	@Override
	public String getColumnName(int col) { return colunas[col]; }
	
	@Override
	public Object getValueAt(int linha, int coluna) {
		
		Venda v = vendas.get(linha);
		
		return switch (coluna) {
		
			case 0 -> v.getVendedor();
			
			case 1 -> v.getProduto();
			
			case 2 -> UtilMoeda.formatarBR(v.getTotal());
			
			default -> "";
		
		};
		
	}
	
	@Override
	public Class<?> getColumnClass(int col) { return String.class; }
	

}
