package servidorExterno.GPS;
import java.util.ArrayList;
import java.util.List;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
public class GPSservice extends Thread {
	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;
	private static String DELIMITER = "#";
	
	public GPSservice(Socket socket) {
		try {
			this.tcpSocket = socket;
			this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
		} catch (IOException e) {
			System.err.println("# GPSService - TCPConnection IO error:" + e.getMessage());
		}
	}
	public void run() {
		try {
			String data = this.in.readUTF();
			System.out.println("   - TranslationService - Received data from '"
			        + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort()
			        + "' -> '" + data + "'");
			data = this.obtenerPosicion(data);
			
			this.out.writeUTF(data);
			System.out.println("   - TranslationService - Sent data to '"
			        + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort()
			        + "' -> '" + data.toUpperCase() + "'");
		} catch (EOFException e) {
			System.err
			        .println("   # TranslationService - TCPConnection EOF error" + e.getMessage());
		} catch (IOException e) {
			System.err
			        .println("   # TranslationService - TCPConnection IO error:" + e.getMessage());
		} finally {
			try {
				tcpSocket.close();
			} catch (IOException e) {
				System.err.println(
				        "   # TranslationService - TCPConnection IO error:" + e.getMessage());
			}
		}
	}
	public String obtenerPosicion(String msg) {
		String posicion = null;
		try{
			if( msg.equals("1234")){
				posicion = "Bilbo";	
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return posicion;
	}
}
