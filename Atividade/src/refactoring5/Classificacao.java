package refactoring5;

/**
 * Lista 1.2.6 - refactoring5
 * Separe o que e igual do que muda e encapsule o que muda.
 * O que muda e a regra de preco/pontos -> vira um objeto proprio, composto pelo Automovel.
 */
public abstract class Classificacao {
	protected static final int PONTO_SIMPLES = 1;

	abstract int getCodigoDoPreco();

	abstract double getValorDaLocacao(int diasAlugado);

	// Comportamento PADRAO: vale para BASICO e FAMILIA.
	int getPontosDeAlugadorFrequente(int diasAlugado) {
		return PONTO_SIMPLES;
	}
}
