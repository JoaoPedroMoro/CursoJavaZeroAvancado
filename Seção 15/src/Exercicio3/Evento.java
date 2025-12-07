package Exercicio3;

public class Evento {
	
	private final int capacidade;
	
	private int lugaresDisponiveis;
	
	public Evento() {
		
		this(10);
		
	}
	
	public Evento(int capacidade) {
		
		if (capacidade < 0) {
			
			throw new IllegalArgumentException("A capacidade não pode ser negativa.");
			
		}
		
		this.capacidade = capacidade;
		
		this.lugaresDisponiveis = capacidade;
		
	}
	
	public void reservar() {
		
		if (lugaresDisponiveis == 0) {
			
			System.out.println("Ops, não existem mais lugares disponíveis para reserva.");
			
			return;
			
		}
		
		lugaresDisponiveis--;
		
		System.out.println("Sucesso! Seu lugar foi reservado.");
		
	}
	
	public void cancelar() {
		
		if (lugaresDisponiveis == capacidade) {
			
			System.out.println("Atenção! Não existem reservas para cancelar");
			
			return;
			
		}
		
		lugaresDisponiveis++;
		
		System.out.println("Sucesso! Sua reserva foi cancelada.");
		
	}
	
	public int lugaresDisponiveis() {
		
		return lugaresDisponiveis;
		
	}
	
	public void exibirStatus() {
		
		int reservados = capacidade - lugaresDisponiveis;
		
		StringBuilder barra = new StringBuilder("[");
		
		for (int i = 0; i < capacidade ;i++) {
			
			if (i < reservados) barra.append("█");
			
			else barra.append("-");
		}
		
		barra.append("]");
		
		System.out.println("\n========== STATUS DO EVENTO ==========");
		
		System.out.println("Capacidade total: " + capacidade);
		
		System.out.println("Reservados: " + reservados);
		
		System.out.println("Disponíveis: " + lugaresDisponiveis);
		
		System.out.println("Ocupação: " + barra);
		
		if (lugaresDisponiveis == 0) {
			
			System.out.println("ATENÇÃO! O evento está lotado.");
			
		} else if (lugaresDisponiveis <= capacidade * 0.2) {
			
			System.out.println("Atenção! Poucas vagas restantes, menos de 20%.");
			
		} else {
			
			System.out.println("Existem bastantes lugares disponíveis");
			
		}
		
	}

}
