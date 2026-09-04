package refactoring5;

/**
 * O atributo códigoDePreço sumiu: quem sabe o codigo agora e o objeto Classificacao.
 * DVD e o CREATOR das classificacoes concretas e DELEGA os calculos para elas.
 */
public class DVD implements Alugavel {
	public static final int NORMAL = 0;
	public static final int LANÇAMENTO = 1;
	public static final int INFANTIL = 2;

	private String título;
	private Classificacao classificacao;

	public DVD(String título, int códigoDePreço) {
		this.título = título;
		setCódigoDePreço(códigoDePreço);
	}

	@Override
	public String getTítulo() {
		return título;
	}

	public int getCódigoDePreço() {
		return classificacao.getCodigoDoPreco();
	}

	// CREATOR: unico ponto do sistema que muda quando surgir uma nova classificacao.
	public void setCódigoDePreço(int códigoDePreço) {
		switch (códigoDePreço) {
		case NORMAL:
			classificacao = new Normal();
			break;
		case LANÇAMENTO:
			classificacao = new Lancamento();
			break;
		case INFANTIL:
			classificacao = new Infantil();
			break;
		}
	}

	@Override
	public double getValorDoAluguel(int diasAlugado) {
		return classificacao.getValorDoAluguel(diasAlugado);
	}

	@Override
	public int getPontosDeAlugadorFrequente(int diasAlugado) {
		return classificacao.getPontosDeAlugadorFrequente(diasAlugado);
	}
}
