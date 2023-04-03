class Alphabet implements Runnable {
	public void run(){
	
	
//public void affiche() {
for (char a = 'A'; a <= 'Z'; a++) {
System.out.print(a);
try { Thread.sleep(500); // ms
} catch (InterruptedException e) {}
}
System.out.print("\n");
}
public static void main(String args[]) {
	Alphabet A = new Alphabet();
	Alphabet B = new Alphabet();
        Thread t1=new Thread (A);
        Thread t2=new Thread (B);
        t1.start();
        t2.start();

}
}