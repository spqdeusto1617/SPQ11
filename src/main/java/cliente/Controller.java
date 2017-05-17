package cliente;

import java.rmi.RemoteException;
import java.util.ArrayList;

import servidor.data.Posicion;




public class Controller {
	@SuppressWarnings("unused")
	private ServiceLocator rsl;
	private String name;
	private Posicion posicionActual;
	private boolean metodoExitoso;
	/** 
	 * Relaciona la aplicación con el ServiceLocator y abre la ventana
	 * @param args String[]  
	 */
	public Controller(String[] args) throws RemoteException 
	{
		

		this.rsl = new ServiceLocator();
		rsl.setService(args[0], args[1], args[2], args[3], args[4]);
		new VentanaCliente(this);
		metodoExitoso=comprobarBateria();
		metodoExitoso=comprobarVelocidad();
		metodoExitoso=obtenerNuevoKilometraje(1066);
		metodoExitoso=obtenerPosicionActualGPS("1234");
		
	}
	 public ServiceLocator getServiceLocator() {
	    	// Add your code to return the TARGET reference HERE
	    	return this.rsl;
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
	public boolean comprobarBateria()
	{
		try {
			// Add your code HERE - Related to getting the service 
		int bateria= rsl.getTelemetrias().comprobarBateria();
		if(bateria<15){
			System.out.println("Queda poca bateria");
		}
		System.out.println("Bateria: "+bateria);
		return true;
		} catch (Exception e) {
			
			System.out.println("$ Error Comprobando Bateria() Controller ");
			return false;
		}	
		
	}
	/** 
	 * Hace una llamada al service locator para que
	 *  conecte con el servidor y mire la velocidad  
	 */
	public boolean comprobarVelocidad()
	{
		try {
			// Add your code HERE - Related to getting the service 
		int velocidad= rsl.getTelemetrias().comprobarVelocidad();
		if(velocidad>80){
			System.out.println("Exceso de velocidad");
		}
		System.out.println("Velocidad: "+velocidad);
		return true;
		} catch (Exception e) {
			
			System.out.println("$ Error Comprobando velocidad Controller ");
			return false;
		}	
		
	}
	
	/** 
	 * Hace una llamada al service locator para que
	 *  conecte con el servidor , actualiza  los kilometros recorridos 
	 *  y se los muestra
	 * @param nuevosKilometrosRecorridos int   
	 */
	public boolean obtenerNuevoKilometraje(int nuevosKilometrosRecorridos)
	{
		try {
			// Add your code HERE - Related to getting the service 
		int kilometros= rsl.getTelemetrias().getNuevoKilometraje(nuevosKilometrosRecorridos);
		
		System.out.println("Kilometraje: "+kilometros);
		return true;
		} catch (Exception e) {
			
			System.out.println("$ Error Kilometraje Controller ");
			return false;
			
		}
		
		
	}

	/** 
	 * Hace una llamada al service locator para que
	 *  conecte con el servidor y mire la posicion actual 
	 *  @param contraseña String   
	 */
	public boolean obtenerPosicionActualGPS(String contraseña)
	{
		try {
			// Add your code HERE - Related to getting the service 
			posicionActual=new Posicion();
			 posicionActual.setUbicacion(rsl.getGPS().obtenerPosicionActualGPS(contraseña));
			 if(posicionActual.getUbicacion().equals("Bilbo")){
					String lugarInt1="MuseoBilbo";
					String lugarInt2="San Mames";
					 posicionActual.getLugaresCercanosDeInteres().add(lugarInt1);
					 posicionActual.getLugaresCercanosDeInteres().add(lugarInt2);
				}
			System.out.println("Posicion encontrada");
		System.out.println("Posicion actual: "+posicionActual.getUbicacion());
		System.out.println("Sitios de interes: "+ posicionActual.getLugaresCercanosDeInteres().get(0));
		System.out.println("Sitios de interes: "+ posicionActual.getLugaresCercanosDeInteres().get(1));
		return true;

		} catch (Exception e) {
			System.out.println("$ Error Comprobando posicion Controller ");
			System.out.println(posicionActual.getUbicacion());
			return false;
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

