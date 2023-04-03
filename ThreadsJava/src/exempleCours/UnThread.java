package exempleCours;

public class UnThread extends Thread
{
public void run()
{
	long start =System.currentTimeMillis();
//boucle tant que la durée de vie du Thread est < à 5 secondes
while(System.currentTimeMillis()<(start+ (1000*5)))
{
//traitement
System.out.println("Ligne affichée par le thread");
try
{
//pause 
	Thread.sleep(500);
}
catch
(InterruptedException ex)
{}
}
}
public static void main(String args[])
{
	
	//création d'une instance du Thread
	UnThread thread=new UnThread();
	//Activation  du Thread
	thread.start();
	//tant que le thread est en vie...
	while( thread.isAlive())
	{
		//faire un traitement...
		System.out.println("Ligne affichée par le main");
	try
	{
	// et faire une pause
	Thread.sleep(1000);
	}
	catch
	(InterruptedException ex)
	{}
	}
}
}
