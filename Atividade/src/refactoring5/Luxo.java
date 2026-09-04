package refactoring5;

public class Luxo extends Classificacao {
	@Override
	int getCodigoDoPreco() {
		return Automovel.LUXO;
	}

	@Override
	double getValorDaLocacao(int diasAlugado) { // R$ 200,00 por dia; 10% off acima de 4 diarias
		double valor = diasAlugado * 200.0;
		if (diasAlugado > 4) {
			valor -= valor * 0.1;
		}
		return valor;
	}

	// Unica classificacao que SOBRESCREVE a regra padrao de pontos.
	@Override
	int getPontosDeAlugadorFrequente(int diasAlugado) {
		return diasAlugado > 2 ? PONTO_SIMPLES + 2 : PONTO_SIMPLES;
	}
}
