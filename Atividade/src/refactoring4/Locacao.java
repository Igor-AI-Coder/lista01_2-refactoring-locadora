package refactoring4;

public class Locacao {
	// Antes: private Automovel carro; -> agora depende da abstracao (DIP).
	private Alugavel item;
	private int diasAlugado;

	public Locacao(Alugavel item, int diasAlugado) {
		this.item = item;
		this.diasAlugado = diasAlugado;
	}

	public Alugavel getItem() {
		return item;
	}

	public int getDiasAlugado() {
		return diasAlugado;
	}

	public double valorDeUmaLocacao() {
		return getItem().getValorDaLocacao(getDiasAlugado());
	}

	public int getPontosDeAlugadorFrequente() {
		return getItem().getPontosDeAlugadorFrequente(getDiasAlugado());
	}
}
