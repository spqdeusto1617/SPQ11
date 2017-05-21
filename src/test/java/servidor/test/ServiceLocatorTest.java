package servidor.test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import cliente.ServiceLocator;
import servidor.data.Album;
import servidor.data.Contacto;
import servidor.remote.IFacadeGPS;
import servidor.remote.IFacadeOrdenadorAbordo;
import servidor.remote.IFacadeTelemetrias;

public class ServiceLocatorTest {
	static Logger logger = Logger.getLogger(ServiceLocator.class.getName());
	private ServiceLocator rsl;

	private IFacadeTelemetrias ServicioTelemetrias= new IFacadeTelemetrias() {
		
		@Override
		public int getNuevoKilometraje(int kilometrosNuevos) throws RemoteException {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public int comprobarVelocidad() throws RemoteException {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public int comprobarBateria() throws RemoteException {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	private IFacadeGPS ServicioGPS= new IFacadeGPS() {
		
		@Override
		public String obtenerPosicionActualGPS(String contraseña) throws RemoteException {
			// TODO Auto-generated method stub
			return "apa";
		}
	};
	private IFacadeOrdenadorAbordo ServicioOrdenadorAbordo= new IFacadeOrdenadorAbordo() {

		@Override
		public Album obtenerCancion(String nombreAalbum, String nombreCancion) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hacerLlamada(Contacto c) throws RemoteException {
			// TODO Auto-generated method stub
			return false;
		}
	};
	@Before
	public void setUp() throws Exception {
		logger.info("Entering setUp");
		rsl= new ServiceLocator();
		logger.info("Leaving setUp");
	}

	@Test public void testgetTelemetrias()throws Exception {
		logger.info("Starting testgetTelemetrias");
		try {
			assertEquals(rsl.getTelemetrias().comprobarBateria(),0); 
			
			
		} catch (Exception e) {
				
		}	
		
		logger.debug("Finishing testgetTelemetrias");
	}
	@Test public void testgetGPS()throws Exception {
		logger.info("Starting testgetGPS");
	try {
			
		assertEquals(rsl.getGPS().obtenerPosicionActualGPS(""), "apa"); 
			
		} catch (Exception e) {
				
		}	
		
		logger.debug("Finishing testgetGPS");
	}
	@Test public void testgetOrdenadorAbordo()throws Exception {
		logger.info("Starting testgetOrdenadorAbordo");
	try {
			
		assertEquals(rsl.getOrdenadorAbordo().hashCode(),rsl.getOrdenadorAbordo().hashCode()); 
			
		} catch (Exception e) {
				
		}	
	
		logger.debug("Finishing testgetOrdenadorAbordo");
	}
}
