package refactoring2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * Lista 1.2.3
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
			// sem variavel temporaria: menos estado intermediario para acompanhar na leitura
			resultado += "\t" + umaLocacao.getCarro().getDescricao() + " (" + umaLocacao.getCarro().getAno() + ")"
					+ "\t R$ " + String.format(Locale.forLanguageTag("pt-BR"), "%,.2f", umaLocacao.valorDeUmaLocacao())
					+ fimDeLinha;
		} // while

		resultado += "Valor total pago: R$ "
				+ String.format(Locale.forLanguageTag("pt-BR"), "%,.2f", getValorTotal()) + fimDeLinha;
		resultado += "Voce acumulou " + getPontosTotaisDeAlugadorFrequente()
				+ " pontos de alugador frequente";

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
