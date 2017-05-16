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
		p = new Posicion();
		
		logger.info("Leaving setUp");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
