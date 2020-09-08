package com.ps.models;

import javax.persistence.*;

@Entity (name = "rental")
public class Rental {
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column (name="RENTAL_ID")
	private int rentalid;
	@Column (name="RENTAL_PICKUP_LOCATION")
	private String rentalpickuplocation;
	@Column (name="RENTAL_PICKUP_DATETIME")
	private String rentalpickupdatetime;
	@Column (name="RENTAL_RETURN_LOCATION")
	private String rentalreturnloction;
	@Column (name="RENTAL_RETURN_DATETIME")
	private String rentalreturndatetime;
	@Column (name="RENTAL_TOTAL_COST")
	private Integer rentaltotalcost;
	@ManyToOne
	@JoinColumn(name="VEHICLE_LICENCE_NO")
	private Vehicle vehiclelicenceno;
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	private Client clientid;
	
	public Rental(){
		
	}
	public Rental(Vehicle vehiclelicenceno,Client clientid,String rentalpickuplocation, String rentalpickupdatetime, 
			String rentalreturnloction, String rentalreturndatetime, Integer rentaltotalcost){
		this.vehiclelicenceno=vehiclelicenceno;
		this.clientid=clientid;
		this.rentalpickuplocation=rentalpickuplocation;
		this.rentalpickupdatetime=rentalpickupdatetime;
		this.rentalreturnloction=rentalreturnloction;
		this.rentalreturndatetime=rentalreturndatetime;
		this.rentaltotalcost=rentaltotalcost;
	}
	public int getRentalid() {
		return rentalid;
	}
	public void setRentalid(int rentalid) {
		this.rentalid = rentalid;
	}
	public String getRentalpickuplocation() {
		return rentalpickuplocation;
	}
	public void setRentalpickuplocation(String rentalpickuplocation) {
		this.rentalpickuplocation = rentalpickuplocation;
	}
	public String getRentalpickupdatetime() {
		return rentalpickupdatetime;
	}
	public void setRentalpickupdatetime(String rentalpickupdatetime) {
		this.rentalpickupdatetime = rentalpickupdatetime;
	}
	public String getRentalreturnloction() {
		return rentalreturnloction;
	}
	public void setRentalreturnloction(String rentalreturnloction) {
		this.rentalreturnloction = rentalreturnloction;
	}
	public String getRentalreturndatetime() {
		return rentalreturndatetime;
	}
	public void setRentalreturndatetime(String rentalreturndatetime) {
		this.rentalreturndatetime = rentalreturndatetime;
	}
	public Integer getRentaltotalcost() {
		return rentaltotalcost;
	}
	public void setRentaltotalcost(Integer rentaltotalcost) {
		this.rentaltotalcost = rentaltotalcost;
	}
	public Vehicle getVehicle() {
		return vehiclelicenceno;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehiclelicenceno = vehicle;
	}
	public Client getClient() {
		return clientid;
	}
	public void setClient(Client client) {
		this.clientid = client;
	}

}
