package servidor.server;

import java.rmi.RemoteException;

import servidor.data.Telemetrias;

public class CocheService {
	Telemetrias telemetrias;
	public CocheService(){
		
	}
	public int getBateria() throws RemoteException {
		System.out.println("Comprobando % de bateria: ...");
		telemetrias = new Telemetrias();
		return telemetrias.getBateria();
	}
	public int getVelocidad() throws RemoteException {
		System.out.println("Sacando Velocidad ...");
		telemetrias = new Telemetrias();
		return telemetrias.getVelocidad();
	}
	public int getNuevoKilometraje(int kilometrosNuevos)throws RemoteException {
		System.out.println("Obteniendo kilometraje ...");
		telemetrias = new Telemetrias();
		telemetrias.setKilometraje(kilometrosNuevos);
		return telemetrias.getKilometraje();
	}
}
