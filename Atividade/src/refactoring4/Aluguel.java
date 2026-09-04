package refactoring4;

public class Aluguel {
	// Antes: private Automovel carro; -> agora depende da abstracao (DIP).
	private Alugavel item;
	private int diasAlugado;

	public Aluguel(Alugavel item, int diasAlugado) {
		this.item = item;
		this.diasAlugado = diasAlugado;
	}

	public Alugavel getItem() {
		return item;
	}

	public int getDiasAlugado() {
		return diasAlugado;
	}

	public double valorDeUmAluguel() {
		return getItem().getValorDoAluguel(getDiasAlugado());
	}

	public int getPontosDeAlugadorFrequente() {
		return getItem().getPontosDeAlugadorFrequente(getDiasAlugado());
	}
}
