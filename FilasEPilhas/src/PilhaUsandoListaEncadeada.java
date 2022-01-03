public class PilhaUsandoListaEncadeada<T> implements Pilha<T> {

    private ListaEncadeada<T> listaEncadeada;

    public PilhaUsandoListaEncadeada() {
        this.listaEncadeada = new ListaEncadeada<>();
    }

    public void empilhar(T numero) {
        this.listaEncadeada.add(numero);
    }

    public T desempilhar() {  // pop()
        return this.listaEncadeada.removerDoFim();
    }

    public T consultarTopo() {  // peek()
        return this.listaEncadeada.consultarUltimo();
    }

    public int getTamanho() {
        return this.listaEncadeada.getTamanho();
    }
}
