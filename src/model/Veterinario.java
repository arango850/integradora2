package model;

public class Veterinario{

	private int id;
	private String name;
	private String lastName;
	private int vetNumber;

	//getters
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getlastName(){
		return lastName;
	}
	public int getvetNumber(){
		return vetNumber;
	}

	//Setters
	public void setId( int id){
		this.id=id;
	}
	public void setName( String name){
		this.name=name;
	}
	public void setlastName( String lastName){
		this.lastName=lastName;
	}
	public void setvetNumber ( int vetNumber){
		this.vetNumber=vetNumber;
	}
	
	//Constructor
	public Veterinario( int id, String name, String lastName, int vetNumber){
		this.id=id;
		this.name=name;
		this.lastName=lastName;
		this.vetNumber=vetNumber;
	}

	public String toString(){
		String v="";

		v += "Nombre: " + name;
		v += "Apellido: " + lastName;
		v += "Id " + id;
		v += "Id de Veterinario" + vetNumber;
		return v;
	}

}