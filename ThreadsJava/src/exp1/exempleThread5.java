package exp1;


/* montrer d'autres incohérences : 
   manipulation variable partagée 
   on peu provoquer le problème : en deux etapes temp = solde, yield, solde = solde +/- montant
*/

/* partagée */
class Tableau {
    public double tab[];
    Tableau() {
    	tab=new double[100]; 
    	for (int i = 0; i< 100; i++)
    		tab[i]=0;
    	}
    
    synchronized void incTab() {
    for (int i = 0; i< 100; i++)
    		tab[i]=tab[i]+10.0;
    }
    
    synchronized void decTab() {
    for (int i = 0; i< 100; i++)
    		tab[i]=tab[i]-10.0;
    }
    
    
    void printTab() {for (int i = 0; i< 100; i++)
    		System.out.println("tab["+ i + "] =" +tab[i]);
	}
}
/**
 * Thread qui depose
 */
class ThreadDeposer extends Thread {
    private int number;
    private Tableau t;

    public ThreadDeposer(int number, Tableau i) {
	this.number = number;
	t=i;
    }

    public void run() {
	for (int j = 0; j <10000; j++) {
		t.incTab();
    }
}
}
/**
 * Thread qui retire
 */
class ThreadRetirer extends Thread {
    private int number;
    private Tableau t;

    public ThreadRetirer(int number, Tableau i) {
	this.number = number;
	t=i;
    }

    public void run() {
	for (int j = 0; j <10000; j++)
	   t.decTab();
    }
}

/*main*/
public class exempleThread5  {        
   

    public static void  main(String args[]){
	ThreadDeposer threadsD[] = new ThreadDeposer[100];
	ThreadRetirer threadsR[] = new ThreadRetirer[100];
      
	Tableau t = new Tableau();


	for (int j = 0; j < 100; j++) {
	    threadsD[j]=new ThreadDeposer(j, t);	    
	    threadsR[j]=new ThreadRetirer(j, t);	    
	}

	for (int j = 0; j < 100; j++) {
	    threadsD[j].start();
	    threadsR[j].start();
	}
      
      try {
	  for (int j = 0; j < 100; j++) {
	      threadsD[j].join();
	      threadsR[j].join();
	  }
      } catch (Exception e ) {
      }

      t.printTab();
      System.exit(0);
      
     
  }
  
}
