package refactoring2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Lista 1.2.3
 */
public class Cliente {
	private String nome;
	private List<Aluguel> dvdsAlugados = new ArrayList<Aluguel>();

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void adicionaAluguel(Aluguel aluguel) {
		dvdsAlugados.add(aluguel);
	}

	public String extrato() {
		final String fimDeLinha = System.getProperty("line.separator");

		Iterator<Aluguel> alugueis = dvdsAlugados.iterator();
		String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;

		while (alugueis.hasNext()) {
			Aluguel cada = alugueis.next();
			// sem variavel temporaria: o valor vai direto para a linha
			resultado += "\t" + cada.getDVD().getTítulo() + "\t R$ " + cada.valorDeUmAluguel() + fimDeLinha;
		} // while

		resultado += "Valor total pago: R$ " + getValorTotal() + fimDeLinha;
		resultado += "Voce acumulou " + getPontosTotaisDeAlugadorFrequente()
				+ " pontos de alugador frequente";

		return resultado;
	}

	public double getValorTotal() {
		double valorTotal = 0.0;
		for (Aluguel cada : dvdsAlugados) {
			valorTotal += cada.valorDeUmAluguel();
		}
		return valorTotal;
	}

	public int getPontosTotaisDeAlugadorFrequente() {
		int pontos = 0;
		for (Aluguel cada : dvdsAlugados) {
			pontos += cada.getPontosDeAlugadorFrequente();
		}
		return pontos;
	}
}
