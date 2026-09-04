package refactoring5;

/**
 * O atributo codigoDoPreco sumiu: quem sabe o codigo agora e o objeto Classificacao.
 * Automovel e o CREATOR das classificacoes concretas e DELEGA os calculos para elas.
 */
public class Automovel implements Alugavel {
	public static final int BASICO = 0;
	public static final int FAMILIA = 1;
	public static final int LUXO = 2;

	private String titulo;
	private String placa;
	private int ano;
	private Classificacao classificacao;

	public Automovel(String titulo, String placa, int ano, int codigoDoPreco) {
		this.titulo = titulo;
		this.placa = placa;
		this.ano = ano;
		setCodigoDoPreco(codigoDoPreco);
	}

	@Override
	public String getTitulo() {
		return titulo;
	}

	public String getPlaca() {
		return placa;
	}

	@Override
	public int getAno() {
		return ano;
	}

	public int getCodigoDoPreco() {
		return classificacao.getCodigoDoPreco();
	}

	// CREATOR: unico ponto do sistema que muda quando surgir uma nova classificacao.
	public void setCodigoDoPreco(int codigoDoPreco) {
		switch (codigoDoPreco) {
		case BASICO:
			classificacao = new Basica();
			break;
		case FAMILIA:
			classificacao = new Familia();
			break;
		case LUXO:
			classificacao = new Luxo();
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
