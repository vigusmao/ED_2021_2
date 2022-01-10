public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public void percorraEmPreOrdem() {
        if (this.raiz != null) {
            this.raiz.preOrdem();
        }
    }

    public void percorraEmIntraOrdem() {
        if (this.raiz != null) {
            this.raiz.intraOrdem();
        }
    }

    public void percorraEmPosOrdem() {
        if (this.raiz != null) {
            this.raiz.posOrdem();
        }
    }

    public void printarTodosOsNiveis() {
        percorraEmPreOrdem();
    }
}
