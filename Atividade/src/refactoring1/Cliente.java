package refactoring1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import locadora.Aluguel;
import locadora.DVD;

/**
 * Lista 1.2.2
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
		double valorTotal = 0.0;
		int pontosDeAlugadorFrequente = 0;

		Iterator<Aluguel> alugueis = dvdsAlugados.iterator();
		String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;

		while (alugueis.hasNext()) {
			Aluguel cada = alugueis.next();

			double valorCorrente = valorDeUmAluguel(cada);
			pontosDeAlugadorFrequente += pontosDeUmAluguel(cada);

			resultado += "\t" + cada.getDVD().getTítulo() + "\t R$ " + valorCorrente + fimDeLinha;
			valorTotal += valorCorrente;
		} // while

		resultado += "Valor total pago: R$ " + valorTotal + fimDeLinha;
		resultado += "Voce acumulou " + pontosDeAlugadorFrequente + " pontos de alugador frequente";

		return resultado;
	}

	private double valorDeUmAluguel(Aluguel umAluguel) {
		double valorDoAluguel = 0.0;

		switch (umAluguel.getDVD().getCódigoDePreço()) {
		case DVD.NORMAL: // R$ 2.00 por 2 dias; dia adicional + R$ 1.50
			valorDoAluguel += 2.0;
			if (umAluguel.getDiasAlugado() > 2) {
				valorDoAluguel += (umAluguel.getDiasAlugado() - 2) * 1.5;
			}
			break;

		case DVD.LANÇAMENTO: // R$ 3.00 por dia
			valorDoAluguel += umAluguel.getDiasAlugado() * 3.00;
			break;

		case DVD.INFANTIL: // R$ 1.50 por 3 dias; dia adicional + R$ 1.50
			valorDoAluguel += 1.5;
			if (umAluguel.getDiasAlugado() > 3) {
				valorDoAluguel += (umAluguel.getDiasAlugado() - 3) * 1.5;
			}
			break;
		} // switch

		return valorDoAluguel;
	}

	private int pontosDeUmAluguel(Aluguel umAluguel) {
		int pontos = 1;
		if (umAluguel.getDVD().getCódigoDePreço() == DVD.LANÇAMENTO
				&& umAluguel.getDiasAlugado() > 1) {
			pontos++;
		}
		return pontos;
	}
}
