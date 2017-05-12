package servidor.DAO;

import java.util.List;

import servidor.data.Album;
import servidor.data.Contacto;
import servidor.data.Destino;

public interface IcocheDAO {

	public List<Destino> getDestinos();
	public List<Album> getAlbums();
	public List<Contacto> getContactos();
	
	public void setDestinos(Destino destino);
	public void setAlbums(Album album);
	public void setContactos(Contacto contacto);
}
