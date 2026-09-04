package refactoring5;

/**
 * Lista 1.2.6 - refactoring5
 *
 * "Separe o que e igual do que muda e encapsule o que muda."
 * O que MUDA e a regra de preco/pontos por classificacao. Isso vira um objeto
 * proprio, composto pelo Automovel (composicao, NAO heranca de Automovel),
 * porque um automovel pode mudar de classificacao em tempo de execucao.
 */
public abstract class Classificacao {
	protected static final int PONTO_SIMPLES = 1;

	abstract int getCodigoDoPreco();

	abstract double getValorDaLocacao(int diasAlugado);

	// Comportamento PADRAO: vale para BASICA e FAMILIA.
	int getPontosDeAlugadorFrequente(int diasAlugado) {
		return PONTO_SIMPLES;
	}
}
