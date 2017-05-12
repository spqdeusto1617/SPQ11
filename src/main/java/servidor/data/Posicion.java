package servidor.data;

import java.util.ArrayList;

public class Posicion {
	private  String ubicacion;
	private  ArrayList <String> lugaresCercanosDeInteres= new ArrayList<>();
	public Posicion(){
			 
	}
	public Posicion(String ubicacion,String lugarInt1,String lugarInt2){
		this.ubicacion=ubicacion;	
		this.lugaresCercanosDeInteres.add(lugarInt1);	 
		this.lugaresCercanosDeInteres.add(lugarInt2);	 
	}
	
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
	
}
