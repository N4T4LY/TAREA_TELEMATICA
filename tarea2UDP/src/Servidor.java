

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.StringTokenizer;

public class Servidor {
	
	public static String recuperar(String cad,int tam) {
		String res="";
		for (int i = 0; i < tam; i++) {
			res+=cad.charAt(i);
		}
		return res;
	}

	public static String numeroPalabras(String x){
		StringTokenizer st = new StringTokenizer(x);
	       int y= st.countTokens();
	       String env=String.valueOf(y);
	       return env;
		
	} 
	public static void main(String[] args) {
		System.out.println("------SERVIDOR------");
		try {
			DatagramSocket socketUDP =new DatagramSocket(8350);
			byte [] buffer =new byte[100000];
			while(true) {
				DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
				socketUDP.receive(peticion);
				
				//DatagramPacket mensaje = new DatagramPacket(peticion.getData(), peticion.getLength(),peticion.getAddress(), peticion.getPort());
				//socketUDP.send(mensaje);
				
				String res=new String(peticion.getData());
				
				String x= recuperar(res,peticion.getLength());
				
				
				String env=numeroPalabras(x); 
				
				
				
				byte[] enviar=env.getBytes();
				DatagramPacket mensaje = new DatagramPacket(enviar, env.length() ,peticion.getAddress(), peticion.getPort());
				socketUDP.send(mensaje);
				
				System.out.println("Datos: "+new String(peticion.getData()));
				
				
			}
			
			
			
			} catch (Exception e) {
			System.out.println(e);
		}
	}

}
