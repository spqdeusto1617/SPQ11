package servidor.test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import servidor.data.Destino;
import servidor.data.Posicion;

public class DestinoTest {
	static Logger logger = Logger.getLogger(Posicion.class.getName());
	Destino p;
	@Before
	public void setUp() throws Exception {
		logger.info("Entering setUp");
		p = new Destino("Museo", "1234");
		
		logger.info("Leaving setUp");
	}

	@Test public void testgetNom_dest()throws Exception {
		logger.info("Starting testgetNom_dest");
		p.setNom_dest("Cine");
		assertEquals("Cine",p.getNom_dest()); 
		logger.debug("Finishing testgetNom_dest");
	}
	@Test public void testsetNom_dest()throws Exception {
		logger.info("Starting testsetNom_dest");
		p.setNom_dest("Metro");
		assertTrue(p.getNom_dest().equals("Metro")); 
		logger.debug("Finishing testsetNom_dest");
	}
	@Test public void testgetCoordenadas()throws Exception {
		logger.info("Starting testCoordenadas");
		p.setCoordenadas("4444");
		assertEquals("4444",p.getCoordenadas()); 
		logger.debug("Finishing testgetCoordenadas");
	}
	@Test public void testsetCoordenadas()throws Exception {
		logger.info("Starting testsetCoordenadas");
		p.setCoordenadas("2222");
		assertTrue(p.getCoordenadas().equals("2222")); 
		logger.debug("Finishing testsetCoordenadas");
	}

}
