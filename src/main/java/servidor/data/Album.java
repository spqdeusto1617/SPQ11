package servidor.data;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")

public class Album {
	@PrimaryKey
	private String nomAlbum;
	private  String canciones;
	public String getNomAlbum() {
		return nomAlbum;
	}
	public void setNomAlbum(String nomAlbum) {
		this.nomAlbum = nomAlbum;
	}
	public String getCanciones() {
		return canciones;
	}
	public void setCanciones(String canciones) {
		this.canciones = canciones;
	}
	
	public Album(String nomAlbum, String canciones) {
		this.nomAlbum=nomAlbum;
		this.canciones=canciones;
	}
}
