public class Aluno implements Comparable<Aluno> {

    private long dre;

    private float cra;

    private String nome;


    @Override
    public int compareTo(Aluno outro) {
        return (int) (this.dre - outro.dre);
    }
}
