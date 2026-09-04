package refactoring5;

/**
 * O atributo codigoDoPreco sumiu: quem sabe o codigo agora e o objeto Classificacao.
 * O switch de CALCULO saiu daqui por polimorfismo; sobra o switch de CRIACAO em
 * setCodigoDoPreco(), que e a responsabilidade de Creator (sairia com um Factory Method).
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

	// O atributo saiu, mas o getter fica: quem responde agora e a classificacao.
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
	public double getValorDaLocacao(int diasAlugado) {
		return classificacao.getValorDaLocacao(diasAlugado);
	}

	@Override
	public int getPontosDeAlugadorFrequente(int diasAlugado) {
		return classificacao.getPontosDeAlugadorFrequente(diasAlugado);
	}
}
