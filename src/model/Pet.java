package model;

public class Pet {

private String petName; 

private int petAge; 



private Especie petSpecie; 

private String petSymptoms;


private Status status;

private Owner owner;

private Priority priorityLevel;

private Especie specie;

private Veterinario aVet;

private int days;

public void setDays(int days){
	this.days=days;
}
public int getDays(){
	return days;
}


public void setStatus (Status status){
	this.status=status;
}
public void setaVet(Veterinario aVet) {

	this.aVet = aVet;
}
public Especie getSpecie(){
	return specie;
}
public void getSpecie(Especie specie){
	this.specie=specie;
}

public Owner getOwner () {
	
	return owner;
}

public String getPetName () {

	return petName;

}

public Priority getPriority () {

	return priorityLevel;
} 

public Status getStatus (){

	return status;
}

public Veterinario getaVet () {

	return aVet;
}





public Pet (String petName, int petAge, Especie specie, String petSymptoms,Owner owner ,Status status, Priority priorityLevel) {


	this.petName=petName;
	this.petAge=petAge;

	this.specie=specie;
	this.petSymptoms=petSymptoms;
	this.priorityLevel=priorityLevel;
	this.status=status;
	this.owner=owner;


}




}