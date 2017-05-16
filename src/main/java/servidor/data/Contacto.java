package servidor.data;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Contacto {
	private String nomContacto;
	private int numContacto;
	public String getNomContacto() {
		return nomContacto;
	}
	public void setNomContacto(String nomContacto) {
		this.nomContacto = nomContacto;
	}
	public int getNumContacto() {
		return numContacto;
	}
	public void setNumContacto(int numContacto) {
		this.numContacto = numContacto;
	}
	
	public Contacto(String nomContacto, int numContacto){
		this.nomContacto=nomContacto;
		this.numContacto=numContacto;
	}
	
}
