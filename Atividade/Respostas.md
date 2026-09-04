#Respostas escritas

1.2.1

a) Não, ele não está pronto devido ao alto acoplamento no Cliente,
e ele está com uma baixa coesão também. Deveria ser alterado a classe DVD o que viola o princípio de Open/Closed.

b) Ainda ocorreria problemas, porque o preço está em um método de formatação de string,
na classe errada. Qualquer reajuste obriga a mexer em "Cliente", que não deveria ser alterado por conta de preço.

1.2.3

Refactoring 2.1: `Locadora` não mudou e `Cliente` mudou apenas a linha da chamada. O que faz com que o Expert Information seja atendido já que a responsabilidade foi designada para quem tem acesso aos dados, e a coesão foi aumentada já que cliente deixa de conhecer tanto de Aluguel.

Refactoring 2.2: Nenhuma outra classe foi alterada então o princípio de alta coesão foi atingido, e os retornos continuam os mesmos.

Refactoring 2.3: A informação para calcular os pontos está no `Aluguel` (dias) e no `DVD` (código do
  preço, acessível pelo aluguel), então movi o cálculo para `Aluguel.getPontosDeAlugadorFrequente()`.
  Que acaba por ajudar no princípio de expert information também, que agora o LANÇAMENTO fica em um método só.

Refactoring 2.4: Criei `getValorTotal()` e `getPontosTotaisDeAlugadorFrequente()` em `Cliente`,
  eliminando as duas variáveis acumuladoras. O que ajuda ainda mais no princípio de Alta Coesão

1.2.6

Agora o open closed principal ainda continua violado, mas é por padrão do método creator, e a alta coesão foi levada ao limite já que todas as classes concretas tem uma única funcionalidade.
