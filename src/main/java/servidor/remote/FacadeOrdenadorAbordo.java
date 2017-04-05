package servidor.remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import servidor.server.CocheService;


public class FacadeOrdenadorAbordo extends UnicastRemoteObject implements IFacadeOrdenadorAbordo {
	private static final long serialVersionUID = 1L;
	private CocheService progServ;

public FacadeOrdenadorAbordo( CocheService progServ) throws RemoteException {
		super();
		this.progServ = progServ;
		
	}

}