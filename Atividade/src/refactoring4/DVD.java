package refactoring4;

/**
 * Lista 1.2.4 - refactoring3
 * O switch testava o codigoDePreco, que e dado do DVD. Pelo Expert,
 * o calculo sobe para ca; o Aluguel passa apenas o dado que e dele: diasAlugado.
 */
public class DVD implements Alugavel {
	public static final int NORMAL = 0;
	public static final int LANÇAMENTO = 1;
	public static final int INFANTIL = 2;

	private String título;
	private int códigoDePreço;

	public DVD(String título, int códigoDePreço) {
		this.título = título;
		this.códigoDePreço = códigoDePreço;
	}

	@Override
	public String getTítulo() {
		return título;
	}

	public int getCódigoDePreço() {
		return códigoDePreço;
	}

	public void setCódigoDePreço(int códigoDePreço) {
		this.códigoDePreço = códigoDePreço;
	}

	@Override
	public double getValorDoAluguel(int diasAlugado) {
		double valorDoAluguel = 0.0;

		switch (getCódigoDePreço()) {
		case NORMAL:
			valorDoAluguel += 2.0;
			if (diasAlugado > 2) {
				valorDoAluguel += (diasAlugado - 2) * 1.5;
			}
			break;

		case LANÇAMENTO:
			valorDoAluguel += diasAlugado * 3.00;
			break;

		case INFANTIL:
			valorDoAluguel += 1.5;
			if (diasAlugado > 3) {
				valorDoAluguel += (diasAlugado - 3) * 1.5;
			}
			break;
		} // switch

		return valorDoAluguel;
	}

	@Override
	public int getPontosDeAlugadorFrequente(int diasAlugado) {
		int pontos = 1;
		if (getCódigoDePreço() == LANÇAMENTO && diasAlugado > 1) {
			pontos++;
		}
		return pontos;
	}
}
