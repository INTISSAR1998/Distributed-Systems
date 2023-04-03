
import java.io.*;
import java.util.*;

public class Ex2 {
	public static void main(String arg[]) throws IOException
	{
		FileInputStream fis = new FileInputStream("TP1.txt");
		DataInputStream dis = new DataInputStream(fis);
		FileOutputStream fos = new FileOutputStream("TP1C.txt");
		String s="BB Bonjour les etudiants";

		byte b[];
		b=s.getBytes();
		fos.write(b);
		int o;
		while((o=dis.read())!=-1)
			fos.write(o);
		
		dis.close();
		fis.close();
		
		fos.close(); 

	}
}