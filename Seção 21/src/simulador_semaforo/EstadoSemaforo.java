package simulador_semaforo;

public enum EstadoSemaforo {
	
	VERMELHO("Pare", 10),
	
	AMARELO("Atenção", 5),
	
	VERDE("Siga", 20);
	
	private final String instrucao;
	
	private final int duracao;
	
	EstadoSemaforo(String instrucao, int duracao) {
		
		this.instrucao = instrucao;
		
		this.duracao = duracao;
		
	}
	
	public String getInstrucao() {
		
		return instrucao;
		
	}
	
	public int getDuracao() {
		
		return duracao;
		
	}
	
	// Método para setar a ordem igual da vida real
    public EstadoSemaforo proximo() {
        switch (this) {
            case VERMELHO:
                return VERDE;
            case VERDE:
                return AMARELO;
            case AMARELO:
                return VERMELHO;
            default:
                return VERMELHO;
        }
    }

}
