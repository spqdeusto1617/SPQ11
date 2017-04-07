package cliente;

import servidor.remote.IFacadeGPS;
import servidor.remote.IFacadeOrdenadorAbordo;
import servidor.remote.IFacadeTelemetrias;

public class ServiceLocator {

	private IFacadeTelemetrias ServicioTelemetrias;
	private IFacadeGPS ServicioGPS;
	private IFacadeOrdenadorAbordo ServicioOrdenadorAbordo;

    public ServiceLocator(){ 
     
    }
    /** Método para conectarse a las interfaces del servidor
	 * 
	 * @param ip String
	 * @param port String
	 * @param serviceName1 String
	 * @param serviceName2 String
	 * @param serviceName3 String
	 */
    public void setService(String ip, String port, String serviceName1, String serviceName2,String serviceName3) {    
    	// Add your code to get the TARGET reference HERE 
    	if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			String name1 = "//" + ip + ":" + port + "/" + serviceName1;
			
			ServicioTelemetrias= (IFacadeTelemetrias) java.rmi.Naming.lookup(name1);
			
		} catch (Exception e) {
			System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace();
		}
		try {
			String name2 = "//" + ip + ":" + port + "/" + serviceName2;
		
			ServicioGPS=(IFacadeGPS) java.rmi.Naming.lookup(name2);
			
		} catch (Exception e) {
			System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace(); 
		}
		try {
			String name3 = "//" + ip + ":" + port + "/" + serviceName3;
		
			ServicioOrdenadorAbordo=(IFacadeOrdenadorAbordo) java.rmi.Naming.lookup(name3);
			
		} catch (Exception e) {
			System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace(); 
		}
    }
    /** Método para acceder a la interfaz 1 del servidor
	 
	 */
    public IFacadeTelemetrias getTelemetrias() {
    	// Add your code to return the TARGET reference HERE
    	return ServicioTelemetrias;
    }
    /** Método para acceder a la interfaz 2 del servidor
	 
   	 */
    public IFacadeGPS getGPS() {
    	// Add your code to return the TARGET reference HERE
    	return ServicioGPS;
    }
    /** Método para acceder a la interfaz 3 del servidor
	 
   	 */
    public IFacadeOrdenadorAbordo getOrdenadorAbordo() {
    	// Add your code to return the TARGET reference HERE
    	return ServicioOrdenadorAbordo;
    }
}