package visual;

import java.rmi.RemoteException;

import servidor.server.CocheService;



public class servidorVisual {

	public static void main(String[]args) throws RemoteException
	{
		CocheService cs = new CocheService("0.0.0.0", 35600);
	int bat =cs.getBateria();
	int vel = cs.getVelocidad();
	int kil = cs.getNuevoKilometraje(45);
	System.out.println("Sacando Bateria :"+ bat);
	System.out.println("Sacando Velocidad :"+ vel);
	System.out.println("Sacando Kilometraje :"+ kil);
	
	}
}
