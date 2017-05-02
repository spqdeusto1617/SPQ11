package servidor.remote;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import servidor.data.Posicion;



public interface IFacadeGPS extends Remote{
	public Posicion obtenerPosicionActualGPS(String contraseña) throws RemoteException ;
}
