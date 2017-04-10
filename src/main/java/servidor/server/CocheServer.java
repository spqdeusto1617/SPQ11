package servidor.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import servidor.remote.FacadeGPS;
import servidor.remote.FacadeOrdenadorAbordo;
import servidor.remote.FacadeTelemetrias;
import servidor.remote.IFacadeGPS;
import servidor.remote.IFacadeOrdenadorAbordo;
import servidor.remote.IFacadeTelemetrias;

@SuppressWarnings("unused")
public class CocheServer {

	 /** Método para estar en linea esperando llamadas del cliente
	 
		 */
		
			public static void main(String[] args) {
				if (args.length != 5) {
					System.exit(0);
				}

				if (System.getSecurityManager() == null) {
					System.setSecurityManager(new SecurityManager());
				}

				String name1= "//" + args[0] + ":" + args[1] + "/" + args[2];
				String name2 = "//" + args[0] + ":" + args[1] + "/" + args[3];
				String name3 = "//" + args[0] + ":" + args[1] + "/" + args[4];
				//**************FAÇADE **************
				try {
					CocheService servicios = new CocheService( );
					System.out.println(name1);
					IFacadeTelemetrias ConexionTelemetrias = new FacadeTelemetrias(servicios);
					Naming.rebind(name1, ConexionTelemetrias);
					System.out.println("- ServidorTelemetrias'" + name1 + "' active and waiting...");
					
					System.out.println(name2);
					IFacadeGPS ConexionGPS = new FacadeGPS(servicios );
					Naming.rebind(name2, ConexionGPS);
					System.out.println("- ServidorGPS '" + name2 + "' active and waiting...");
					
					System.out.println(name3);
					IFacadeOrdenadorAbordo ConexionOrdenadorAbordo = new FacadeOrdenadorAbordo(servicios );
					Naming.rebind(name2, ConexionOrdenadorAbordo);
					System.out.println("- ServidorOrdenador de Abordo '" + name3 + "' active and waiting...");
				} catch (Exception e) {
					System.err.println("$ Servidor exception: " + e.getMessage());
					e.printStackTrace();
				}
				
				
			}
		
		
	
}
