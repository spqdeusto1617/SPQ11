package servidor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;

import junit.framework.JUnit4TestAdapter;
import servidor.data.Telemetrias;
import servidor.server.CocheService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import org.junit.Rule;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;

@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class CocheServiceTest {
	
	static Logger logger = Logger.getLogger(CocheService.class.getName());
	
@Rule public ContiPerfRule rule = new ContiPerfRule();

CocheService cocheService;

	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(CocheServiceTest.class);
	}
	@Before public void setUp() {
		logger.info("Entering setUp");
		 cocheService= new CocheService("0.0.0.0", 35600);
		
		logger.info("Leaving setUp");
	}
	@Test 
    @PerfTest(invocations = 1000, threads = 20)
    @Required(max = 120, average = 30)
	public void testgetBateria() throws Exception {
		logger.info("Starting testgetBateria");
		 cocheService.getTelemetrias().setBateria(1234);
		assertEquals(1234,  cocheService.getTelemetrias().getBateria()); 
		Thread.sleep(121);
		logger.debug("Finishing testgetBateria");
	}
	@Test public void testgetVelocidad() throws Exception {
		logger.info("Starting testgetVelocidad");
		 cocheService.getTelemetrias().setVelocidad(45);;
		assertEquals(45,  cocheService.getVelocidad()); 
		logger.debug("Finishing testgetVelocidad");
	}
	@Test public void testgetNuevoKilometraje()throws Exception {
		logger.info("Starting testgetNuevoKilometraje");
		 cocheService.getTelemetrias().setKilometraje(45);
		assertEquals(90,cocheService.getNuevoKilometraje(45)); 
		logger.debug("Finishing testgetNuevoKilometraje");
	}
	@Test public void testgetPosicionActualGPS()throws Exception {
		logger.info("Starting testgetPosicionActualGPS");
		String contraseña= "1234";
		String lugarInt1="MuseoBilbo";
		String lugarInt2="San Mames";
		assertEquals("Bilbo",cocheService.getPosicionActualGPS(contraseña).getUbicacion()); 
		assertEquals(lugarInt1,cocheService.getPosicionActualGPS(contraseña).getLugaresCercanosDeInteres().get(0)); 
		assertEquals(lugarInt2,cocheService.getPosicionActualGPS(contraseña).getLugaresCercanosDeInteres().get(0)); 
		logger.debug("Finishing testgetPosicionActualGPS");
	}
	@Test public void testgetIpSocket()throws Exception {
		logger.info("Starting testgetIpSocket");
		assertEquals("0.0.0.0",cocheService.getIpSocket()); 
		logger.debug("Finishing testgetIpSocket");
	}
	@Test public void testgetPuestoSocket()throws Exception {
		logger.info("Starting testgetPuestoSocket");
		assertEquals(35600,cocheService.getPuestoSocket()); 
		logger.debug("Finishing testgetPuestoSocket");
	}
	@Test public void testgetTelemetrias()throws Exception {
		logger.info("Starting testgetTelemetrias");
		Telemetrias t = cocheService.getTelemetrias();
		assertEquals(t.getBateria(),cocheService.getTelemetrias().getBateria()); 
		assertEquals(t.getVelocidad(),cocheService.getTelemetrias().getVelocidad()); 
		assertEquals(t.getKilometraje(),cocheService.getTelemetrias().getKilometraje()); 
		logger.debug("Finishing testgetTelemetrias");
	}

}
