package refactoring5;

/**
 * Lista 1.2.5 - refactoring4
 *
 * Isola "dois mundos": o mundo das coisas que podem ser alugadas
 * (Automovel, AutomovelEletrico, Motocicleta...) e o mundo que USA essas coisas
 * (Locacao / Cliente). Quem usa passa a depender da ABSTRACAO (DIP + Polimorfismo GRASP).
 */
public interface Alugavel {
	String getDescricao();

	int getAno();

	double getValorDaLocacao(int diasAlugado);

	int getPontosDeAlugadorFrequente(int diasAlugado);
}
