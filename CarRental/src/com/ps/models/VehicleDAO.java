package com.ps.models;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;


public class VehicleDAO {
	
    public List<Vehicle> getVehicles(){
        Session session = SessionUtil.getSession();    
        NativeQuery query = session.createNativeQuery("select * from vehicle");
        List<Vehicle> vehicles =  query.list();
        session.close();
        return vehicles;
    }
    
    public List<Vehicle> getVehicleDetails(String vehiclelicenceno){
        Session session = SessionUtil.getSession();    
        NativeQuery query = session.createNativeQuery("Select * from vehicle where VEHICLE_LICENCE_NO=?1");
        query.setParameter(1, vehiclelicenceno);
        List<Vehicle> check =  query.list();
        session.close();
        return check;
    }

	
	
    public List<Vehicle> checkLicence(String vehiclelicenceno){
        Session session = SessionUtil.getSession();    
        NativeQuery query = session.createNativeQuery("Select * from vehicle where VEHICLE_LICENCE_NO=?1");
        query.setParameter(1, vehiclelicenceno);
        List<Vehicle> check =  query.list();
        session.close();
        return check;
    }




	public int deleteVehicle(String vehiclelicenceno) {
	    Session session = SessionUtil.getSession();
	    Transaction tx = session.beginTransaction();
	    String hql = "delete from vehicle where VEHICLE_LICENCE_NO = ?1";
	    NativeQuery query = session.createNativeQuery(hql);
	    query.setParameter(1,vehiclelicenceno);
	    int rowCount = query.executeUpdate();
	    System.out.println("Rows affected: " + rowCount);
	    tx.commit();
	    session.close();
	    return rowCount;
	    }
	
	public List<Vehicle> checkAvailability(String rentalpickuplocation, String rentalpickupdatetime, String rentalreturndatetime) {
		Session session = SessionUtil.getSession();    
		NativeQuery query = session.createNativeQuery("SELECT vehicle.* FROM vehicle,rental,store,city WHERE rental.VEHICLE_LICENCE_NO="
				+ "vehicle.VEHICLE_LICENCE_NO AND vehicle.STORE_ID=store.STORE_ID and store.CITY_ID=city.CITY_ID AND city.CITY_NAME='"+rentalpickuplocation+"'"
				+ " and rental.RENTAL_PICKUP_DATETIME <= '"+rentalreturndatetime+"' and rental.RENTAL_RETURN_DATETIME >= '"+rentalpickupdatetime+"' GROUP BY VEHICLE_LICENCE_NO");
        List<Vehicle> check =  query.list();
        session.close();
        return check;
	}
	
	public List<Vehicle> checkAvailabilityCategory(String rentalpickuplocation, String rentalpickupdatetime, String rentalreturndatetime, String vehiclecategory) {
		Session session = SessionUtil.getSession();    
		NativeQuery query = session.createNativeQuery("SELECT vehicle.* FROM vehicle,rental,store,city WHERE vehicle.VEHICLE_CATEGORY='"+vehiclecategory+"' AND rental.VEHICLE_LICENCE_NO="
				+ "vehicle.VEHICLE_LICENCE_NO AND vehicle.STORE_ID=store.STORE_ID and store.CITY_ID=city.CITY_ID AND city.CITY_NAME='"+rentalpickuplocation+"'"
				+ " and rental.RENTAL_PICKUP_DATETIME <= '"+rentalreturndatetime+"' and rental.RENTAL_RETURN_DATETIME >= '"+rentalpickupdatetime+"' GROUP BY VEHICLE_LICENCE_NO");
        List<Vehicle> check =  query.list();
        session.close();
        return check;
	}
	
    public List<Vehicle> getCityVehiclesCategory(String rentalpickuplocation, String vehiclecategory){
        Session session = SessionUtil.getSession();    
        NativeQuery query = session.createNativeQuery("SELECT vehicle.* from vehicle, store, city where vehicle.VEHICLE_CATEGORY='"+vehiclecategory+"' AND"
        		+ " vehicle.STORE_ID=store.STORE_ID and store.CITY_ID=city.CITY_ID and city.CITY_NAME='"+rentalpickuplocation+"'");
        List<Vehicle> vehicles =  query.list();
        session.close();
        return vehicles;
    }
    
    public List<Vehicle> getCityVehicles(String rentalpickuplocation){
        Session session = SessionUtil.getSession();    
        NativeQuery query = session.createNativeQuery("SELECT vehicle.* from vehicle, store, city where"
        		+ " vehicle.STORE_ID=store.STORE_ID and store.CITY_ID=city.CITY_ID and city.CITY_NAME='"+rentalpickuplocation+"'");
        List<Vehicle> vehicles =  query.list();
        session.close();
        return vehicles;
    }
    
    
    //METHODOS GIA NA ALLAZEI AYTOMATA H TOPOTHESIA ENOS OXIMATOS AN O PELATIS EPILEKSEI NA TO EPISTREPSEI SE DIAFORETIKO SIMEIO APO EKEINO POY TO PHRE
	public int updateVehicleLocation(String vehiclelicenceno, String rentalreturnloction) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "UPDATE vehicle INNER JOIN(SELECT store.STORE_ID FROM store, city where "
				+ "store.CITY_ID=city.CITY_ID AND city.CITY_NAME='"+rentalreturnloction+"' GROUP BY store.CITY_ID )"
				+ " AS id ON vehicle.VEHICLE_LICENCE_NO='"+vehiclelicenceno+"' set vehicle.STORE_ID=id.STORE_ID ";
		NativeQuery query = session.createNativeQuery(hql);
		query.setParameter(1,vehiclelicenceno);
		query.setParameter(2,rentalreturnloction);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
	
	
	
}
