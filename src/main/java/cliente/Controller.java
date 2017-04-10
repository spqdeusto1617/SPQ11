package cliente;

import java.rmi.RemoteException;
import java.util.ArrayList;



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
		comprobarVeocidad();
		obtenerNuevoKilometraje(1066);
		
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
	public void comprobarVeocidad()
	{
		try {
			// Add your code HERE - Related to getting the service 
		int velicidad= rsl.getTelemetrias().comprobarVelocidad();
		if(velicidad>80){
			System.out.println("Exceso de velocidad");
		}
		System.out.println("Velocidad: "+velicidad);
		} catch (Exception e) {
			
			System.out.println("$ Error Comprobando velicidad Controller ");
			
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
    
	/** Método principal
	 * 
	 * @param args String[]
	 */
	public static void main(String[]args) throws RemoteException
	{
		
		new Controller(args);

	}
	
}

