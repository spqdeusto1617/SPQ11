package servidor.server;

import java.rmi.RemoteException;

import servidor.data.Posicion;
import servidor.data.Telemetrias;
import servidor.gateways.GatewayGPS;

public class CocheService {
	Telemetrias telemetrias;
	Posicion posicionActual;
	private GatewayGPS gatewayGPS;
	public CocheService(){
		
	}
	 /** Método para devolver el estado actual de la bateria
	 
		 */
	public int getBateria() throws RemoteException {
		System.out.println("Comprobando % de bateria: ...");
		telemetrias = new Telemetrias();
		return telemetrias.getBateria();
	}
	 /** Método para devolver la velocidad a a que circulamos actualmente
	 
		 */
	public int getVelocidad() throws RemoteException {
		System.out.println("Sacando Velocidad ...");
		telemetrias = new Telemetrias();
		return telemetrias.getVelocidad();
	}
	 /** Método para actualizar y devolver los kilometros recoridos
	  * @param kilometrosNuevos int
	 */
	public int getNuevoKilometraje(int kilometrosNuevos)throws RemoteException {
		System.out.println("Obteniendo kilometraje ...");
		telemetrias = new Telemetrias();
		telemetrias.setKilometraje(kilometrosNuevos);
		return telemetrias.getKilometraje();
	}
	 /** Método para actualizar y devolver la posicion actual
	
	 */
	public Posicion getPosicionActualGPS(String contraseña)throws RemoteException {
		System.out.println("Obteniendo Posicion actual ...");
		System.out.println("Conectando con servicio externo");
		gatewayGPS =new GatewayGPS("0.0.0.0",35600);
		String obtenerPosicion = gatewayGPS.sendMessage(contraseña);
		if(obtenerPosicion.equals("Bilbo")){
			 posicionActual = new Posicion("Bilbo","MuseoBilbo","San Mames");
			return  posicionActual;
		}else{
			
			return null;
		}
	
	}

}
