package original;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

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
		final Locale BR = Locale.forLanguageTag("pt-BR");
		final String fimDeLinha = System.lineSeparator();
		double valorTotal = 0.0;
		int pontosDeAlugadorFrequente = 0;
		int sequencia = 0;

		Iterator<Locacao> locacoes = carrosAlugados.iterator();
		String resultado = "Registro de Locacoes de " + getNome() + fimDeLinha;
		resultado += "Seq Automovel              Ano Diarias  Valor Pago" + fimDeLinha;
		resultado += "=== ==================== ===== ======= ===========" + fimDeLinha;

		while (locacoes.hasNext()) {
			double valorCorrente = 0.0;
			Locacao cada = locacoes.next();

			// determina valores para cada linha
			switch (cada.getCarro().getCodigoDoPreco()) {
			case Automovel.BASICO: // R$ 90.00 por dia
				valorCorrente += cada.getDiasAlugado() * 90.00;
				break;

			case Automovel.FAMILIA: // R$ 130.00 por dia
				valorCorrente += cada.getDiasAlugado() * 130.00;
				break;

			case Automovel.LUXO: // R$ 200.00 por dia
				valorCorrente += cada.getDiasAlugado() * 200.00;
				// Acima de 4 diarias tem 10% de desconto
				if (cada.getDiasAlugado() > 4) {
					valorCorrente *= 0.9;
				}
				break;
			} // switch

			// trata de pontos de alugador frequente
			pontosDeAlugadorFrequente++;
			// adiciona bonus para locacao de carro de luxo por mais de 2 dias
			if (cada.getCarro().getCodigoDoPreco() == Automovel.LUXO
					&& cada.getDiasAlugado() > 2) {
				pontosDeAlugadorFrequente += 2;
			}

			// mostra valores para esta locacao
			sequencia++;
			resultado += String.format(BR, "%02d. %-20s %5d %7d R$ %8.2f",
					sequencia,
					cada.getCarro().getDescricao(),
					cada.getCarro().getAno(),
					cada.getDiasAlugado(),
					valorCorrente) + fimDeLinha;

			valorTotal += valorCorrente;
		} // while

		// adiciona rodape
		resultado += "====================================================" + fimDeLinha;
		resultado += String.format(BR, "Valor Acumulado em diarias............: R$ %8.2f", valorTotal) + fimDeLinha;
		resultado += "Voce acumulou " + pontosDeAlugadorFrequente + " pontos de locador frequente";

		return resultado;
	}
}
