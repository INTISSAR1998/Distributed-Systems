package joinUse;

public class ExampelPartage extends Thread {

    private static String chaineCommune = "";
    private String nom;

    ExampelPartage ( String s ) {
        nom = s;
    }

    public void run() {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        chaineCommune = chaineCommune + nom;
    }

    public static void main(String args[]) {
        Thread T1 = new ExampelPartage( "T1" );
        Thread T2 = new ExampelPartage( "T2" );
        T1.start();
        T2.start();
        try {
			T1.join();
			T2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println( chaineCommune );
    }
}