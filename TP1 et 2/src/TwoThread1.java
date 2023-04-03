public class TwoThread1 extends Thread {
public void run() {
for ( int i = 0; i < 10; i++ ) {
System.out.println("New thread");
}
}
public static void main(String[] args) {
	Thread t=Thread.currentThread();//Ajouter
	t.setPriority(1);//Ajouter pour attribuer la priority 1 au thread main
	////par défaut main priority=5 alors il affiche MainThread puis New THread 10 fois puis 9 fois MainThread
TwoThread1 tt = new TwoThread1();
tt.start();
for ( int i = 0; i < 10; i++ ) {
System.out.println("Main thread");
}
}
}