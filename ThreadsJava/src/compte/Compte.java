package compte;

/**
 * Pour �viter les probl�mes de concurrence,
 * il faut synchroniser non seulement opreationNulle,
 * mais aussi getSolde()
 * pour la derni�re question il faut ajouter synchronized aux m�thodes retirer et ajouter
 */
public class Compte {
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
