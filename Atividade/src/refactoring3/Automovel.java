package refactoring3;

/**
 * Lista 1.2.4 - refactoring3
 *
 * Novo questionamento: o switch de Locacao testava dados do AUTOMOVEL
 * (codigoDoPreco), nao dados de Locacao. Pelo Information Expert, o calculo
 * pertence a Automovel. Locacao passa apenas o dado que e dela: diasAlugado.
 */
public class Automovel {
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

	public String getDescricao() {
		return descricao;
	}

	public String getPlaca() {
		return placa;
	}

	public int getAno() {
		return ano;
	}

	public int getCodigoDoPreco() {
		return codigoDoPreco;
	}

	public void setCodigoDoPreco(int codigoDoPreco) {
		this.codigoDoPreco = codigoDoPreco;
	}

	public double getValorDaLocacao(int diasAlugado) {
		double valorDaLocacao = 0.0;

		switch (getCodigoDoPreco()) {
		case BASICO: // R$ 90.00 por dia
			valorDaLocacao += diasAlugado * 90.00;
			break;

		case FAMILIA: // R$ 130.00 por dia
			valorDaLocacao += diasAlugado * 130.00;
			break;

		case LUXO: // R$ 200.00 por dia
			valorDaLocacao += diasAlugado * 200.00;
			if (diasAlugado > 4) { // desconto de 10%
				valorDaLocacao *= 0.9;
			}
			break;
		}
		return valorDaLocacao;
	}

	public int getPontosDeAlugadorFrequente(int diasAlugado) {
		int pontos = 1;
		if (getCodigoDoPreco() == LUXO && diasAlugado > 2) {
			pontos += 2;
		}
		return pontos;
	}
}
