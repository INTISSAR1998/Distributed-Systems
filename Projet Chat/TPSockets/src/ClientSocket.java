import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSocket extends Thread {

	private PrintWriter printWriter;
	private BufferedReader bufferedReader;
	
	public ClientSocket() {
		try {
			Socket s = new Socket("localhost",1234);
			bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			printWriter = new PrintWriter(s.getOutputStream(),true);
			this.start();
			Scanner clavier = new Scanner(System.in);
			while(true) {
			System.out.println("Donner votre requête:");
			String req = clavier.nextLine();
			printWriter.println(req);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClientSocket();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
			try {
			String rep;
			while((rep =bufferedReader.readLine()) != null){
				System.out.println(rep);
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}

}
