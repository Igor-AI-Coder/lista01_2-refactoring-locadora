package original;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

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
		double valorTotal = 0.0;
		int pontosDeAlugadorFrequente = 0;

		Iterator<Aluguel> alugueis = carrosAlugados.iterator();
		String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;

		while(alugueis.hasNext()) {
			double valorCorrente = 0.0;
			Aluguel cada = alugueis.next();

			// determina valores para cada linha
			switch(cada.getCarro().getCodigoDoPreco()) {
			case Automovel.BASICO: // R$ 90,00 por dia
				valorCorrente += cada.getDiasAlugado() * 90.0;
				break;

			case Automovel.FAMILIA: // R$ 130,00 por dia
				valorCorrente += cada.getDiasAlugado() * 130.0;
				break;

			case Automovel.LUXO: // R$ 200,00 por dia, com 10% de desconto acima de 4 diarias
				valorCorrente += cada.getDiasAlugado() * 200.0;
				if(cada.getDiasAlugado() > 4) {
					valorCorrente -= valorCorrente * 0.1;
				}
				break;
			} //switch

			// trata de pontos de alugador frequente
			pontosDeAlugadorFrequente++;
			// adiciona bonus para aluguel de carro de luxo por mais de 2 dias
			if(cada.getCarro().getCodigoDoPreco() == Automovel.LUXO &&
				cada.getDiasAlugado() > 2) {
				pontosDeAlugadorFrequente += 2;
			}

			// mostra valores para este aluguel
			resultado += "\t" + cada.getCarro().getTitulo() + " (" + cada.getCarro().getAno() + ")"
				+ "\t R$ " + String.format(new Locale("pt", "BR"), "%,.2f", valorCorrente) + fimDeLinha;
			valorTotal += valorCorrente;

		} // while

		// adiciona rodape
		resultado += "Valor total pago: R$ "
			+ String.format(new Locale("pt", "BR"), "%,.2f", valorTotal) + fimDeLinha;
		resultado += "Voce acumulou " + pontosDeAlugadorFrequente +
              " pontos de alugador frequente";

		return resultado;
	}

}
