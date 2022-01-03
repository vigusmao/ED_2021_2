public class FilaUsandoArrayDeFormaCircular implements Fila {

    private final int TAMANHO_INICIAL_DEFAULT = 10;

    private int[] arrayInterno;

    private int posPrimeiro;  // head  (posiçãodo primeiro elemento)
    private int posUltimo;   // tail

    private int tamanhoLogico;

    public FilaUsandoArrayDeFormaCircular(int capacidadeInicial) {
        inicializar(capacidadeInicial);
    }

    public FilaUsandoArrayDeFormaCircular() {
        inicializar(TAMANHO_INICIAL_DEFAULT);
    }

    private void inicializar(int capacidadeInicial) {
        this.arrayInterno = new int[capacidadeInicial];
        this.tamanhoLogico = 0;
        this.posPrimeiro = -1;
        this.posUltimo = -1;
    }

    /**
     * Acrescenta um elemento (no caso, um inteiro) no final da fila
     *
     * @param numero O inteiro desejado, que entrará no finaldafila
     */
    public void colocarAtras(int numero) {

        if (this.arrayInterno.length == this.tamanhoLogico) {
            // overflow --- precisamos de um array maior
            int[] novoArrayInterno = new int[2 * this.arrayInterno.length];
            int contCopiados = 0;
            for (int i = this.posPrimeiro; i != this.posUltimo;
                 i = (i + 1) % this.arrayInterno.length) {
                novoArrayInterno[contCopiados++] = this.arrayInterno[i];
            }
            novoArrayInterno[contCopiados++] = this.arrayInterno[this.posUltimo];

            this.arrayInterno = novoArrayInterno;

            this.posPrimeiro = 0;
            this.posUltimo = contCopiados - 1;
        }

        this.posUltimo = (this.posUltimo + 1) % this.arrayInterno.length;
        this.arrayInterno[this.posUltimo] = numero;
        if (tamanhoLogico == 0) {  // acabamos de inserir o primeiro elemento
            this.posPrimeiro = this.posUltimo;
        }
        this.tamanhoLogico++;
    }

    /**
     * Retorna o primeiro elemento da fila, que é o mais antigo
     * e, portanto, o próximo a ser tratado
     */
    public int removerDaFrente() {  // pop()
        if (this.tamanhoLogico == 0) {
            // underflow
            throw new RuntimeException("Underflow!!");
        }
        int primeiro = this.arrayInterno[this.posPrimeiro++];

        this.tamanhoLogico--;

        return primeiro;
    }

    public int consultarDaFrente() {  // peek()
        if (this.tamanhoLogico == 0) {
            // underflow
            throw new RuntimeException("Underflow!!");
        }
        return this.arrayInterno[this.posPrimeiro];
    }

    public int getTamanho() {
        return this.tamanhoLogico;
    }

    /*
        Tamanho inicial do array = 1
        Crescimento em P.G. (com razão 2)

      #inserção        esforço            tamanho (depois)
             1   ----      1      ----       1
             2   ----  1 + 1      ----       2
             3   ----  2 + 1      ----       4
             4   ----      1      ----       4
             5   ----  4 + 1      ----       8
             6   ----      1      ----       8
             7   ----      1                 8
             8   ----      1                 8
             9   ----  8 + 1                 8
            10   ----      1
           ....         ...
         n = 2^k ----      1

         Esforço total = n + (1+2+4+8+16+...+2^(k-1))
                       = n + (2^k - 1)
                       = n +   n  - 1
                       = 2n - 1 = O(n)

         Esforço médio (por inserção) = O(n) / n = O(1)


         -----------------------------------


         Tamanho inicial do array = 1
        Crescimento em P.A. (com razão 10)

      #inserção        esforço            tamanho (depois)
             1   ----      1      ----       10
             2   ----      1      ----       10
             3   ----      1      ----       10
             4   ----      1      ----       10
           ...                              ...
            10   ----      1      ----       10
            11   ---  10 + 1      ----       20
            12             1                 20
            13             1                 20
           ...
            20             1                 20
            21        20 + 1                 30
            22             1                 30
          ...
         n=10k                          o menor múltiplo de 10
                                          que é <= n

         Esforço total = n + (10+20+30+40+50+...+ 10k)
                       = n + (10 + 10k).k/2 =
                       = n +  5k^2 + 5k =
                       = n + 5(n/10)^2 + 5(n/10)
                       = n + n^2/20 + n/2 =
                       = 0.05n^2 + 1.5n = O(n^2)

         Esforço médio (por inserção) = O(n^2) / n = O(n)
     */
}