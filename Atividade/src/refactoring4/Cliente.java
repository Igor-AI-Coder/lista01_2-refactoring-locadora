package refactoring4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * Cliente nao conhece mais Automovel: fala apenas com a interface Alugavel.
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
			resultado += linhaDoExtrato(sequencia, cada, cada.valorDeUmaLocacao());
		}

		return resultado + rodape();
	}

	public String extratoHTML() {
		int sequencia = 0;
		Iterator<Locacao> locacoes = carrosAlugados.iterator();

		String resultado = "<html><body>" + FIM_DE_LINHA;
		resultado += String.format("<H2>Registro de Locacoes de <EM> %s </EM></H2>", getNome()) + FIM_DE_LINHA;
		resultado += "<table border=\"1\"><tr><th>Seq</th><th>Automovel</th><th>Ano</th>"
				+ "<th>Diarias</th><th>Valor</th></tr>" + FIM_DE_LINHA;

		while (locacoes.hasNext()) {
			Locacao cada = locacoes.next();
			sequencia++;
			resultado += String.format(BR,
					"<tr><th>%02d.</th><th>%s</th><th>%4d</th><th>%2d</th><th>R$ %8.2f</th></tr>",
					sequencia,
					cada.getItem().getDescricao(),
					cada.getItem().getAno(),
					cada.getDiasAlugado(),
					cada.valorDeUmaLocacao()) + FIM_DE_LINHA;
		}

		resultado += String.format(BR,
				"<tfoot><tr><td colspan=\"4\">Valor Acumulado em diarias:</td>"
				+ "<td><EM>R$ %8.2f</EM></td></tr></tfoot></table>", getValorTotal()) + FIM_DE_LINHA;
		resultado += "<P>Voce acumulou <EM>" + getPontosTotaisDeAlugadorFrequente()
				+ " pontos </EM> de locador frequente</p></body></html>";
		return resultado;
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
				umaLocacao.getItem().getDescricao(),
				umaLocacao.getItem().getAno(),
				umaLocacao.getDiasAlugado(),
				valorDaLocacao) + FIM_DE_LINHA;
	}

	private String rodape() {
		return "====================================================" + FIM_DE_LINHA
				+ String.format(BR, "Valor Acumulado em diarias............: R$ %8.2f", getValorTotal()) + FIM_DE_LINHA
				+ "Voce acumulou " + getPontosTotaisDeAlugadorFrequente() + " pontos de locador frequente";
	}
}
