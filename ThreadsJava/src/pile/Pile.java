package pile;

public class Pile{
private Object[] tab;private int sommet;
public Pile(int taille){
this.tab = new Object[taille];
this.sommet = -1;
}
 public void empile(Object o) throws IndexOutOfBoundsException {
 if(this.sommet>=this.tab.length-1)throw new IndexOutOfBoundsException("Pile pleine");
 else{
	 this.notify();
 this.tab[this.sommet+1] = o;
this.sommet ++;
 }
 }
 public Object depile() throws IndexOutOfBoundsException {
 if(this.sommet == -1)
	 //this.wait();
 throw new IndexOutOfBoundsException("Pile vide");
 else{
 this.sommet --;
 return this.tab[this.sommet+1];
 }
 }
}

