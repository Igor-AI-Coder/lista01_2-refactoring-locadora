package refactoring4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Lista 1.2.5 - Cliente conversa apenas com a interface Alugavel.
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
			resultado += "\t" + cada.getItem().getTítulo() + "\t R$ " + cada.valorDeUmAluguel() + fimDeLinha;
		}

		resultado += "Valor total pago: R$ " + getValorTotal() + fimDeLinha;
		resultado += "Voce acumulou " + getPontosTotaisDeAlugadorFrequente()
				+ " pontos de alugador frequente";

		return resultado;
	}

	public String extratoHTML() {
		final String fimDeLinha = System.getProperty("line.separator");
		int sequencia = 0;

		Iterator<Aluguel> alugueis = dvdsAlugados.iterator();
		String resultado = "<html><body>" + fimDeLinha;
		resultado += String.format("<H2>Registro de Alugueis de <EM> %s </EM></H2>", getNome()) + fimDeLinha;
		resultado += "<table border=\"1\"><tr><th>Seq</th><th>DVD</th><th>Diarias</th><th>Valor</th></tr>" + fimDeLinha;

		while (alugueis.hasNext()) {
			Aluguel cada = alugueis.next();
			sequencia++;
			resultado += String.format("<tr><th>%02d.</th><th>%s</th><th>%2d</th><th>R$ %6.2f</th></tr>",
					sequencia, cada.getItem().getTítulo(), cada.getDiasAlugado(), cada.valorDeUmAluguel())
					+ fimDeLinha;
		}

		resultado += String.format(
				"<tfoot><tr><td colspan=\"3\">Valor total pago:</td><td><EM>R$ %6.2f</EM></td></tr></tfoot></table>",
				getValorTotal()) + fimDeLinha;
		resultado += "<P>Voce acumulou <EM>" + getPontosTotaisDeAlugadorFrequente()
				+ " pontos </EM> de alugador frequente</p></body></html>";
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
