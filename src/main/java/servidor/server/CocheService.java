package servidor.server;

import java.rmi.RemoteException;
import java.util.ArrayList;

import servidor.DAO.IcocheDAO;
import servidor.DAO.cocheDAO;
import servidor.data.Album;
import servidor.data.Contacto;
import servidor.data.Destino;
import servidor.data.Posicion;
import servidor.data.Telemetrias;
import servidor.gateways.GatewayGPS;

public class CocheService {
	Destino destino;
	Contacto contacto;
	Album album;
	Telemetrias telemetrias;
	Posicion posicionActual;
	private GatewayGPS gatewayGPS;
	//private IcocheDAO IcocheDAO = new cocheDAO();
	String ipSocket;
	int puertoSocket;
	public CocheService(String ipSocket,int puestoSocket){
		this.ipSocket=ipSocket;
		this.puertoSocket=puestoSocket;
		telemetrias = new Telemetrias();
		 posicionActual= new Posicion();
	}
	public String getIpSocket() {
		return ipSocket;
	}
	public Posicion getposicionActual() {
		return posicionActual;
	}


	public int getPuertoSocket() {
		return puertoSocket;
	}

	 public Telemetrias getTelemetrias() {
		return telemetrias;
	}
	 /** Método para devolver el estado actual de la bateria
	 
		 */
	public int getBateria() throws RemoteException {
		System.out.println("Comprobando % de bateria: ...");
		
		return telemetrias.getBateria();
	}
	 /** Método para devolver la velocidad a a que circulamos actualmente
	 
		 */
	public int getVelocidad() throws RemoteException {
		System.out.println("Sacando Velocidad ...");
	
		return telemetrias.getVelocidad();
	}
	 /** Método para actualizar y devolver los kilometros recoridos
	  * @param kilometrosNuevos int
	 */
	public int getNuevoKilometraje(int kilometrosNuevos)throws RemoteException {
		System.out.println("Obteniendo kilometraje ...");
	
		telemetrias.setKilometraje(kilometrosNuevos);
		return telemetrias.getKilometraje();
	}
	 /** Método para actualizar y devolver la posicion actual
	
	 */
	public Posicion getPosicionActualGPS(String contraseña)throws RemoteException {
		System.out.println("Obteniendo Posicion actual ...");
		System.out.println("Conectando con servicio externo");
		gatewayGPS =new GatewayGPS(ipSocket,puertoSocket);
		String obtenerPosicion = gatewayGPS.sendMessage(contraseña);
		if(obtenerPosicion.equals("Bilbo")){
			System.out.println("Analizando...");
			String lugarInt1="MuseoBilbo";
			String lugarInt2="San Mames";
			String coordenada1="Latitud: 43.260||Longitud: -2.933";
			 posicionActual.setUbicacion("Bilbo");
			 posicionActual.getLugaresCercanosDeInteres().add(lugarInt1);
			 posicionActual.getLugaresCercanosDeInteres().add(lugarInt2);
			 //introducirDestinoBD(lugarInt1, coordenada1);
			
			 System.out.println("Posicion encontrada");
			return  posicionActual;
		}else{
			return null;
		}
	
	}
	
	public void introducirDestinoBD(String nomDest, String coordenadasDest){
		destino = new Destino(nomDest, coordenadasDest);
		System.out.println("destino creado desde CocheService");
		//IcocheDAO.setAlbums(album);
	}

	public void introducirContactoBD(String nomContacto, int numContacto){
		contacto = new Contacto(nomContacto, numContacto);
		//IcocheDAO.setContactos(contacto);
	}

	public void introducirAlbumBD(String nomAlbum, ArrayList<String> canciones){
		album = new Album(nomAlbum, canciones);
		//	IcocheDAO.setAlbums(album);
	}
	
	public void verDestinos(){
		//IcocheDAO.getDestinos();
	}

	public void verContactos(){
		//IcocheDAO.getContactos();
	}

	public void verAlbums(){
		//IcocheDAO.getAlbums();
	}
	
	public boolean hacerLlamada(Contacto c) throws RemoteException {
		
		return true;
	}
	
	public boolean reproducirCancion(Album a, int numCancion) throws RemoteException {
		return true;
	}
}
