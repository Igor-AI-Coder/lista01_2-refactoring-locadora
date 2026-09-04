package refactoring5;

public class Lancamento extends Classificacao {
	@Override
	int getCodigoDoPreco() {
		return DVD.LANÇAMENTO;
	}

	@Override
	double getValorDoAluguel(int diasAlugado) { // R$ 3,00 por dia
		return diasAlugado * 3.00;
	}

	// Unica classificacao que SOBRESCREVE a regra padrao de pontos.
	@Override
	int getPontosDeAlugadorFrequente(int diasAlugado) {
		return diasAlugado > 1 ? PONTO_SIMPLES + 1 : PONTO_SIMPLES;
	}
}
