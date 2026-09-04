package refactoring3;

/**
 * Lista 1.2.4
 */
public class Aluguel {
	private Automovel carro;
	private int diasAlugado;

	public Aluguel(Automovel carro, int diasAlugado) {
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
	public double valorDeUmAluguel() {
		return getCarro().getValorDoAluguel(getDiasAlugado());
	}

	public int getPontosDeAlugadorFrequente() {
		return getCarro().getPontosDeAlugadorFrequente(getDiasAlugado());
	}
}
