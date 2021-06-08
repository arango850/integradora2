package model;

public class CatHabitat extends Habitat{
	private int altura;
	private int peso_MAX;

	public void setAltura(int altura){
		this.altura=altura;
	}
	public int getAltura(){
		return altura;
	}
	public void setPeso_MAX(int peso_MAX){
		this.peso_MAX=peso_MAX;
	}
	public int getPeso_MAX(){
		return peso_MAX;
	}

	public CatHabitat(int gId, int largo, int ancho,HabitatEstado habitatstatus, int altura, int peso_MAX ){
		super(gId,largo,ancho,1);
		this.altura=altura;
		this.peso_MAX=peso_MAX;
	}

}