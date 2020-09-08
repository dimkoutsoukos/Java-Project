package com.ps.models;
import java.util.Set;

import javax.persistence.*;


@Entity(name = "vehicle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="VEHICLE_TYPE",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="vehicle")
public class Vehicle {
	@Id
	@Column (name="VEHICLE_LICENCE_NO")
	private String vehiclelicenceno;
	@Column (name="VEHICLE_MODEL")
	private String vehiclemodel;
	@Column (name="VEHICLE_FUEL")
	private String vehiclefuel;
	@Column (name="VEHICLE_CAPACITY")
	private String vehiclecapacity;
	@Column (name="VEHICLE_RENTAL_COST")
	private Integer vehiclerentalcost;
	@Column (name="VEHICLE_TYPE", insertable=false, updatable=false)
	private String vehicletype;
	@Column (name="VEHICLE_CATEGORY")
	private String vehiclecategory;
	@ManyToOne
	@JoinColumn(name="STORE_ID")
	private  Store storeid;
	@OneToMany(mappedBy = "vehiclelicenceno", cascade = CascadeType.ALL)
	private Set<Rental> rental;
	
	public Vehicle() {
		
	}
	public Vehicle(String vehiclelicenceno){
		this.vehiclelicenceno = vehiclelicenceno;
	}
	
	public Vehicle(String vehiclelicenceno, Store storeid, String vehiclemodel, String vehiclefuel, String vehiclecapacity,
			Integer vehiclerentalcost,String vehiclecategory) {
		this.vehiclelicenceno = vehiclelicenceno;
		this.storeid = storeid;
		this.vehiclemodel = vehiclemodel;
		this.vehiclefuel = vehiclefuel;
		this.vehiclecapacity = vehiclecapacity;
		this.vehiclerentalcost = vehiclerentalcost;
		this.vehiclecategory = vehiclecategory;
	}


	public String getVehiclelicenceno() {
		return vehiclelicenceno;
	}
	public void setVehiclelicenceno(String vehiclelicenceno) {
		this.vehiclelicenceno = vehiclelicenceno;
	}
	public String getVehiclemodel() {
		return vehiclemodel;
	}
	public void setVehiclemodel(String vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}
	public String getVehiclefuel() {
		return vehiclefuel;
	}
	public void setVehiclefuel(String vehiclefuel) {
		this.vehiclefuel = vehiclefuel;
	}
	public String getVehiclecapacity() {
		return vehiclecapacity;
	}
	public void setVehiclecapacity(String vehiclecapacity) {
		this.vehiclecapacity = vehiclecapacity;
	}

	public Integer getVehiclerentalcost() {
		return vehiclerentalcost;
	}
	public void setVehiclerentalcost(Integer vehiclerentalcost) {
		this.vehiclerentalcost = vehiclerentalcost;
	}
	public Set<Rental> getRental() {
		return rental;
	}

	public void setRental(Set<Rental> rental) {
		this.rental = rental;
	}

	public String getVehicletype() {
		return vehicletype;
	}
	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}


	public Store getStoreid() {
		return this.storeid;
	}


	public void setStoreid(Store storeid) {
		this.storeid = storeid;
	}

	public String getVehiclecategory() {
		return vehiclecategory;
	}

	public void setVehiclecategory(String vehiclecategory) {
		this.vehiclecategory = vehiclecategory;
	}





}
