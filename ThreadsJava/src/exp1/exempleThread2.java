package exp1;
/* jouer avec les delais et voir que le main se termine en tuant tous les autres */

public class exempleThread2 extends Thread {
    
    private String toSay;
    private int toWait;
    private int number;

    public exempleThread2(int number, String toSay, int toWait) {
	this.toSay=toSay;
	this.toWait= toWait;
    }

  
    public void run() {
	try {
	    sleep(toWait);
	} catch (Exception e) {}	
	System.out.print(toSay);
    }

    public static void  main(String args[]){
      exempleThread2 thread1, thread2, thread3;
      thread1=new exempleThread2(1, "Hello ", 50);
      thread2=new exempleThread2(2, "World ",25);
      thread3=new exempleThread2(3, "and Everybody ",40);
     
      thread1.start();
      thread2.start();
      thread3.start();

      System.exit(0);
     
  }
  
}
