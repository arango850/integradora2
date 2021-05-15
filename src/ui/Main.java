package ui;

import java.util.Scanner;

import model.Veterinario;
import model.Pet;

public class Main{
		private Veterinario vet;
		
		private Pet petRelation;
		private Scanner reader; 

	public Main(){
		reader = new Scanner(System.in);
	}	
	

	public static void main (String [] args){
		int option=0;
		System.out.println("Bienvenido a petCenter");
		Main pp= new Main();
		do{
			option= pp.showMenu();
			pp.answerOption(option);
		}while (option != 0);
}

	public int showMenu(){
		int option=0;
		
		System.out.println("Digite una opccion\n"+
			"(1)Ingresar un nuevo veterinario\n"+
			"(2)Eliminar un veterinario\n"+
			"(4)Registrar una nueva mascota\n"+
			"(5)Registar un dueño\n"+
			"(0) Salir\n");
		option=reader.nextInt();
		answerOption(option);
		reader.nextLine();
		return option;
	}

	
	public void answerOption(int num){
		switch(num){
			case 0:
			System.out.println("Este es el fin del programa");
			break;
			case 1: 
			createVet();
			break;
			case 2: 
			showVet();
			break;
			case 4:
			createPet();
			break;
			case 5:
			createOwner();
		}
	}
	private void createVet(){
		int id;
		String name;
		String lastName;
		int vetNumber;
		System.out.println("");
		name= reader.nextLine();
		System.out.println("Digita el Apellido del veterinario");
		lastName= reader.nextLine();	
		System.out.println("Digite el nombre del veterinario");
		name=reader.nextLine();
		System.out.println("Digita la identificación del veterinario");
		id= reader.nextInt();
		System.out.println("Digita la identificación como veterinario del veterinario");
		vetNumber= reader.nextInt();
		Veterinario vet1 = new  Veterinario(id, name, lastName, vetNumber);
		System.out.println("El veterinario con el id de "+ vetNumber+ " ha sido registrado");
		showMenu();

	}

	private void showVet(){
		System.out.println(vet.toString());

		}

	private void createPet(){
		String petName;
		int petAge;
		String petSpecies;
		String petSintomas;
		petName= reader.nextLine();
		System.out.println("Digita el nombre de la mascota");
		petName= reader.nextLine();
		System.out.println("Digita la edad de la mascota");
		petAge= reader.nextInt();
		petSpecies=reader.nextLine();
		System.out.println("Digita la especie del animal");
		petSpecies=reader.nextLine();
		petSintomas= reader.nextLine();
		System.out.println("Digita los sintomas del animal");
		petSintomas=reader.nextLine();
		Pet petRelation = new Pet(petName, petAge, petSpecies, petSintomas);
		System.out.println("La mascota con nombre de "+ petName+ " ha sido registrada");
		showMenu();
	}

	private void createOwner(){


	}	
}



	
