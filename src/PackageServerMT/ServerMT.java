package PackageServerMT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMT extends Thread{
	int nbClients;
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(4719);
			System.out.println("je suis un serveur en attente la connexion d'un client");
			while(true) {
				Socket s = ss.accept();
				++nbClients;
				new ClientPrecces(s,nbClients).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class ClientPrecces extends Thread {
		private Socket socket;
		private int nmClient;
		
		public ClientPrecces(Socket socket, int num) {
			super();
			this.socket=socket;
			this.nmClient=num;
		}
		
		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				OutputStream os = socket.getOutputStream();
				
				PrintWriter pw = new PrintWriter(os,true);
				
				String IP = socket.getRemoteSocketAddress().toString();
				
				System.out.println("connection de client numero :"+nmClient+" IP= "+IP);
				
				while(true) {
					
					//System.out.println("En Attent de Premier Nombre");
					//recu de premier valeur envoyee par le client 
					Double op11 = Double.parseDouble(br.readLine());
					//System.out.println("En Attent de l'operation");
					//recu de le l'operation envoyee par le client 
					char operationn = br.readLine().charAt(0);
					//System.out.println("En Attent de deuxieme Nombre");
					//recu de la deuxieme nombre envoyee par le client 
					Double op22 = Double.parseDouble(br.readLine());
			
					 String op;
				      op=op11+" "+operationn+" "+op22;
			System.out.println(" l'operation recu est :" + op);
			String []t = op.split(" ");
			
			Double op1=Double.parseDouble(t[0]);
			Double op2 = Double.parseDouble(t[2]);
			char operation=t[1].charAt(0);
						switch(operation){
						case '*' : {System.out.println("Le Resultat de ("+op1+" "+operation+" "+op2+") est : "+(op1*op2));
						          pw.println(op1*op2);
						break;}
						case '/' : {System.out.println("Le Resultat de ("+op1+" "+operation+" "+op2+") est : "+(op1/op2));
						pw.println(op1/op2+"");
						break;
						}
						case '+' :{ System.out.println("Le Resultat de ("+op1+" "+operation+" "+op2+") est : "+(op1+op2));
						pw.println(op1+op2+"");
						break;}

						case '-' : {System.out.println("Le Resultat de ("+op1+" "+operation+" "+op2+") est : "+(op1-op2));
						pw.println(op1-op2+"");
						break;}

					}
						
						
					}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	public static void main(String[] args) {
	new ServerMT().start();
		
	}
	
	

}
