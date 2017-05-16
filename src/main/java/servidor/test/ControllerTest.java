package servidor.test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import cliente.Controller;
import cliente.ServiceLocator;


public class ControllerTest {
	static Logger logger = Logger.getLogger(ServiceLocator.class.getName());
	private Controller c;
	@Before
	public void setUp(String[] args) throws Exception {
		logger.info("Entering setUp");
		c=new Controller(args);
		logger.info("Leaving setUp");
	}

	@Test public void comprobarBateria()throws Exception {
		logger.info("Starting comprobarBateria");
		assertTrue(c.comprobarBateria()); 
		logger.debug("Finishing comprobarBateria");
	}
	@Test public void comprobarVelocidad()throws Exception {
		logger.info("Starting comprobarVelocidad");
		assertTrue(c.comprobarVelocidad()); 
		logger.debug("Finishing comprobarVelocidad");
	}
	@Test public void obtenerNuevoKilometraje()throws Exception {
		logger.info("Starting obtenerNuevoKilometraje");
		assertTrue(c.obtenerNuevoKilometraje(12)); 
		logger.debug("Finishing obtenerNuevoKilometraje");
	}

}
