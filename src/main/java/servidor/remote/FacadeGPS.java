package servidor.remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import servidor.data.Posicion;
import servidor.server.CocheService;


public class FacadeGPS extends UnicastRemoteObject implements IFacadeGPS {
	private static final long serialVersionUID = 1L;
	private CocheService progServ;

public FacadeGPS( CocheService progServ) throws RemoteException {
		super();
		this.progServ = progServ;
		
	}
public Posicion obtenerPosicionActualGPS(String contraseña) throws RemoteException {
	System.out.println("Enviando peticion de Posicion actual");
	return progServ.getPosicionActualGPS(contraseña);
}
}
