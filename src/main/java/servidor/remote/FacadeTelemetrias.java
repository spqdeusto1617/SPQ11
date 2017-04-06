package servidor.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import servidor.server.CocheService;


public class FacadeTelemetrias extends UnicastRemoteObject implements IFacadeTelemetrias {
	private static final long serialVersionUID = 1L;
	private CocheService progServ;

public FacadeTelemetrias( CocheService progServ) throws RemoteException {
		super();
		this.progServ = progServ;
		
	}

public int comprobarBateria() throws RemoteException {
	System.out.println("Enviando peticion de comprobacion de bateria");
	return progServ.getBateria();
}
public int comprobarVelocidad() throws RemoteException {
	System.out.println("Enviando peticion de comprobacion de velocidad");
	return progServ.getVelocidad();
}
public int getNuevoKilometraje(int kilometrosNuevos) throws RemoteException {
	System.out.println("Enviando peticion de comprobacion de kilometraje");
	return progServ.getNuevoKilometraje(kilometrosNuevos);
}
}