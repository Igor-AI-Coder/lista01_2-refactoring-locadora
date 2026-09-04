package refactoring1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import original.Automovel;
import original.Locacao;

/**
 * Lista 1.2.2
 * Extract Method: o calculo sai de dentro do laco, mas continua em Cliente.
 * O ganho e ficar visivel que valorDeUmaLocacao(Locacao) nao usa nenhum campo de Cliente.
 */
public class Cliente {
	private String nome;
	private List<Locacao> carrosAlugados = new ArrayList<Locacao>();

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void adicionaLocacao(Locacao locacao) {
		carrosAlugados.add(locacao);
	}

	public String extrato() {
		final String fimDeLinha = System.getProperty("line.separator");
		double valorTotal = 0.0;
		int pontosDeAlugadorFrequente = 0;

		Iterator<Locacao> locacoes = carrosAlugados.iterator();
		String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;

		while (locacoes.hasNext()) {
			Locacao umaLocacao = locacoes.next();

			double valorDaLocacao = valorDeUmaLocacao(umaLocacao);
			pontosDeAlugadorFrequente += pontosDeUmaLocacao(umaLocacao);

			resultado += "\t" + umaLocacao.getCarro().getDescricao() + " (" + umaLocacao.getCarro().getAno() + ")"
					+ "\t R$ " + String.format(Locale.forLanguageTag("pt-BR"), "%,.2f", valorDaLocacao) + fimDeLinha;
			valorTotal += valorDaLocacao;
		} // while

		resultado += "Valor total pago: R$ "
				+ String.format(Locale.forLanguageTag("pt-BR"), "%,.2f", valorTotal) + fimDeLinha;
		resultado += "Voce acumulou " + pontosDeAlugadorFrequente + " pontos de alugador frequente";

		return resultado;
	}

	private double valorDeUmaLocacao(Locacao umaLocacao) {
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

	private int pontosDeUmaLocacao(Locacao umaLocacao) {
		int pontos = 1;
		if (umaLocacao.getCarro().getCodigoDoPreco() == Automovel.LUXO
				&& umaLocacao.getDiasAlugado() > 2) {
			pontos += 2;
		}
		return pontos;
	}
}
