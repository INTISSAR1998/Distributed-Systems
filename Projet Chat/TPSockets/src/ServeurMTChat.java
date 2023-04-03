import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServeurMTChat extends Thread {
	private int nbClients;
	private int nbSecret;
	private boolean fin;
	private String gagnant;
	private List <Socket> sockets=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServeurMTChat().start();
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
				sockets.add(s);
				++nbClients;
				new Conversation(s,nbClients).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void broadcastMessage(String message,Socket source) {
		for(Socket s:sockets) {
			try {
				if(s!=source) {
				PrintWriter pw =  new PrintWriter(s.getOutputStream(),true);
				pw.println(message);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
				//pw.println("Devine le nombre secrêt entre 0 et 1000");
				while (true) {
					String req = br.readLine();
					broadcastMessage(IP+"a envoyé le message=>"+req,socket);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
