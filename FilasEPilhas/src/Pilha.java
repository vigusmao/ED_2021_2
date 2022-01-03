public interface Pilha<T> {

    /**
     * Acrescenta um elemento no topo da pilha
     *
     * @param elemento O elemento que será empilhado
     */
    void empilhar(T elemento);

    /**
     * Retorna o elemento que está no topo da pilha, removendo-o
     */
    T desempilhar();

    /**
     * Retorna o elemento que está no topo da pilha, sem removê-lo
     */
    T consultarTopo();

    /**
     * @return a quantidade de elementos na pilha
     */
    int getTamanho();
}
