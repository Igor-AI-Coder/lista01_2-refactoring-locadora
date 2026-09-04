package refactoring5;

/**
 * Prova de que a interface resolveu o problema de extensibilidade:
 * um novo tipo de item alugavel entra no sistema SEM tocar em Locacao,
 * Cliente ou Locadora (Open/Closed).
 *
 * Nao e usado no main para que a saida do exercicio continue identica.
 */
public class AutomovelEletrico implements Alugavel {
	private String descricao;
	private int ano;
	private double tarifaDiaria;

	public AutomovelEletrico(String descricao, int ano, double tarifaDiaria) {
		this.descricao = descricao;
		this.ano = ano;
		this.tarifaDiaria = tarifaDiaria;
	}

	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public int getAno() {
		return ano;
	}

	@Override
	public double getValorDaLocacao(int diasAlugado) {
		return diasAlugado * tarifaDiaria;
	}

	@Override
	public int getPontosDeAlugadorFrequente(int diasAlugado) {
		return diasAlugado > 1 ? 3 : 2; // regra propria de fidelidade
	}
}
