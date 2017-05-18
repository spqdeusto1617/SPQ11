package servidor.data;

import java.util.ArrayList;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")

public class Album {
	@PrimaryKey
	private String nomAlbum;
	private  ArrayList <String> canciones= new ArrayList<>();
	public String getNomAlbum() {
		return nomAlbum;
	}
	public void setNomAlbum(String nomAlbum) {
		this.nomAlbum = nomAlbum;
	}
	public ArrayList<String> getCanciones() {
		return canciones;
	}
	public void setCanciones(ArrayList<String> canciones) {
		this.canciones = canciones;
	}
	
	public Album(String nomAlbum, ArrayList <String> canciones) {
		this.nomAlbum=nomAlbum;
		this.canciones=canciones;
	}
}
