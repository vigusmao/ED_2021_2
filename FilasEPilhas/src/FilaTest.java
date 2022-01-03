import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilaTest {

    private Fila fila;

    @Before
    public void setUp() {
        fila = new FilaUsandoArray();
    }

    @Test
    public void testarFuncionamentoBasico() {
        fila.colocarAtras(10);
        fila.colocarAtras(20);
        fila.colocarAtras(30);
        fila.colocarAtras(40);

        assertEquals(4, fila.getTamanho());

        assertEquals(10, fila.consultarDaFrente());

        assertEquals(4, fila.getTamanho());

        assertEquals(10, fila.removerDaFrente());

        assertEquals(3, fila.getTamanho());
    }

    @Test
    public void testarMuitasInsercoes() {
        for (int i = 0; i < 1000; i++) {
            fila.colocarAtras(i);
        }

        assertEquals(1000, fila.getTamanho());
    }

    @Test
    public void testarMuitasRemocoes() {
        final int TAMANHO = 200_000;

        long inicio = System.currentTimeMillis();
        for (int i = 0; i < TAMANHO; i++) {
            fila.colocarAtras(i);
        }
        long duracao = System.currentTimeMillis() - inicio;
        System.out.printf(
                "\nDuração (n inserções) para fila de tamanho %d: %.3fs",
                TAMANHO, (duracao / 1000.));

        inicio = System.currentTimeMillis();
        while (fila.getTamanho() > 0) {
            fila.removerDaFrente();
        }
        duracao = System.currentTimeMillis() - inicio;
        System.out.printf(
                "\nDuração (n remoções) para fila de tamanho %d: %.3fs",
                TAMANHO, (duracao / 1000.));
    }
}