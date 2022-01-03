import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PilhaTest {

    private Pilha<Integer> pilha;

    @Before
    public void setUp() {
        pilha = new PilhaDeInteirosUsandoArray();
    }

    @Test
    public void testarFuncionamentoBasico() {
        pilha.empilhar(10);
        pilha.empilhar(20);
        pilha.empilhar(30);
        pilha.empilhar(40);

        assertEquals(4, pilha.getTamanho());

        assertEquals(40, (int) pilha.consultarTopo());

        assertEquals(4, pilha.getTamanho());

        assertEquals(40, (int) pilha.desempilhar());

        assertEquals(3, pilha.getTamanho());

        assertEquals(30, (int) pilha.desempilhar());
        assertEquals(20, (int) pilha.desempilhar());
        assertEquals(10, (int) pilha.desempilhar());

        assertEquals(0, pilha.getTamanho());
    }

    @Test
    public void testarMuitosEmpilhamentos() {
        for (int i = 0; i < 1000; i++) {
            pilha.empilhar(i);
        }

        assertEquals(1000, pilha.getTamanho());
    }

    @Test
    public void testarMuitosDesempilhamentos() {
        final int TAMANHO = 200_000;

        long inicio = System.currentTimeMillis();
        for (int i = 0; i < TAMANHO; i++) {
            pilha.empilhar(i);
        }
        long duracao = System.currentTimeMillis() - inicio;
        System.out.printf(
                "\nDuração (n empilhamentos) para pilha de tamanho %d: %.3fs",
                TAMANHO, (duracao / 1000.));

        inicio = System.currentTimeMillis();
        while (pilha.getTamanho() > 0) {
            pilha.desempilhar();
        }
        duracao = System.currentTimeMillis() - inicio;
        System.out.printf(
                "\nDuração (n desempilhamentos) para pilha de tamanho %d: %.3fs",
                TAMANHO, (duracao / 1000.));
    }

}