import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("J'attend une connexion...");
			Socket s = ss.accept();
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			System.out.println("J'attend un nombre");
			int nb = is.read();
			System.out.println("Je viens de reçevoir le nombre");
			int res = nb*12;
			os.write(res);
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
