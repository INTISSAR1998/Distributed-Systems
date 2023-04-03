package alphabet;

public class AlphabetThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (char a = 'A'; a <= 'Z'; a++) {
            System.out.print(a);
            try { Thread.sleep(500); // ms
            } catch (InterruptedException e) {}
        }
        System.out.print("\n");
	}
	 public static void main(String args[]) {
		 AlphabetThread A = new AlphabetThread();
		 AlphabetThread B = new AlphabetThread();
	        Thread t1=new Thread (A);
	        Thread t2=new Thread (B);
	        t1.start();
	        t2.start();
	    }
}
