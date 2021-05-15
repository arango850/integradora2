package model; 

public class Pet{

	private String petName;
	private int petAge;
	private String petSpecies;
	private String petSintomas;

	//getters
	public String getpetName(){
		return petName;
	}
	public int getpetAge(){
		return petAge;
	}
	public String getpetSpecies(){
		return petSpecies;
	}
	public String getpetSintomas(){
		return petSintomas;
	}
	//Setters
	public void setpetName(String petName){
		this.petName=petName;
	}
	public void setpetAge(int petAge){
		this.petAge=petAge;
	}
	public void setpetSpecies(String petSpecies){
		this.petSpecies=petSpecies;
	}
	public void setpetSintomas(String petSintomas){
		this.petSintomas=petSintomas;
	}

	//Constructores
	public Pet( String petName, int petAge, String petSpecies, String petSintomas){
		this.petName=petName;
		this.petAge=petAge;
		this.petSpecies=petSpecies;
		this.petSintomas=petSintomas;
	}
}