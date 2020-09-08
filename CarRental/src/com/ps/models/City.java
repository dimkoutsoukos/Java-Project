package com.ps.models;

import java.util.Set;

import javax.persistence.*;





@Entity (name="city")
public class City {
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	@Column (name="CITY_ID")
	private int cityid;
	@Column (name="CITY_NAME")
	private String cityname;
	@OneToMany(mappedBy = "ST", cascade = CascadeType.ALL)
	private Set<Store> stores;
	
	
	public Set<Store> getStores() {
		return stores;
	}

	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}
	
	public City(int city_id) {
		cityid=city_id;
	}

	
	
	public City() {
	}
	public City (String cityname){
		this.cityname=cityname;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}	

}
