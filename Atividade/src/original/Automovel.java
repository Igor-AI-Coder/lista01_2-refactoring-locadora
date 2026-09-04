package original;

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
}
