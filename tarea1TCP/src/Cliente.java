

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) throws IOException{
		Socket socketCliente = null;
		
		BufferedReader entrada=null;
		PrintWriter salida=null;
		System.out.println("----CLIENTE-----");
		try {
			socketCliente =new Socket("localhost",4673);
			entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
			salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream() )),true);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		BufferedReader sc =new BufferedReader(new InputStreamReader(System.in));
		try {
			
			while(true) {
				System.out.println("--------MENU-----------");
		    	 System.out.println("Ingrese la opción");
		        System.out.println("Opción 1");
		        System.out.println("Opción 2");
		        System.out.println("Opción 3");
		        System.out.println("salir");
		    	System.out.println("----------------------");
				//mensaje por consola
				String cad = sc.readLine();
				//enviando
				salida.println(cad);
				if(cad.equals("salir"))break;
				//recibiendo
				
				cad=entrada.readLine();
				
				System.out.println("la respuesta del servidor es:"+cad);
				
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		salida.close();
		entrada.close();
		sc.close();
		socketCliente.close();
		
	
		
		
			

	}

}
