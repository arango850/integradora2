package model;

public class Owner {

	private String ownerName;

	private int ownerPhone;

	private String ownerAdress;

	private double owneridNumber;
	


	

	public String getownerName () {

		return ownerName;
	}


	public double getowneridNumber () {

		return owneridNumber;
	}

	

	public Owner (String ownerName, int ownerPhone, String ownerAdress, double owneridNumber) {

		this.ownerName=ownerName;
		this.ownerPhone=ownerPhone;
		this.ownerAdress=ownerAdress;
		this.owneridNumber=owneridNumber;


	}







}