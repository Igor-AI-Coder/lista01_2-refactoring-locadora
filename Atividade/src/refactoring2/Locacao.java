package refactoring2;

import original.Automovel;

/**
 * Lista 1.2.3
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

	// Expert: os dados do calculo (dias e o carro) estao aqui, nao no Cliente.
	public double valorDeUmaLocacao() {
		double valorDaLocacao = 0.0;

		switch (getCarro().getCodigoDoPreco()) {
		case Automovel.BASICO:
			valorDaLocacao += getDiasAlugado() * 90.0;
			break;

		case Automovel.FAMILIA:
			valorDaLocacao += getDiasAlugado() * 130.0;
			break;

		case Automovel.LUXO:
			valorDaLocacao += getDiasAlugado() * 200.0;
			if (getDiasAlugado() > 4) {
				valorDaLocacao -= valorDaLocacao * 0.1;
			}
			break;
		} // switch

		return valorDaLocacao;
	}

	public int getPontosDeAlugadorFrequente() {
		int pontos = 1;
		if (getCarro().getCodigoDoPreco() == Automovel.LUXO && getDiasAlugado() > 2) {
			pontos += 2;
		}
		return pontos;
	}
}
