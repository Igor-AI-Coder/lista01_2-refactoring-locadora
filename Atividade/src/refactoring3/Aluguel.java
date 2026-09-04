package refactoring3;

/**
 * Lista 1.2.4
 */
public class Aluguel {
	private DVD dvd;
	private int diasAlugado;

	public Aluguel(DVD dvd, int diasAlugado) {
		this.dvd = dvd;
		this.diasAlugado = diasAlugado;
	}

	public DVD getDVD() {
		return dvd;
	}

	public int getDiasAlugado() {
		return diasAlugado;
	}

	public double valorDeUmAluguel() {
		return getDVD().getValorDoAluguel(getDiasAlugado());
	}

	public int getPontosDeAlugadorFrequente() {
		return getDVD().getPontosDeAlugadorFrequente(getDiasAlugado());
	}
}
