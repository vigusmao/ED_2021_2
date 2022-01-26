public class ArvoreBinaria<T extends Comparable<T>> {

    private NoArvoreBinaria<T> raiz;

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean percorraEmPreOrdem() {
        if (this.raiz != null) {
            return this.raiz.preOrdem();
        }
        return true;
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

    public void encontrarMenorEMaiorDeCadaSubarvore() {
        percorraEmPosOrdem();
    }

    public boolean ehArvoreBinariaDeBusca() {
        encontrarMenorEMaiorDeCadaSubarvore();  // O(n)
        return percorraEmPreOrdem();  // O(n)
    }
}
