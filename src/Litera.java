public class Litera implements Comparable<Litera> {
    public String litera;
    public long ilosc;
    public Litera left;
    public Litera right;

    public Litera(String litera, long ilosc) {
        this.litera = litera;
        this.ilosc = ilosc;
    }

    @Override
    public int compareTo(Litera other) {
        if (this.ilosc == other.ilosc) {
            return this.litera.compareTo(other.litera);
        }
        return Long.compare(this.ilosc, other.ilosc);
    }

    @Override
    public String toString() {
        return litera + ": " + ilosc;
    }
}
