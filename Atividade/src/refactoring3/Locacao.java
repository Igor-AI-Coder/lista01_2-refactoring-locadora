package refactoring3;

public class Locacao {
	private Automovel carro;
	private int diasAlugado;

	public Locacao(Automovel carro, int diasAlugado) {
		this.carro = carro;
		this.diasAlugado = diasAlugado;
	}

	public Automovel getCarro() {
		return carro;
	}

	public int getDiasAlugado() {
		return diasAlugado;
	}

	// Mantem a mesma interface publica, mas apenas DELEGA para o Automovel.
	public double valorDeUmaLocacao() {
		return getCarro().getValorDaLocacao(getDiasAlugado());
	}

	public int getPontosDeAlugadorFrequente() {
		return getCarro().getPontosDeAlugadorFrequente(getDiasAlugado());
	}
}
