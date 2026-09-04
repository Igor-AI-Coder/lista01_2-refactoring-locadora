//***** Lista 1.2.1 - codigo ORIGINAL (deixe estes 3 imports ativos)
import original.Cliente;
import original.Aluguel;
import original.Automovel;

//***** Lista 1.2.2 - refactoring1 (so o Cliente mudou)
//import refactoring1.Cliente;
//import original.Aluguel;
//import original.Automovel;

//***** Lista 1.2.3 - refactoring2 (Cliente + Aluguel)
//import refactoring2.Cliente;
//import refactoring2.Aluguel;
//import original.Automovel;

//***** Lista 1.2.4 - refactoring3 (Cliente + Aluguel + Automovel)
//import refactoring3.Cliente;
//import refactoring3.Aluguel;
//import refactoring3.Automovel;

//***** Lista 1.2.5 - refactoring4 (interface Alugavel)
//import refactoring4.Cliente;
//import refactoring4.Aluguel;
//import refactoring4.Automovel;

//***** Lista 1.2.6 - refactoring5 (composicao com Classificacao)
//import refactoring5.Cliente;
//import refactoring5.Aluguel;
//import refactoring5.Automovel;

public class Locadora {
	public static void main(String[] args) {
		Cliente c1 = new Cliente("Alex Sandro");

		c1.adicionaAluguel(new Aluguel(new Automovel("Toyota Corolla xEi", "PLN0525", 2021, Automovel.LUXO), 10));
		c1.adicionaAluguel(new Aluguel(new Automovel("Fiat Mobi", "JPA2464", 2021, Automovel.BASICO), 2));
		c1.adicionaAluguel(new Aluguel(new Automovel("BMW Serie 7", "UBA0808", 2022, Automovel.LUXO), 30));
		c1.adicionaAluguel(new Aluguel(new Automovel("Fiat Siena", "ABC0001", 2023, Automovel.FAMILIA), 4));
		c1.adicionaAluguel(new Aluguel(new Automovel("Honda HRV", "KJD9745", 2024, Automovel.FAMILIA), 10));
		c1.adicionaAluguel(new Aluguel(new Automovel("Volkswagen Gol", "JJJ0055", 2024, Automovel.BASICO), 3));

		System.out.println(c1.extrato());
	}
}
