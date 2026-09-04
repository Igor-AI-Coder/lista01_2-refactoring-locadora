package refactoring5;

/**
 * O atributo codigoDoPreco sumiu: quem sabe o codigo agora e o objeto
 * Classificacao. Automovel e o CREATOR das classificacoes concretas
 * (ele tem o dado necessario para inicializa-las) e DELEGA os calculos.
 */
public class Automovel implements Alugavel {
	public static final int BASICO = 0;
	public static final int FAMILIA = 1;
	public static final int LUXO = 2;

	private String descricao;
	private String placa;
	private int ano;
	private Classificacao classificacao;

	public Automovel(String descricao, String placa, int ano, int codigoDoPreco) {
		this.descricao = descricao;
		this.placa = placa;
		this.ano = ano;
		setCodigoDoPreco(codigoDoPreco);
	}

	@Override
	public String getDescricao() {
		return descricao;
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

	// CREATOR: cria a classificacao concreta a partir do codigo recebido.
	// E o unico ponto do sistema que precisa mudar quando surgir PREMIUM.
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
		default:
			throw new IllegalArgumentException("Codigo de preco invalido: " + codigoDoPreco);
		}
	}

	@Override
	public double getValorDaLocacao(int diasAlugado) {
		return classificacao.getValorDaLocacao(diasAlugado);
	}

	@Override
	public int getPontosDeAlugadorFrequente(int diasAlugado) {
		return classificacao.getPontosDeAlugadorFrequente(diasAlugado);
	}
}
