package pile;

public class Depileur extends Thread{
private Pile p;
public Depileur(Pile p){
super();
this.p = p;
}
public void run(){
try{
while(true){
System.out.println(p.depile());
Thread.sleep(10);
}
}
catch(IndexOutOfBoundsException e){System.out.println(e.getMessage());}
catch(InterruptedException e){System.out.println(e.getMessage());}
}
public static void main(String ar[]){
Pile p = new Pile(10);
for(int i = 0;i<10;i++) 
p.empile(new Integer(i));
Depileur d1 = new Depileur(p);
Depileur d2 = new Depileur(p);
d1.start();
d2.start();
 }
}
