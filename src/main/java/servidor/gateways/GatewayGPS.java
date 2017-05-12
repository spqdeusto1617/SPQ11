package servidor.gateways;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class GatewayGPS implements IGatewayGPS{
	private String ip;
	private int port;
	private String resultado;

	public GatewayGPS(String ip, int port) {
		this.ip = ip;
		this.port = port;
		
	}
public String sendMessage(String text) {
		
		try (Socket socket = new Socket(ip, port);
		        // Streams to send and receive information are created from the Socket
		        DataInputStream in = new DataInputStream(socket.getInputStream());
		        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

			// Send request (a String) to the server
			out.writeUTF(text);
			System.out.println(
			        " - TCPSocketClient: Sent data to '" + socket.getInetAddress().getHostAddress()
			                + ":" + socket.getPort() + "' -> '" + text + "'");
			
			// Read response (a String) from the server
			String data = in.readUTF();
			resultado=data;
			System.out.println(" - TCPSocketClient: Received data from '"
			        + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "' -> '"
			        + data + "'");
		} catch (UnknownHostException e) {
			System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("# TCPSocketClient: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
		}
		return resultado;
	}
}
