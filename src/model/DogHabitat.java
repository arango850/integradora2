package model;

public class DogHabitat extends Habitat{

	private int conttoy;


	public void setConttoy(int conttoy){
		this.conttoy=conttoy;
	}
	public int getConttoy(){
		return conttoy;
	}

	public DogHabitat( int gId, int largo, int ancho, HabitatEstado habitatstatus, int conttoy){
		super(gId,largo,ancho, 1);
		this.conttoy=conttoy;
	}
}