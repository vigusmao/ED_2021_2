import java.util.Objects;

public class ComecoEFim {

    int comeco;
    int fim;

    public ComecoEFim(int comeco, int fim) {
        this.comeco = comeco;
        this.fim = fim;
    }

    public int getComeco() {
        return comeco;
    }

    public int getFim() {
        return fim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComecoEFim that = (ComecoEFim) o;
        return comeco == that.comeco &&
                fim == that.fim;
    }

    @Override
    public int hashCode() {
        return Objects.hash(comeco, fim);
    }
}
