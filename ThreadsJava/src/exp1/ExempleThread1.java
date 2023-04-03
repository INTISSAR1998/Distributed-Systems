package exp1;

public class ExempleThread1 extends Thread {
    
    private String toSay;
    private int toWait;
    private int number;

    public ExempleThread1(String toSay) {
		this.toSay=toSay;
    }

  
    public void run() {
	for (int i =1; i< 10; i++) 
		System.out.print(i + " " + toSay );
    }

    public static void  main(String args[]){
    ExempleThread1 thread1, thread2, thread3;
      thread1=new ExempleThread1("Hello ");
      thread2=new ExempleThread1("World ");
      thread3=new ExempleThread1("and Everybody ");
     
      thread1.start();
      thread2.start();
      thread3.start();
	  /*try {
	  	sleep(100);
      } catch (InterruptedException e) {}*/
      //System.exit(0);
     
  }
  
}
/*Ce programme donne lieu � la cr�ation de 4 threads : le thread principal (qui ex�cute la fonction main), et trois threads  que l'on cr�e explicitement.
 *  Si on l'ex�cute, on pourra observer l'un des affichages suivants :
 Aucun affichage : le thread principal affiche chaineCommune avant que le syst�me n'ai donn� la main aux threads T1 et T2.
T1 : au moment de l'affichage, le thread T1 s'est ex�cut�, mais pas T2.
T2 : idem;
T3
T1T2T3 ou T3T2T1 : les trois ou bien les deux threads se sont ex�cut�s, dans un ordre arbitraire.*/