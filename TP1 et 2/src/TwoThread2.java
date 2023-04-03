public class TwoThread2 extends Thread {
public void run() {
	Thread t=Thread.currentThread();
	t.setPriority(10);
	for ( int i = 0; i < 10; i++ ) {
	System.out.println("New thread "+t.getName());
}
}
public static void main(String[] args) {
	//Thread t=Thread.currentThread();
	//t.setPriority(1);
	TwoThread2 tt = new TwoThread2();
tt.start();
for ( int i = 0; i < 10; i++ ) {
System.out.println("Main thread");
}
}
}