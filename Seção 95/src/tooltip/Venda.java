package tooltip;

import java.math.BigDecimal;

public class Venda {
	
	private int id;
	private String vendedor;
	private String produto;
	private BigDecimal total;
	private String caminhoImagem;
	
	public Venda() {}
	
	public Venda(int id, String vendedor, String produto, BigDecimal total, String caminhoImagem) {
		
		this.id = id;
		this.vendedor = vendedor;
		this.produto = produto;
		this.total = total;
		this.caminhoImagem = caminhoImagem;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}
	
	

}
