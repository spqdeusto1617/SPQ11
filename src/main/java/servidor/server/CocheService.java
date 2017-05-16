package servidor.server;

import java.rmi.RemoteException;

import servidor.data.Posicion;
import servidor.data.Telemetrias;
import servidor.gateways.GatewayGPS;

public class CocheService {
	private Telemetrias telemetrias;
	private Posicion posicionActual;
	private GatewayGPS gatewayGPS;
	String ipSocket;
	
	int puertoSocket;
	public CocheService(String ipSocket,int puestoSocket){
		this.ipSocket=ipSocket;
		this.puertoSocket=puestoSocket;
		telemetrias= new Telemetrias();
		 posicionActual= new Posicion();
	}

	public String getIpSocket() {
		return ipSocket;
	}

	public int getPuestoSocket() {
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
		telemetrias.setKilometraje(telemetrias.getKilometraje()+kilometrosNuevos);
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
			 posicionActual.setUbicacion("Bilbo");
			 posicionActual.getLugaresCercanosDeInteres().add(lugarInt1);
			 posicionActual.getLugaresCercanosDeInteres().add(lugarInt2);
			 System.out.println("Posicion encontrada");
			return  posicionActual;
		}else{
			return null;
		}
	
	}

}
