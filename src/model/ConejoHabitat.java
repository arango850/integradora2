package model;

public class ConejoHabitat extends Habitat{

	private int plantas;

	public void setPlanta( int plantas){
		this.plantas=plantas;
	}

	public int getPlantas(){
		return plantas;
	}

	public ConejoHabitat(int gId, int largo, int ancho, int plantas, HabitatEstado habitatstatus){
		super(gId,largo,ancho,1);
		this.plantas=plantas;
	}
}