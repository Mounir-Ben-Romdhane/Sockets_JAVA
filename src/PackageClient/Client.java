package PackageClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			Socket sc= new Socket("localhost",4719);
		       System.out.println("je suis connecté");
		       OutputStream os= sc.getOutputStream();
		      Scanner scan = new Scanner(System.in);
		     
		      
		      
		      PrintWriter pw = new PrintWriter(os,true);
		      
		      
		      System.out.println("saisser l'operade 1 :");
		      Double op1= scan.nextDouble();
		      pw.println(op1);
		      System.out.println("saisser l'operateur :");
		      Scanner scan1 = new Scanner(System.in);
		      char opp = scan1.nextLine().charAt(0);
		      pw.println(opp);
		      System.out.println("saisser l'operade 2 :");
		      Double op2= scan.nextDouble();
		      pw.println(op2);
		      
		      InputStream is= sc.getInputStream();
		      InputStreamReader isr = new InputStreamReader(is);
		      BufferedReader br = new BufferedReader(isr);
		      String  sos=br.readLine();
		      System.out.println("le resultat de envoyé par le server est : "+sos);
		      sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
