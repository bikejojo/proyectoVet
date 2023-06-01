/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author HP
 */
public class ClienteSMTP {
    
 	protected int port =25;

	protected Socket socket;
	protected BufferedReader entrada;
	protected DataOutputStream salida;
   
    
	String comando = "";

        
        
	public ClienteSMTP(){

		try { 
			socket = new Socket("mail.tecnoweb.org.bo", port);
			entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			salida = new DataOutputStream(socket.getOutputStream());
			if (existeConexion()) {
				System.out.println("Conectado a " + "mail.tecnoweb.org.bo" + " Protocol " + this.port + " succesfull!!..");
				System.out.println("Escuchando ...........");
				System.out.println("S: " + entrada.readLine());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}


   public void helo() {
		String comando;
		try {
			comando = "HELO " + "mail.tecnoweb.org.bo" + "\r\n";
			System.out.println("C: " + comando);
			salida.writeBytes(comando);
			//System.out.println("S : " + getMultiline(entrada));
			 System.out.println("S: " + entrada.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean existeConexion() {
		// Escribimos datos en el canal de salida establecido con el puerto del
		if (socket != null && entrada != null && salida != null) {
			return true;
		}
		System.out.print("la conexion fallo");
		return false;
	}

	static protected String getMultiline(BufferedReader in) throws IOException {
		String lines = "";
		while (true) {
			String line = in.readLine();
			if (line == null) {
				throw new IOException("S: server unawares closed the conection.");

			}
			if (line.equals(".")) {
				break;
			}
			if ((line.length() > 0) && (line.charAt(0) == '.')) {
				line = line.substring(1);
			}
			lines = lines + "\n" + line;
		}
		return lines;
	}

	// Cerramos los flujos de salida y de entrada y el socket cliente

	public void close() {
		try {
			salida.close();
			entrada.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

        
	public void mailFrom(String emailEmisor) {
		if (existeConexion()) {

			try {
				comando = "MAIL FROM : " + emailEmisor + " " + "\r\n";
				System.out.println("C: " + comando);
				salida.writeBytes(comando);
				System.out.println("S: " + entrada.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void rcptTo(String emailReceptor){
		if (existeConexion()) {
			try {
				comando = "RCPT TO : " + emailReceptor + " " + "\r\n";
				System.out.println("C: " + comando);
				salida.writeBytes(comando);
				System.out.println("S: " + entrada.readLine());
		 	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void data(){
		if (existeConexion()) {
			try {
				comando = "DATA" +"\r\n";
				System.out.println("C: " + comando);
				salida.writeBytes(comando);
				System.out.println("S: " + entrada.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void subject(String title, String message){
		if (existeConexion()) {
			try {
				comando = "SUBJECT: " + title + "\r\n";
				comando += message + "\r\n";
				comando += "." + "\r\n";
				System.out.println("C: " + comando);
				salida.writeBytes(comando);
				System.out.println("S: " + entrada.readLine());
				System.out.println("");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void quit() throws IOException {
		if (existeConexion()) {
			comando = "QUIT" +"\r\n";
			System.out.println("C: " + comando);
			salida.writeBytes(comando);
			System.out.println("S: " + entrada.readLine());
		}
	}

}
