package exempleCours;

public class Go {
	public static void main(String args[])
	{
		Ping p1 = new Ping();
		Pong p2 = new Pong();
		p1.start();
		p2.start();
	}
}
