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
		final String fimDeLinha = System.getProperty("line.separator");
		double valorTotal = 0.0;
		int pontosDeAlugadorFrequente = 0;

		Iterator<Locacao> locacoes = carrosAlugados.iterator();
		String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;

		while(locacoes.hasNext()) {
			double valorCorrente = 0.0;
			Locacao cada = locacoes.next();

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
			// adiciona bonus para locacao de carro de luxo por mais de 2 dias
			if(cada.getCarro().getCodigoDoPreco() == Automovel.LUXO &&
				cada.getDiasAlugado() > 2) {
				pontosDeAlugadorFrequente += 2;
			}

			// mostra valores para esta locacao
			resultado += "\t" + cada.getCarro().getDescricao() + " (" + cada.getCarro().getAno() + ")"
				+ "\t R$ " + String.format(Locale.forLanguageTag("pt-BR"), "%,.2f", valorCorrente) + fimDeLinha;
			valorTotal += valorCorrente;

		} // while

		// adiciona rodape
		resultado += "Valor total pago: R$ "
			+ String.format(Locale.forLanguageTag("pt-BR"), "%,.2f", valorTotal) + fimDeLinha;
		resultado += "Voce acumulou " + pontosDeAlugadorFrequente +
              " pontos de alugador frequente";

		return resultado;
	}

}
