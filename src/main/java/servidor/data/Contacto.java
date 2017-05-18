package servidor.data;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")

public class Contacto {
	@PrimaryKey
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
