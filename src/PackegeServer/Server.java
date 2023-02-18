package PackegeServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(2222);
			System.out.println("j'attend la cnx de client!");
			Socket s = ss.accept();
			InputStream is =s.getInputStream();
			OutputStream os = s.getOutputStream();
			System.out.println("j'attend un nombre!");
			int nb = is.read();
			int res = nb*8;
			System.out.println("j'envoi la repence");
			os.write(res);
			s.close();
		
			
		} catch (IOException e){
			e.printStackTrace();
			
		}
	}
}
