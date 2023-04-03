package exempleCours;

public class Retrait extends Thread{

CompteBancaire compt;

  public Retrait(CompteBancaire b, String name)
      {compt=b;
      this.setName(name);}

  public void run()
  {    
	
	while(compt.retrait(100))
  	{ System.out.println(this.getName()+ " a retiré 100 et le reste ="+ compt.getTotal());}
  
 }
  public static void main(String[] args)
  {
	  CompteBancaire cp=new CompteBancaire(400);
	  System.out.println("le solde du compte ="+cp.getTotal());
	  Retrait mari=new Retrait(cp, "mari");
	  Retrait epouse=new Retrait(cp, "épouse");
	  mari.start();
	  epouse.start();
	  
	 
  }

}
