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

}