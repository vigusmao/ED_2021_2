import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        List<ValorEPeso> itens = new ArrayList<>();

        /*
         * Ex.: L = [     0: (V=100, P=5),
         *      *         1: (V=500, P=7),
         *      *         2: (V=450, P=4) ]
         *      *            w = 10
         */

        for (int i = 0; i < 216; i++) {
            itens.add(new ValorEPeso(100, 2));
        }

        long inicio = System.currentTimeMillis();
        System.out.println(
                Mochila.resolverMochila(
                    itens, 100));
        long duracao = System.currentTimeMillis() - inicio;
        System.out.printf("\nDuração = %d milissegundos", duracao);
    }
}
