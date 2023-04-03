package timer;

import java.io.IOException;
import java.io.InputStreamReader;


public class Timer extends Thread {
int compteur;
  public Timer() {
  }
  public void run(){
	  while(true){
		  try{sleep((long)1000);compteur++;} 
		  catch(Exception e){}
  }
  }

public static void main(String[] args)
  {
	Timer crono=new Timer();
    crono.start();
    InputStreamReader clavier= new InputStreamReader(System.in);
  try{
	  System.out.println("Taper votre texte");
	  clavier.read();} catch(IOException e){}
  System.out.println("vous avez mis "+crono.compteur+" secondes pour taper votre texte");
  crono.stop();}
}