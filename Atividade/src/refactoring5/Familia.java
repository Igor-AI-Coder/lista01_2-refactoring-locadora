package refactoring5;

public class Familia extends Classificacao {
	@Override
	int getCodigoDoPreco() {
		return Automovel.FAMILIA;
	}

	@Override
	double getValorDaLocacao(int diasAlugado) { // R$ 130,00 por dia
		return diasAlugado * 130.00;
	}
}
