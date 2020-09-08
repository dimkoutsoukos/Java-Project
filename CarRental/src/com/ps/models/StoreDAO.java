package com.ps.models;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class StoreDAO {
	/*public int addStore(String storename, String cityname) {
		Session session =SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
		String hql ="INSERT INTO store VALUES (STORE_ID,(SELECT CITY_ID FROM city WHERE CITY_NAME =?1), ?2) ";
		NativeQuery query = session.createNativeQuery(hql);
		query.setParameter(1,cityname);
		query.setParameter(2,storename);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
	    tx.commit();
	    return rowCount;
		}catch(PersistenceException e) {System.out.println("Persistence Exception");e.printStackTrace();};
	    session.close(); 
	    return 0;
	    }*/
	

	public void addStore(Store bean) {
		Session session =SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
	        session.save(bean);
	        	tx.commit();
	        }catch(PersistenceException e) {System.out.println("Persistence Exception");e.printStackTrace();};
	        session.close();  
	    }
	
	public List<Store> getStores(){
		Session session = SessionUtil.getSession();
		NativeQuery query = session.createNativeQuery("select * from store");
		List<Store> stores = query.list();
		session.close();
		return stores;
    }
	
	
	public int deleteStore(String storeid) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from store where STORE_ID = ?1";
		NativeQuery query = session.createNativeQuery(hql);
		query.setParameter(1,storeid);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
	
	public int updateStore(int storeid, String storename) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update store set STORE_NAME = ?1 WHERE STORE_ID = ?2";
		NativeQuery query = session.createNativeQuery(hql);
		query.setParameter(1,storename);
		query.setParameter(2,storeid);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
	
	public List<Store> getStoreDetails(String storename){
		Session session = SessionUtil.getSession();
		NativeQuery query = session.createNativeQuery("Select * from store where STORE_NAME = ?1");
		query.setParameter(1, storename);
		List<Store> stores = query.list();
		session.close();
		return stores;
	}




}
