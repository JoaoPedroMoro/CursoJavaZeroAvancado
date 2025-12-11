package Exercicio_1;

public class Pessoa {
	
	private String nome;
	
	private boolean acordado;
	
	private boolean comendo;
	
	private boolean dirigindo;
	
	public Pessoa (String nome) {
		
		this.nome = nome;
		
		this.acordado = false;
		
		this.comendo = false;
		
		this.dirigindo = false;
		
	}
	
	public void acordar() {
		
		if (acordado) {
			
			System.out.println(nome + " já está acordado.");
			
		} else {
			
			System.out.println(nome + " acordou!");
			
			this.acordado = true;
			
		}
		
	}
	
	public void comer () {
		
		if (comendo) {
			
			System.out.println(nome + " já está comendo.");
			
		} else {
			
			if (!acordado) {
				
				System.out.println(nome + " não pode conmer enquanto dorme!");
				
			} else if (dirigindo) {
				
				System.out.println(nome + " não pode conmer enquanto dirige!");
				
			} else {
				
				this.comendo = true;
				
				System.out.println(nome + " está comendo.");
				
			}
			
		}
		
			
		
		
	}
	
	public void pararComer() {
		
		if (!comendo) {
			
			System.out.println(nome + " não está comendo nada.");
			
		}else {
			
			System.out.println(nome + " parou de comer!");
			
			this.comendo = false;
			
		}
		
		
	}
	
	public void dirigir() {
		
		if (dirigindo) {
			
			System.out.println(nome + " não está dirigindo.");
			
			
		} else {
		
			if (comendo) {
				
				System.out.println(nome + " não pode dirigir enquanto come!");
				
			}else if (!acordado) {
				
				System.out.println(nome + " não pode dirigir enquanto dorme!");
				
			} else {
				
				this.dirigindo = true;
				
				System.out.println(nome + " está dirigindo.");
				
			}
		
		}
		
		
	}
	
	public void pararDirigir() {
		
		if (!dirigindo) {
			
			System.out.println(nome + " não está dirigindo.");
			
		} else {
			
			System.out.println(nome + " parou de dirigir!");
			
			this.dirigindo = false;
			
		}
		
	}
	
	public void dormir() {
		
		if (!acordado) {
			
			System.out.println(nome + " já está dormindo.");
			
		} else {
			
			if (dirigindo) {
				
				System.out.println(nome + " não pode dormir enquanto dirige!");
				
			} else if(comendo) {
				
				System.out.println(nome + " não pode dormir enquanto come!");
				
			} else {
				
				this.acordado = false;
				
				System.out.println(nome + " está dormindo.");
				
			}
			
		}
		
	}
	

}
