package partie1;

public class PremierEntreEux {
	int pgcd(int m, int n)
	{
		int r;
		while(m%n!=0)
		{
			r=m%n;
			m=n;
			n=r;
		}
		return n;
	}
	boolean premierEntre(int m, int n)
	{
		return pgcd(m,n)==1;
	}
	public static void main(String a[])
	{
		PremierEntreEux p=new PremierEntreEux();
		System.out.println(p.premierEntre(16,8));
	}
}
