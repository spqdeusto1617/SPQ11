package servidor.remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import servidor.data.Contacto;
import servidor.server.CocheService;


public class FacadeOrdenadorAbordo extends UnicastRemoteObject implements IFacadeOrdenadorAbordo {
	private static final long serialVersionUID = 1L;
	private CocheService progServ;

public FacadeOrdenadorAbordo( CocheService progServ) throws RemoteException {
		super();
		this.progServ = progServ;
		
	}
public String obtenerCancion(String nombreAalbum, String nombreCancion) throws RemoteException {
	return progServ.reproducirCancion(nombreAalbum, nombreCancion);
}
@Override
public boolean hacerLlamada(Contacto c) throws RemoteException {
	return progServ.hacerLlamada(c);
}

}