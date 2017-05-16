package servidor.test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import junit.framework.JUnit4TestAdapter;
import servidor.data.Posicion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import org.junit.Rule;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;

public class PosicionTest {
	static Logger logger = Logger.getLogger(Posicion.class.getName());
	Posicion p;
	@Before
	public void setUp() throws Exception {
		logger.info("Entering setUp");
		p = new Posicion("Bilbo","Museo","Cine");
		
		logger.info("Leaving setUp");
	}

	@Test public void testgetUbicacion()throws Exception {
		logger.info("Starting testgetUbicacion");
		p.setUbicacion("Madrid");
		assertEquals("Madrid",p.getUbicacion()); 
		logger.debug("Finishing testgetUbicacion");
	}
	@Test public void testsetUbicacion()throws Exception {
		logger.info("Starting testsetUbicacion");
		p.setUbicacion("Londres");
		assertTrue(p.getUbicacion().equals("Londres")); 
		logger.debug("Finishing testsetUbicacion");
	}
	@Test public void testgetLugaresCercanosDeInteres()throws Exception {
		logger.info("Starting testgetLugaresCercanosDeInteres");
			assertEquals(p.getLugaresCercanosDeInteres().get(1),"Cine"); 
			assertEquals(p.getLugaresCercanosDeInteres().get(0),"Museo"); 
	
		logger.debug("Finishing testgetLugaresCercanosDeInteres");
	}

}
