

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static String menu(String a) {

    	
    	String cad="";
        int y=Integer.parseInt(a);
        switch (y) {
	     
        case 1:    
                cad="piedra";
                
            break;   
		case 2:     
                cad="papel";    
                break;     
        case 3:     
                cad="tijera";    
                break;    
                  
            default:    
                System.out.println("No en la lista");    
                break;
	    
	    }
        return cad;

	}
	public static void main(String[] args) throws IOException {
		ServerSocket socketServidor =null;
		Socket socketCliente=null;
		BufferedReader entrada=null;
		PrintWriter salida=null;
		System.out.println("--SERVIDOR---");
		try {
			socketServidor = new ServerSocket(4673);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			while(true) {
				socketCliente=socketServidor.accept();
				entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream() )),true);
				
				while(true) {
					//recibiendo
					String cad=entrada.readLine();
					if(cad.equals("salir"))break;
					//enviando
					System.out.println("el cliente escogio la opcion: "+cad);
				
					String res="";
					
					
					salida.println(menu(cad));
					
				}
				
			
				
				
				//System.out.println("el puerto del clente: "+socketCliente.getPort());
				//System.out.println("el address del cliente: "+socketCliente.getInetAddress());
				
				
				
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		salida.close();
		entrada.close();
		socketServidor.close();
		socketCliente.close();
		

	}


}
