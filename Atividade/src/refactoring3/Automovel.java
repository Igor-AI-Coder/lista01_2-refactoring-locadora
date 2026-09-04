package refactoring3;

/**
 * Lista 1.2.4 - refactoring3
 * O switch testava o codigoDoPreco, que e dado do Automovel. Pelo Expert,
 * o calculo sobe para ca; o Aluguel passa apenas o dado que e dele: diasAlugado.
 */
public class Automovel {
	public static final int BASICO = 0;
	public static final int FAMILIA = 1;
	public static final int LUXO = 2;

	private String titulo;
	private String placa;
	private int ano;
	private int codigoDoPreco;

	public Automovel(String titulo, String placa, int ano, int codigoDoPreco) {
		this.titulo = titulo;
		this.placa = placa;
		this.ano = ano;
		this.codigoDoPreco = codigoDoPreco;
	}

	public String getTitulo() {
		return titulo;
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

	public double getValorDoAluguel(int diasAlugado) {
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

	public int getPontosDeAlugadorFrequente(int diasAlugado) {
		int pontos = 1;
		if (getCodigoDoPreco() == LUXO && diasAlugado > 2) {
			pontos += 2;
		}
		return pontos;
	}
}
