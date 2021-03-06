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
				if (args.length != 7) {
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
					int puertoGPS = Integer.parseInt(args[6]);
					CocheService servicios = new CocheService(args[5],puertoGPS);
					System.out.println(name1);
					IFacadeTelemetrias ConexionTelemetrias = new FacadeTelemetrias(servicios);
					Naming.rebind(name1, ConexionTelemetrias);
					System.out.println("SERVIDOR TELEMETRÍAS: "+ name1 + "' active and waiting...");
					
					System.out.println(name2);
					IFacadeGPS ConexionGPS = new FacadeGPS(servicios);
					Naming.rebind(name2, ConexionGPS);
					System.out.println("SERVIDOR GPS: "+ name2 + "' active and waiting...");
					
					System.out.println(name3);
					IFacadeOrdenadorAbordo ConexionOrdenadorAbordo = new FacadeOrdenadorAbordo(servicios);
					Naming.rebind(name3, ConexionOrdenadorAbordo);
					System.out.println("SERVIDOR ORDENADOR DE ABORDO: "+ name3 + "' active and waiting...");
					
					//Hace que se queden esperando una linea
					java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader ( System.in );
					java.io.BufferedReader stdin = new java.io.BufferedReader ( inputStreamReader );
					String line  = stdin.readLine();
				} catch (Exception e) {
					System.err.println("$ Servidor exception: " + e.getMessage());
					e.printStackTrace();
				}
				
				
			}
		
		
	
}
