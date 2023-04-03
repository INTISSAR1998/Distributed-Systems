package prodcons;

import java.util.Vector;

                                                   
class Q {
                                                   
int  n=5;
Vector <Integer> sharedVect;
public Q()
{
	sharedVect=new <Integer>Vector();
}
                                                   
boolean valueSet = false;
                                                          
synchronized int get() {
                                                          
       if(sharedVect.isEmpty()){                                           
       try {
    	   System.out.println("Queue is empty " + Thread.currentThread().getName()
                   + " is waiting , size: " + sharedVect.size());                                      
              wait();
              
                                                          
       } catch(InterruptedException e) {
                                                          
       System.out.println("InterruptedException caught");
                                                          
       }
       }
       int x= sharedVect.get(0);                                            
       System.out.println("Got: " +sharedVect.remove(0));//first in first out     
       notify();
     return x;
       }
synchronized void put(int l) {
      if(n==sharedVect.size())
       {
       try {
    	   System.out.println("Queue is full " + Thread.currentThread().getName()
                   + " is waiting , size: " + sharedVect.size());
              wait();
       } catch(InterruptedException e) {
System.out.println("InterruptedException caught");
       }
       }
       sharedVect.add(l);
       valueSet = true;
       System.out.println("Put: " + l);
       notify();
       }
}



class Producer implements Runnable {
Q q;
 Producer(Q q) {
this.q = q;
new Thread(this, "Producer").start();
}
  public void run() {
 int i = 0;
 while(true) {
if(Math.random()>0.8)
try {
              Thread.sleep(4000);
       } catch(InterruptedException e) {
System.out.println("InterruptedException caught1");
       }
 q.put(i++);

}
}
 }
class Consumer implements Runnable {
Q q;
Consumer(Q q) {
this.q = q;
 new Thread(this, "Consumer").start();
 }
  public void run() {
 while(true) {
if(Math.random()>0.8)
try {
              Thread.sleep(5000);
       } catch(InterruptedException e) {
System.out.println("InterruptedException caught1");
       }
q.get();
}
}
 }
 public class ProdCons {
   public static void main(String args[]) {
Q q = new Q();
 new Producer(q);
 new Consumer(q);
   }
 }


