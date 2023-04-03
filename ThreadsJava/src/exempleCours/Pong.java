package exempleCours;

public class Pong extends Thread{
	public void run(){
		try{
			while (true){
				System.out.println("Pong");
				sleep((long)(5000*Math.random()));
				}
			}
		catch(InterruptedException e){ return;}
		}

}
