package refactoring4;

/**
 * Lista 1.2.5 - o Automovel passa a ser apenas UM dos possiveis Alugavel.
 */
public class Automovel implements Alugavel {
	public static final int BASICO = 0;
	public static final int FAMILIA = 1;
	public static final int LUXO = 2;

	private String descricao;
	private String placa;
	private int ano;
	private int codigoDoPreco;

	public Automovel(String descricao, String placa, int ano, int codigoDoPreco) {
		this.descricao = descricao;
		this.placa = placa;
		this.ano = ano;
		this.codigoDoPreco = codigoDoPreco;
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
		return codigoDoPreco;
	}

	public void setCodigoDoPreco(int codigoDoPreco) {
		this.codigoDoPreco = codigoDoPreco;
	}

	@Override
	public double getValorDaLocacao(int diasAlugado) {
		double valorDaLocacao = 0.0;

		switch (getCodigoDoPreco()) {
		case BASICO:
			valorDaLocacao += diasAlugado * 90.0;
			break;

		case FAMILIA:
			valorDaLocacao += diasAlugado * 130.0;
			break;

		case LUXO:
			valorDaLocacao += diasAlugado * 200.0;
			if (diasAlugado > 4) {
				valorDaLocacao -= valorDaLocacao * 0.1;
			}
			break;
		} // switch

		return valorDaLocacao;
	}

	@Override
	public int getPontosDeAlugadorFrequente(int diasAlugado) {
		int pontos = 1;
		if (getCodigoDoPreco() == LUXO && diasAlugado > 2) {
			pontos += 2;
		}
		return pontos;
	}
}
