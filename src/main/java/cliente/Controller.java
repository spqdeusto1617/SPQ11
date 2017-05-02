package cliente;

import java.rmi.RemoteException;
import java.util.ArrayList;

import servidor.data.Posicion;



public class Controller {
	@SuppressWarnings("unused")
	private ServiceLocator rsl;
	private String name;
	
	/** 
	 * Relaciona la aplicación con el ServiceLocator y abre la ventana
	 * @param args String[]  
	 */
	public Controller(String[] args) throws RemoteException 
	{
		

		this.rsl = new ServiceLocator();
		rsl.setService(args[0], args[1], args[2], args[3], args[4]);
		new VentanaCliente(this);
		comprobarBateria();
		comprobarVelocidad();
		obtenerNuevoKilometraje(1066);
		obtenerPosicionActualGPS("1234");
		
	}
	
	
	/**
	 * Cierra la conexión con el servidor
	 */
	public void exit()
	{
		System.exit(0);
	}
	
	/** 
	 * Hace una llamada al service locator para que
	 *  conecte con el servidor y mire la bateria  
	 */
	public void comprobarBateria()
	{
		try {
			// Add your code HERE - Related to getting the service 
		int bateria= rsl.getTelemetrias().comprobarBateria();
		if(bateria<15){
			System.out.println("Queda poca bateria");
		}
		System.out.println("Bateria: "+bateria);
		} catch (Exception e) {
			
			System.out.println("$ Error Comprobando Bateria() Controller ");
			
		}	
		
	}
	/** 
	 * Hace una llamada al service locator para que
	 *  conecte con el servidor y mire la velocidad  
	 */
	public void comprobarVelocidad()
	{
		try {
			// Add your code HERE - Related to getting the service 
		int velocidad= rsl.getTelemetrias().comprobarVelocidad();
		if(velocidad>80){
			System.out.println("Exceso de velocidad");
		}
		System.out.println("Velocidad: "+velocidad);
		} catch (Exception e) {
			
			System.out.println("$ Error Comprobando velocidad Controller ");
			
		}	
		
	}
	
	/** 
	 * Hace una llamada al service locator para que
	 *  conecte con el servidor , actualiza  los kilometros recorridos 
	 *  y se los muestra
	 * @param nuevosKilometrosRecorridos int   
	 */
	public void obtenerNuevoKilometraje(int nuevosKilometrosRecorridos)
	{
		try {
			// Add your code HERE - Related to getting the service 
		int kilometros= rsl.getTelemetrias().getNuevoKilometraje(nuevosKilometrosRecorridos);
		
		System.out.println("Kilometraje: "+kilometros);
		} catch (Exception e) {
			
			System.out.println("$ Error Kilometraje Controller ");
			
		}
		
		
	}
	
	/** 
	 * Hace una llamada al service locator para que
	 *  conecte con el servidor y mire la posicion actual 
	 *  @param contraseña String   
	 */
	public void obtenerPosicionActualGPS(String contraseña)
	{
		try {
			// Add your code HERE - Related to getting the service 
			Posicion posicionActual= rsl.getGPS().obtenerPosicionActualGPS(contraseña);
		
		System.out.println("Posicion actual: "+posicionActual.getUbicacion());
		} catch (Exception e) {
			
			System.out.println("$ Error Comprobando posicion Controller ");
			
		}	
		
	}
	/** Método principal
	 * 
	 * @param args String[]
	 */
	public static void main(String[]args) throws RemoteException
	{
		
		new Controller(args);

	}
	
}

