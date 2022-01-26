import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Principal {

    public static void main(String[] args) {

        final int TAMANHO = 50;
        Random random = new Random(123456);

        OptimalBST arvoreOtima = new OptimalBST();

        List<ChaveEFrequencia> lista = new ArrayList<>();
        for (int i = 0; i < TAMANHO; i++) {
            lista.add(new ChaveEFrequencia(i, 1 + random.nextInt(10)));
        }

        int pesoMinimo =
                arvoreOtima.getPesoArvoreOtima(lista);

        System.out.println(pesoMinimo);
    }
}
