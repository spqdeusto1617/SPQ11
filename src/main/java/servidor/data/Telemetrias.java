package servidor.data;

import java.util.Random;

public class Telemetrias {
private int bateria;
private int velocidad;
private int kilometraje;
public Telemetrias(){
	Random rnd = new Random();
	double estadoActual= rnd.nextDouble();
	if(estadoActual<0.15){
		bateria= 10;
		velocidad= 50;
		kilometraje= 70;
	}else if(estadoActual<0.25){
		bateria= 25;
		velocidad= 60;
		kilometraje= 75;
	}else if(estadoActual<0.5){
		bateria= 44;
		velocidad= 75;
		kilometraje= 87;
	}else if(estadoActual<0.75){
		bateria= 67;
		velocidad= 90;
		kilometraje= 35;
	}else{
		bateria= 97;
		velocidad= 110;
		kilometraje= 24;
	}
}
public int getBateria() {
	return bateria;
}
public void setBateria(int bateria) {
	this.bateria = bateria;
}
public int getVelocidad() {
	return velocidad;
}
public void setVelocidad(int velocidad) {
	this.velocidad = velocidad;
}
public int getKilometraje() {
	return kilometraje;
}
public void setKilometraje(int kilometraje) {
	this.kilometraje = kilometraje;
}
}
