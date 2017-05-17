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
public class Destino {
	@PrimaryKey
	private  String nomDest;
	private  String coordenadas;
	
	public String getNom_dest() {
		return nomDest;
	}
	public void setNom_dest(String nomDest) {
		this.nomDest = nomDest;
	}
	public String getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}
	
	public Destino(String nomDest, String coordenadas){
		this.nomDest=nomDest;
		this.coordenadas=coordenadas;
		
	}
}
