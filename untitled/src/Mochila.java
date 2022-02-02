import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Mochila {

    private static Map<IdInstancia, Integer> memo;

    private static int totalChamadas;
    /**
     * Entrada: uma lista L de n itens,
     *          cada qual com um VALOR (V) e um PESO (P) inteiros,
     *          e também um inteiro w indicando o peso máximo
     *          suportado pela mochila.
     *
     * Saída: um subconjunto de itens da lista que possua
     *        a máxima soma de VALORes, dentre aqueles sub-
     *        conjuntos cuja soma de PESOs não excede w.
     *
     * Ex.: L = [ 0: (V=100, P=5),
     *            1: (V=500, P=7),
     *            2: (V=450, P=4) ]
     *      w = 10
     *
     *      Solução ótima:
     *          {}      --> valor 0,    peso 0
     *          {0}     --> valor 100,  peso 5
     *          {1}     --> valor 500,  peso 7
     *          {2}     --> valor 450,  peso 4
     *          {0,1}   --> valor 600,  peso 12 (INVIÁVEL!)
     *          {0,2}   --> valor 550,  peso 9 (ÓTIMO!)
     *          {1,2}   --> valor 950,  peso 11 (INVIÁVEL!)
     *          {0,1,2} --> valor 1050, peso 16 (INVIÁVEL!)
     *
     *
     *      Técnica do dividir-e-conquistar:
     *
     *      recebo a lista L, com índice inicial COMEÇO
     *
     *      Pergunta: devo levar o "primeiro item",
     *                ou seja, o item de índice COMEÇO???
     *      Como saber?
     *
     *      Se LEVAR o item de índice COMEÇO, o que eu terei?
     *      --> Cabe o item de índice COMEÇO?
     *          Se couber, então levando-o eu terei
     *          VALOR(COMEÇO) +
     *          solução do problema MOCHILA
     *          para uma mochila de peso máximo
     *          igual a w - PESO(COMEÇO),
     *          e itens começando em COMEÇO + 1.
     *          Se não couber, então essa opção me dá valor 0.
     *
     *      Se eu NÃO LEVAR o item de índice COMEÇO, o que eu terei?
     *      --> solução do problema MOCHILA
     *          para uma mochila de peso máximo
     *          igual a w,
     *          e itens começando em COMEÇO + 1
     *
     *      Agora escolhe a opção de maior valor, se é COM ou SEM
     *      o item de índice 0.
     *
     *
     *   Vamos aplicar a técnica do dividir-e-conquistar
     *   desenhada acima, de forma BOTTOM-UP, para resolver
     *   o exemplo anterior.
     *
     *   Ex.: L = [     0: (V=100, P=5),
     *                  1: (V=500, P=7),
     *                  2: (V=450, P=4) ]
     *            w = 10
     *
     *
     *          COMEÇO  0             1             2
     *   W
     *
     *   0              0             0             0
     *   1              0             0             0
     *   2              0             0             0
     *   3              0             0             0
     *   4              450           450           450
     *   5              450           450           450
     *   6              500           500           450
     *   7              500           500           450
     *   8              500           500           450
     *   9              550           500           450
     *  10              550           500           450
     *
     *  Tamanho da tabela = n * (w+1)      complexidade O(nw)
     */

    public static int resolverMochila(List<ValorEPeso> itens,
                                      int w) {
        memo = new HashMap<>();
        totalChamadas = 0;

        // dispara a chamada inicial à função recursiva ("top")
        int resultado =
                getValorMochilaOtima(itens, w, 0);

        System.out.println(totalChamadas);

        return resultado;
    }

    // essa será nossa função recursiva
    private static int getValorMochilaOtima(List<ValorEPeso> itens,
                                            int capacidade,
                                            int indiceComeco) {
        totalChamadas++;

        // condições iniciais: retorna direto, sem qualquer recursão
        if (indiceComeco >= itens.size()) {
            return 0;
        }

        // objeto que identifica a instância deste (sub-)problema
        IdInstancia idInstancia = new IdInstancia(capacidade, indiceComeco);

        // MEMOIZAÇÃO, PASSO 1: verificar se já existe a resposta
        Integer resultadoArmazenado = memo.get(idInstancia);
        if (resultadoArmazenado != null) {
            return resultadoArmazenado;
        }

        final ValorEPeso primeiroItemConsiderado =
                itens.get(indiceComeco);

        int pesoDoPrimeiroItem = primeiroItemConsiderado.getPeso();
        int valorDoPrimeiroItem = primeiroItemConsiderado.getValor();

        int valorLevandoOPrimeiroItem =
                pesoDoPrimeiroItem <= capacidade
                        ? valorDoPrimeiroItem +
                                getValorMochilaOtima(
                                    itens,
                                    capacidade - pesoDoPrimeiroItem,
                                    indiceComeco + 1)
                        : 0;

        int valorNaoLevandoOPrimeiroitem =
                getValorMochilaOtima(
                        itens,
                        capacidade,
                        indiceComeco + 1);

        int resultado = Math.max(
                valorLevandoOPrimeiroItem,
                valorNaoLevandoOPrimeiroitem);

        // MEMOIZAÇÃO, passo 2: armazene o resultado que vc
        //                      acabou de calcular!
        memo.put(idInstancia, resultado);

        return resultado;
    }

    /**
     *       Ex.: L = [ 0: (V=100, P=5),
     *                  1: (V=500, P=7),
     *                  2: (V=450, P=4) ]
     *            w = 10
     *
     *
     *            top-down
     *                      0,10
     *              1,5             1,10
     *             2,5            2,3   2,10
     *
     *
     *
     *
     *
     */

    private static class IdInstancia {
        int capacidade;
        int indiceInicial;

        public IdInstancia(int capacidade, int indiceInicial) {
            this.capacidade = capacidade;
            this.indiceInicial = indiceInicial;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IdInstancia that = (IdInstancia) o;
            return capacidade == that.capacidade &&
                    indiceInicial == that.indiceInicial;
        }

        @Override
        public int hashCode() {
            return Objects.hash(capacidade, indiceInicial);
        }
    }
}
