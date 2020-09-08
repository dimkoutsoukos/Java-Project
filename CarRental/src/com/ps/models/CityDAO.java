package com.ps.models;


import java.util.List;

import javax.persistence.PersistenceException;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;


public class CityDAO {
	public void addCity(City bean) {
		Session session =SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
	        session.save(bean);
	        	tx.commit();
	        }catch(PersistenceException e) {System.out.println("Persistence Exception");e.printStackTrace();};
	        session.close();  
	    }
	
	public  List<City> getCities(){
		Session session = SessionUtil.getSession();
		NativeQuery query = session.createNativeQuery("select * from city");
		List<City> cities = query.list();
		session.close();
		return cities;
    }
	
	
	public int deleteCity(String cityname) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from city where CITY_NAME = ?1";
		NativeQuery query = session.createNativeQuery(hql);
		query.setParameter(1,cityname);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
	
	public int updateCity(String cityid, String cityname) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update city set CITY_NAME = ?1 where CITY_ID = ?2";
		NativeQuery query = session.createNativeQuery(hql);
		query.setParameter(1,cityname);
		query.setParameter(2,cityid);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
	
	public List<City> getCityDetails(String cityname){
		Session session = SessionUtil.getSession();
		NativeQuery query = session.createNativeQuery("Select * from city where CITY_NAME = ?1");
		query.setParameter(1, cityname);
		List<City> cities = query.list();
		session.close();
		return cities;
	}
	




}
