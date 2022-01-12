public class NoArvoreBinaria<T extends Comparable<T>> {

    private T dado;
    private int nivel;
    private NoArvoreBinaria<T> pai;
    private NoArvoreBinaria<T> esq;
    private NoArvoreBinaria<T> dir;
    private T menorElemento;  // o menor elemento na sub-árvore cuja raiz é este nó (this)
    private T maiorElemento;  // o maior elemento na sub-árvore cuja raiz é este nó (this)


    public NoArvoreBinaria(T dado, NoArvoreBinaria<T> pai) {
        this.dado = dado;
        this.pai = pai;
        this.esq = null;  // nasce sem filhos
        this.dir = null;  //
        this.menorElemento = this.dado;
        this.maiorElemento = this.dado;
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

    public T getMenorElemento() {
        return menorElemento;
    }

    public T getMaiorElemento() {
        return maiorElemento;
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

    public void encontrarMenorEMaiorElementoNaSubarvore() {
        if (this.esq != null) {
            if (menorElemento.compareTo(this.esq.getMenorElemento()) > 0) {
                menorElemento = this.esq.getMenorElemento();
            }
            if (maiorElemento.compareTo(this.esq.getMaiorElemento()) < 0) {
                maiorElemento = this.esq.getMaiorElemento();
            }
        }
        if (this.dir != null) {
            if (menorElemento.compareTo(this.dir.getMenorElemento()) > 0) {
                menorElemento = this.dir.getMenorElemento();
            }
            if (maiorElemento.compareTo(this.dir.getMaiorElemento()) < 0) {
                maiorElemento = this.dir.getMaiorElemento();
            }
        }
        System.out.printf(
                "\n\nNó: %s (menor nesta subárvore: %s, maior nesta subárvore: %s)",
                this.dado, this.menorElemento, this.maiorElemento);
    }

    public void determinarNivel() {
        setNivel(this.pai != null ? this.pai.getNivel() + 1 : 1);
        System.out.printf("%s --> nível: %d   ", this.dado, this.nivel);
    }

    public boolean verificaPropriedadeArvoreBinariaDeBusca() {
        if (this.esq != null) {
            if (this.esq.getMaiorElemento().compareTo(this.dado) > 0) {
                System.out.printf("\n%s > %s", this.esq.getMaiorElemento(), this.dado);
                return false;  // todos à minha esquerda devem ser menores do que eu!
            }
        }
        if (this.dir != null) {
            if (this.dir.getMenorElemento().compareTo(this.dado) < 0) {
                System.out.printf("\n%s < %s", this.dir.getMaiorElemento(), this.dado);
                return false;  // todos à minha direita devem ser maiores do que eu!
            }
        }
        return true;
    }

    public boolean preOrdem() {

        // visita a raiz                                        //
        if (!verificaPropriedadeArvoreBinariaDeBusca()) {       // O(1)
            return false;                                       //
        }                                                       //

        // visita a sub-árvore à esquerda (em pré-ordem!)
        if (this.esq != null) {
            if (!this.esq.preOrdem()) {
                return false;
            }
        }

        // visita a sub-árvore à direita (em pré-ordem!)
        if (this.dir != null) {
            if (!this.dir.preOrdem()) {
                return false;
            }
        }

        return true;
    }

    public void intraOrdem() {

        // visita a sub-árvore à esquerda (em intra-ordem!)
        if (this.esq != null) {
            this.esq.intraOrdem();
        }

        // visita a raiz
        System.out.printf("%s ", this.dado);

        // visita a sub-árvore à direita (em intra-ordem!)
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
        encontrarMenorEMaiorElementoNaSubarvore();
    }
}
