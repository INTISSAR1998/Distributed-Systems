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
			System.out.println("Démarrage du serveur multi thread");
			//nbSecret = (int) (Math.random()*1000);
			nbSecret = new Random().nextInt(1000);
			System.out.println("Le serveur a généré un nombre secrêt");
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
				System.out.println("Connexion du client numéro"+numero+",IP="+IP);
				pw.println("Bienvenue, vous êtes le client numéro:"+numero);
				pw.println("Devine le nombre secrêt entre 0 et 1000");
				while (true) {
					String req = br.readLine();
					System.out.println("Le client"+IP+" a envoyé la requête"+req);
					int nb = Integer.parseInt(req);
					if(fin==false) {
						if(nb<nbSecret)
							pw.println("Votre numéro est plus petit que le nb secrêt");
						else if(nb>nbSecret)
							pw.println("Votre numéro est plus grand que le nb secrêt");
						else {
							fin=true;
							gagnant = IP;
							System.out.println("BRAVO à "+IP);
							pw.println("BRAVO vous avez gagné ");
						}
					}
					else {
						pw.print("JEU Terminé, le gagnant est"+gagnant);
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
