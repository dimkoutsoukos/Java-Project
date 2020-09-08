package com.ps.models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Bike")
public class TwoWheeled extends Vehicle {
	@Column (name="VEHICLE_SEAT_HEIGHT")
	private Integer vehicleseatheight;
	@Column (name="VEHICLE_LUGGAGE_SUPPORT")
	private String vehicleluggagesupport;
	
	public TwoWheeled() {
		
	}


	public TwoWheeled(String vehiclelicenceno, Store storeid,  String vehiclemodel, String vehiclefuel, String vehiclecapacity,
			Integer vehiclerentalcost, String vehiclecategory, Integer vehicleseatheight, String vehicleluggagesupport) {
		super(vehiclelicenceno, storeid, vehiclemodel, vehiclefuel, vehiclecapacity, vehiclerentalcost, vehiclecategory);
		this.vehicleseatheight=vehicleseatheight;
		this.vehicleluggagesupport=vehicleluggagesupport;
	}



	public String getVehicleluggagesupport() {
		return vehicleluggagesupport;
	}
	public void setVehicleluggagesupport(String vehicleluggagesupport) {
		this.vehicleluggagesupport = vehicleluggagesupport;
	}
	public Integer getVehicleseatheight() {
		return vehicleseatheight;
	}
	public void setVehicleseatheight(Integer vehicleseatheight) {
		this.vehicleseatheight = vehicleseatheight;
	}
	



}
