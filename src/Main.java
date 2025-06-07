import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String tekst = "AABCCCDDEEEFFFFFFFFFFFFGGG";
        PriorityQueue<Litera> litery = new PriorityQueue<>();
        makePQ(litery,tekst);
        System.out.println(litery);
        makeHuffman(litery);
        travelHuffman(litery.peek(),"");
    }
    static long zlicz(char znak, String tekst){
        return tekst.chars().filter(e -> e == znak).count();
    }
    static void makePQ(PriorityQueue<Litera> pq, String tekst){
        Set<Character> literki = new HashSet<>();
        for (char znak : tekst.toCharArray()) {
            literki.add(znak);
        }
        for(char literka : literki){
            pq.add(new Litera(literka+"",zlicz(literka,tekst)));
        }
    }
    static void makeHuffman(PriorityQueue<Litera> pq){
        while (pq.size() > 1){
            Litera kopia1 = pq.poll();
            Litera kopia2 = pq.poll();
            pq.add(connect(kopia1,kopia2,pq));
            System.out.println(pq);
        }
    }
    static void travelHuffman(Litera l1, String prefix){
        if(l1.left != null){
            travelHuffman(l1.left, prefix+"0");
        }
        if(l1.right != null){
            travelHuffman(l1.right, prefix+"1");
        }
        if (l1.litera.length() == 1){
            System.out.println(l1.litera + ": " + prefix);
        }
    }
    static Litera connect(Litera l1, Litera l2, PriorityQueue<Litera> pq){
        Litera l3 = null;
        if(l1.compareTo(l2) <= 0){
            l3 = new Litera(l1.litera+l2.litera,l1.ilosc+l2.ilosc);
            l3.left = l1;
            l3.right = l2;
        }
        if(l1.compareTo(l2) >= 1){
            l3 = new Litera(l2.litera+l1.litera,l1.ilosc+l2.ilosc);
            l3.left = l2;
            l3.right = l1;
        }
        return l3;
    }
}