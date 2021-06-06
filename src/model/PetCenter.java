package model;
import model.Veterinario;
import model.Owner;



public class PetCenter {



	private Veterinario [] veterinaryarray;


	private Pet [] petarray;

	private int veterinaryNumber;

	private int petNumber;

	private final int MAX_VETS = 7;

	private final int MAX_PETS=120;

	private String petCenterName;

	private int posicion; 

	private double noatendidos; 

	private double salidaunoatendidos; 


	private double totalMascotas;  

	private int totalRojo; 

	private int totalNaranja; 

	private int totalAmarillo;

	private int totalVerde;  

	private int totalAzul;



	

	public String metodoInc2 () {

		return petCenterName;
	}

	

	


	public PetCenter (String name) {
	
		veterinaryNumber=0;
		petNumber=0;


		petCenterName= name;

		veterinaryarray= new Veterinario [MAX_VETS];
		petarray= new Pet [MAX_PETS];
		noatendidos=0;
	
	}

	
	

	public void addVeterinario (String name, String lastName, String  idNumber, String  uniqueVet,VetEstado vetstatus) {

		boolean exit=false; // Var to control if the space on the array is available
		boolean diff= false; //boolean to control that there are not 2 vets with same information
		
		for (int i=0; i<MAX_VETS;i++){
			if(veterinaryarray[i]!=null && veterinaryarray[i].getidNumber().equalsIgnoreCase(idNumber)){
				diff=true;
				System.out.println("\nError, ya existe un veterinario con la misma informacion\n");
				

			}

		}

	
		if (!diff && veterinaryNumber==7){

			System.out.println("\nError, No hay más espcios para veterinarios\n");
			

			}else {

			for (int i =0 ;!diff && !exit && i<MAX_VETS; i++) {    // For to verify if there is a space to save a Vet

				if (veterinaryarray[i]==null){
				veterinaryarray[i] = new Veterinario(name,lastName,idNumber,uniqueVet,vetstatus);
				exit= true;
				veterinaryNumber++;
				System.out.println("\nEl veterinario "+ veterinaryarray[i].getName()+ " Ha sido agregado\n");
				System.out.println("\nActualmente hay "+ veterinaryNumber + " veterinarios\n");
		
				}

			}
		} 
	}


	


	public void eliminarVeterinario (String  idNumber) {

		String verify= idNumber;
		int check = 1; // Var to verify that the veterinary was succesfully deleted
		boolean exit=false;
		if (petNumber!=0){
			System.out.println("\nError, no es posible elminar a un veterinario dado a que hay una mascota sin atender\n");
			exit=true;
		}


		for(int del=0; !exit && del<MAX_VETS ; del++) {

			if (veterinaryarray[del]!=null && veterinaryarray[del].getidNumber().equalsIgnoreCase(verify)){
			veterinaryarray[del]=null;
			check=-1;
			System.out.println("\nEl veterinario "+ veterinaryarray[del].getName()+ " Ha sido eliminado\n");
			veterinaryNumber--;
			}

		}

		if (!exit && check==1){
		System.out.println("Error, Veterinario no encontrado");
		} 
	}


	







	public void addMascota (String petName, int petAge, Especie petSpecie, String petSymptoms, Owner owner,Status status, Priority priority){

		boolean exit= false;
		boolean combination=false;
		boolean cent=false;

		for (int i=0;i<MAX_PETS ; i++){

		if(petarray[i]!=null && petarray[i].getPetName().equalsIgnoreCase(petName) && petarray[i].getOwner().getownerName().equalsIgnoreCase(owner.getownerName())){
                    System.out.println("\nLa mascota " + petarray[i].getPetName() + "de " + owner.getownerName() + " ya existe\n");
                    combination=true;
                }

		}

		for (int i =0 ;!exit && i<MAX_VETS; i++) {    // For to verify if there is a space to save a pet

			if (!combination && petarray[i]==null){
			petarray[i] = new Pet(petName,petAge,petSpecie,petSymptoms,owner,status,priority);
			exit= true;
			petNumber++;
			System.out.println("La mascota con nombre de "+ petarray[i].getPetName()+ "Ha sido agregada");
			System.out.println("\nActualmente hay \n"+ petNumber + "\n mascotas \n");
			
			noatendidos++;
			prioridadVer();
			totalMascotas++;
			}


		}

		
		



		

		if ( !combination && petNumber==120){
			System.out.println("\nError, no hay espacio para las mascotas\n");
		}
	}




	public void eliminarMascota (String petName, double ownerid){
		
		boolean exit= false;
		

		for(int i=0; !exit && i<MAX_PETS ; i++) {

			if (!exit && petarray[i]!=null && petarray[i].getOwner().getowneridNumber()==ownerid){

				if(!exit && petarray[i].getPetName().equalsIgnoreCase(petName) && petarray[i].getStatus()==Status.ESPERA){


					petarray[i].setStatus(Status.SALIDANOAUTORIZADA);
			
					System.out.println("\n La mascota abandonó el petCenter sin haber sido atendida\n");
					petNumber--;
					System.out.println("\nActualmente hay  "+ petNumber + " mascotas\n");
					exit=true;
					prioridadVer();
					salidaunoatendidos++;

				}else {
					System.out.println("Error");
					exit=true;}

			
			}else if(i==6){
				System.out.println("Error, la mascota no tiene ese dueño");
			}

		}

	}





	public void empezarConsulta (String id){
		
		boolean exit= false;
		boolean nopet=false;
		int condition=0;
		boolean novet=false;
		
		

			if(petarray[posicion]==null){
				System.out.println("No hay mascotas pendiente para iniciar una consulta");
				nopet=true;
			}

			
			if (!nopet && veterinaryNumber==0) {

				System.out.println("\nError, no hay veterinarios en el petCenter\n");
				novet=true;
			}


			for (int i=0;!novet && !nopet && !exit && i<MAX_VETS; i++){

				if(veterinaryarray[i]!=null && veterinaryarray[i].getvetstatus()==VetEstado.DISPONIBLE && veterinaryarray[i].getidNumber().equalsIgnoreCase(id)){

					veterinaryarray[i].setvetstatus(VetEstado.ENCONSULTA);
					countPerconsult(petarray[posicion].getPriority());
					petarray[posicion].setaVet(veterinaryarray[i]);
					petarray[posicion].setStatus(Status.ENCONSULTA);
					System.out.println("\nLa mascota "+ petarray[posicion].getPetName()+ " está siendo atendida por "+ veterinaryarray[i].getName() + " " + veterinaryarray[i].getlastName()+"\n");
					int numberofpatients = veterinaryarray[i].getNumberOfPatients();
					numberofpatients++;
					veterinaryarray[i].setNumberOfPatients(numberofpatients);
					condition =1;
					noatendidos--;
					
					prioridadVer();
					
							


				}

			

			}

			if (!novet && !nopet && condition==0){
				System.out.println("\nError\n");

			}

	}




	public void finalizarConsulta (String id, String petName,int option) {

		boolean exit=false;
		boolean inconsult=true;
		int position=0;
		String aId= id;
		String apetName=petName;
		int aOption=option;
		

		for (int i=0;!exit && i<MAX_VETS; i++) {

			if(veterinaryarray[i]!=null && veterinaryarray[i].getidNumber().equalsIgnoreCase(id) && veterinaryarray[i].getvetstatus()==VetEstado.ENCONSULTA){
				inconsult=false;
				exit=true;
				position=i;
				

			}


		}

		if (inconsult==true){

			System.out.println("Error, la mascota no fue encontrada en las consultas");


		}else exit=false;

		for (int a=0;!inconsult && !exit &&  a<MAX_PETS; a++) {


			if(petarray[a]!=null && petarray[a].getPetName().equalsIgnoreCase(apetName) && petarray[a].getStatus()==Status.ENCONSULTA && petarray[a].getaVet().getidNumber().equals(aId)){
			
				if(aOption==1){

					petarray[a].setStatus(Status.SALIDAUTORIZADA);
					veterinaryarray[position].setvetstatus(VetEstado.DISPONIBLE);
					System.out.println("La consulta ha finalizado, "+ veterinaryarray[position].getName()+ " "+ veterinaryarray[position].getlastName()+" queda disponible");
					System.out.println("La mascota "+ petarray[a].getPetName() + " ha salido del petCenter");
					
					exit=true;


				}else if (aOption==2) {

					petarray[a].setStatus(Status.HOSPITALIZACION);
					veterinaryarray[position].setvetstatus(VetEstado.DISPONIBLE);
					System.out.println("La consulta ha finalizado, "+ veterinaryarray[position].getName()+" "+ veterinaryarray[position].getlastName()+" queda disponible");
					System.out.println("La mascota "+ petarray[a].getPetName() + " va para hospitalización");
					
					exit=true;

				}else {
					System.out.println("Opcción no valida");
					exit=true;
				}


			}


		}


	}



	public void prioridadVer(){

		boolean cent=false;
		

		


		for(int i=0;!cent && i<MAX_PETS;i++){

			if(petarray[i]!=null && petarray[i].getStatus()==Status.ESPERA && petarray[i].getPriority()==Priority.ROJO){
			posicion=i;
			cent=true;
			System.out.println("La siguiente mascota para atender es " + petarray[posicion].getPetName());
			
			

			}

		}
		for(int i=0;!cent &&i<MAX_PETS;i++){

			if(petarray[i]!=null && petarray[i].getStatus()==Status.ESPERA && petarray[i].getPriority()==Priority.NARANJA){
			posicion=i;
			cent=true;
			System.out.println("La siguiente mascota para atender es " + petarray[posicion].getPetName());
		
			
			}

		}
		for(int i=0;!cent &&i<MAX_PETS;i++){

			if(petarray[i]!=null && petarray[i].getStatus()==Status.ESPERA && petarray[i].getPriority()==Priority.AMARILLO){
			posicion=i;
			cent=true;
			System.out.println("La siguiente mascota para atender es " + petarray[posicion].getPetName());
			
			
			}

		}
		for(int i=0;!cent &&i<MAX_PETS;i++){

			if(petarray[i]!=null && petarray[i].getStatus()==Status.ESPERA && petarray[i].getPriority()==Priority.VERDE){
			posicion=i;
			cent=true;
			System.out.println("La siguiente mascota para atender es " + petarray[posicion].getPetName());
			
			
			}

		}
		for(int i=0;!cent &&i<MAX_PETS;i++){

			if(petarray[i]!=null && petarray[i].getStatus()==Status.ESPERA && petarray[i].getPriority()==Priority.AZUL){
			posicion=i;
			cent=true;
			System.out.println("La siguiente mascota para atender es " + petarray[posicion].getPetName());
			
			
			}

		} 

	}


	

	public boolean cerrarPetCenter () {

		boolean exit=false;
		int maxtotalconsult=0;
		int positionmaxvet=0;


		for(int i=0 ; !false && i<MAX_PETS;i++){

			if(petarray[i]!=null && (petarray[i].getStatus()==Status.ESPERA||petarray[i].getStatus()==Status.ENCONSULTA) ){

			exit=true;
			}




		}

		for (int i=0; i<MAX_VETS;i++){


			if(veterinaryarray[i]!=null && veterinaryarray[i].getNumberOfPatients()>maxtotalconsult){

				maxtotalconsult=veterinaryarray[i].getNumberOfPatients();
				positionmaxvet=i;
			}

		}


		if(!exit && totalMascotas!=0){
			System.out.print("\nMostrando estadisticas:\n");
			System.out.println("Total de mascotas según la prioridad " + "\n" +
			"ROJO " + totalRojo + "\n" + 
			"NARANJA "+ totalNaranja + "\n" +
			"AMARILLO "+ totalAmarillo + "\n" +
			"VERDE "+ totalVerde + "\n" +
			"AZUL "+ totalAzul + "\n");

			System.out.println("\nEl veterinario con más mascotas atendidas fue " + veterinaryarray[positionmaxvet].getName() + " "+ veterinaryarray[positionmaxvet].getlastName()+"\n");


			double percentage = (salidaunoatendidos/totalMascotas)*100;
			System.out.println("\nEl porcentaje de mascotas que abandonaron el petCenter sin haber sido atendidos es de "+ percentage + "%\n");

			

			for(int i=0; i<MAX_PETS;i++){ 
				if(petarray[i]!=null && petarray[i].getStatus()!=Status.ESPERA){
					petarray[i]=null;
				}

			}

		}
					

		return exit;

	}


	
	public void countPerconsult(Priority aPos){


		if (aPos==Priority.ROJO){

			totalRojo++;
		}
		if (aPos==Priority.NARANJA){

			totalNaranja++;
		}
		if (aPos==Priority.AMARILLO){

			totalAmarillo++;
		}
		if (aPos==Priority.VERDE){

			totalVerde++;
		}
		if (aPos==Priority.AZUL){

			totalAzul++;
		}

	}

	public double getNoAttended () {

		return noatendidos;
	}


	



}