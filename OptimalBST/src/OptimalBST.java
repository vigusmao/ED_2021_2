import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalBST {

    Map<ComecoEFim, Integer> memoPesos;
    Map<ComecoEFim, Integer> memoIndicesRaizes;

//    public int getPesoArvoreOtima(
//            List<ChaveEFrequencia> lista) {   // Programação Dinâmica clássica (bottom-up)
//
//        memoPesos = new HashMap<>();
//        memoIndicesRaizes = new HashMap<>();
//
//        Collections.sort(lista);
//
//        for (int tamanhoRange = 0; tamanhoRange < lista.size(); tamanhoRange++) {
//
//            for (int comeco = 0; comeco + tamanhoRange < lista.size(); comeco++) {
//                int fim = comeco + tamanhoRange;
//
//                ComecoEFim comecoEFim = new ComecoEFim(comeco, fim);
//
//                if (fim == comeco) {
//                    int pesoOtimo = lista.get(comeco).getFrequencia();
//                    memoPesos.put(comecoEFim, pesoOtimo);
//                } else {
//                    int somaDeTodasAsFrequencias = 0;
//                    for (int i = comeco; i <= fim; i++) {
//                        somaDeTodasAsFrequencias += lista.get(i).getFrequencia();
//                    }
//
//
//                    /** TO DO:  falta terminar aqui!!!!!!!
//                     *          Estamos tentando todas as raízes, mas não estamos retendo
//                     *          a árvore de menor peso!!!!
//                     *          Não estamos retendo a árvore de menor peso!
//                     */
//                    int pesoOtimo = Integer.MAX_VALUE;
//                    Integer indiceRaizOtima = null;
//
//                    for (int indiceRaiz = comeco; indiceRaiz <= fim; indiceRaiz++) {
//
//                        int pesoOtimoAEsquerda = indiceRaiz == comeco
//                                ? 0
//                                : memoPesos.get(new ComecoEFim(comeco, indiceRaiz - 1));
//                        int pesoOtimoADireita = indiceRaiz == fim
//                                ? 0
//                                : memoPesos.get(new ComecoEFim(indiceRaiz + 1, fim));
//                        int pesoTotalComEssaRaiz = pesoOtimoAEsquerda + pesoOtimoADireita +
//                                somaDeTodasAsFrequencias;
//
//                        if (pesoTotalComEssaRaiz < pesoOtimo) {
//                            pesoOtimo = pesoTotalComEssaRaiz;
//                            indiceRaizOtima = indiceRaiz;
//                        }
//                    }
//
//                    memoPesos.put(comecoEFim, pesoOtimo);
//                    memoIndicesRaizes.put(comecoEFim, indiceRaizOtima);
//                }
//            }
//        }
//
//        return memoPesos.get(new ComecoEFim(0, lista.size() - 1));
//
//        /**
//         *       Programação Dinâmica (bottom-up)
//         *
//         *       Exemplo com 4 chaves
//         *
//         *       0..0 -->
//         *       1..1 -->
//         *       2..2 -->
//         *       3..3 -->
//         *
//         *       0..1 -->
//         *       1..2 -->
//         *       2..3 -->
//         *
//         *       0..2 -->
//         *       1..3 -->
//         *
//         *       0..3 --> [ OBJETIVO ]
//         */
//
//
//
////        return encontrarPesoOtimo(
////                lista, 0, lista.size() - 1);
//    }

    public int getPesoArvoreOtima(
            List<ChaveEFrequencia> lista) {

        memoPesos = new HashMap<>();
        memoIndicesRaizes = new HashMap<>();

        return encontrarPesoOtimo(lista, 0, lista.size() - 1);  // chamada original ("top")
    }

    private int encontrarPesoOtimo(
            List<ChaveEFrequencia> lista, int comeco, int fim) {   // P.D. top-down (com memoização)

        if (comeco > fim) {
            return 0;  // árvore vazia
        }

        if (comeco == fim) {
            return lista.get(comeco).getFrequencia();  // árvore unitária
        }

        ComecoEFim comecoEFim = new ComecoEFim(comeco, fim);

//        // verifica se já tem a resposta no memoPesos
//        Integer resultadoPreArmazenado = memoPesos.get(comecoEFim);
//        if (resultadoPreArmazenado != null) {
//            return resultadoPreArmazenado;
//        }

        int somaDeTodasAsFrequencias = 0;
        for (int i = comeco; i <= fim; i++) {
            somaDeTodasAsFrequencias += lista.get(i).getFrequencia();
        }

        int pesoOtimo = Integer.MAX_VALUE;
        Integer indiceRaizOtima = null;

        for (int indiceRaiz = comeco; indiceRaiz <= fim; indiceRaiz++) {
            int peso =
                    encontrarPesoOtimo(lista, comeco, indiceRaiz - 1) +
                    encontrarPesoOtimo(lista, indiceRaiz + 1, fim) +
                    somaDeTodasAsFrequencias;
            if (peso < pesoOtimo) {
                pesoOtimo = peso;
                indiceRaizOtima = indiceRaiz;
            }
        }

        memoPesos.put(comecoEFim, pesoOtimo);
        memoIndicesRaizes.put(comecoEFim, indiceRaizOtima);

        return pesoOtimo;
    }


}
