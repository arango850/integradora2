package model;

public class ReptileHabitat extends Habitat{

	private String material;
	private TipoHabitatReptil tipoHabitatReptil;

	public void setMaterial(String material){
		this.material=material;
	}
	public String getMaterial(){
		return material;
	}

	public void setTipoHabitatReptil(TipoHabitatReptil tipoHabitatReptil){
		this.tipoHabitatReptil=tipoHabitatReptil;
	}
	public TipoHabitatReptil getTipoHabitatReptil(){
		return tipoHabitatReptil;
	}

	public ReptileHabitat( int gId, int largo, int ancho, String material, TipoHabitatReptil tipoHabitatReptil, HabitatEstado habitatstatus){
		super( gId,largo,ancho,1);
		this.material=material;
		this.tipoHabitatReptil=tipoHabitatReptil;
	}
}