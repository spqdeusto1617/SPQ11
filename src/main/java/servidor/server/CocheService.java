package servidor.server;


import java.rmi.RemoteException;
import java.util.ArrayList;

import org.datanucleus.store.types.wrappers.List;

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
	Contacto contacto1;
	Contacto contacto2;
	Album album1;
	Album album2;
	Album album3;
	
	private  ArrayList <String> canciones1= new ArrayList<>();
	private  ArrayList <String> canciones2= new ArrayList<>();
	private  ArrayList <String> canciones3= new ArrayList<>();
	Telemetrias telemetrias;
	Posicion posicionActual;
	private GatewayGPS gatewayGPS;
	private IcocheDAO IcocheDAO = new cocheDAO();
	String ipSocket;
	int puertoSocket;
	public CocheService(String ipSocket,int puestoSocket){
		this.ipSocket=ipSocket;
		this.puertoSocket=puestoSocket;
		telemetrias = new Telemetrias();
		 posicionActual= new Posicion();
		 canciones1.add("In the End");
		 canciones2.add("Manifiesto");
		 canciones3.add("Euskaraz bizi");
		 album1 = new Album("Linking Park", canciones1.toString());
		 album2 = new Album("Nach", canciones2.toString());
		 album3 = new Album("Esne beltza", canciones3.toString());
		 introducirAlbumBD(album1);
		 introducirAlbumBD(album2);
		 introducirAlbumBD(album3);
		 contacto1 = new Contacto("Pepe", 123456789);
		 contacto2 = new Contacto("Sara", 123456788);
		 introducirContactoBD( contacto1);
		 introducirContactoBD( contacto2);
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
			 introducirDestinoBD(lugarInt1, coordenada1);
			 verDestinos();
			 System.out.println("Posicion encontrada");
			return  posicionActual;
		}else{
			return null;
		}
	
	}
	
	public void introducirDestinoBD(String nomDest, String coordenadasDest){
		destino = new Destino(nomDest, coordenadasDest);
		System.out.println("destino creado desde CocheService");
		IcocheDAO.setDestinos(destino);
	}

	public void introducirContactoBD(Contacto contacto){
		
		IcocheDAO.setContactos(contacto);
	}

	public void introducirAlbumBD(Album album){
		
		IcocheDAO.setAlbums(album);
	}
	
	public void verDestinos(){
		IcocheDAO.getDestinos();
	}

	public void verContactos(){
		IcocheDAO.getContactos();
	}

	public void verAlbums(){
		IcocheDAO.getAlbums();
	}
	
	public boolean hacerLlamada(Contacto c) throws RemoteException {
		System.out.println("Buscando contacto ...");
		boolean encontrado= false;
		
		try{
		 for(int i=0;i>= IcocheDAO.getContactos().size();i++){
			 if(IcocheDAO.getContactos().get(i).getNomContacto().equals(c.getNomContacto())){
				 System.out.println("Conectado con el contacto ...");
				 return true;
				
				
			 }
		 }
		 System.out.println("Error en la llamada...");
			 return false;
	 }catch(Exception e){
		 return false;
	 }
		
	}
	
	public Album reproducirCancion(String nombreAlbum, String nombreCancion) throws RemoteException {
		System.out.println("Obteniendo Cancion ...");
		//String cancion=null;
		try{
		List<Album> myList = new List<Album>(null,null);
		myList = (List<Album>) IcocheDAO.getAlbums();
		return myList.get(1);
		}catch(Exception e){
			System.out.println("Error al obtener la canción desde CocheService");
			return null;
		}
		/*if(nombreAlbum.equals(album1.getNomAlbum())){
			//for(int i=0;i>=album1.getCanciones().size();i++){
				if(nombreCancion.equals(album1.getCanciones())){
					cancion=album1.getNomAlbum()+": "+album1.getCanciones();
				}
		}else if(nombreAlbum.equals(album2.getNomAlbum())){
			//for(int i=0;i>=album2.getCanciones().size();i++){
				if(nombreCancion.equals(album2.getCanciones())){
					cancion=album2.getNomAlbum()+": "+album2.getCanciones();
				}
		}else if(nombreAlbum.equals(album3.getNomAlbum())){
			//for(int i=0;i>=album3.getCanciones().size();i++){
				if(nombreCancion.equals(album3.getCanciones())){
					cancion=album3.getNomAlbum()+": "+album3.getCanciones();
				}
			}*/
	}
}
