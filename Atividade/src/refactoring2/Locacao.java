package refactoring2;

/**
 * Lista 1.2.3 - refactoring2-1 e refactoring2-3
 *
 * Information Expert: o calculo do valor e dos pontos usa dados de Locacao
 * (diasAlugado) e do Automovel, e NADA de Cliente. Logo, a responsabilidade
 * desce para ca.
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

	public double valorDeUmaLocacao() {
		double valorDaLocacao = 0.0;

		switch (getCarro().getCodigoDoPreco()) {
		case Automovel.BASICO: // R$ 90.00 por dia
			valorDaLocacao += getDiasAlugado() * 90.00;
			break;

		case Automovel.FAMILIA: // R$ 130.00 por dia
			valorDaLocacao += getDiasAlugado() * 130.00;
			break;

		case Automovel.LUXO: // R$ 200.00 por dia
			valorDaLocacao += getDiasAlugado() * 200.00;
			if (getDiasAlugado() > 4) { // desconto de 10%
				valorDaLocacao *= 0.9;
			}
			break;
		}
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
