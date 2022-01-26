public class ChaveEFrequencia implements Comparable<ChaveEFrequencia> {

    private int chave;
    private int frequencia;

    public ChaveEFrequencia(int chave, int frequencia) {
        this.chave = chave;
        this.frequencia = frequencia;
    }

    public int getChave() {
        return chave;
    }

    public int getFrequencia() {
        return frequencia;
    }

    @Override
    public int compareTo(ChaveEFrequencia o) {
        return this.chave - o.chave;
    }

    @Override
    public String toString() {
        return "(chave=" + chave +
                ", frequencia=" + frequencia +
                ')';
    }
}
