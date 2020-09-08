package com.ps.models;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class CarDAO {
    public void addCar(Car bean){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        try {
        	
        session.save(bean);
        	tx.commit();
        }catch(PersistenceException e) {System.out.println("Persistence Exception");e.printStackTrace();};
        session.close();  
    }
    
   
    
    public List<Car> getCars(){
        Session session = SessionUtil.getSession();    
        NativeQuery query = session.createNativeQuery("Select VEHICLE_LICENCE_NO, STORE_ID,VEHICLE_MODEL,"
        		+ "VEHICLE_FUEL, VEHICLE_CAPACITY, VEHICLE_RENTAL_COST, VEHICLE_CATEGORY, VEHICLE_SEAT_NO,"
        		+ "VEHICLE_DOOR_NUMBER from vehicle where VEHICLE_TYPE= 'Car'");
        List<Car> cars =  query.list();
        session.close();
        return cars;
    }
    
    public List<Car> getCompacts(){
        Session session = SessionUtil.getSession();    
        NativeQuery query = session.createNativeQuery("Select VEHICLE_LICENCE_NO, STORE_ID,VEHICLE_MODEL,"
        		+ "VEHICLE_FUEL, VEHICLE_CAPACITY, VEHICLE_RENTAL_COST, VEHICLE_CATEGORY, VEHICLE_SEAT_NO,"
        		+ "VEHICLE_DOOR_NUMBER from vehicle where VEHICLE_CATEGORY= 'Compact'");
        List<Car> cars =  query.list();
        session.close();
        return cars;
    }
    
    public List<Car> getMidranged(){
        Session session = SessionUtil.getSession();    
        NativeQuery query = session.createNativeQuery("Select VEHICLE_LICENCE_NO, STORE_ID,VEHICLE_MODEL,"
        		+ "VEHICLE_FUEL, VEHICLE_CAPACITY, VEHICLE_RENTAL_COST, VEHICLE_CATEGORY, VEHICLE_SEAT_NO,"
        		+ "VEHICLE_DOOR_NUMBER from vehicle where VEHICLE_CATEGORY= 'Midrange'");
        List<Car> cars =  query.list();
        session.close();
        return cars;
    }
    
    public List<Car> getVans(){
        Session session = SessionUtil.getSession();    
        NativeQuery query = session.createNativeQuery("Select VEHICLE_LICENCE_NO, STORE_ID,VEHICLE_MODEL,"
        		+ "VEHICLE_FUEL, VEHICLE_CAPACITY, VEHICLE_RENTAL_COST, VEHICLE_CATEGORY, VEHICLE_SEAT_NO,"
        		+ "VEHICLE_DOOR_NUMBER from vehicle where VEHICLE_CATEGORY= 'Van'");
        List<Car> cars =  query.list();
        session.close();
        return cars;
    }
    
    
    public int updateCar(String vehiclelicenceno, Store storeid,  String vehiclemodel, String vehiclefuel, String vehiclecapacity,
			Integer vehiclerentalcost, String vehiclecategory, Integer vehicleseatno, Integer vehicledoornumber){
            Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update vehicle set VEHICLE_MODEL = ?1, STORE_ID=?8, VEHICLE_FUEL=?2, VEHICLE_CAPACITY =?3, VEHICLE_RENTAL_COST=?4, "
            		+ "VEHICLE_CATEGORY = ?9, VEHICLE_SEAT_NO=?5, VEHICLE_DOOR_NUMBER=?6 where VEHICLE_LICENCE_NO = ?7";
            NativeQuery query = session.createNativeQuery(hql);
            query.setParameter(1,vehiclemodel);
            query.setParameter(2,vehiclefuel);
            query.setParameter(3,vehiclecapacity);
            query.setParameter(4,vehiclerentalcost);
            query.setParameter(5,vehicleseatno);
            query.setParameter(6,vehicledoornumber);
            query.setParameter(7,vehiclelicenceno);
            query.setParameter(8,storeid);
            query.setParameter(9,vehiclecategory);
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            tx.commit();
            session.close();
            return rowCount;
    }

	


}
