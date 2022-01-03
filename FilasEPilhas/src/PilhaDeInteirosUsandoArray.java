public class PilhaDeInteirosUsandoArray implements Pilha<Integer> {

    private final int TAMANHO_INICIAL_DEFAULT = 10;

    private int[] arrayInterno;

    private int tamanhoLogico;

    public PilhaDeInteirosUsandoArray() {
        this.arrayInterno = new int[TAMANHO_INICIAL_DEFAULT];
        this.tamanhoLogico = 0;
    }

    public void empilhar(Integer numero) {
        if (this.arrayInterno.length == this.tamanhoLogico) {
            // overflow --- precisamos de um array maior
            int[] novoArrayInterno = new int[2 * this.arrayInterno.length];
            for (int i = 0; i < this.arrayInterno.length; i++) {
                novoArrayInterno[i] = this.arrayInterno[i];
            }
            this.arrayInterno = novoArrayInterno;
        }
        this.arrayInterno[this.tamanhoLogico++] = numero;
    }

    public Integer desempilhar() {
        return this.arrayInterno[--this.tamanhoLogico];
    }

    public Integer consultarTopo() {  // peek()
        if (this.tamanhoLogico == 0) {
            // underflow
            throw new RuntimeException("Underflow!!");
        }
        return this.arrayInterno[this.tamanhoLogico - 1];
    }

    public int getTamanho() {
        return this.tamanhoLogico;
    }


}