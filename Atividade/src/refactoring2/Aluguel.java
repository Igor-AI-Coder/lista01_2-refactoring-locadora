package refactoring2;

import locadora.DVD;

/**
 * Lista 1.2.3
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
		double valorDoAluguel = 0.0;

		switch (getDVD().getCódigoDePreço()) {
		case DVD.NORMAL:
			valorDoAluguel += 2.0;
			if (getDiasAlugado() > 2) {
				valorDoAluguel += (getDiasAlugado() - 2) * 1.5;
			}
			break;

		case DVD.LANÇAMENTO:
			valorDoAluguel += getDiasAlugado() * 3.00;
			break;

		case DVD.INFANTIL:
			valorDoAluguel += 1.5;
			if (getDiasAlugado() > 3) {
				valorDoAluguel += (getDiasAlugado() - 3) * 1.5;
			}
			break;
		} // switch

		return valorDoAluguel;
	}

	public int getPontosDeAlugadorFrequente() {
		int pontos = 1;
		if (getDVD().getCódigoDePreço() == DVD.LANÇAMENTO && getDiasAlugado() > 1) {
			pontos++;
		}
		return pontos;
	}
}
