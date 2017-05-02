package servidor.data;

import java.util.ArrayList;

public class Posicion {
	private  String ubicacion;
	private  ArrayList <String> lugaresCercanosDeInteres;
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public ArrayList<String> getLugaresCercanosDeInteres() {
		return lugaresCercanosDeInteres;
	}
	public void setLugaresCercanosDeInteres(ArrayList<String> lugaresCercanosDeInteres) {
		this.lugaresCercanosDeInteres = lugaresCercanosDeInteres;
	}
	public Posicion(String ubicacion,String lugarInt1,String lugarInt2){
		 this.ubicacion=ubicacion;	
				 lugaresCercanosDeInteres.add(lugarInt1);	 
				 lugaresCercanosDeInteres.add(lugarInt2);	 
	}
}
