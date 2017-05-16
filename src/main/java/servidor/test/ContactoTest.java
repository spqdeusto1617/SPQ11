package servidor.test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import servidor.data.Contacto;
import servidor.data.Telemetrias;

public class ContactoTest {
	static Logger logger = Logger.getLogger(Telemetrias.class.getName());
	Contacto c;
	@Before
	public void setUp() throws Exception {
		
			logger.info("Entering setUp");
			c = new Contacto("Pepe", 123456789);		
			logger.info("Leaving setUp");
	}

	@Test public void testgetNomContacto()throws Exception {
		logger.info("Starting testgetNomContacto");
		c.setNomContacto("Javi");
		assertEquals("Javi",c.getNomContacto()) ;
		logger.debug("Finishing testgetNomContacto");
	}
	@Test public void testgetNumContacto()throws Exception {
		logger.info("Starting testgetNumContacto");
		c.setNumContacto(222222222);
		assertEquals(222222222,c.getNumContacto()); 
		logger.debug("Finishing testgetNumContacto");
	}
	@Test public void testsetNomContacto()throws Exception {
		logger.info("Starting testsetNomContacto");
		c.setNomContacto("Javi");
		assertTrue(c.getNomContacto().equals("Javi")); 
		logger.debug("Finishing testsetNomContacto");
	}
	@Test public void testsetNumContacto()throws Exception {
		logger.info("Starting testsetNumContacto");
		c.setNumContacto(222222222);
		assertTrue(c.getNumContacto()==222222222); 
		logger.debug("Finishing testsetNumContacto");
	}
}
