package exempleCours;


public class GetCurrentThread {
	 
    public static void main(String[] args) {
           
            /*
             * To get the reference of currently running thread, use
             * Thread currentThread() method of Thread class.
             *
             * This is a static method.
             */
           
            Thread currentThread = Thread.currentThread();
            System.out.println(currentThread.getName());
            System.out.println(currentThread.getPriority());
    }
}