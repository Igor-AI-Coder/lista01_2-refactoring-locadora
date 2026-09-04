package refactoring5;

public class Normal extends Classificacao {
	@Override
	int getCodigoDoPreco() {
		return DVD.NORMAL;
	}

	@Override
	double getValorDoAluguel(int diasAlugado) { // R$ 2,00 por 2 dias; +R$ 1,50 por dia extra
		double valor = 2.0;
		if (diasAlugado > 2) {
			valor += (diasAlugado - 2) * 1.5;
		}
		return valor;
	}
}
