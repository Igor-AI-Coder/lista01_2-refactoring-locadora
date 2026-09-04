package refactoring2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * Lista 1.2.3 - refactoring2-2 e refactoring2-4
 *
 * Cliente nao calcula mais preco nem pontos: DELEGA para Locacao.
 * As variaveis temporarias valorCorrente, valorTotal e pontosDeAlugadorFrequente
 * sairam do laco e viraram metodos reutilizaveis.
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
		int sequencia = 0;
		Iterator<Locacao> locacoes = carrosAlugados.iterator();
		String resultado = cabecalho();

		while (locacoes.hasNext()) {
			Locacao cada = locacoes.next();
			sequencia++;
			// sem variavel temporaria: o valor vai direto para a linha
			resultado += linhaDoExtrato(sequencia, cada, cada.valorDeUmaLocacao());
		}

		return resultado + rodape();
	}

	public double getValorTotal() {
		double valorTotal = 0.0;
		for (Locacao cada : carrosAlugados) {
			valorTotal += cada.valorDeUmaLocacao();
		}
		return valorTotal;
	}

	public int getPontosTotaisDeAlugadorFrequente() {
		int pontos = 0;
		for (Locacao cada : carrosAlugados) {
			pontos += cada.getPontosDeAlugadorFrequente();
		}
		return pontos;
	}

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

	private String rodape() {
		return "====================================================" + FIM_DE_LINHA
				+ String.format(BR, "Valor Acumulado em diarias............: R$ %8.2f", getValorTotal()) + FIM_DE_LINHA
				+ "Voce acumulou " + getPontosTotaisDeAlugadorFrequente() + " pontos de locador frequente";
	}
}
