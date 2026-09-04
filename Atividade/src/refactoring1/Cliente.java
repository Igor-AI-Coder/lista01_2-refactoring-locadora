package refactoring1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import original.Aluguel;
import original.Automovel;

/**
 * Lista 1.2.2
 */
public class Cliente {
	private String nome;
	private List<Aluguel> carrosAlugados = new ArrayList<Aluguel>();

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void adicionaAluguel(Aluguel aluguel) {
		carrosAlugados.add(aluguel);
	}

	public String extrato() {
		final String fimDeLinha = System.getProperty("line.separator");
		double valorTotal = 0.0;
		int pontosDeAlugadorFrequente = 0;

		Iterator<Aluguel> alugueis = carrosAlugados.iterator();
		String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;

		while (alugueis.hasNext()) {
			Aluguel umaLocacao = alugueis.next();

			double valorDaLocacao = valorDeUmAluguel(umaLocacao);
			pontosDeAlugadorFrequente += pontosDeUmAluguel(umaLocacao);

			resultado += "\t" + umaLocacao.getCarro().getTitulo() + " (" + umaLocacao.getCarro().getAno() + ")"
					+ "\t R$ " + String.format(new Locale("pt", "BR"), "%,.2f", valorDaLocacao) + fimDeLinha;
			valorTotal += valorDaLocacao;
		} // while

		resultado += "Valor total pago: R$ "
				+ String.format(new Locale("pt", "BR"), "%,.2f", valorTotal) + fimDeLinha;
		resultado += "Voce acumulou " + pontosDeAlugadorFrequente + " pontos de alugador frequente";

		return resultado;
	}

	private double valorDeUmAluguel(Aluguel umaLocacao) {
		double valorDaLocacao = 0.0;

		switch (umaLocacao.getCarro().getCodigoDoPreco()) {
		case Automovel.BASICO: // R$ 90,00 por dia
			valorDaLocacao += umaLocacao.getDiasAlugado() * 90.0;
			break;

		case Automovel.FAMILIA: // R$ 130,00 por dia
			valorDaLocacao += umaLocacao.getDiasAlugado() * 130.0;
			break;

		case Automovel.LUXO: // R$ 200,00 por dia, com 10% de desconto acima de 4 diarias
			valorDaLocacao += umaLocacao.getDiasAlugado() * 200.0;
			if (umaLocacao.getDiasAlugado() > 4) {
				valorDaLocacao -= valorDaLocacao * 0.1;
			}
			break;
		} // switch

		return valorDaLocacao;
	}

	private int pontosDeUmAluguel(Aluguel umaLocacao) {
		int pontos = 1;
		if (umaLocacao.getCarro().getCodigoDoPreco() == Automovel.LUXO
				&& umaLocacao.getDiasAlugado() > 2) {
			pontos += 2;
		}
		return pontos;
	}
}
