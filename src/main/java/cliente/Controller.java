package cliente;

import java.rmi.RemoteException;
import java.util.ArrayList;



public class Controller {
	@SuppressWarnings("unused")
	private ServiceLocator rsl;
	private String name;
	
	/** 
	 * Relaciona la aplicación con el ServiceLocator
	 * @param args
	 */
	public Controller(String[] args) throws RemoteException 
	{
		

		this.rsl = new ServiceLocator();
		rsl.setService(args[0], args[1], args[2], args[3], args[4]);
		new VentanaCliente(this);
		
		
	}
	
	
	/**
	 * Cierra la conexión con el servidor
	 */
	public void exit()
	{
		System.exit(0);
	}
	
	
	
	
	
    
    
	/** Método principal
	 * 
	 * @param args
	 */
	public static void main(String[]args) throws RemoteException
	{
		
		new Controller(args);

	}
	
}

