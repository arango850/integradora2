package model;

public abstract class Habitat{

private int gId;
private int largo;
private int ancho;
private HabitatEstado habitatstatus;
private Pet pet;
private int diasUso;

public Habitat(int largo, int ancho, int diasUso, int gId){

	this.largo=largo;
	this.ancho=ancho;
	this.diasUso=diasUso;
	this.gId=gId;
}

public void setgId(int gId ){
	this.gId=gId;
}
public void setLargo(int largo){
	this.largo=largo;
}
public void setAncho(int ancho){
	this.ancho=ancho;
}
public void setDiasUso(int diasUso){
	this.diasUso=diasUso;
}

public int getGId(){
	return gId;

}
public int getAncho(){
	return ancho;
}
public int getLargo(){
	return largo;
}
public int getDiasUso(){
	return diasUso;
}

public void setPet( Pet pet){
	this.pet=pet;
}
public Pet getPet(){
	return pet;
}
public HabitatEstado gethabitatstatus(){
return habitatstatus;	
}
public void setHabitatStatus(HabitatEstado habitatstatus){
	this.habitatstatus=habitatstatus;
	}
}
