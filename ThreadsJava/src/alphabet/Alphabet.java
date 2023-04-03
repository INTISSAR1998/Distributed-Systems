package alphabet;

public class Alphabet {
    public void affiche() {
        for (char a = 'A'; a <= 'Z'; a++) {
            System.out.print(a);
            try { Thread.sleep(10); // ms
            } catch (InterruptedException e) {}
        }
        System.out.print("\n");
    }
 
    public static void main(String args[]) {
        Alphabet A = new Alphabet();
        A.affiche();
    }
}

