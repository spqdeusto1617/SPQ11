package servidor.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import servidor.data.Album;

public class AlbumTest {
	static Logger logger = Logger.getLogger(Album.class.getName());
	Album album;
	private  ArrayList <String> canciones= new ArrayList<>();
	String cancion1= "DJpepe";
	String cancion2= "DJpape";
	
	@Before
	public void setUp() throws Exception {
		logger.info("Entering setUp");
		canciones.add(cancion1);
		canciones.add(cancion2);
		album = new Album("DJS", canciones);
		
		logger.info("Leaving setUp");
	}


	@Test public void testgetNomAlbum()throws Exception {
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
		assertEquals("DJpepe",album.getCanciones().get(0)); 
		assertEquals("DJpape",album.getCanciones().get(1)); 	
		logger.debug("Finishing testgetCanciones");
	}
}
