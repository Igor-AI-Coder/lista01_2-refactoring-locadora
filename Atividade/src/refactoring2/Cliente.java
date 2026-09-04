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

		Iterator<Aluguel> alugueis = carrosAlugados.iterator();
		String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;

		while (alugueis.hasNext()) {
			Aluguel umaLocacao = alugueis.next();
			// sem variavel temporaria: o valor vai direto para a linha
			resultado += "\t" + umaLocacao.getCarro().getTitulo() + " (" + umaLocacao.getCarro().getAno() + ")"
					+ "\t R$ " + String.format(new Locale("pt", "BR"), "%,.2f", umaLocacao.valorDeUmAluguel())
					+ fimDeLinha;
		} // while

		resultado += "Valor total pago: R$ "
				+ String.format(new Locale("pt", "BR"), "%,.2f", getValorTotal()) + fimDeLinha;
		resultado += "Voce acumulou " + getPontosTotaisDeAlugadorFrequente()
				+ " pontos de alugador frequente";

		return resultado;
	}

	public double getValorTotal() {
		double valorTotal = 0.0;
		for (Aluguel umaLocacao : carrosAlugados) {
			valorTotal += umaLocacao.valorDeUmAluguel();
		}
		return valorTotal;
	}

	public int getPontosTotaisDeAlugadorFrequente() {
		int pontos = 0;
		for (Aluguel umaLocacao : carrosAlugados) {
			pontos += umaLocacao.getPontosDeAlugadorFrequente();
		}
		return pontos;
	}
}
