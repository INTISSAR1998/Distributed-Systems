package exp1;
/* rajouter le join dans un cas où 
   le main coupe pour voir que l'on attend bien tous les affichages */

public class exempleThread3 extends Thread {
    
    private String toSay;
    private int toWait;
    private int number;

    public exempleThread3(int number, String toSay, int toWait) {
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
      exempleThread3 thread1, thread2, thread3;
      thread1=new exempleThread3(1, "Hello ", 50);
      thread2=new exempleThread3(2, "World ",25);
      thread3=new exempleThread3(3, "and Everybody ",40);
     
      thread1.start();
      thread2.start();
      thread3.start();

      try {
	  thread1.join();
	  thread2.join();
	  thread3.join();
      } catch (Exception e) {
      }

      

      System.exit(0);
     
  }
  
}
