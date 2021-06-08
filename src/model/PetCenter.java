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

	private Habitat [][]matrixHabitats;

	private final int minGatosFilas=0;

	private final int maxGatosFilas=2;

	private final int minGatosCol=0;

	private final int maxGatosCol=2;

	private final int minPerrosFilas=3;

	private final int maxPerrosFilas=5;

	private final int minPerrosCol=0;

	private final int maxPerrosCol=2;

	private final int minReptilesFilas=0;

	private final int maxReptilesFilas=1;

	private final int minReptilesCol= 3;

	private final int maxReptilesCol= 4;

	private final int minConejosFilas= 2;

	private final int maxConejosFilas= 3;

	private final int minConejosCol= 3;

	private final int maxConejosCol=4;

	private final int minAvesFilas= 4;

	private final int maxAvesFilas= 5;

	private final int minAvesCol= 3;

	private final int maxAvesCol= 4;






	

	public String metodoInc2 () {

		return petCenterName;
	}

	

	


	public PetCenter (String name) {
	
		veterinaryNumber=0;
		petNumber=0;

		iniciarPerro();
		iniciarGato();
		iniciarReptil();
		iniciarAVe();
		iniciarConejo();


		petCenterName= name;

		matrixHabitats= new Habitat[6][5];
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

	public void addMascotaGuarderiaG(String petName,int petAge, Especie petSpecie, int day, Owner owner2, int alturaGato, int peso_MAX){
	boolean cent = false;
		for (int filas = minGatosFilas;filas<=maxGatosFilas;filas++ ) {
			for (int col= minGatosCol;col<=maxGatosCol ;col++ ) {
				if (matrixHabitats[filas][col].gethabitatstatus()==HabitatEstado.V) {
					Pet newPet = new Pet(petName,petAge,petSpecie,"",owner2,Status.GUARDERIA,Priority.AZUL);
					
					matrixHabitats[filas][col].setPet(newPet);
					matrixHabitats[filas][col].setHabitatStatus(HabitatEstado.S);
					cent=true;
				}
			}
		}
		
	}

	public void addMascotaGuarderiaP(String petName, int petAge, Especie petSpecie,int day,Owner owner2, int conttoy){
		boolean cent=false;
		for (int filas= minPerrosFilas;filas<=maxPerrosFilas ;filas ++ ) {
			for (int  col =minPerrosCol; col<=maxPerrosCol ;col++ ) {
				if (matrixHabitats[filas][col].gethabitatstatus()==HabitatEstado.V) {
					Pet newPet= new Pet(petName,petAge,petSpecie,"",owner2,Status.GUARDERIA,Priority.AZUL);

					matrixHabitats[filas][col].setPet(newPet);
					matrixHabitats[filas][col].setHabitatStatus(HabitatEstado.S);
					cent=true;					
				}
			}
			
		}
	}

	public void addMascotaGuarderiaC(String petName, int petAge,Especie petSpecie, int day, Owner owner2,int plantas){
		boolean cent=false;
		for (int filas= minConejosFilas; filas<=maxConejosFilas;filas++ ) {
			for (int col=minConejosCol;col<=maxConejosCol ;col++ ) {
				if (matrixHabitats[filas][col].gethabitatstatus()==HabitatEstado.V) {
					Pet newPet = new Pet(petName,petAge,petSpecie,"",owner2,Status.GUARDERIA,Priority.AZUL);

					matrixHabitats[filas][col].setPet(newPet);
					matrixHabitats[filas][col].setHabitatStatus(HabitatEstado.S);
					cent=true;
				}
			}
		}
	}

	public void addMascotaGuarderiaR(String petName,int petAge, Especie petSpecie, int day, Owner owner2,String material, TipoHabitatReptil tipoHabitatReptil){
		boolean cent= false;
		for (int filas=minReptilesFilas;filas<=maxReptilesFilas ;filas++ ) {
			for (int col= minReptilesCol; col<=maxReptilesCol ;col++ ) {
				if (matrixHabitats[filas][col].gethabitatstatus()==HabitatEstado.V) {
					Pet newPet= new Pet(petName,petAge,petSpecie,"",owner2,Status.GUARDERIA,Priority.AZUL);

					matrixHabitats[filas][col].setPet(newPet);
					matrixHabitats[filas][col].setHabitatStatus(HabitatEstado.S);
					cent=true;
				}
			}
		}
	}

	public void addMascotaGuarderiaA(String petName, int petAge, Especie petSpecie, int day, Owner owner2 ,int capacidad, int alturaAve,TipoJaulaAve tipoJaulaAve){
		boolean cent=false;
		for (int filas=minAvesFilas;filas<=maxAvesFilas ;filas++ ) {
			for (int col=minAvesCol;col<=maxAvesCol ;col++ ) {
				if (matrixHabitats[filas][col].gethabitatstatus()==HabitatEstado.V) {
					Pet newPet= new Pet(petName,petAge,petSpecie,"",owner2,Status.GUARDERIA,Priority.AZUL);

					matrixHabitats[filas][col].setPet(newPet);
					matrixHabitats[filas][col].setHabitatStatus(HabitatEstado.S);
					cent=true;

				}
			}
		}
	}

	
public void bMG(String petName){
	for (int filas =0;filas<= matrixHabitats.length ;filas++ ) {
		for(int col=0;col<= matrixHabitats[0].length; col++)
			if(matrixHabitats[filas][col]!=null && matrixHabitats[filas][col].getPet().getPetName().equals(petName)){

				if (matrixHabitats[filas][col].getPet().getSpecie()==Especie.PERRO) {
					System.out.println(petName+ " está en la zona de perros");
				}else if (matrixHabitats[filas][col].getPet().getSpecie()==Especie.GATO) {
					System.out.println(petName+" está en la zona de gatos");
				}else if (matrixHabitats[filas][col].getPet().getSpecie()==Especie.CONEJO) {
					System.out.println(petName+" está en la zona de conejo");
				}else if (matrixHabitats[filas][col].getPet().getSpecie()==Especie.REPTIL) {
					System.out.println(petName+" está en la zona de resptiles");
				}else if (matrixHabitats[filas][col].getPet().getSpecie()==Especie.AVE) {
					System.out.println(petName+" está en la zona de aves");
					}

				if (matrixHabitats[filas][col].gethabitatstatus()==HabitatEstado.S) {
						System.out.println("Está en un habitat de tipo Sano");	
						}
				if (matrixHabitats[filas][col].gethabitatstatus()==HabitatEstado.E) {
						System.out.println("Está en un habitat de tipo enfermo");			
								}
				if (matrixHabitats[filas][col]==null) {
					System.out.println("No hay mascotas en el centro");								
												}								
			}
	}

}

public String mostrarGuarderia(){
	String out ="";
   	for(int filas=0;filas<matrixHabitats.length;filas++){
			 out +="\n";
			for(int col=0;col<matrixHabitats[0].length;col++){
				if(matrixHabitats[filas][col].gethabitatstatus()==HabitatEstado.V){
					out+= matrixHabitats[filas][col].getGId()+ "E";
					out+=" - ";
				}
				if(matrixHabitats[filas][col].gethabitatstatus()==HabitatEstado.E){
					out+= matrixHabitats[filas][col].getGId()+ "H";
					out+=" - ";
				}
				if(matrixHabitats[filas][col].gethabitatstatus()==HabitatEstado.S){
					out+= matrixHabitats[filas][col].getGId()+ "S";
					out+=" - ";
				}


			}
}
return out;
}


public void iniciarPerro(){

	for (int filas= minPerrosFilas; filas <= maxPerrosFilas ;filas ++ ) {
		for (int col= minPerrosCol; col <= maxPerrosCol ; col++ ) {
			matrixHabitats[filas][col]= new DogHabitat(1,1,1,HabitatEstado.V,1);
		}
	}
}
public void iniciarAVe(){
	for (int filas= minAvesFilas; filas <= maxAvesFilas ;filas ++ ) {
		for (int col= minAvesCol; col <= maxAvesCol ; col++ ) {
			matrixHabitats[filas][col]= new BirdHabitat(2,0,0,0,0,TipoJaulaAve.TIERRA,HabitatEstado.V);
		}
	}
}
public void iniciarGato(){
	for (int filas= minGatosFilas; filas <= maxGatosFilas ;filas ++ ) {
		for (int col= minGatosCol; col <= maxGatosCol ; col++ ) {
			matrixHabitats[filas][col]= new CatHabitat(3,0,0,HabitatEstado.V,0,0);
		}
	}
}	
public void iniciarConejo(){
	for (int filas= minConejosFilas; filas <= maxConejosFilas ;filas ++ ) {
		for (int col= minConejosCol; col <= maxConejosCol ; col++ ) {
			matrixHabitats[filas][col]= new ConejoHabitat(4,1,1,1,HabitatEstado.V);
		}
	}
}
public void iniciarReptil(){
	for (int filas= minReptilesFilas; filas <= maxReptilesFilas ;filas ++ ) {
		for (int col= minReptilesCol; col <= maxReptilesCol ; col++ ) {
			matrixHabitats[filas][col]= new ReptileHabitat(5,1,1,"",TipoHabitatReptil.TIERRA,HabitatEstado.V);
		}
	}
}


}