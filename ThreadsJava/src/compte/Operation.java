package compte;

public class Operation extends Thread {
	  private CompteInitial compte;

	  public Operation(String nom, CompteInitial compte) {
	    super(nom);
	    this.compte = compte;
	  }

	   public void run() {
	    while (true) {
	      int i = (int) (Math.random() * 10000);
	      String nom = getName();
	      System.out.print(nom);
	      // Pour être sûr de garder la main au cours des 2 opérations,
	      // il faut les synchroniser sur compte
	     /*synchronized(compte) {
		compte.ajouter(i);
		compte.retirer(i);
	      }*/
	      compte.operationNulle(i);
	      int solde = compte.getSolde();
	      System.out.print(nom+ " ");
	      if (solde != 0) {
		System.out.println(nom + ":**solde=" + solde);
		System.exit(1);
	      }
	    }
	  }

	  public static void main(String[] args) {
	    CompteInitial compte = new CompteInitial();
	    for (int i = 0; i < 5; i++) {
	      Operation operation = new Operation("" + (char)('A' + i), compte);
	      operation.start();
	    }
	  }
	}