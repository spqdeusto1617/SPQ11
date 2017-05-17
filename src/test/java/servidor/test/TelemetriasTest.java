package servidor.test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import junit.framework.JUnit4TestAdapter;
import servidor.data.Telemetrias;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import org.junit.Rule;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;

public class TelemetriasTest {
	static Logger logger = Logger.getLogger(Telemetrias.class.getName());
	Telemetrias t;
	@Before
	public void setUp() throws Exception {
		logger.info("Entering setUp");
		t = new Telemetrias();
		
		logger.info("Leaving setUp");
	}
	@Test public void testgetBateria()throws Exception {
		logger.info("Starting testgetBateria");
		t.setBateria(24);
		assertEquals(24,t.getBateria()); 
		logger.debug("Finishing testgetBateria");
	}
	@Test public void testgetVelocidad()throws Exception {
		logger.info("Starting testgetVelocidad");
		t.setVelocidad(64);
		assertEquals(64,t.getVelocidad()); 
		logger.debug("Finishing testgetVelocidad");
	}
	@Test public void testgetKilometraje()throws Exception {
		logger.info("Starting testgetKilometraje");
		t.setKilometraje(50);
		assertEquals(50,t.getKilometraje()); 
		logger.debug("Finishing testgetKilometraje");
	}
	@Test public void testsetBateria()throws Exception {
		logger.info("Starting testsetBateria");
		t.setBateria(24);
		assertTrue(t.getBateria()==24); 
		logger.debug("Finishing testsetBateria");
	}
	@Test public void testsetVelocidad()throws Exception {
		logger.info("Starting testsetVelocidad");
		t.setVelocidad(64);
		assertTrue(t.getVelocidad()==64); 
		logger.debug("Finishing testsetVelocidad");
	}
	@Test public void testsetKilometraje()throws Exception {
		logger.info("Starting testsetKilometraje");
		t.setKilometraje(50);
		assertTrue(t.getKilometraje()==50); 
		logger.debug("Finishing testsetKilometraje");
	}

	

}
