package refactoring1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * Lista 1.2.2 - refactoring1.1 e refactoring1.2
 *
 * O metodo extrato() era uma "God method": montava cabecalho, calculava preco,
 * calculava pontos e montava o rodape. Aqui apenas EXTRAIMOS blocos coesos
 * para metodos privados da propria classe Cliente (Extract Method).
 * Nenhuma responsabilidade mudou de classe ainda -> o switch continua no lugar errado.
 */
public class Cliente {
	private static final Locale BR = Locale.forLanguageTag("pt-BR");
	private static final String FIM_DE_LINHA = System.lineSeparator();

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
		double valorTotal = 0.0;
		int pontosDeAlugadorFrequente = 0;
		int sequencia = 0;

		Iterator<Locacao> locacoes = carrosAlugados.iterator();
		String resultado = cabecalho();

		while (locacoes.hasNext()) {
			Locacao cada = locacoes.next();

			double valorCorrente = valorDeUmaLocacao(cada);
			pontosDeAlugadorFrequente += pontosDeUmaLocacao(cada);

			sequencia++;
			resultado += linhaDoExtrato(sequencia, cada, valorCorrente);

			valorTotal += valorCorrente;
		}

		return resultado + rodape(valorTotal, pontosDeAlugadorFrequente);
	}

	// ---------- blocos coesos extraidos (refactoring1.1) ----------

	private String cabecalho() {
		return "Registro de Locacoes de " + getNome() + FIM_DE_LINHA
				+ "Seq Automovel              Ano Diarias  Valor Pago" + FIM_DE_LINHA
				+ "=== ==================== ===== ======= ===========" + FIM_DE_LINHA;
	}

	private String linhaDoExtrato(int sequencia, Locacao umaLocacao, double valorDaLocacao) {
		return String.format(BR, "%02d. %-20s %5d %7d R$ %8.2f",
				sequencia,
				umaLocacao.getCarro().getDescricao(),
				umaLocacao.getCarro().getAno(),
				umaLocacao.getDiasAlugado(),
				valorDaLocacao) + FIM_DE_LINHA;
	}

	private String rodape(double valorTotal, int pontos) {
		return "====================================================" + FIM_DE_LINHA
				+ String.format(BR, "Valor Acumulado em diarias............: R$ %8.2f", valorTotal) + FIM_DE_LINHA
				+ "Voce acumulou " + pontos + " pontos de locador frequente";
	}

	// ---------- calculo do valor de uma locacao (refactoring1.2) ----------
	// Nomes revisados: "umaLocacao" e "valorDaLocacao" comunicam melhor o proposito.
	private double valorDeUmaLocacao(Locacao umaLocacao) {
		double valorDaLocacao = 0.0;

		switch (umaLocacao.getCarro().getCodigoDoPreco()) {
		case Automovel.BASICO: // R$ 90.00 por dia
			valorDaLocacao += umaLocacao.getDiasAlugado() * 90.00;
			break;

		case Automovel.FAMILIA: // R$ 130.00 por dia
			valorDaLocacao += umaLocacao.getDiasAlugado() * 130.00;
			break;

		case Automovel.LUXO: // R$ 200.00 por dia
			valorDaLocacao += umaLocacao.getDiasAlugado() * 200.00;
			if (umaLocacao.getDiasAlugado() > 4) { // desconto de 10%
				valorDaLocacao *= 0.9;
			}
			break;
		}
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
