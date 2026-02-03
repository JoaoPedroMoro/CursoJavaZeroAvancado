package tooltip;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

	public void criarEstruturaEPopularSeVazio() throws SQLException {
		
		try (Connection conn = ConexaoMySQL.obterConexao();
				Statement st = conn.createStatement()){
			
			st.execute("""
					CREATE TABLE IF NOT EXISTS produtos (
						id INT AUTO_INCREMENT PRIMARY KEY,
						nome VARCHAR(120) NOT NULL UNIQUE,
						caminho_imagem VARCHAR (255) NULL
					) ENGINE=InnoDB
					"""
					);
			
			st.execute("""
	        	    CREATE TABLE IF NOT EXISTS vendas (
	        	      id INT AUTO_INCREMENT PRIMARY KEY,
	        	      vendedor   VARCHAR(120) NOT NULL,
	        	      produto_id INT NOT NULL,
	        	      total      DECIMAL(10,2) NOT NULL,
	        	      CONSTRAINT fk_vendas_produtos
	        	        FOREIGN KEY (produto_id) REFERENCES produtos(id)
	        	        ON UPDATE CASCADE ON DELETE RESTRICT
	        	    ) ENGINE=InnoDB
	        	""");
			
			st.executeUpdate("""
	        	    INSERT IGNORE INTO produtos (nome, caminho_imagem) VALUES
	        	     ('Notebook','imagem/Notebook.jpg'),
	        	     ('Mouse','imagem/Mouse.jpg'),
	        	     ('Teclado','imagem/Teclado.jpg')
	        	""");
			
			int qtd;
			
			try (ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM vendas")) {
				
				rs.next();
				
				qtd = rs.getInt(1);
				
			}
			
			if (qtd == 0) {
				
				st.executeUpdate("""
	        	        INSERT INTO vendas (vendedor, produto_id, total)
	        	        SELECT 'Ana', id, 3500.00 FROM produtos WHERE nome='Notebook'
	        	    """);
				
				st.executeUpdate("""
	        	        INSERT INTO vendas (vendedor, produto_id, total)
	        	        SELECT 'Bruno', id, 80.00 FROM produtos WHERE nome='Mouse'
	        	    """);
				
				st.executeUpdate("""
	        	        INSERT INTO vendas (vendedor, produto_id, total)
	        	        SELECT 'Carla', id, 200.00 FROM produtos WHERE nome='Teclado'
	        	    """);
				
			}
			
		}
		
	}
	
	public List<Venda> listarTodas() throws SQLException {
		
		String sql = """
				SELECT v.id, v.vendedor, p.nome AS produto, v.total, p.caminho_imagem
						FROM vendas v
						JOIN produtos p ON p.id = v.produto_id
				ORDER BY v.id
		""";
		
		List<Venda> lista = new ArrayList<>();
		
		try (
				Connection con = ConexaoMySQL.obterConexao();
		        PreparedStatement ps = con.prepareStatement(sql);
		        ResultSet rs = ps.executeQuery()
		) {
			
			while (rs.next()) {
				
				int id = rs.getInt("id");
				
				String vendedor = rs.getString("vendedor");
				
				String produto = rs.getString("produto");
				
				BigDecimal total = rs.getBigDecimal("total");
				
				String caminho = rs.getString("caminho_imagem");
				
				lista.add(new Venda(id, vendedor, produto, total, caminho));
				
			}
			
		}
		
		return lista;
		
	}
	
}
