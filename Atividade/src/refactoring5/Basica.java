package refactoring5;

public class Basica extends Classificacao {
	@Override
	int getCodigoDoPreco() {
		return Automovel.BASICO;
	}

	@Override
	double getValorDaLocacao(int diasAlugado) { // R$ 90,00 por dia
		return diasAlugado * 90.0;
	}
}
