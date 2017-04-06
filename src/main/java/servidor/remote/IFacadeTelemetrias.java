package servidor.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;



public interface IFacadeTelemetrias extends Remote{
	public int comprobarBateria() throws RemoteException ;
	public int comprobarVelocidad() throws RemoteException ;
	public int getNuevoKilometraje(int kilometrosNuevos)throws RemoteException ;
}
