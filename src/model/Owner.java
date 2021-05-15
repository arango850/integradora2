package model;

public class Owner{

	private String ownerName;
	private String ownerLastName;
	private int ownerId;
	private int ownerCelular;
	private String ownerAdress;

	//getters

	public String getownerName(){
		return ownerName;
	}
	public String getownerLastName(){
		return ownerLastName;
	}
	public int getownerId(){
		return ownerId;
	}
	public int getownerCelular(){
		return ownerCelular;
	}
	public String getownerAdress(){
		return ownerAdress;
	}
	// Setters 

	public void setownerName(String ownerName){
		this.ownerName=ownerName;
	}
	public void setownerLastName(String ownerLastName){
		this.ownerLastName=ownerLastName;
	}
	public void setownerId(int ownerId){
		this.ownerId=ownerId;
	}
	public void setownerCelular(int ownerCelular){
		this.ownerCelular=ownerCelular;
	}
	public void setownerAdress(String ownerAdress){
		this.ownerCelular=ownerCelular;
	}
	public Owner(String ownerName, String ownerLastName, int ownerId, int ownerCelular, String ownerAdress){
		this.ownerName=ownerName;
		this.ownerLastName=ownerLastName;
		this.ownerId=ownerId;
		this.ownerCelular=ownerCelular;
		this.ownerAdress=ownerAdress;
	}

}