public class Principal {

    public static void main(String[] args) {
        ArvoreBinaria<Integer> minhaArvore = new ArvoreBinaria<>();

        final NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>(44, null);
        minhaArvore.setRaiz(raiz);

        NoArvoreBinaria<Integer> no = raiz.adicionarFilhoEsquerdo(-12);
        no.adicionarFilhoEsquerdo(-50);
        no.adicionarFilhoDireito(33);

        no = raiz.adicionarFilhoDireito(600);
        no.adicionarFilhoEsquerdo(49);

        no = no.adicionarFilhoDireito(765);
        no.adicionarFilhoDireito(789);

        minhaArvore.printarTodosOsNiveis();


    }
}
