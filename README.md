# RedeNeuralSimples
Classe que implementa uma rede neural simples feita em Java

## Utilização

Basta simplesmente instanciar a classe e utilizar os métodos setDna, recalcularPesos e calcular.

```
RedeNeural redeNeural = new RedeNeural(2, 1, 1, new FuncaoDeAtivacaoReluDX(), new AtivadorMaiorQueZero());
List<Double> pesos = Arrays.asList(5d, 5d, 5d, 5d, 5d);
redeNeural.setDna(pesos);
redeNeural.calcular(Arrays.asList(2d, 2d)).forEach(n -> System.out.println(n.getValor()));
```

### Sugestões de melhorias ou correção de bugs basta entrar em contato.