package servidor.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import servidor.data.Album;
import servidor.data.Contacto;
import servidor.data.Destino;


public class cocheDAO implements IcocheDAO {
	
	private PersistenceManagerFactory pmf;
	
	public cocheDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	
	@Override
	public List<Destino> getDestinos() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(1);
		
		Transaction tx = pm.currentTransaction();
		List<Destino> listaDestinos = new ArrayList<>();
		
		try {
			System.out.println("   * Retrieving an Extent for Products.");
			
			tx.begin();			
			Extent<Destino> extent = pm.getExtent(Destino.class, true);
			
			for (Destino d : extent) {
				listaDestinos.add(d);
			}

			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
	    				
		return listaDestinos;
		
	}

	@Override
	public List<Album> getAlbums() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(1);
		
		Transaction tx = pm.currentTransaction();
		List<Album> listaAlbums = new ArrayList<>();
		
		try {
			System.out.println("   * Retrieving an Extent for Products.");
			
			tx.begin();			
			Extent<Album> extent = pm.getExtent(Album.class, true);
			
			for (Album a : extent) {
				listaAlbums.add(a);
			}

			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
	    				
		return listaAlbums;
	}

	@Override
	public List<Contacto> getContactos() {
		PersistenceManager pm = pmf.getPersistenceManager();
		/* By default only 1 level is retrieved from the db
		 * so if we wish to fetch more than one level, we must indicate it
		 */
		pm.getFetchPlan().setMaxFetchDepth(1);
		
		Transaction tx = pm.currentTransaction();
		List<Contacto> listaContactos = new ArrayList<>();
		
		try {
			System.out.println("   * Retrieving an Extent for Products.");
			
			tx.begin();			
			Extent<Contacto> extent = pm.getExtent(Contacto.class, true);
			
			for (Contacto c : extent) {
				listaContactos.add(c);
			}

			tx.commit();			
		} catch (Exception ex) {
	    	System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
	    				
		return listaContactos;
		
	}


	@Override
	public void setDestinos(Destino destino) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Metiendo destino: " + destino);
	       pm.makePersistent(destino);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error introduciendo destino: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	
	}


	@Override
	public void setAlbums(Album album) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing the User: " + album);
	       pm.makePersistent(album);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing the User: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	
	}


	@Override
	public void setContactos(Contacto contacto) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       System.out.println("   * Storing the User: " + contacto);
	       pm.makePersistent(contacto);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   $ Error storing the User: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
	

	}
	
	}

