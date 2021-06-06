package model;

public class Veterinario {


	private String name;

	private String lastName;

	private String  idNumber;

	private String  uniqueVet;

	private VetEstado vetstatus;

	private int numberofpatients;
	



	public void setNumberOfPatients (int numberofpatients){

		this.numberofpatients=numberofpatients;
	}

	public void setvetstatus (VetEstado vetstatus){
		this.vetstatus=vetstatus;
	}


	public int getNumberOfPatients(){

		return numberofpatients;
	}
	public VetEstado getvetstatus (){
		return vetstatus;
	}

	public String getName (){

		return name;

	}

	public String getlastName () {

		return lastName;
	}

	public String getidNumber () {

		return idNumber;

	}





	public Veterinario (String name, String lastName, String  idNumber,String  uniqueVet, VetEstado vetstatus) {

		this.name= name;
		this.lastName= lastName;
		this.idNumber=idNumber;
		this.uniqueVet=uniqueVet;
		this.vetstatus=vetstatus;
		

	}


}