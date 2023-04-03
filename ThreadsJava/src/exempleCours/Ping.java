package exempleCours;

class Ping extends Thread{
	public void run(){
		try{
			while (true){
				System.out.println("Ping");
				sleep((long)(500*Math.random()));
				}
			}
		catch(InterruptedException e){ return;}
		}
	}
