package tdTakoua;

public class ExempleThread2 extends Thread {
    private static int numThread = 0; // nb de threads crées
    private int numero; // de ce thread
    // constructeur
    ExempleThread2 () {
        numero = numThread;
        numThread = numThread + 1;
        System.out.println("Thread numero " + numero + " cree." );
    }
    public void run() {
        System.out.println("Thread numero " + numero + " demarre." );
         /*try {
             Thread.sleep(1); // ms
         } catch (InterruptedException e) {
             return;
         }*/
        System.out.println("Thread numero " + numero + " termine." );
    }//fin run

    public static void main(String args[]) {
        System.out.println("Programme demarre..");
        // Creation de 5 threads
        for (int i=0; i < 5; i++) {
            Thread unThread = new ExempleThread2();
            unThread.start();
        }
        System.out.println("Programme principal termine.");
    }// fin main
} // fin exempleThread2

