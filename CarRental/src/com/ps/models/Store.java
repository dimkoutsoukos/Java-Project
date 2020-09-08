package com.ps.models;

import java.util.Set;
import javax.persistence.*;


@Entity (name="store")
public class Store {
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column (name="STORE_ID")
	private int storeid;
	@Column (name="STORE_NAME")
	private String storename;
	@ManyToOne
	@JoinColumn (name="CITY_ID")
	private City ST;
	@OneToMany(mappedBy = "storeid",  cascade = CascadeType.ALL)
	private Set<Vehicle> Vehicle;
	
	public Store() {
		
	}
	
	public Set<Vehicle> getVehicle() {
		return Vehicle;
	}

	public void setVehicle(Set<Vehicle> vehicle) {
		Vehicle = vehicle;
	}
	
	public Store(int store_id) {
		storeid=store_id;
	}

	
	public Store(String storename, City ST){
		this.storename=storename;
		this.ST=ST;
	}

	public int getStoreid() {
		return storeid;
	}

	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}
	public City getST() {
		return ST;
	}
	public void setST(City sT) {
		ST = sT;
	}
}

	

