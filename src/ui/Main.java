package ui;

import java.util.Scanner;
import model.PetCenter;
import model.Owner;
import model.Especie;
import model.Priority;
import model.Status;
import model.VetEstado;
import model.TipoHabitatReptil;
import model.TipoJaulaAve;

public class Main{









private Scanner reader;



private PetCenter petCenterRelation; 


public Main () {

	reader= new Scanner (System.in);
}


public static void main (String[]args){

	Main op=new Main();
	op.showMenu();

}




public void showMenu (){

	int option=0;
	

	System.out.println("\nBienvenido a petCenter\n"+
	"¿Que servicio quieres usar? \n"+
	"(1) Emergencias Veterinarias \n"+
	"(2) Guardería de mascotas\n"+
	"(0) Salir\n");
		
	option= reader.nextInt();
	reader.nextLine();

	switch (option){

	case 1:
	metodoInc1();
	mostarMenu();
	break;
	case 0:
	System.out.println("Cerrando PetCenter");
	break;
	case 2:
	mostarMenu2();
		}


}

public void mostarMenu(){

	int option=0;

	System.out.print("\nBienvenido a Emergencias Veterinarias, ¿Qué quieres hacer?\n");
	System.out.print("\n(1) Registrar\n"+
		"\n(2) Eliminar\n"+
		"\n(3) Consultas\n"+
		"\n(4) Cerrar el petCenter\n"+
		"\n(0) Volver\n");
	option=reader.nextInt();
	reader.nextLine();
	switch(option){
		
		case 1:
		registrosMenu();
		break;
		case 3:
		consultasMenu();
		break;
		case 2:
		eliminarMenu();
		case 4:
		if (petCenterRelation.cerrarPetCenter()==true){
				option=-1;
				System.out.println("El petCenter no se puede cerrar aún, hay mascotas que faltan por atender");

			}else {
				System.out.println("Cerrando PetCenter\n");
					
				option=0;
			}
		break;
		case 0:
		showMenu();
		break;



	}
}

public void registrosMenu(){
	int option=0;

	System.out.print("\nBienvenido al menú de registros\n");
	System.out.print("\n¿Que quieres registrar?\n"+
		"\n(1) Veterinario\n"+
		"\n(2) Mascota\n"+
		"\n(0) Volver\n");
	option= reader.nextInt();
	reader.nextLine();
	
	switch(option){
		case 1: 
		registrarVeterinario();
		break;
		case 2:
		registrarMascota();
		break;
		case 0:
		mostarMenu();
		break;
	}
	mostarMenu();


}

public void eliminarMenu(){
	int option =0;
	System.out.print("\nBienvenido al menú de eliminaciones\n");
	System.out.print("\n¿Qué quieres eliminar?\n"+
		"\n(1) Veterinarios\n"+
		"\n(2) Mascotas\n"+
		"\n(0) Volver\n");
	option= reader.nextInt();
	reader.nextLine();

	switch(option){
		case 1:
		String idNumber= eliminarVeterinario();
		petCenterRelation.eliminarVeterinario(idNumber);
		break;
		case 2:
		eliminarMascota();
		break;
		case 0:
		mostarMenu();
		break;


	}
	mostarMenu();
}

public void consultasMenu(){

	int option=0;

	System.out.print("\nBienvenido al menu de consultas\n");
	System.out.print("\n¿Qué quieres hacer?\n"+
		"\n(1) Iniciar consulta\n"+
		"\n(2) Finalizar consulta\n"+
		"\n(0) Volver \n");

	option=reader.nextInt();
	reader.nextLine();
	switch(option){

		case 1:
		empezarConsulta();
		break;
		case 2:
		finalizarConsulta();
		break;
		case 0:
		mostarMenu();
		break;
	}
	mostarMenu();
}







public void registrarVeterinario() {


	System.out.println("Digita el nombre del veterinario");

	String name= reader.nextLine();
	

	System.out.println("Digita el apellido del veterinario");

	String lastName= reader.nextLine();
	

	System.out.println("Digita la identificación del veterinario");

	String  idNumber= reader.nextLine();
	
	

	System.out.println("Digita la identificación veterinaria del veterinario");

	String  uniqueVet= reader.nextLine();
	


	petCenterRelation.addVeterinario(name,lastName,idNumber,uniqueVet,VetEstado.DISPONIBLE);


}





public String  eliminarVeterinario() {

	System.out.println("Digita la identificación del veterinario que quieres eliminar");
		String  idNumber = reader.nextLine();
		

		return idNumber;

}









public void registrarMascota(){
	


	System.out.println("\nDigita el nombre de tu mascota");
	String fullname= reader.nextLine();

	System.out.println("Digita la edad de tu mascota");
	int age= reader.nextInt();
	reader.nextLine();

	System.out.println("Selecciona la especie de tu mascota \n"+
		"1. Gato \n"+
		"2. Perro \n" +
		"3. Reptil \n"+
		"4. Conejo \n"+
		"5. Ave");
	int type= reader.nextInt();
	reader.nextLine();

	

	
	System.out.println("Digita los sintomas de tu mascota");
	String symptoms= reader.nextLine();

	System.out.println("Digita la prioridad de atención de tu mascota \n"+
		"(1) Rojo \n"+
		"(2) Naranja \n" +
		"(3) Amarillo \n"+
		"(4) Verde \n"+
		"(5) Azul");

	int priority = reader.nextInt();
	reader.nextLine();


	System.out.print("\nAhora Digita los datos del dueño de la mascota\n");

	System.out.println("Digita el nombre del dueño de la mascota");
	String ownerName= reader.nextLine();



	System.out.println("Digita el número telefónico del dueño de la mascota");
	int ownerPhone= reader.nextInt();
	reader.nextLine();

	System.out.println("Digita la residencia del dueño de la mascota");
	String ownerAdress= reader.nextLine();

	System.out.println("Digita la identificación del dueño de la mascota");
	double owneridNumber= reader.nextDouble();
	reader.nextLine();

	Owner owner = new Owner(ownerName,ownerPhone,ownerAdress,owneridNumber);

	
	
	switch (type) {

		case 1:
		switch (priority){
			case 1:
			petCenterRelation.addMascota(fullname,age,Especie.GATO,symptoms,owner,Status.ESPERA,Priority.ROJO);
			break;
			case 2:
			petCenterRelation.addMascota(fullname,age,Especie.GATO,symptoms,owner,Status.ESPERA,Priority.NARANJA);
			break;
			case 3:
			petCenterRelation.addMascota(fullname,age,Especie.GATO,symptoms,owner,Status.ESPERA,Priority.AMARILLO);
			break;
			case 4:
			petCenterRelation.addMascota(fullname,age,Especie.GATO,symptoms,owner,Status.ESPERA,Priority.AZUL);
			break;
			case 5:
			petCenterRelation.addMascota(fullname,age,Especie.GATO,symptoms,owner,Status.ESPERA,Priority.VERDE);
			break;
			default:
			System.out.println("\nInformación incorrecta\n");
			break;
		}

		break;
		case 2:
		switch (priority){
			case 1:
			petCenterRelation.addMascota(fullname,age,Especie.PERRO,symptoms,owner,Status.ESPERA,Priority.ROJO);
			break;
			case 2:
			petCenterRelation.addMascota(fullname,age,Especie.PERRO,symptoms,owner,Status.ESPERA,Priority.NARANJA);
			break;
			case 3:
			petCenterRelation.addMascota(fullname,age,Especie.PERRO,symptoms,owner,Status.ESPERA,Priority.AMARILLO);
			break;
			case 4:
			petCenterRelation.addMascota(fullname,age,Especie.PERRO,symptoms,owner,Status.ESPERA,Priority.AZUL);
			break;
			case 5:
			petCenterRelation.addMascota(fullname,age,Especie.PERRO,symptoms,owner,Status.ESPERA,Priority.VERDE);
			break;
			default:
			System.out.println("\nInformación incorrecta\n");
			break;
		}
		break;
		case 3:
		switch (priority){
			case 1:
			petCenterRelation.addMascota(fullname,age,Especie.REPTIL,symptoms,owner,Status.ESPERA,Priority.ROJO);
			break;
			case 2:
			petCenterRelation.addMascota(fullname,age,Especie.REPTIL,symptoms,owner,Status.ESPERA,Priority.NARANJA);
			break;
			case 3:
			petCenterRelation.addMascota(fullname,age,Especie.REPTIL,symptoms,owner,Status.ESPERA,Priority.AMARILLO);
			break;
			case 4:
			petCenterRelation.addMascota(fullname,age,Especie.REPTIL,symptoms,owner,Status.ESPERA,Priority.AZUL);
			break;
			case 5:
			petCenterRelation.addMascota(fullname,age,Especie.REPTIL,symptoms,owner,Status.ESPERA,Priority.VERDE);
			break;
			default:
			System.out.println("\nInformación incorrecta\n");
			break;
		}

		break;
		case 4:
		switch (priority){
			case 1:
			petCenterRelation.addMascota(fullname,age,Especie.CONEJO,symptoms,owner,Status.ESPERA,Priority.ROJO);
			break;
			case 2:
			petCenterRelation.addMascota(fullname,age,Especie.CONEJO,symptoms,owner,Status.ESPERA,Priority.NARANJA);
			break;
			case 3:
			petCenterRelation.addMascota(fullname,age,Especie.CONEJO,symptoms,owner,Status.ESPERA,Priority.AMARILLO);
			break;
			case 4:
			petCenterRelation.addMascota(fullname,age,Especie.CONEJO,symptoms,owner,Status.ESPERA,Priority.AZUL);
			break;
			case 5:
			petCenterRelation.addMascota(fullname,age,Especie.CONEJO,symptoms,owner,Status.ESPERA,Priority.VERDE);
			break;
			default:
			System.out.println("\nInformación incorrecta\n");
			break;
		}
		break;
		case 5:
		switch (priority){
			case 1:
			petCenterRelation.addMascota(fullname,age,Especie.AVE,symptoms,owner,Status.ESPERA,Priority.ROJO);
			break;
			case 2:
			petCenterRelation.addMascota(fullname,age,Especie.AVE,symptoms,owner,Status.ESPERA,Priority.NARANJA);
			break;
			case 3:
			petCenterRelation.addMascota(fullname,age,Especie.AVE,symptoms,owner,Status.ESPERA,Priority.AMARILLO);
			break;
			case 4:
			petCenterRelation.addMascota(fullname,age,Especie.AVE,symptoms,owner,Status.ESPERA,Priority.AZUL);
			break;
			case 5:
			petCenterRelation.addMascota(fullname,age,Especie.AVE,symptoms,owner,Status.ESPERA,Priority.VERDE);
			break;
			default:
			System.out.println("\nInformación incorrecta\n");
			break;
		}
		break;
		default:
			System.out.println("\nInformación incorrecta\n");
			break;

	}

}




public void eliminarMascota(){

	System.out.print("\nDigita el nombre de la mascota que quieres eliminar\n");
	String petName= reader.nextLine();
	System.out.print("\nDigita el id del dueño de la mascota que quieres eliminar\n ");
	double ownerid= reader.nextDouble();

	petCenterRelation.eliminarMascota(petName,ownerid);

}



public void empezarConsulta() {
	System.out.println("\nDigita la identificación del veterinario que quieres que inicie la consulta\n");
	String id= reader.nextLine();
	petCenterRelation.empezarConsulta(id);
}



public void finalizarConsulta(){
	System.out.println("Digita la identificación del veterinario para finalizar la consulta");
	String id= reader.nextLine();
	System.out.println("Digita el nombre de la mascota que quieres que finalice la consulta");
	String petName= reader.nextLine();
	System.out.println("\nSelecciona que pasará con la mascota\n " + 
			"\n(1) Sale del petCenter mediante la autorización de un veterinario\n" +
			"\n(2) La mascota va para hospitalización\n" );
	int option=reader.nextInt();

	petCenterRelation.finalizarConsulta(id,petName,option);


}

public void metodoInc1(){

	System.out.println("\nPasando a Emergencias Veterinarias\n");
	String name = "";

	petCenterRelation = new PetCenter(name);
}

public void mostarMenu2(){

	int option=0;

	System.out.print("\nBienvenido al menu de Guardería\n");
	System.out.print("\n¿Qué quieres hacer\n"+
		"\n(1) Registrar una mascota\n"+
		"\n(2) Buscar Mascota\n"+
		"\n(3) Mostar guardería\n"+
		"\n(4) Estadística\n");

	option= reader.nextInt();
	reader.nextLine();

	switch(option){
		case 1:
		registroMascotaG();
		break;
		case 2:
		buscarMascotaG();
		break;
		case 3:
		showGuarderia();
		break;
		case 4:
		estadistica();
		break;

	}
}

public void registroMascotaG(){
	
	int alturaAve=0;
	int peso_MAX=0;
	int conttoy=0;
	int plantas=0;
	String material="";
	int type2=0;
	int type3=0;
	int capacidad=0;
	int alturaGato=0;
	System.out.println("\nBienvenido al registro de mascotas para la guardería\n");
	System.out.println("\nDigita el nombre de tu mascota\n");
	String petName= reader.nextLine();
	System.out.println("\nDigita la edad de la mascota\n");
	int petAge= reader.nextInt();
	reader.nextLine();
	System.out.println("\nDigita la especie de la mascota\n"+
		"\n(1) Gato\n"+
		"\n(2) Perro\n"+
		"\n(3) Conejo\n"+
		"\n(4) Reptil\n"+
		"\n(5) Ave\n");
	int type= reader.nextInt();
	reader.nextLine();
	if(type==1){
		System.out.println("Digita la altura");
		alturaGato=reader.nextInt();
	    reader.nextLine();
		System.out.println("Digita el peso máximo");
		 peso_MAX=reader.nextInt();
	    reader.nextLine();
	}else if (type==2) {
		System.out.println("Digita la cantidad de juguetes");
		conttoy=reader.nextInt();
		reader.nextLine();
	}else if (type==3) {
		System.out.println("Digita la cantidad de plantas");
		plantas=reader.nextInt();
		reader.nextLine();
	}else if (type==4) {
		System.out.println("Digita el Material de la jaula");
		material=reader.nextLine();
		System.out.println("Selecciona el tipo de habitat\n"+
			"(1) Tierra\n"+
			"(2) Agua");
		type2=reader.nextInt();
		reader.nextLine();
	}else if(type==5){
		System.out.println("Digita la capaciad\n");
		capacidad= reader.nextInt();
		reader.nextLine();
		System.out.println("Digita la altura\n");
		alturaAve= reader.nextInt();
		reader.nextLine();
		System.out.println("Selecciona el tipo de jaula\n"+
			"(1) Tierra\n"+
			"(2) Colgada\n");
		type3= reader.nextInt();
		reader.nextLine();
	}

	System.out.print("\nDigita el número de dias que la mascota va estar en la guardería\n");
	int days= reader.nextInt();
	reader.nextLine();
	System.out.println("\nDigita los datos del dueño\n");
	System.out.println("\nDigita el nombre del dueño\n");
	String ownerName= reader.nextLine();
	System.out.println("\nDigita la identidad del dueño\n");
	double owneridNumber= reader.nextDouble();
	reader.nextLine();
	System.out.println("\nDigita la dirección del dueño\n");
	String ownerAdress= reader.nextLine();
	System.out.println("\nDigita el número telefónico del dueño\n");
	int ownerPhone= reader.nextInt();
	reader.nextLine();

	Owner owner2 = new Owner(ownerName,ownerPhone,ownerAdress,owneridNumber);


	switch(type){
		case 1:
		petCenterRelation.addMascotaGuarderiaG(petName, petAge, Especie.GATO, days,owner2,alturaGato,peso_MAX);
		break;
		case 2:
		petCenterRelation.addMascotaGuarderiaP(petName,petAge, Especie.PERRO, days,owner2,conttoy);
		break;
		case 3:
		petCenterRelation.addMascotaGuarderiaC(petName, petAge, Especie.CONEJO, days,owner2,plantas);
		break;
		case 4:
		switch(type2){
			case 1:
			petCenterRelation.addMascotaGuarderiaR(petName,petAge, Especie.REPTIL, days, owner2,material,TipoHabitatReptil.TIERRA);
			break;
			case 2:
			petCenterRelation.addMascotaGuarderiaR(petName,petAge, Especie.REPTIL, days, owner2,material, TipoHabitatReptil.AGUA);
			break;
		}
			
		case 5:
		switch (type3) {
			case 1:
			petCenterRelation.addMascotaGuarderiaA(petName,petAge,Especie.AVE,  days,owner2,capacidad,alturaAve, TipoJaulaAve.TIERRA);
			break;
			case 2:
			petCenterRelation.addMascotaGuarderiaA(petName,petAge,Especie.AVE,  days,owner2,capacidad,alturaAve, TipoJaulaAve.COLGADA);
			break;
		}
		
	}
	



}
public void buscarMascotaG(){
	System.out.println("\nBienvenido al buscador de mascotas de la guardería\n");
	System.out.println("\nDigita el nombre de la mascota\n");
	String petName=reader.nextLine();
	petCenterRelation.bMG(petName);
}

public void showGuarderia(){

	System.out.println(petCenterRelation.mostrarGuarderia());
}


public void estadistica(){

}


}



	
