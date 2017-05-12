package servidor.data;


public class Destino {
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
