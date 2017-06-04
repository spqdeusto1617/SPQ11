package servidor.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;


import junit.framework.JUnit4TestAdapter;
import servidor.data.Album;
import org.junit.Rule;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;

@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class AlbumTest {
	static Logger logger = Logger.getLogger(Album.class.getName());
	Album album;
	private  ArrayList <String> canciones= new ArrayList<>();
	String cancion1= "DJpepe";
	String cancion2= "DJpape";
@Rule public ContiPerfRule rule = new ContiPerfRule();
public static junit.framework.Test suite() {
	 return new JUnit4TestAdapter(AlbumTest.class);
}
	@Before
	public void setUp() throws Exception {
		logger.info("Entering setUp");
		canciones.add(cancion1);
		canciones.add(cancion2);
		album = new Album("DJS", canciones.toString());
		
		logger.info("Leaving setUp");
	}


	@Test 
    @PerfTest(invocations = 1000, threads = 20)
    @Required(max = 120, average = 30)
	public void testgetNomAlbum()throws Exception {
		logger.info("Starting testgetNomAlbum");
		album.setNomAlbum("pepe");
		assertEquals("pepe",album.getNomAlbum()); 
		logger.debug("Finishing testgetNomAlbum");
	}
	@Test public void testsetNomAlbum()throws Exception {
		logger.info("Starting testsetNomAlbum");
		album.setNomAlbum("pepe");
		assertTrue(album.getNomAlbum().equals("pepe")); 
		logger.debug("Finishing testsetNomAlbum");
	}
	@Test public void testgetCanciones()throws Exception {
		logger.info("Starting testgetCanciones");
		assertEquals("DJpepe",album.getCanciones()); 
		assertEquals("DJpape",album.getCanciones()); 	
		logger.debug("Finishing testgetCanciones");
	}
}
