import java.util.LinkedList;

public class ListaEncadeada<T> {

    private int tamanho;

    private No primeiro;
    private No ultimo;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    /**
     * Acrescenta um nó com o valor desejado no final da lista
     *
     * @param valor O valor a ser incluído
     * @return O nó recém-adicionado no final da lista
     */
    public void add(T valor) {
        No novoNo = new No(valor);
        novoNo.anterior = this.ultimo;

        if (this.ultimo != null) {
            this.ultimo.proximo = novoNo;
        }
        this.ultimo = novoNo;

        if (this.primeiro == null) {
            this.primeiro = novoNo;
        }

        this.tamanho++;
    }

    /**
     * Insere um novo valor na lista, na posição (lógica) especificada, começando de 0
     *
     * @param valor O valor desejado
     * @param pos A posição onde será feita a inserção; os elementos a partir desta posição
     *            serão (logicamente) shiftados para a direita
     */
    public void insert(T valor, int pos) {
        No novoNo = new No(valor);

        if (pos == 0) {
            // vamos inserir no começo da lista
            novoNo.proximo = this.primeiro;
            No aux = this.primeiro;
            this.primeiro = novoNo;
            novoNo.proximo = aux;
            aux.anterior = novoNo;
        } else {
            No noCorrente = this.primeiro;
            int cont = 0;
            while (cont < pos - 1) {
                cont++;
                noCorrente = noCorrente.proximo;
            }

            // x (noCorrente) --> y
            // x (noCorrente) -->  z (novoNo) -->  y (noCorrente.proximo)

            novoNo.proximo = noCorrente.proximo;
            novoNo.anterior = noCorrente;
            noCorrente.proximo = novoNo;
            novoNo.proximo.anterior = noCorrente;
        }

        // ToDo: atualizar o campo "ultimo" da lista

        tamanho++;

    }

    public T get(int index) {
        No noCorrente = this.primeiro;
        int pos = 0;
        while (pos < index) {
            noCorrente = noCorrente.proximo;
            pos++;
        }
        return noCorrente.valor;
    }

    public T remove(No noASerRemovido) {
        if (noASerRemovido.lista != this) {
            throw new IllegalArgumentException("Nó não pertence à lista!");
        }

        if (noASerRemovido.anterior != null) {
            noASerRemovido.anterior.proximo = noASerRemovido.proximo;
        } else {
            // era o primeiro da lista;
            this.primeiro = noASerRemovido.proximo;
        }

        if (noASerRemovido.proximo != null) {
            noASerRemovido.proximo.anterior = noASerRemovido.anterior;
        } else {
            // era o último da lista
            this.ultimo = noASerRemovido.anterior;
        }

        // destaca o nó da lista completamente, limpando as referências a outros nós
        noASerRemovido.proximo = null;
        noASerRemovido.anterior = null;

        this.tamanho--;

        return noASerRemovido.valor;
    }

    public T removerDoComeco() {
        return remove(this.primeiro);
    }

    public T removerDoFim() {
        return remove(this.ultimo);
    }

    public T consultarPrimeiro() {
        return this.primeiro.valor;
    }

    public T consultarUltimo() {
        return this.ultimo.valor;
    }

    private No encontrarNo(T valor) {
        No noCorrente = this.primeiro;

        while (noCorrente != null) {
            if (noCorrente.valor.equals(valor)) {
                return noCorrente;
            }
            noCorrente = noCorrente.proximo;
        }

        return null;
    }

    /**
     * Encontra o primeiro nó com o valor desejado, se existir,
     * e o joga para o começo da lista
     *
     * @return true, se encontrou o valor e fez a operação de tornar primeiro;
     *         false, caso contrário
     */
    public boolean tornarPrimeiro(T valor) {
        No no = encontrarNo(valor);

        if (no != null) {
            remove(no);
            insert(valor, 0);
            return true;
        }
        return false;
    }

    public void imprimir() {
        No no = this.primeiro;
        while (no != null) {
            System.out.println(no.valor);
            no = no.proximo;
        }
    }

    public int getTamanho() {
        return this.tamanho;
    }

    private class No {
        private T valor;
        private No anterior;
        private No proximo;
        private ListaEncadeada lista;

        No(T valor) {
            this.valor = valor;
            this.anterior = null;
            this.proximo = null;
            this.lista = ListaEncadeada.this;
        }

        public T getValor() {
            return this.valor;
        }
    }

    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.add(30);
        lista.add(40);
        lista.add(50);
        lista.add(60);

        lista.imprimir();
        System.out.println("\n\n");

        lista.tornarPrimeiro(50);

        lista.imprimir();

        LinkedList<Integer> myList = new LinkedList<>();

        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);

        myList.addFirst(2);

        for (Integer numero : myList) {
            System.out.println(numero);
        }

    }

}
