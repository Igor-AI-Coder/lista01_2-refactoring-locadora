package original;

public class Aluguel {
	private Automovel carro;
	private int diasAlugado;

	public Aluguel(Automovel carro, int diasAlugado) {
		this.carro = carro;
		this.diasAlugado = diasAlugado;
	}

	public Automovel getCarro() {
		return carro;
	}

	public int getDiasAlugado() {
		return diasAlugado;
	}
}
