package exempleCours;

public class CompteBancaire {
	 private  float total;

	  public CompteBancaire(float init){total=init;}

	   public synchronized boolean retrait(float t){
	    if (t<=total)
	      {total -=t;
	         return true;}
	    return false;
	  }
	   public synchronized float getTotal()
	  {
		  return total;
	  }
	}

