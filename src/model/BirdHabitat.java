package model;

public class BirdHabitat extends Habitat{

	private int capacidad;
	private int altura;
	private TipoJaulaAve tipoJaulaAve;

	public void setCapacidad(int capacidad){
		this.capacidad=capacidad;
	}
	public int getCapacidad(){
		return capacidad;
	}
	public void setAltura( int altura){
		this.altura=altura;
	}
	public int getAltura(){
		return altura;
	}
	public void setTipoJaulaAve(TipoJaulaAve tipoJaulaAve){
		this.tipoJaulaAve=tipoJaulaAve;
	}
	public TipoJaulaAve getTipoJaulaAve(){
		return tipoJaulaAve;
	}
	

	public BirdHabitat( int gId, int largo, int ancho, int capacidad, int altura, TipoJaulaAve tipoJaulaAve,HabitatEstado habitatstatus){
		super( gId, largo, ancho,1);
		this.capacidad=capacidad;
		this.altura=altura;
		this.tipoJaulaAve=tipoJaulaAve;
	} 
}