package servidor.remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import servidor.data.Posicion;
import servidor.server.CocheService;


public class FacadeGPS extends UnicastRemoteObject implements IFacadeGPS {
	private static final long serialVersionUID = 1L;
	private CocheService progServ;
	private Posicion posicionActual= new Posicion();
public FacadeGPS(CocheService progServ) throws RemoteException {
		super();
		this.progServ = progServ;
		
	}
public String obtenerPosicionActualGPS(String contraseña) throws RemoteException {
	System.out.println("Enviando peticion de Posicion actual");
	posicionActual= progServ.getPosicionActualGPS(contraseña);
	System.out.println("Devolviendo peticion de Posicion actual: "+ posicionActual.getUbicacion());
	System.out.println("Sitios de interes: "+ posicionActual.getLugaresCercanosDeInteres().get(0));
	return posicionActual.getUbicacion();
		
}
}

