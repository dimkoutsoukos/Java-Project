package com.ps.models;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class RentalDAO {
	public void addRental(Rental bean) {
		Session session =SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
	        session.save(bean);
	        	tx.commit();
	        }catch(PersistenceException e) {System.out.println("Persistence Exception");e.printStackTrace();};
	        session.close();  
	    }
	
	public List<Rental> getRentals(){
		Session session = SessionUtil.getSession();
		NativeQuery query = session.createNativeQuery("select * from rental");
		List<Rental> rentals = query.list();
		session.close();
		return rentals;
    }
	
	
	public int deleteRental(int rentalid) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from rental where RENTAL_ID = ?1";
		NativeQuery query = session.createNativeQuery(hql);
		query.setParameter(1,rentalid);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
	
	public int updateRental(int rentalid, String vehiclelicenceno, int clientid, String rentalpickuplocation, String rentalpickupdatetime, String rentalreturnloction,
			String rentalreturndatetime, Integer rentaltotalcost) {
		Date dt1 = new Date();
  	    SimpleDateFormat sdf1 = new SimpleDateFormat(rentalpickupdatetime);
  	    String picktime = sdf1.format(dt1);
  	    Date dt2 = new Date();
  	    SimpleDateFormat sdf2 = new SimpleDateFormat(rentalreturndatetime);
  	    String droptime = sdf2.format(dt2);
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update rental set RENTAL_PICKUP_LOCATION = ?1, RENTAL_PICKUP_DATETIME = ?2, RENTAL_RETURN_LOCATION = ?3,"
				+ " RENTAL_RETURN_DATETIME = ?4, RENTAL_TOTAL_COST = ?5, VEHICLE_LICENCE_NO = ?6, CLIENT_ID = ?7 where RENTAL_ID = ?8";
		NativeQuery query = session.createNativeQuery(hql);
		query.setParameter(1,rentalpickuplocation);
		query.setParameter(2,picktime);
		query.setParameter(3,rentalreturnloction);
		query.setParameter(4,droptime);
		query.setParameter(5,rentaltotalcost);
		query.setParameter(6,vehiclelicenceno);
		query.setParameter(7,clientid);
		query.setParameter(8,rentalid);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
	
	public List<Rental> getRentalDetails(int rentalid){
		Session session = SessionUtil.getSession();
		NativeQuery query = session.createNativeQuery("Select * from rental where RENTAL_ID = ?1");
		query.setParameter(1, rentalid);
		List<Rental> rentals = query.list();
		session.close();
		return rentals;
	}
	
	
	/*public Integer getRentalCost(String vehiclelicenceno) {
		Statement stmt = conn.createStatement();
		Integer vehiclecost=0;
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "select VEHICLE_RENTAL_COST from vehicle where VEHICLE_LICENCE_NO="+vehiclelicenceno+"";
		try {
			ResultSet rs =  executeQuery(hql);
			vehiclecost = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tx.commit();
		session.close();
		return vehiclecost;
	}*/
	public Integer getRentalCost(String vehiclelicenceno) {
		Session session = SessionUtil.getSession();
		NativeQuery query = session.createNativeQuery("select VEHICLE_RENTAL_COST from vehicle where VEHICLE_LICENCE_NO=?1");
		query.setParameter(1, vehiclelicenceno);
		List rentals = query.list();
		session.close();
		Integer rentalcost= (Integer) rentals.get(0);
		return rentalcost;
	}
	
	



}
