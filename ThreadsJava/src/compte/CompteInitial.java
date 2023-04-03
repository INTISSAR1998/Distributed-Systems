package compte;

public class CompteInitial {
	 private int solde = 0;

	  public synchronized void ajouter(int somme) {
	    solde += somme;
	    System.out.print(" ajoute " + somme);
	  }

	  public synchronized void retirer(int somme) {
	    solde -= somme;
	    System.out.print(" retire " + somme);
	  }

	  public synchronized void operationNulle(int somme) {
	    solde += somme;
	    System.out.print(" ajoute " + somme);
	    solde -= somme;
	    System.out.print(" retire " + somme);
	  }

	  public synchronized int getSolde() {
	    return solde;
	  }
}
