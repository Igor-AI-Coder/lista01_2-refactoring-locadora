//***** Lista 1.2.1 - codigo ORIGINAL (deixe estes 3 imports ativos)
import locadora.Cliente;
import locadora.Aluguel;
import locadora.DVD;

//***** Lista 1.2.2 - refactoring1 (so o Cliente mudou)
//import refactoring1.Cliente;
//import locadora.Aluguel;
//import locadora.DVD;

//***** Lista 1.2.3 - refactoring2 (Cliente + Aluguel)
//import refactoring2.Cliente;
//import refactoring2.Aluguel;
//import locadora.DVD;

//***** Lista 1.2.4 - refactoring3 (Cliente + Aluguel + DVD)
//import refactoring3.Cliente;
//import refactoring3.Aluguel;
//import refactoring3.DVD;

//***** Lista 1.2.5 - refactoring4 (interface Alugavel)
//import refactoring4.Cliente;
//import refactoring4.Aluguel;
//import refactoring4.DVD;

//***** Lista 1.2.6 - refactoring5 (composicao com Classificacao)
//import refactoring5.Cliente;
//import refactoring5.Aluguel;
//import refactoring5.DVD;

public class Locadora {
	public static void main(String[] args) {
		Cliente c1 = new Cliente("Alex Sandro");

		c1.adicionaAluguel(new Aluguel(new DVD("O Atirador", DVD.NORMAL), 10));
		c1.adicionaAluguel(new Aluguel(new DVD("Luca", DVD.INFANTIL), 2));
		c1.adicionaAluguel(new Aluguel(new DVD("O Gato de Botas 2", DVD.LANÇAMENTO), 30));
		c1.adicionaAluguel(new Aluguel(new DVD("Arremessando Alto", DVD.LANÇAMENTO), 4));
		c1.adicionaAluguel(new Aluguel(new DVD("Moana", DVD.INFANTIL), 10));
		c1.adicionaAluguel(new Aluguel(new DVD("Uma Noite no Museu", DVD.NORMAL), 3));

		System.out.println(c1.extrato());
	}
}
