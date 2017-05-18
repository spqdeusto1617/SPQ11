package servidor.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import servidor.data.Contacto;

public interface IFacadeOrdenadorAbordo extends Remote{
	public String obtenerCancion(String nombreAalbum, String nombreCancion) throws RemoteException ;
	public boolean hacerLlamada(Contacto c) throws RemoteException;
}
