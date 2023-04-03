import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServeurMT extends Thread {
	private int nbClients;
	private int nbSecret;
	private boolean fin;
	private String gagnant;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServeurMT().start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("D�marrage du serveur multi thread");
			//nbSecret = (int) (Math.random()*1000);
			nbSecret = new Random().nextInt(1000);
			System.out.println("Le serveur a g�n�r� un nombre secr�t");
			while (true) {
				Socket s = ss.accept();
				++nbClients;
				new Conversation(s,nbClients).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	class Conversation extends Thread{
		private Socket socket;
		private int numero;
		
		public Conversation (Socket s,int num) {
			this.socket = s;
			this.numero = num;
		}
		
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				OutputStream os =socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os,true);
				String IP = socket.getRemoteSocketAddress().toString();
				System.out.println("Connexion du client num�ro"+numero+",IP="+IP);
				pw.println("Bienvenue, vous �tes le client num�ro:"+numero);
				pw.println("Devine le nombre secr�t entre 0 et 1000");
				while (true) {
					String req = br.readLine();
					System.out.println("Le client"+IP+" a envoy� la requ�te"+req);
					int nb = Integer.parseInt(req);
					if(fin==false) {
						if(nb<nbSecret)
							pw.println("Votre num�ro est plus petit que le nb secr�t");
						else if(nb>nbSecret)
							pw.println("Votre num�ro est plus grand que le nb secr�t");
						else {
							fin=true;
							gagnant = IP;
							System.out.println("BRAVO � "+IP);
							pw.println("BRAVO vous avez gagn� ");
						}
					}
					else {
						pw.print("JEU Termin�, le gagnant est"+gagnant);
					}
					//pw.print(req.length());
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
