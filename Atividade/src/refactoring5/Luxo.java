package refactoring5;

public class Luxo extends Classificacao {
	@Override
	int getCodigoDoPreco() {
		return Automovel.LUXO;
	}

	@Override
	double getValorDaLocacao(int diasAlugado) { // R$ 200,00 por dia
		double valor = diasAlugado * 200.00;
		if (diasAlugado > 4) { // desconto de 10%
			valor *= 0.9;
		}
		return valor;
	}

	// Unica classificacao que SOBRESCREVE a regra padrao de pontos.
	@Override
	int getPontosDeAlugadorFrequente(int diasAlugado) {
		return diasAlugado > 2 ? PONTO_SIMPLES + 2 : PONTO_SIMPLES;
	}
}
