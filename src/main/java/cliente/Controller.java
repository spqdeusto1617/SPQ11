package cliente;

import java.rmi.RemoteException;
import java.util.ArrayList;

import servidor.data.Album;
import servidor.data.Contacto;
import servidor.data.Destino;
import servidor.data.Posicion;



public class Controller {
	@SuppressWarnings("unused")
	private ServiceLocator rsl;
	private String name;
	private Posicion posicionActual;
	private Album album;
	private Contacto contacto;
	private Destino destino;
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

		} catch (Exception e) {
			System.out.println("$ Error Comprobando posicion Controller ");
			System.out.println(posicionActual.getUbicacion());
		}
		
	/*public void hacerLlamada(){

		try{
			System.out.println("Marcando ..." + c.getNumContacto());
			System.out.println("Llamando a ..." + c.getNomContacto());
			System.out.println("Llamada establecida");
			System.out.println("#########################################");
			System.out.println("FIN DE LA LLAMADA");
			}catch (Exception e){
				System.out.println("$ Error haciendo la llamada desde el Controller ");
			}
		}
		
		public void reproducirCancion(Album a, int numCancion) throws RemoteException {
			System.out.println("Album elegido: " + a.getNomAlbum());
			System.out.println("Canciones: " + a.getCanciones());
			System.out.println("Reproduciendo canción nº" + numCancion + " --> " + a.getCanciones().get(numCancion));
		}*/
		
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

