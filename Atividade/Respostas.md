#Respostas escritas

1.2.1

a) Não, ele não está pronto. Pra adicionar um PREMIUM eu teria que criar a constante em Automovel, adicionar mais um case no switch dentro do extrato() e ainda revisar o if dos pontos. São três mudanças em código que já funciona, o que viola o Open/Closed. E é justamente o acoplamento do Cliente com as constantes de Automovel que obriga essas mudanças.

b) Ainda ocorreria problemas, porque o preço está em um método de formatação de string,
na classe errada. Qualquer reajuste obriga a mexer em "Cliente", que não deveria ser alterado por conta de preço.

1.2.3

Refactoring 2.1: Locadora não mudou e Cliente mudou só a linha da chamada. O Expert Information foi atendido, já que a responsabilidade foi pra classe que tem os dados. O acoplamento do Cliente diminuiu porque ele não conhece mais Automovel. A coesão aumentou nas duas: Cliente perdeu uma responsabilidade que não era dele e Locacao deixou de ser só um contêiner sem comportamento.

Refactoring 2.2: Nenhuma outra classe foi alterada, a mudança é interna ao extrato() mesmo.

Refactoring 2.3: A informação pra calcular os pontos está na Locacao (dias) e no Automovel (código do preço, acessível pela locação), então movi o cálculo pra Locacao.getPontosDeAlugadorFrequente(). Ajuda no Expert Information e ainda tira a duplicação do teste == LUXO, que antes aparecia no switch e de novo no cálculo dos pontos. Agora fica em um método só.

Refactoring 2.4: Criei getValorTotal() e getPontosTotaisDeAlugadorFrequente() no Cliente, eliminando as duas variáveis acumuladoras. Ajuda ainda mais na Alta Coesão.

1.2.6

Agora o Open/Closed passou a ser atendido pras classificações: adicionar um PREMIUM cria uma classe nova e uma linha no setCodigoDoPreco(). Ainda sobra um switch dentro do setCodigoDoPreco(), mas ele é de criação e não de cálculo, é a responsabilidade de Creator que ficou com o Automovel. A alta coesão foi levada ao limite, já que cada classificação concreta tem uma única funcionalidade.
