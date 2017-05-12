package servidor.remote;
import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.data.Posicion;



public interface IFacadeGPS extends Remote{
	public String obtenerPosicionActualGPS(String contraseña) throws RemoteException ;
}
