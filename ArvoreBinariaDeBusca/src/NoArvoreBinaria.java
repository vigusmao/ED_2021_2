public class NoArvoreBinaria<T> {

    private T dado;
    private int nivel;
    private NoArvoreBinaria<T> pai;
    private NoArvoreBinaria<T> esq;
    private NoArvoreBinaria<T> dir;

    public NoArvoreBinaria(T dado, NoArvoreBinaria<T> pai) {
        this.dado = dado;
        this.pai = pai;
        this.esq = null;  // nasce sem filhos
        this.dir = null;  //
    }

    public T getDado() {
        return dado;
    }

    public NoArvoreBinaria<T> getPai() {
        return pai;
    }

    public NoArvoreBinaria<T> getEsq() {
        return esq;
    }

    public NoArvoreBinaria<T> getDir() {
        return dir;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public NoArvoreBinaria<T> adicionarFilhoEsquerdo(T valorFilho) {
        if (this.esq != null) {
            throw new IllegalStateException("Filho esquerdo já existe!!");
        }

        NoArvoreBinaria<T> novoNo = new NoArvoreBinaria<>(
                valorFilho, this);
        this.esq = novoNo;
        return novoNo;
    }

    public NoArvoreBinaria<T> adicionarFilhoDireito(T valorFilho) {
        if (this.dir != null) {
            throw new IllegalStateException("Filho direito já existe!!");
        }

        NoArvoreBinaria<T> novoNo = new NoArvoreBinaria<>(
                valorFilho, this);
        this.dir = novoNo;
        return novoNo;
    }

    public void facaAlgo() {
        setNivel(this.pai != null ? this.pai.getNivel() + 1 : 1);
        System.out.printf("%s --> nível: %d   ", this.dado, this.nivel);
    }

    public void preOrdem() {

        // visita a raiz
        facaAlgo();

        // visita a sub-árvore à esquerda (em pré-ordem!)
        if (this.esq != null) {
            this.esq.preOrdem();
        }

        // visita a sub-árvore à direita (em pré-ordem!)
        if (this.dir != null) {
            this.dir.preOrdem();
        }
    }

    public void intraOrdem() {

        // visita a sub-árvore à esquerda (em pré-ordem!)
        if (this.esq != null) {
            this.esq.intraOrdem();
        }

        // visita a raiz
        facaAlgo();

        // visita a sub-árvore à direita (em pré-ordem!)
        if (this.dir != null) {
            this.dir.intraOrdem();
        }
    }

    public void posOrdem() {

        // visita a sub-árvore à esquerda (em pré-ordem!)
        if (this.esq != null) {
            this.esq.posOrdem();
        }

        // visita a sub-árvore à direita (em pré-ordem!)
        if (this.dir != null) {
            this.dir.posOrdem();
        }

        // visita a raiz
        facaAlgo();
    }
}
