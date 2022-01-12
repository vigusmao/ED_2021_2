public class Principal {

    public static void main(String[] args) {
        ArvoreBinaria<Integer> minhaArvore = new ArvoreBinaria<>();

        final NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>(44, null);
        minhaArvore.setRaiz(raiz);

        NoArvoreBinaria<Integer> noMenos12 = raiz.adicionarFilhoEsquerdo(-12);
        NoArvoreBinaria<Integer> noMenos50 = noMenos12.adicionarFilhoEsquerdo(-50);
        noMenos12.adicionarFilhoDireito(33);
        noMenos50.adicionarFilhoDireito(-40);

        NoArvoreBinaria<Integer> no600 = raiz.adicionarFilhoDireito(490);
        NoArvoreBinaria<Integer> no45 = no600.adicionarFilhoEsquerdo(45);
        no45.adicionarFilhoDireito(500);

        NoArvoreBinaria<Integer> no765 = no600.adicionarFilhoDireito(765);
        no765.adicionarFilhoDireito(789);

//        minhaArvore.printarTodosOsNiveis();

        minhaArvore.encontrarMenorEMaiorDeCadaSubarvore();

        if (minhaArvore.ehArvoreBinariaDeBusca()) {
            System.out.println("\n\nÉ árvore binária de busca!");
        } else {
            System.out.println("\n\nNÃO É árvore binária de busca!!!!");
        }

        System.out.println("\n\n");
        minhaArvore.percorraEmIntraOrdem();

    }
}
