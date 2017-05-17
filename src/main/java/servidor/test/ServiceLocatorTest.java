package servidor.test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import cliente.ServiceLocator;
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
			return null;
		}
	};
	private IFacadeOrdenadorAbordo ServicioOrdenadorAbordo= new IFacadeOrdenadorAbordo() {
	};
	@Before
	public void setUp() throws Exception {
		logger.info("Entering setUp");
		rsl= new ServiceLocator();
		logger.info("Leaving setUp");
	}

	@Test public void testgetTelemetrias()throws Exception {
		logger.info("Starting testgetTelemetrias");
		assertEquals(rsl.getTelemetrias().getClass(),ServicioTelemetrias.getClass()); 
		logger.debug("Finishing testgetTelemetrias");
	}
	@Test public void testgetGPS()throws Exception {
		logger.info("Starting testgetGPS");
		assertEquals(rsl.getGPS().getClass(),ServicioGPS.getClass()); 
		logger.debug("Finishing testgetGPS");
	}
	@Test public void testgetOrdenadorAbordo()throws Exception {
		logger.info("Starting testgetOrdenadorAbordo");
		assertEquals(rsl.getOrdenadorAbordo().getClass(),ServicioOrdenadorAbordo.getClass()); 
		logger.debug("Finishing testgetOrdenadorAbordo");
	}
}
