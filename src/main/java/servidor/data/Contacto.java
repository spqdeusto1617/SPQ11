package servidor.data;

import javax.jdo.annotations.Discriminator;
import javax.jdo.annotations.DiscriminatorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
//@Inheritance(strategy=InheritanceStrategy.SUPERCLASS_TABLE)
//@Discriminator(strategy=DiscriminatorStrategy.CLASS_NAME)
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
