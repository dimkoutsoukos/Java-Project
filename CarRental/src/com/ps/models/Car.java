package com.ps.models;
import javax.persistence.*;


@Entity
@DiscriminatorValue("Car")    
public class Car extends Vehicle {
	@Column (name="VEHICLE_SEAT_NO")
	private Integer vehicleseatno;
	@Column (name="VEHICLE_DOOR_NUMBER")
	private Integer vehicledoornumber;
	
	public Car() {
		
	}

	public Car(String vehiclelicenceno, Store storeid,  String vehiclemodel, String vehiclefuel, String vehiclecapacity,
			Integer vehiclerentalcost, String vehiclecategory, Integer vehicleseatno, Integer vehicledoornumber) {
		super(vehiclelicenceno, storeid, vehiclemodel, vehiclefuel, vehiclecapacity, vehiclerentalcost, vehiclecategory);
		this.vehicleseatno=vehicleseatno;
		this.vehicledoornumber=vehicledoornumber;
	}

	public Integer getVehicleseatno() {
		return vehicleseatno;
	}
	public void setVehicleseatno(Integer vehicleseatno) {
		this.vehicleseatno = vehicleseatno;
	}
	public Integer getVehicledoornumber() {
		return vehicledoornumber;
	}
	public void setVehicledoornumber(Integer vehicledoornumber) {
		this.vehicledoornumber = vehicledoornumber;
	}

}
