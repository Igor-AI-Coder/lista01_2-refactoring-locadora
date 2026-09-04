package refactoring5;

/**
 * Lista 1.2.5 - refactoring4
 * Isola dois mundos: o das coisas que podem ser alugadas (Automovel, Moto, Van...)
 * e o de quem usa essas coisas (Locacao/Cliente).
 */
public interface Alugavel {
	String getDescricao();

	int getAno();

	double getValorDaLocacao(int diasAlugado);

	int getPontosDeAlugadorFrequente(int diasAlugado);
}
