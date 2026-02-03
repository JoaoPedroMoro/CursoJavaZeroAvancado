package tooltip;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class TelaPrincipalVendas extends JFrame {
	
	private final JTextField campoFiltroVendedor = new JTextField();
	private final JTextField campoFiltroProduto = new JTextField();
	private final JTextField campoFiltroTotal = new JTextField();
	
	private final TabelaVendasModelo modelo =  new TabelaVendasModelo();
	
	private final JTable tabela = new JTable(modelo);
	
	private TableRowSorter<TabelaVendasModelo> ordenador;
	
	private final TooltipImagemFlutuante tooltip = new TooltipImagemFlutuante(this);
	
	public TelaPrincipalVendas () {
		
		setTitle("Tabela de vendas - Tooltip com imagens");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		configurarLookAndFeel();
		
		montarLayout();
		
		carregarDados();
		
		configurarInteracoes();
		
	}
	
	private void configurarLookAndFeel() {
		
		try {
			
			for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				
				if ("Nimbus".equals(info.getName())) {
					
					UIManager.setLookAndFeel(info.getClassName());
					
					break;
					
				}
				
			}
			
		} catch (Exception ignore) {}
		
	}
	
	private void montarLayout() {
		
		JPanel painelFiltros = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6, 6, 6, 6);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel rotV = new JLabel("Filtrar por Vendedor:");
		JLabel rotP = new JLabel("Filtrar por Produto:");
		JLabel rotT = new JLabel("Filtrar por Total:");
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		painelFiltros.add(rotV, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		painelFiltros.add(campoFiltroVendedor, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 0;
		painelFiltros.add(rotP, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.weightx = 1;
		painelFiltros.add(campoFiltroProduto, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.weightx = 0;
		painelFiltros.add(rotT, gbc);
		
		gbc.gridx = 5;
		gbc.gridy = 0;
		gbc.weightx = 1;
		painelFiltros.add(campoFiltroTotal, gbc);
		
		tabela.setRowHeight(30);
		tabela.setFillsViewportHeight(true);
		tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tabela.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JScrollPane rolagem = new JScrollPane(tabela);
		
		getContentPane().setLayout(new BorderLayout(8, 8));
		getContentPane().add(painelFiltros, BorderLayout.NORTH);
		getContentPane().add(rolagem, BorderLayout.CENTER);
		
	}
	
	private void carregarDados() {
		
		try {
			
			VendaDAO dao = new VendaDAO();
			
			dao.criarEstruturaEPopularSeVazio();
			
			List<Venda> vendas = dao.listarTodas();
			
			modelo.setVendas(vendas);
			
			ordenador = new TableRowSorter<>(modelo);
			
			tabela.setRowSorter(ordenador);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(this, 
					"Erro ao carregar dados: " + e.getMessage(),
					"Banco de Dados", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	private void configurarInteracoes() {
		
		DocumentListener ouvinte = new DocumentListener() {
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				aplicarFiltros();
			}
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				aplicarFiltros();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				aplicarFiltros();
			}
			
		};
		
		campoFiltroVendedor.getDocument().addDocumentListener(ouvinte);
		campoFiltroProduto.getDocument().addDocumentListener(ouvinte);
		campoFiltroTotal.getDocument().addDocumentListener(ouvinte);
		
		tabela.addMouseMotionListener(new MouseAdapter () {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				
				int linhaView = tabela.rowAtPoint(e.getPoint());
				
				if (linhaView < 0) {
					tooltip.ocultar();
					return;
				}
				
				int linhaModelo = tabela.convertRowIndexToModel(linhaView);
				
				Venda v = modelo.getVendaAt(linhaModelo);
				
				if (v == null) {				
					tooltip.ocultar();				
					return;
				}
				
				String texto  = "Vendedor: " + v.getVendedor() +
						"\nProduto: " + v.getProduto() + 
						"\nTotal: " + UtilMoeda.formatarBR(v.getTotal());
				
				tooltip.mostrar(texto, v.getCaminhoImagem(), e.getXOnScreen(), e.getYOnScreen());

			}
			
		});
		
		tabela.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) { tooltip.ocultar(); }
		});
		
	}
	
	private void aplicarFiltros() {
		
		if (ordenador == null) return;
		
		RowFilter<TabelaVendasModelo, Object> rf = new RowFilter<>() {
			
			@Override
			public boolean include(Entry<? extends TabelaVendasModelo, ? extends Object> entry) {
				
				String vend = campoFiltroVendedor.getText().trim().toLowerCase();
				
				String prod = campoFiltroProduto.getText().trim().toLowerCase();
				
				String total = campoFiltroTotal.getText().trim().toLowerCase();
				
				String v0 = String.valueOf(entry.getValue(0)).toLowerCase();
				String v1 = String.valueOf(entry.getValue(1)).toLowerCase();
				String v2 = String.valueOf(entry.getValue(2)).toLowerCase();
				
				return v0.contains(vend) && v1.contains(prod) && v2.contains(total);
				
			}
			
		};
		
		ordenador.setRowFilter(rf);
		
	}
		

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			
			new TelaPrincipalVendas()
			.setVisible(true);
			
		});

	}

}
