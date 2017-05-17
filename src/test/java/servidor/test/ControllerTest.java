package servidor.test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import cliente.Controller;
import cliente.ServiceLocator;
import servidor.data.Posicion;


public class ControllerTest {
	static Logger logger = Logger.getLogger(ServiceLocator.class.getName());
	private ServiceLocator rsl;
	private  Controller c;
	@Before
	public void setUp() throws Exception {
		logger.info("Entering setUp");
		rsl= new ServiceLocator();
		
		logger.info("Leaving setUp");
	}
	@Test public void testobtenerPosicionActualGPS()throws Exception {
		logger.info("Starting testobtenerPosicionActualGPS");
		//c.getServiceLocator().setService(args[0], args[1], args[2], args[3], args[4]);
		try {
			assertTrue(c.obtenerPosicionActualGPS("1234")); 
		
		} catch (Exception e) {
				
		}	
		logger.debug("Finishing testobtenerPosicionActualGPS");
	}
	@Test public void testcomprobarBateria()throws Exception {
		logger.info("Starting comprobarBateria");
		//c.getServiceLocator().setService(args[0], args[1], args[2], args[3], args[4]);
		try {
			assertTrue(c.comprobarBateria()); 
		
		} catch (Exception e) {
				
		}	
		logger.debug("Finishing comprobarBateria");
	}
	@Test public void testcomprobarVelocidad()throws Exception {
		logger.info("Starting comprobarVelocidad");
		try {
			assertTrue(c.comprobarVelocidad()); 
			
		} catch (Exception e) {
				
		}	
		logger.debug("Finishing comprobarVelocidad");
	}
	@Test public void testobtenerNuevoKilometraje()throws Exception {
		logger.info("Starting obtenerNuevoKilometraje");
		try {
			assertTrue(c.obtenerNuevoKilometraje(123)); 
			
		} catch (Exception e) {
				
		}	
		
		logger.debug("Finishing obtenerNuevoKilometraje");
	}

}
