import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalBST {

    Map<ComecoEFim, Integer> memoPesos;
    Map<ComecoEFim, Integer> memoIndicesRaizes;

    public int getPesoArvoreOtima(
            List<ChaveEFrequencia> lista) {

        memoPesos = new HashMap<>();
        memoIndicesRaizes = new HashMap<>();

        Collections.sort(lista);

        return encontrarPesoOtimo(
                lista, 0, lista.size() - 1);
    }

    private int encontrarPesoOtimo(
            List<ChaveEFrequencia> lista, int comeco, int fim) {

        if (comeco > fim) {
            return 0;  // árvore vazia
        }

        if (comeco == fim) {
            return lista.get(comeco).getFrequencia();  // árvore unitária
        }

        ComecoEFim comecoEFim = new ComecoEFim(comeco, fim);

        // verifica se já tem a resposta no memoPesos
        Integer resultadoPreArmazenado = memoPesos.get(comecoEFim);
        if (resultadoPreArmazenado != null) {
            return resultadoPreArmazenado;
        }

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
