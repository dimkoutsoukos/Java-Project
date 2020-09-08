package com.ps.models;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;


public class ClientDAO {
	public void addClient(Client bean) {
		Session session =SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
	        session.save(bean);
	        	tx.commit();
	        }catch(PersistenceException e) {System.out.println("Persistence Exception");e.printStackTrace();};
	        session.close();  
	    }
	
	public List<Client> getClients(){
		Session session = SessionUtil.getSession();
		NativeQuery query = session.createNativeQuery("select * from client");
		List<Client> clients = query.list();
		session.close();
		return clients;
    }
	
	
	public int deleteClient(String clientid) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from client where CLIENT_ID = ?1";
		NativeQuery query = session.createNativeQuery(hql);
		query.setParameter(1,clientid);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
	
	public int updateClient(int clientid, String clientname, String clientsurname, String clientdrivinglicence, String clientaddress, String clientemail, String clienttelephonenumber) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update client set CLIENT_NAME = ?1, CLIENT_SURNAME = ?2, CLIENT_DRIVING_LICENSE = ?3, CLIENT_ADDRESS = ?4, CLIENT_EMAIL = ?5, CLIENT_TELEPHONE_NO = ?6 where CLIENT_ID = ?7";
		NativeQuery query = session.createNativeQuery(hql);
		query.setParameter(1,clientname);
		query.setParameter(2,clientsurname);
		query.setParameter(3,clientdrivinglicence);
		query.setParameter(4,clientaddress);
		query.setParameter(5,clientemail);
		query.setParameter(6,clienttelephonenumber);
		query.setParameter(7,clientid);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
		
	}
	
	public List<Client> getClientDetails(String clientname, String clienttelephonenumber){
		Session session = SessionUtil.getSession();
		NativeQuery query = session.createNativeQuery("Select * from client where CLIENT_NAME = ?1 and CLIENT_TELEPHONE_NO = ?2");
		query.setParameter(1, clientname);
		query.setParameter(2, clienttelephonenumber);
		List<Client> clients = query.list();
		session.close();
		return clients;
	}


}
