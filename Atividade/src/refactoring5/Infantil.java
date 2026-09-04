package refactoring5;

public class Infantil extends Classificacao {
	@Override
	int getCodigoDoPreco() {
		return DVD.INFANTIL;
	}

	@Override
	double getValorDoAluguel(int diasAlugado) { // R$ 1,50 por 3 dias; +R$ 1,50 por dia extra
		double valor = 1.5;
		if (diasAlugado > 3) {
			valor += (diasAlugado - 3) * 1.5;
		}
		return valor;
	}
}
