public class FilaUsandoListaEncadeada implements Fila {

    private ListaEncadeada<Integer> listaEncadeada;

    public FilaUsandoListaEncadeada() {
        this.listaEncadeada = new ListaEncadeada<>();
    }

    /**
     * Acrescenta um elemento (no caso, um inteiro) no final da fila
     *
     * @param numero O inteiro desejado, que entrará no finaldafila
     */
    public void colocarAtras(int numero) {
        this.listaEncadeada.add(numero);
    }

    /**
     * Retorna o primeiro elemento da fila, que é o mais antigo
     * e, portanto, o próximo a ser tratado
     */
    public int removerDaFrente() {  // pop()
        return this.listaEncadeada.removerDoComeco();
    }

    public int consultarDaFrente() {  // peek()
        return this.listaEncadeada.get(0);
    }

    public int getTamanho() {
        return this.listaEncadeada.getTamanho();
    }
}
