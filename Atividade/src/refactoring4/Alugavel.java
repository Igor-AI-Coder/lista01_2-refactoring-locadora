package refactoring4;

/**
 * Lista 1.2.5 - refactoring4
 * Isola dois mundos: o das coisas que podem ser alugadas (DVD, BluRay, Jogo...)
 * e o de quem usa essas coisas (Aluguel/Cliente).
 */
public interface Alugavel {
	String getTítulo();

	double getValorDoAluguel(int diasAlugado);

	int getPontosDeAlugadorFrequente(int diasAlugado);
}
