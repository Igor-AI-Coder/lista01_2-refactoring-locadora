package refactoring4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * Lista 1.2.5 - Cliente conversa apenas com a interface Alugavel.
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

		Iterator<Locacao> locacoes = carrosAlugados.iterator();
		String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;

		while (locacoes.hasNext()) {
			Locacao umaLocacao = locacoes.next();
			resultado += "\t" + umaLocacao.getItem().getDescricao() + " (" + umaLocacao.getItem().getAno() + ")"
					+ "\t R$ " + String.format(Locale.forLanguageTag("pt-BR"), "%,.2f", umaLocacao.valorDeUmaLocacao())
					+ fimDeLinha;
		}

		resultado += "Valor total pago: R$ "
				+ String.format(Locale.forLanguageTag("pt-BR"), "%,.2f", getValorTotal()) + fimDeLinha;
		resultado += "Voce acumulou " + getPontosTotaisDeAlugadorFrequente()
				+ " pontos de alugador frequente";

		return resultado;
	}

	public String extratoHTML() {
		final String fimDeLinha = System.getProperty("line.separator");
		int sequencia = 0;

		Iterator<Locacao> locacoes = carrosAlugados.iterator();
		String resultado = "<html><body>" + fimDeLinha;
		resultado += String.format("<H2>Registro de Alugueis de <EM> %s </EM></H2>", getNome()) + fimDeLinha;
		resultado += "<table border=\"1\"><tr><th>Seq</th><th>Veiculo</th><th>Diarias</th><th>Valor</th></tr>"
				+ fimDeLinha;

		while (locacoes.hasNext()) {
			Locacao umaLocacao = locacoes.next();
			sequencia++;
			resultado += String.format(Locale.forLanguageTag("pt-BR"),
					"<tr><th>%02d.</th><th>%s</th><th>%2d</th><th>R$ %,.2f</th></tr>",
					sequencia, umaLocacao.getItem().getDescricao(), umaLocacao.getDiasAlugado(),
					umaLocacao.valorDeUmaLocacao()) + fimDeLinha;
		}

		resultado += String.format(Locale.forLanguageTag("pt-BR"),
				"<tfoot><tr><td colspan=\"3\">Valor total pago:</td><td><EM>R$ %,.2f</EM></td></tr></tfoot></table>",
				getValorTotal()) + fimDeLinha;
		resultado += "<P>Voce acumulou <EM>" + getPontosTotaisDeAlugadorFrequente()
				+ " pontos </EM> de alugador frequente</p></body></html>";
		return resultado;
	}

	public double getValorTotal() {
		double valorTotal = 0.0;
		for (Locacao umaLocacao : carrosAlugados) {
			valorTotal += umaLocacao.valorDeUmaLocacao();
		}
		return valorTotal;
	}

	public int getPontosTotaisDeAlugadorFrequente() {
		int pontos = 0;
		for (Locacao umaLocacao : carrosAlugados) {
			pontos += umaLocacao.getPontosDeAlugadorFrequente();
		}
		return pontos;
	}
}
