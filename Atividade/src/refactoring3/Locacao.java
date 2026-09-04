package refactoring3;

/**
 * Lista 1.2.4
 */
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

	// INDIRECAO: os metodos continuam aqui, mas so repassam para o Automovel.
	public double valorDeUmaLocacao() {
		return getCarro().getValorDaLocacao(getDiasAlugado());
	}

	public int getPontosDeAlugadorFrequente() {
		return getCarro().getPontosDeAlugadorFrequente(getDiasAlugado());
	}
}
