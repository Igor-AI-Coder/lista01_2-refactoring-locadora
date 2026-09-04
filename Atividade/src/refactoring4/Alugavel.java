package refactoring4;

/**
 * Lista 1.2.5 - refactoring4
 * Isola dois mundos: o das coisas que podem ser alugadas (Automovel, Moto, Van...)
 * e o de quem usa essas coisas (Aluguel/Cliente).
 */
public interface Alugavel {
	String getTitulo();

	int getAno();

	double getValorDoAluguel(int diasAlugado);

	int getPontosDeAlugadorFrequente(int diasAlugado);
}
